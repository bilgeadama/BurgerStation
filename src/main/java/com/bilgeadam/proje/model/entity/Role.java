package com.bilgeadam.proje.model.entity;

import com.bilgeadam.proje.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
//@SQLDelete(sql="UPDATE role set state=0 where id= ? and version=?")
public class Role extends BaseEntity {

    /**
     * Role entity user relation information
     */
    @Column(name = "user_id")
    private UUID userId;

    /**
     * Role Entity name information
     */
    @Column(name = "name")
    private String name;
}
