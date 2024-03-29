package com.zeroToHero.accountingapp.controller;


import com.zeroToHero.accountingapp.dto.InvoiceDTO;
import com.zeroToHero.accountingapp.dto.InvoiceProductDTO;
import com.zeroToHero.accountingapp.enums.CompanyType;
import com.zeroToHero.accountingapp.enums.InvoiceType;
import com.zeroToHero.accountingapp.service.ClientVendorService;
import com.zeroToHero.accountingapp.service.InvoiceProductService;
import com.zeroToHero.accountingapp.service.InvoiceService;
import com.zeroToHero.accountingapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/invoice")
public class PurchaseInvoiceController {

    final private InvoiceService invoiceService;
    final private ClientVendorService clientVendorService;
    final private InvoiceProductService invoiceProductService;

    public PurchaseInvoiceController(InvoiceService invoiceService, ClientVendorService clientVendorService, InvoiceProductService invoiceProductService) {
        this.invoiceService = invoiceService;
        this.clientVendorService = clientVendorService;
        this.invoiceProductService = invoiceProductService;
    }

    @GetMapping("/purchaseInvoiceList")
    public String purchaseInvoiceList(Model model) {
        model.addAttribute("purchaseInvoices", invoiceService.listAllByInvoiceType(InvoiceType.PURCHASE));
        return "invoice/purchase-invoice-list";
    }


    @PostMapping("/setInvoiceStatusEnabled/{id}")
    public String setInvoiceStatusEnabled(@PathVariable("id") Long id) {
        invoiceService.enableInvoice(id);
        return "redirect:/invoice/purchaseInvoiceList";
    }


    @PostMapping("/purchaseInvoiceList/{id}")
    public String saveInvoice(@PathVariable("id") Long id) {
        invoiceService.enableInvoice(id);
        return "redirect:/invoice/purchaseInvoiceList";
    }

    @GetMapping("/editPurchaseInvoiceSelectProduct/{id}")
    public String editPurchaseInvoiceSelectProduct(@PathVariable("id") Long id) {
        invoiceProductService.disableInvoiceProductsByInvoiceId(id);
        return "redirect:/invoice/purchaseInvoiceSelectProduct/" + id;
    }


    @GetMapping("/purchaseInvoiceCreate")
    public String purchaseInvoiceCreate(Model model) {
        // TODO Vitaly Bahrom for new ID _ test
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setInvoiceType(InvoiceType.PURCHASE);
        Long id = invoiceService.saveAndReturnId(invoiceDTO);
        invoiceDTO.setId(id);
        model.addAttribute("invoiceDTO", invoiceDTO);
        model.addAttribute("vendors", clientVendorService.findAllByCompanyType(CompanyType.VENDOR));
        return "invoice/purchase-invoice-create";
    }

    @PostMapping("/purchaseInvoiceCreate/{id}")
    public String postPurchaseInvoiceCreate(@PathVariable("id") Long id, @ModelAttribute("invoiceDTO") InvoiceDTO invoiceDTO) {
        invoiceService.updateInvoiceCompany(invoiceDTO);
        return "redirect:/invoice/purchaseInvoiceSelectProduct/" + id;
    }

    @GetMapping("/purchaseInvoiceSelectProduct/{id}")
    public String getProductDetailsForInvoiceProduct(@PathVariable("id") Long id, Model model) {
        InvoiceDTO invoiceDTO = invoiceService.getInvoiceDTOById(id);
        model.addAttribute("id", id);
        model.addAttribute("tax", invoiceProductService.getTaxByInvoiceId(id));
        model.addAttribute("invoiceDTO", invoiceDTO);
        model.addAttribute("companyName", invoiceDTO.getClientVendor().getCompanyName());
        model.addAttribute("date", invoiceService.getLocalDate());
        model.addAttribute("invoiceId", invoiceService.getNextInvoiceIdPurchase());
        model.addAttribute("invoiceProductDTO", new InvoiceProductDTO());
        model.addAttribute("products", invoiceProductService.findAllProductsByCompanyName(invoiceDTO.getClientVendor().getCompanyName()));
        model.addAttribute("invoiceProducts", invoiceProductService.findAllInvoiceProductsByInvoiceId(id));
        return "invoice/purchase-invoice-select-product";
    }

    @PostMapping("/purchaseInvoiceSelectProduct/{id}")
    public String postProductDetailsForInvoiceProduct(@PathVariable("id") Long id, @ModelAttribute("invoiceProductDTO") InvoiceProductDTO invoiceProductDTO) {
        invoiceProductService.addInvoiceProductByInvoiceId(id, invoiceProductDTO);
        return "redirect:/invoice/purchaseInvoiceSelectProduct/" + id;
    }

    @PostMapping("/removeItemFromInvoice/{ipid}")
    public String deleteInvoiceProductFromInvoice(@PathVariable("ipid") Long ipid) {
        Long id = invoiceProductService.findInvoiceIdByInvoiceProductId(ipid);
        invoiceProductService.deleteInvoiceProductById(ipid);
        return "redirect:/invoice/purchaseInvoiceSelectProduct/" + id;
    }


    @PostMapping("/deletePurchaseInvoice/{id}")
    public String approveDeleteToInvoice(@PathVariable("id") String id) {
        invoiceService.delete(invoiceService.getInvoiceNo(id));
        return "redirect:/invoice/purchaseInvoiceList";
    }

    @PostMapping("/approvePurchaseInvoice/{id}")
    public String approvePurchaseInvoiceById(@PathVariable("id") Long id) {
        invoiceService.approvePurchaseInvoice(id);
        invoiceService.addProductToStockByInvoice(id);
        return "redirect:/invoice/purchaseInvoiceList";
    }


}
