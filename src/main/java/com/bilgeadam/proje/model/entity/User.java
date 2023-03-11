package com.bilgeadam.proje.model.entity;

import com.bilgeadam.proje.common.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
//@SQLDelete(sql="UPDATE user set state=0 where id= ? and version=?")
public class User extends BaseEntity {

    /**
     * username information in User Table
     */
    @NotBlank
    @Size(min = 4, max = 15)
    @Column(name = "user_name")
    private String userName;

    /**
     * password information in User Table
     */
    @NotBlank
    @Size(min = 4, max = 50)
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * Confirmation password
     */
    @Transient
    @Size(min = 4, max = 50)
    private String cPassword;

    /**
     * Entity Email information
     */
    @Email
    @NotBlank
    @Size(min = 10, max = 50)
    @Column(name = "email")
    private String email;

    /**
     * Entity Phone Number information
     */
    @Size(min = 6, max = 20)
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * User gender information
     */
    @NotBlank
    @Column(name = "gender")
    private String gender;

    /**
     * User enabled information
     */
    @Column(name = "enabled")
    private boolean isEnable = true;

    /**
     * Relation of role entity
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Set<Role> roles;

}
