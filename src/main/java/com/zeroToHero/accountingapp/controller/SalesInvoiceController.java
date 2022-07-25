package com.zeroToHero.accountingapp.controller;


import com.zeroToHero.accountingapp.dto.InvoiceDTO;
import com.zeroToHero.accountingapp.dto.InvoiceProductDTO;
import com.zeroToHero.accountingapp.dto.ProductDTO;
import com.zeroToHero.accountingapp.dto.StockDetailsDTO;
import com.zeroToHero.accountingapp.enums.CompanyType;
import com.zeroToHero.accountingapp.enums.InvoiceType;
import com.zeroToHero.accountingapp.enums.ProductStatus;
import com.zeroToHero.accountingapp.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/invoice")
public class SalesInvoiceController {

    private final InvoiceService invoiceService;
    private final CompanyService companyService;
    private final InvoiceProductService invoiceProductService;
    private final ClientVendorService clientVendorService;
    private final ProductService productService;
    private final StockDetailsService stockDetailsService;

    public SalesInvoiceController(InvoiceService invoiceService, CompanyService companyService, InvoiceProductService invoiceProductService, ClientVendorService clientVendorService, ProductService productService, StockDetailsService stockDetailsService) {
        this.invoiceService = invoiceService;
        this.companyService = companyService;
        this.invoiceProductService = invoiceProductService;
        this.clientVendorService = clientVendorService;
        this.productService = productService;
        this.stockDetailsService = stockDetailsService;
    }


    @GetMapping("/salesInvoiceList")
    public String salesInvoiceList(Model model) {
        model.addAttribute("salesInvoices", invoiceService.listAllByInvoiceType(InvoiceType.SALE));
        model.addAttribute("clients", clientVendorService.findAllByCompanyType(CompanyType.CLIENT));
        return "/invoice/sales-invoice-list";
    }

    @GetMapping("/updateInvoice/{id}")
    public String editInvoice(@PathVariable("id") String invoiceId, Model model) {

        Long id = invoiceService.getInvoiceNo(invoiceId);
        model.addAttribute("clientName", clientVendorService.findClientNameById(id));
        model.addAttribute("date", invoiceService.getLocalDate());
        model.addAttribute("invoiceId", invoiceService.findInvoiceName(invoiceId));
        model.addAttribute("products", productService.listAllProducts());
        model.addAttribute("invoiceProductList", invoiceProductService.findAllByInvoiceId(id));
        return "/invoice/sales-invoice-set-product-numbers";
    }

    @PostMapping("/delete/{id}")
    public String approveDeleteToInvoice(@PathVariable("id") String id, Model model) {

        model.addAttribute("salesInvoices", invoiceService.listAllByInvoiceType(InvoiceType.SALE));
        model.addAttribute("clients", clientVendorService.findAllByCompanyType(CompanyType.CLIENT));
        Long invoiceId = invoiceService.getInvoiceNo(id);
        invoiceService.delete(invoiceId);
        return "redirect:/invoice/salesInvoiceList";
    }

    @PostMapping("/toInvoice/{id}")
    public String toInvoice(@PathVariable("id") Long id, Model model) {

        model.addAttribute("salesInvoices", invoiceService.listAllByInvoiceType(InvoiceType.SALE));
        model.addAttribute("clients", clientVendorService.findAllByCompanyType(CompanyType.CLIENT));
        model.addAttribute("invoiceProducts", invoiceProductService.findAllInvoiceProductsByInvoiceId(id));
        return "/invoice/toInvoice";
    }

    @PostMapping("/approve/{id}")
    public String approve(@PathVariable("id") String id, Model model) {

        model.addAttribute("salesInvoices", invoiceService.listAllByInvoiceType(InvoiceType.SALE));
        model.addAttribute("clients", clientVendorService.findAllByCompanyType(CompanyType.CLIENT));
        Long invoiceId = invoiceService.getInvoiceNo(id);
        List<InvoiceProductDTO> invoiceProducts = invoiceProductService.getByInvoiceId(invoiceId);


        for (InvoiceProductDTO invoiceProduct : invoiceProducts) {

            List<StockDetailsDTO> stocks = stockDetailsService.getByProductId(invoiceProduct.getProductId());
            List<StockDetailsDTO> sortedList = stocks.stream()
                    .sorted(Comparator.comparing(StockDetailsDTO :: getIDate))
                    .collect(Collectors.toList());
            ProductDTO product = productService.findById(invoiceProduct.getProductId());

            if (product.getProductStatus() == ProductStatus.ACTIVE && product.getQty().compareTo(invoiceProduct.getQty())>=0) {
                BigDecimal leftOverQty = product.getQty().subtract(invoiceProduct.getQty());
                product.setQty(leftOverQty);
                productService.updateProduct(product);
                invoiceService.approveInvoice(id);
                BigDecimal stocksToRemove = invoiceProduct.getQty();
                for(StockDetailsDTO stockDetailsDTO : sortedList) {
                    if (stocksToRemove.compareTo(BigDecimal.ZERO) > 0) {
                        if(stockDetailsDTO.getRemainingQuantity().compareTo(stocksToRemove)>0){
                            BigDecimal remaining = stockDetailsDTO.getRemainingQuantity().subtract(stocksToRemove);
                            stockDetailsDTO.setRemainingQuantity(remaining);
                            stockDetailsService.updateStockDetail(stockDetailsDTO);
                            stocksToRemove = BigDecimal.ZERO;
                        } else{
                            stocksToRemove = stocksToRemove.subtract(stockDetailsDTO.getRemainingQuantity());
                            stockDetailsDTO.setRemainingQuantity(BigDecimal.ZERO);
                            stockDetailsService.updateStockDetail(stockDetailsDTO);
                        }
                    }

                }

            } else {
                return "invoice/message";
            }


        }

        return "redirect:/invoice/salesInvoiceList";
    }

    @GetMapping("/salesInvoiceCreate")
    public String salesInvoiceCreate(Model model) {
        InvoiceDTO invoiceDTO = new InvoiceDTO();

        invoiceDTO.setInvoiceType(InvoiceType.SALE);
        Long id = invoiceService.saveAndReturnId(invoiceDTO);
        invoiceDTO.setId(id);

        model.addAttribute("invoiceDTO", invoiceDTO);
        model.addAttribute("clients", clientVendorService.findAllByCompanyType(CompanyType.CLIENT));
        return "/invoice/sales-invoice-create";
    }


    @PostMapping("/salesInvoiceCreate/{id}")
    public String postSalesInvoiceCreate(@PathVariable("id") Long id, @ModelAttribute("invoiceDTO") InvoiceDTO invoiceDTO) {
        invoiceService.updateInvoiceCompany(invoiceDTO);
        return "redirect:/invoice/salesInvoiceSelectProduct/" + id;
    }

    @GetMapping("/salesInvoiceSelectProduct/{id}")
    public String salesInvoiceSelectProduct(@PathVariable("id") Long id, Model model) {

        InvoiceDTO invoiceDTO = invoiceService.getInvoiceDTOById(id);
        model.addAttribute("id", id);
        model.addAttribute("invoiceDTO", invoiceDTO);
        model.addAttribute("companyName", invoiceDTO.getClientVendor().getCompanyName());
        model.addAttribute("date", invoiceService.getLocalDate());
        model.addAttribute("invoiceId", invoiceService.getNextInvoiceIdSale());
        model.addAttribute("invoiceProductDTO", new InvoiceProductDTO());
        model.addAttribute("products", productService.listAllProducts());
        model.addAttribute("invoiceProducts", invoiceProductService.findAllInvoiceProductsByInvoiceId(id));
        return "invoice/sales-invoice-select-product";
    }
    @PostMapping("/salesInvoiceSelectProduct/{id}")
    public String postProductDetailsForInvoiceProduct(@PathVariable("id") Long id, @ModelAttribute("invoiceProductDTO") InvoiceProductDTO invoiceProductDTO) {
        invoiceProductService.addInvoiceProductByInvoiceId(id, invoiceProductDTO);
        return "redirect:/invoice/salesInvoiceSelectProduct/" + id;
    }

    @PostMapping("/setInvoiceStatusEnabledSales/{id}")
    public String setInvoiceStatusEnabled(@PathVariable("id") Long id){
        invoiceService.enableInvoice(id);
        return "redirect:/invoice/salesInvoiceList";
    }


    @GetMapping("/editSalesInvoiceSelectProduct/{id}")
    public String editSalesInvoiceSelectProduct (@PathVariable("id") Long id) {

        invoiceProductService.disableInvoiceProductsByInvoiceId(id);
        return "redirect:/invoice/salesInvoiceSelectProduct/" + id;
    }

    @PostMapping("/removeItemFromInvoiceSales/{ipid}")
    public String deleteInvoiceProductFromInvoice(@PathVariable("ipid") Long ipid) {
        Long id = invoiceProductService.findInvoiceIdByInvoiceProductId(ipid);
        invoiceProductService.deleteInvoiceProductById(ipid);
        return "redirect:/invoice/salesInvoiceSelectProduct/" + id;
    }


}