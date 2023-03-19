package com.bilgeadam.proje.repository;

import com.bilgeadam.proje.common.repository.BaseRepository;
import com.bilgeadam.proje.entity.RoleEntity;
import com.bilgeadam.proje.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends BaseRepository<UserEntity, UUID> {
    //Like la arama
    List<UserEntity> findByUserNameContainingIgnoreCase(String username);

    //Like la arama
    UserEntity findByUserNameIgnoreCase(String username);

    //int deger varsa user icinde between ile arama
    List<UserEntity> findByAgeBetween(int ageStart, int ageEnd);

    //email parametreli distinc ile arama


    //icinde or & and in oldugu bi query

    //JPQL ile Driven query yaz
    //Role tablosunda name i olan ve userleri getiren, role ile user arasindaki iliskiyi getiren JPQL

    @Query("SELECT c FROM RoleEntity  c INNER JOIN c.userEntity WHERE c.name =?1")
    List<RoleEntity> findByRoleName(String name);


}
