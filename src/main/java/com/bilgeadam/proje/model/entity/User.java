package com.bilgeadam.proje.model.entity;

import com.bilgeadam.proje.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "users")
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
//@SQLDelete(sql="UPDATE users set durum=0 where id= ? and version=?")

public class User  extends BaseEntity {


}
