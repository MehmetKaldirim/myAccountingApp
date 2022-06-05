package com.zeroToHero.accountingapp.service;


import com.zeroToHero.accountingapp.dto.ClientVendorDTO;

import java.util.List;

public interface ClientVendorService {
    List<ClientVendorDTO> listAllClients();
    ClientVendorDTO findById(Long id);
    void delete(Long id);
}