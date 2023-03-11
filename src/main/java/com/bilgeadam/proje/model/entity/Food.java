package com.bilgeadam.proje.model.entity;

import com.bilgeadam.proje.common.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

//@SQLDelete(sql="UPDATE user set durum=0 where id= ? and version=?")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "foods")
public class Food extends BaseEntity {

    /**
     * Food category information
     */
//    todo kategori tablosu olusturulup baglanabilir veya enum olarak tanımlanabilir.
    @NotBlank
    @Column(name = "category")
    private String category;

    /**
     * Food title information
     */
    @NotBlank
    @Size(min = 5, max = 30)
    @Column(name = "title")
    private String title;

    /**
     * Food description information
     */
    @NotBlank
    @Size(min = 4, max = 500)
    @Column(name = "description")
    private String description;

    /**
     * Food price information
     */
    @NotNull
    @Min(50)
    @Max(1000)
    @Column(name = "price")
    private int price;

    /**
     * Foods comments relation
     */
//            --version - 1---
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "food_id",referencedColumnName = "id")
//            --version - 2 --
//    @OneToMany(mappedBy = "food",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    private Set<Comment> comments;
}
