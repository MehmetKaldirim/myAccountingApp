package com.zeroToHero.accountingapp.converter;



import com.zeroToHero.accountingapp.dto.ClientVendorDTO;
import com.zeroToHero.accountingapp.entity.ClientVendor;
import com.zeroToHero.accountingapp.mapper.MapperUtil;
import com.zeroToHero.accountingapp.repository.ClientVendorRepository;
import com.zeroToHero.accountingapp.service.ClientVendorService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class ClientVendorDTOConverter implements Converter<String, ClientVendorDTO> {

    private final ClientVendorRepository clientVendorRepository;
    private final MapperUtil mapperUtil;

    public ClientVendorDTOConverter(@Lazy ClientVendorRepository clientVendorRepository, MapperUtil mapperUtil) {
        this.clientVendorRepository = clientVendorRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public ClientVendorDTO convert(String source) {
        if (source == null || source.equals("")) {
            return null;
        }

        ClientVendor clientVendor= clientVendorRepository.findById(Long.parseLong(source)).orElseThrow();
        return mapperUtil.convert(clientVendor, new ClientVendorDTO());

    }



}
