package com.bilgeadam.proje.entity;

import com.bilgeadam.proje.common.entity.BaseEntity;
import com.bilgeadam.proje.consts.EntityConstants;
import com.bilgeadam.proje.consts.MessageConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@SQLDelete(sql = "UPDATE burger_station.foods set state=0 where id= ? and version=?")
@Where(clause = EntityConstants.WHERE_CLAUSE)
@Table(name = "foods")
public class FoodEntity extends BaseEntity {

    /**
     * Food category information
     */
//    todo kategori tablosu olusturulup baglanabilir veya enum olarak tanımlanabilir.
    @NotBlank(message = MessageConstants.MESSAGE_NOT_BLANK)
    @Column(name = "category")
    private String category;

    /**
     * Food title information
     */
    @NotBlank(message = MessageConstants.MESSAGE_NOT_BLANK)
    @Size(min = 5, max = 30)
    @Column(name = "title")
    private String title;

    /**
     * Food description information
     */
    @NotBlank(message = MessageConstants.MESSAGE_NOT_BLANK)
    @Size(min = 4, max = 500)
    @Column(name = "description")
    private String description;

    /**
     * Food price information
     */
    @NotNull(message = MessageConstants.MESSAGE_NOT_BLANK)
    @Min(50)
    @Max(1000)
    @Column(name = "price")
    private int price;

    /**
     * Foods comments relation
     */
//            --version - 1---
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "food_id",referencedColumnName = "id")
//            --version - 2 --
    @OneToMany(mappedBy = "food", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @ToString.Exclude
    private Set<CommentEntity> commentEntities;
}
