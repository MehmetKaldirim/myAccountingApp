package com.zeroToHero.accountingapp.service;


import com.zeroToHero.accountingapp.dto.ClientVendorDTO;
import com.zeroToHero.accountingapp.entity.ClientVendor;
import com.zeroToHero.accountingapp.enums.CompanyType;

import java.util.List;

public interface ClientVendorService {
    List<ClientVendorDTO> listAllClients();
    ClientVendorDTO findById(Long id);
    void delete(Long id);
    void save(ClientVendorDTO dto);
    ClientVendorDTO update(ClientVendorDTO dto);
    ClientVendorDTO findByEmail(String email);

    List<ClientVendorDTO> findAllByCompanyType(CompanyType companyType);

    ClientVendor findVendorById(Long vendorId);

}