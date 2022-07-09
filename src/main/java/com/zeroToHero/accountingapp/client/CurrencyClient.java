package com.zeroToHero.accountingapp.client;

import com.zeroToHero.accountingapp.dto.client.Latest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(url = "https://www.frankfurter.app/",name="CURRENCY-CLIENT")
public interface CurrencyClient {

    @GetMapping("/latest")
    Latest getCurrency();


}
