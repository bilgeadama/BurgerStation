package com.bilgeadam.proje.entity;

import com.bilgeadam.proje.common.entity.BaseEntity;
import com.bilgeadam.proje.consts.EntityConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE burger_station.roles set state=0 where id= ? and version=?")
@Where(clause = EntityConstants.WHERE_CLAUSE)
@Table(name = "roles")
public class Role extends BaseEntity {

    /**
     * Role entity user relation information
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Role Entity name information
     */
    @Column(name = "name")
    private String name;
}
