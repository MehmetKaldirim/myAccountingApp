package com.zeroToHero.accountingapp.entity;

import com.zeroToHero.accountingapp.enums.State;
import com.zeroToHero.accountingapp.enums.CompanyType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Where(clause = "is_deleted=false")
public class ClientVendor extends BaseEntity {

    private String companyName;
    private String phone;
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @Enumerated(EnumType.STRING)
    private CompanyType type;

    private String zipCode;
    private String address;

    @Enumerated(EnumType.STRING)
    private State state_id;

    private boolean enabled;

}
