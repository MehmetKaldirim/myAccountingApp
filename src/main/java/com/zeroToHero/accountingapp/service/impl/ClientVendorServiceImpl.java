package com.zeroToHero.accountingapp.service.impl;


import com.zeroToHero.accountingapp.dto.ClientVendorDTO;
import com.zeroToHero.accountingapp.entity.ClientVendor;
import com.zeroToHero.accountingapp.enums.CompanyType;
import com.zeroToHero.accountingapp.mapper.MapperUtil;
import com.zeroToHero.accountingapp.repository.ClientVendorRepository;
import com.zeroToHero.accountingapp.service.ClientVendorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientVendorServiceImpl implements ClientVendorService {

    private final ClientVendorRepository clientVendorRepository;
    private final MapperUtil mapperUtil;

    public ClientVendorServiceImpl(ClientVendorRepository clientVendorRepository, MapperUtil mapperUtil) {
        this.clientVendorRepository = clientVendorRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<ClientVendorDTO> listAllClients() {
        return clientVendorRepository.findAllBy().stream().map(p -> mapperUtil.convert(p, new ClientVendorDTO())).collect(Collectors.toList());
    }

    @Override
    public ClientVendorDTO findById(Long id) {
        return mapperUtil.convert(clientVendorRepository.findById(id), new ClientVendorDTO());
    }

    @Override
    public void delete(Long id) {
        ClientVendor clientVendor = clientVendorRepository.findById(id).get();
        clientVendor.setIsDeleted(true);
        clientVendorRepository.save(clientVendor);
    }

    @Override
    public void save(ClientVendorDTO dto) {
        dto.setEnabled(true);
        clientVendorRepository.save(mapperUtil.convert(dto, new ClientVendor()));
    }

    @Override
    public ClientVendorDTO update(ClientVendorDTO dto) {
        ClientVendor client = clientVendorRepository.findByEmail(dto.getEmail());
        ClientVendor convertedClient = mapperUtil.convert(dto,new ClientVendor());
        convertedClient.setId(client.getId());
        clientVendorRepository.save(convertedClient);
        return findByEmail(dto.getEmail());
    }

    @Override
    public ClientVendorDTO findByEmail(String email) {
        ClientVendor clientVendor = clientVendorRepository.findByEmail(email);
        return mapperUtil.convert(clientVendor,new ClientVendorDTO());
    }

    @Override
    public List<ClientVendorDTO> findAllByCompanyType(CompanyType companyType) {
        return clientVendorRepository.findAllByType (companyType)
                .stream()
                .map(p -> mapperUtil.convert(p, new ClientVendorDTO()))
                .collect(Collectors.toList());

    }

    @Override
    public ClientVendor findVendorById(Long vendorId) {
        return clientVendorRepository.findById(vendorId).get();
    }

    @Override
    public String findClientNameById(Long id) {
        return clientVendorRepository.findClientNameById(id);
    }

}