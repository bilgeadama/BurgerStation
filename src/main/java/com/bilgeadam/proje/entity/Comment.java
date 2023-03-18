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
@AllArgsConstructor
@RequiredArgsConstructor
@SQLDelete(sql = "UPDATE burger_station.comments set state=0 where id= ? and version=?")
@Where(clause = EntityConstants.WHERE_CLAUSE)
@Table(name = "comments")
public class Comment extends BaseEntity {

    /**
     * Comment information
     */
    @Column(name = "comment")
    private String comment;

    /**
     * Food Relation
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;
}
