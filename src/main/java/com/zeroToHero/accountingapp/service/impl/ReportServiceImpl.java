package com.zeroToHero.accountingapp.service.impl;

import com.zeroToHero.accountingapp.dto.ProductDTO;
import com.zeroToHero.accountingapp.dto.ReportDTO;
import com.zeroToHero.accountingapp.entity.User;
import com.zeroToHero.accountingapp.enums.InvoiceType;
import com.zeroToHero.accountingapp.repository.InvoiceProductRepository;
import com.zeroToHero.accountingapp.repository.UserRepository;
import com.zeroToHero.accountingapp.service.ReportService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    private final InvoiceProductRepository invoiceProductRepository;
    private final UserRepository userRepository;

    public ReportServiceImpl(InvoiceProductRepository invoiceProductRepository, UserRepository userRepository) {
        this.invoiceProductRepository = invoiceProductRepository;
        this.userRepository = userRepository;
    }



    @Override
    public Map<String, BigDecimal> profitLoss() {

        User user = userRepository.findByEmail("admin@company2.com");

        Map<String, BigDecimal> profitLoss = new HashMap<>();


        BigDecimal totalCost = invoiceProductRepository.findAllByInvoice_InvoiceTypeAndInvoice_Company(InvoiceType.PURCHASE, user.getCompany()).stream().
                map(p->p.getPrice()).
                reduce(BigDecimal.ZERO, (a, b) -> a.add(b));


        BigDecimal totalSale = invoiceProductRepository.findAllByInvoice_InvoiceTypeAndInvoice_Company(InvoiceType.SALE, user.getCompany()).stream().
                map(p->p.getPrice()).
                reduce(BigDecimal.ZERO, (a, b) -> a.add(b));


        BigDecimal totalTax = invoiceProductRepository.findAllByInvoice_InvoiceTypeAndInvoice_Company(InvoiceType.SALE, user.getCompany()).stream().
                map(p->p.getTax()).
                reduce(BigDecimal.ZERO, (a, b) -> a.add(b));


        profitLoss.put("totalCost", totalCost);
        System.out.println("this is total cost =  "+ totalCost);
        profitLoss.put("totalSale", totalSale);
        System.out.println("this is total sale =  " + totalSale);
        profitLoss.put("totalTax", totalTax);
        System.out.println("this is total for tax =  " + totalTax);

        return profitLoss;
    }

    @Override
    public Set<ReportDTO> calculateByProducts() {
        Set<ReportDTO> list= new HashSet<>();
        User user = userRepository.findByEmail("admin@company2.com");
        invoiceProductRepository.findAllByInvoice_Company(user.getCompany()).stream().forEach(p->{
            BigDecimal totalCost = invoiceProductRepository.findAllByInvoice_InvoiceTypeAndInvoice_Company(InvoiceType.PURCHASE,user.getCompany())
                    .stream()
                    .filter(product->product.getName().equals(p.getName()))
                    .map(product->product.getPrice()).
                    reduce(BigDecimal.ZERO, (a, b) -> a.add(b));

            BigDecimal purchasedQTY = invoiceProductRepository.findAllByInvoice_InvoiceTypeAndInvoice_Company(InvoiceType.PURCHASE,user.getCompany())
                    .stream()
                    .filter(product->product.getName().equals(p.getName()))
                    .map(product->product.getQty()).
                    reduce(BigDecimal.ZERO, (a, b) -> a.add(b));

            BigDecimal totalIncome = invoiceProductRepository.findAllByInvoice_InvoiceTypeAndInvoice_Company(InvoiceType.SALE,user.getCompany())
                    .stream()
                    .filter(product->product.getName().equals(p.getName()))
                    .map(product->product.getPrice()).
                    reduce(BigDecimal.ZERO, (a, b) -> a.add(b));

            BigDecimal soldQTY = invoiceProductRepository.findAllByInvoice_InvoiceTypeAndInvoice_Company(InvoiceType.SALE,user.getCompany())
                    .stream()
                    .filter(product->product.getName().equals(p.getName()))
                    .map(product->product.getQty()).
                    reduce(BigDecimal.ZERO, (a, b) -> a.add(b));

            list.add(new ReportDTO(p.getName(),purchasedQTY,soldQTY,totalCost,totalIncome));
        });
        list.forEach(System.out::println);
        return list;
    }


}
