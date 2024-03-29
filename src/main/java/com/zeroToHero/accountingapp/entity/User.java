package com.zeroToHero.accountingapp.entity;
import com.zeroToHero.accountingapp.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Where(clause= "is_deleted=false")
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private String phone;
    private Boolean enabled;
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    @ManyToOne(fetch=FetchType.EAGER)
    private Company company;
    @ManyToOne(fetch=FetchType.EAGER)
    private Role role;


}