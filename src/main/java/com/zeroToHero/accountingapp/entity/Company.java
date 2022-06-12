package com.zeroToHero.accountingapp.entity;

import com.zeroToHero.accountingapp.enums.CompanyStatus;
import com.zeroToHero.accountingapp.enums.State;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;



@Entity
@NoArgsConstructor
@Getter
@Setter
@Where(clause = "is_deleted=false")
public class Company extends BaseEntity {
    private String title;
    private String address1;
    private String address2;
    private String zip;
    private String representative;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate establishmentDate;
    private boolean enabled;
    private String phone;
    @Enumerated(EnumType.STRING)
    private State state;
    @Enumerated(EnumType.STRING)
    private CompanyStatus companyStatus;

}
