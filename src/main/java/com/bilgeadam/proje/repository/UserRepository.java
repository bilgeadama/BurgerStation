package com.bilgeadam.proje.repository;

import com.bilgeadam.proje.common.repository.BaseRepository;
import com.bilgeadam.proje.model.Role;
import com.bilgeadam.proje.model.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends BaseRepository<User, UUID> {
    //Like la arama
    List<User> findByUserNameContainingIgnoreCase(String username);

    //int deger varsa user icinde between ile arama
    List<User> findByAgeBetween(int ageStart, int ageEnd);

    //email parametreli distinc ile arama


    //icinde or & and in oldugu bi query

    //JPQL ile Driven query yaz
    //Role tablosunda name i olan ve userleri getiren, role ile user arasindaki iliskiyi getiren JPQL

    @Query("SELECT c FROM users c INNER JOIN roles r ON Id WHERE r.name =?1")
    List<Role> findByRoleName(String name);


}
