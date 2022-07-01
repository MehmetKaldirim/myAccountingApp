package com.zeroToHero.accountingapp.repository;


import com.zeroToHero.accountingapp.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

  List<Payment> findAllBy();

  Payment findPaymentById(Long id);

  @Query(value = "SELECT * FROM payment ORDER BY to_date(month,'Month')",nativeQuery = true)
  List<Payment> findPaymentByYearOrderByMonth(String year);



}