package com.zeroToHero.accountingapp.service.impl;


import com.zeroToHero.accountingapp.dto.PaymentDTO;
import com.zeroToHero.accountingapp.mapper.MapperUtil;
import com.zeroToHero.accountingapp.repository.PaymentRepository;
import com.zeroToHero.accountingapp.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {
  private final PaymentRepository paymentRepository;
  private final MapperUtil mapperUtil;

  public PaymentServiceImpl(PaymentRepository paymentRepository, MapperUtil mapperUtil) {
    this.paymentRepository = paymentRepository;
    this.mapperUtil = mapperUtil;
  }

  @Override
  public List<PaymentDTO> listAllPayments() {
    return paymentRepository.findAllBy().stream()
        .map(p -> mapperUtil.convert(p, new PaymentDTO()))
        .collect(Collectors.toList());
  }

  @Override
  public List<PaymentDTO> listAllByYear(String year) {
    return paymentRepository.findAllByYear(year).stream()
        .map(payment -> mapperUtil.convert(payment, new PaymentDTO()))
        .collect(Collectors.toList());
  }

  @Override
  public PaymentDTO findById(Long id) {
    return mapperUtil.convert(paymentRepository.findById(id), new PaymentDTO());
  }

  @Override
  public void delete(Long id) {}

  @Override
  public PaymentDTO findPaymentById(Long id) {
    return mapperUtil.convert(paymentRepository.findPaymentById(id), new PaymentDTO());
  }
}
