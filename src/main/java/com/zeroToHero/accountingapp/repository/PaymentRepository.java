package com.zeroToHero.accountingapp.repository;


import com.zeroToHero.accountingapp.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

  List<Payment> findAllBy();

  List<Payment> findAllByYear(String year);

  Payment findPaymentById(Long id);
}
