package com.bilgeadam.proje.repository;

import com.bilgeadam.proje.common.repository.BaseRepository;
import com.bilgeadam.proje.model.User;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends BaseRepository<User, UUID> {
    //Like la arama
    List<User> findByUserNameContainingIgnoreCase(String username);

    //int deger varsa user icinde between ile arama
    List<User> findbyAgeBetween(int ageStart,int ageEnd);

    //email parametreli distinc ile arama


    //icinde or & and in oldugu bi query

    //JPquel ile Driven query yaz

}
