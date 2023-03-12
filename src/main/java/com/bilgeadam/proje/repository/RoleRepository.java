package com.bilgeadam.proje.repository;

import com.bilgeadam.proje.common.repository.BaseRepository;
import com.bilgeadam.proje.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RoleRepository extends BaseRepository <Role, UUID> {

    /**
     *
     *
     */

    List<Role> findByNameEquals(String name);

    List<Role> findByUURoles(int id);

}
