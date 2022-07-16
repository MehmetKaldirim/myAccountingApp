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
    final private ProductService productService;

    public PurchaseInvoiceController(InvoiceService invoiceService, ClientVendorService clientVendorService,
                                     InvoiceProductService invoiceProductService, ProductService productService) {
        this.invoiceService = invoiceService;
        this.clientVendorService = clientVendorService;
        this.invoiceProductService = invoiceProductService;
        this.productService = productService;
    }

    @GetMapping("/purchaseInvoiceList")
    public String purchaseInvoiceList(Model model) {
        model.addAttribute("purchaseInvoices", invoiceService.listAllByInvoiceType(InvoiceType.PURCHASE));
        return "invoice/purchase-invoice-list";
    }



    @PostMapping("/setInvoiceStatusEnabled/{id}")
    public String setInvoiceStatusEnabled(@PathVariable("id") Long id){
        invoiceService.enableInvoice(id);
        return "redirect:/invoice/purchaseInvoiceList";
    }


    @PostMapping("/purchaseInvoiceList/{id}")
    public String saveInvoice(@PathVariable("id") Long id) {

        invoiceService.enableInvoice(id);
        return "redirect:/invoice/purchaseInvoiceList";
    }
    @GetMapping("/editPurchaseInvoiceSelectProduct/{id}")
    public String editPurchaseInvoiceSelectProduct (@PathVariable("id") Long id) {

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
        System.out.println("id 84 " + id);
        InvoiceDTO invoiceDTO = invoiceService.getInvoiceDTOById(id);
        model.addAttribute("id", id);
        model.addAttribute("invoiceDTO", invoiceDTO);
        model.addAttribute("companyName", invoiceDTO.getClientVendor().getCompanyName());
        model.addAttribute("date", invoiceService.getLocalDate());
        model.addAttribute("invoiceId", invoiceService.getNextInvoiceIdPurchase());
        model.addAttribute("tax", invoiceProductService.getTaxByInvoiceId(id));
        model.addAttribute("invoiceProductDTO",new InvoiceProductDTO());
        model.addAttribute("products", invoiceProductService.findAllProductsByCompanyName(invoiceDTO.getClientVendor().getCompanyName()));
        model.addAttribute("invoiceProducts", invoiceProductService.findAllInvoiceProductsByInvoiceId(id));
        return "invoice/purchase-invoice-select-product";
    }

    @PostMapping("/purchaseInvoiceSelectProduct/{id}")
    public String postProductDetailsForInvoiceProduct(@PathVariable("id") Long id, @ModelAttribute("invoiceProductDTO") InvoiceProductDTO invoiceProductDTO) {
        System.out.println("id 102 " + id);
        System.out.println("what is this " + invoiceProductDTO );
        invoiceProductDTO.setTax(invoiceProductService.getTaxByInvoiceId(id));
        invoiceProductDTO.setInvoiceDTO(invoiceService.getInvoiceDTOById(id));
        invoiceProductService.addInvoiceProductByInvoiceId(id, invoiceProductDTO);
        System.out.println("it s qty for purchase" + invoiceProductDTO.getQty());

        return "redirect:/invoice/purchaseInvoiceSelectProduct/" + id;
    }

    @PostMapping("/removeItemFromInvoice/{ipid}")
    public String deleteInvoiceProductFromInvoice(@PathVariable("ipid") Long ipid) {
        System.out.println("113 ipid " + ipid);
        Long id = invoiceProductService.findInvoiceIdByInvoiceProductId(ipid);
        invoiceProductService.deleteInvoiceProductById(ipid);
        return "redirect:/invoice/purchaseInvoiceSelectProduct/" + id;
    }


    @PostMapping("/deletePurchaseInvoice/{id}")
    public String approveDeleteToInvoice(@PathVariable("id") String id, Model model) {
        invoiceService.delete(invoiceService.getInvoiceNo(id));
        return "redirect:/invoice/purchaseInvoiceList";
    }

    @PostMapping("/toProductInvoice/{id}")
    public String toInvoice(@PathVariable("id") String id, Model model) {

        model.addAttribute("salesInvoices", invoiceService.listAllByInvoiceType(InvoiceType.SALE));
        model.addAttribute("clients", clientVendorService.findAllByCompanyType(CompanyType.CLIENT));
        Long invoiceId = invoiceService.getInvoiceNo(id);
        return "/invoice/toInvoice";
    }


    @PostMapping ("/approvePurchaseInvoice/{id}")
    public String approvePurchaseInvoiceById(@PathVariable("id") Long id){
        invoiceService.approvePurchaseInvoice(id);
        invoiceService.addProductToStockByInvoice(id);
        return "redirect:/invoice/purchaseInvoiceList";
    }


}
