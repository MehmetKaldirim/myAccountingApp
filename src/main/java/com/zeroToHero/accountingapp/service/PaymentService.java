package com.zeroToHero.accountingapp.service;



import com.zeroToHero.accountingapp.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {

  List<PaymentDTO> listAllPayments();

  List<PaymentDTO> listByYearAndCompany(String year);

  PaymentDTO findById(Long id);

  void delete(Long id);

  PaymentDTO findPaymentById(Long id);

  void chargePaymentById(Long id);

}
