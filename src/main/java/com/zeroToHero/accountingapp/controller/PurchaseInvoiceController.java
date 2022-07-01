package com.zeroToHero.accountingapp.controller;


import com.zeroToHero.accountingapp.dto.ClientVendorDTO;
import com.zeroToHero.accountingapp.dto.InvoiceDTO;
import com.zeroToHero.accountingapp.dto.InvoiceProductDTO;
import com.zeroToHero.accountingapp.dto.UserDTO;
import com.zeroToHero.accountingapp.enums.CompanyType;
import com.zeroToHero.accountingapp.enums.InvoiceType;

import com.zeroToHero.accountingapp.enums.UserStatus;
import com.zeroToHero.accountingapp.exception.RecordNotFoundException;
import com.zeroToHero.accountingapp.service.ClientVendorService;
import com.zeroToHero.accountingapp.service.InvoiceProductService;
import com.zeroToHero.accountingapp.service.InvoiceService;
import com.zeroToHero.accountingapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;


@Controller
@RequestMapping("/purchase")
public class PurchaseInvoiceController {
    private InvoiceDTO tempInvoiceDTO = new InvoiceDTO();

    final private InvoiceService invoiceService;
    final private InvoiceProductService invoiceProductService;
    final private ClientVendorService clientVendorService;
    final private ProductService productService;

    public PurchaseInvoiceController(InvoiceService invoiceService, InvoiceProductService invoiceProductService, ClientVendorService clientVendorService, ProductService productService) {
        this.invoiceService = invoiceService;
        this.invoiceProductService = invoiceProductService;
        this.clientVendorService = clientVendorService;
        this.productService = productService;
    }

    @GetMapping("/list")
    public String purchaseInvoiceList(Model model) {
        model.addAttribute("invoice",tempInvoiceDTO );
        model.addAttribute("clientVendor",new ClientVendorDTO());
        model.addAttribute("vendors",clientVendorService.findAllByCompanyType(CompanyType.VENDOR));
        model.addAttribute("purchaseInvoices", invoiceService.listAllByInvoiceType(InvoiceType.PURCHASE));
        return "invoice/purchase-invoice-list";
    }




     //@GetMapping(value = {"/create","/create/{id}"}) //check baldung optional path variables
    @GetMapping("/create") //check baldung optional path variables
    public String addInvoice(@RequestParam Long id, Model model) throws RecordNotFoundException {
        tempInvoiceDTO.setClientVendor(clientVendorService.findVendorById(id));
        tempInvoiceDTO.setInvoiceNumber(invoiceService.createInvoiceNumber(InvoiceType.PURCHASE));
        tempInvoiceDTO.setInvoiceDate(LocalDate.now());
        model.addAttribute("invoice",tempInvoiceDTO);
        model.addAttribute("vendors",clientVendorService.findAllByCompanyType(CompanyType.VENDOR));
        model.addAttribute("products",productService.listAllProducts());
        model.addAttribute("invoiceProduct", new InvoiceProductDTO());
        model.addAttribute("tempProducts",invoiceProductService.listAllTempProducts());
        return "/invoice/purchase-invoice-create";

    }

    @PostMapping("/insertProduct")
    public String insertProduct(InvoiceProductDTO invoiceProductDTO) {
        invoiceProductDTO.setName(invoiceProductDTO.getProductDTO().getName());
        invoiceProductService.saveTemp(invoiceProductDTO);
        //tempInvoiceDTO.getInvoiceProductList().add(invoiceProductDTO);
        return "redirect:/purchase/create?id="+tempInvoiceDTO.getClientVendor().getId();
        //return "redirect:/purchase/create/"+tempInvoiceDTO.getClientVendor().getId();
    }
    @GetMapping("/getTemp/{id}")
    public String deleteTempProduct(@PathVariable("id") Long id, Model model) {
        System.out.println("here in controller get delete");
        //model.addAttribute("tempProducts",invoiceProductService.findTempInvoiceProductById(id));
        invoiceProductService.deleteTemp(id);
        return "redirect:/purchase/create? id=" + tempInvoiceDTO.getClientVendor().getId();
        //return "redirect:/purchase/create/" + tempInvoiceDTO.getClientVendor().getId();

    }

    @PostMapping("/saveInvoice")
    public String saveInvoice(Model model) throws RecordNotFoundException{
        tempInvoiceDTO.setInvoiceType(InvoiceType.PURCHASE);
        invoiceService.save(tempInvoiceDTO);
        return "redirect:/purchase/list";
    }


}
