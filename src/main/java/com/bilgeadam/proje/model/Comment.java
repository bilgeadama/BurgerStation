package com.bilgeadam.proje.model;

import com.bilgeadam.proje.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@SQLDelete(sql="UPDATE burger_station.comments set state=0 where id= ? and version=?")
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
    @JoinColumn(name = "id")
    private Food food;
}
