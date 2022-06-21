package com.zeroToHero.accountingapp.repository;


import com.zeroToHero.accountingapp.entity.Product;
import com.zeroToHero.accountingapp.entity.StockDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Queue;

public interface StockRepository extends JpaRepository<StockDetails,Long> {
    //StockDetails findFirstByIDateAndProductDescription(Product product);
   // @Query(value = "SELECT * FROM ticket t JOIN user_account ua ON t.user_account_id = ua.id WHERE ua.email = ?1", nativeQuery = true)
    //List<Ticket> findAllByUserEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM stock_details sd JOIN product p ON sd.product_id = p.id WHERE p.name = ?1 ORDER BY sd.i_date ASC", nativeQuery = true)
    List<StockDetails> findByIDateAndProductDescription (String name);



}
