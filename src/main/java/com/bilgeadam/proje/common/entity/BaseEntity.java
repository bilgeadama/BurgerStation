package com.bilgeadam.proje.common.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
@Setter
@Getter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "durum <> 0")
public abstract class BaseEntity {

    /**
     * Entity primaryKey UUID
     */
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    /**
     * Entity Created Date
     */
    @CreatedDate
    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDateTime createDate;

    /**
     * Entity Created By
     */
    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    private String createdUser;

    /**
     * Entity Update Date
     */
    @LastModifiedDate
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    /**
     * Entity Updated By
     */
    @LastModifiedBy
    @Column(name = "updated_by")
    private String updatedUser;

    /**
     * State of entity
     * deleted = 0, undeleted=1
     */
    @Column(name = "state", nullable = false, updatable = false)
    private short state;

    /**
     * Entity Version
     */
    @Version
    @Column(name = "version", nullable = false)
    private Long version;

}
