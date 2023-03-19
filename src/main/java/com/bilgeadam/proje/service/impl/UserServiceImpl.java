package com.bilgeadam.proje.service.impl;

import com.bilgeadam.proje.common.service.impl.BaseService;
import com.bilgeadam.proje.dto.UserDto;
import com.bilgeadam.proje.entity.UserEntity;
import com.bilgeadam.proje.repository.UserRepository;
import com.bilgeadam.proje.service.UserService;
import com.bilgeadam.proje.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl extends BaseService<UserRepository, UserMapper, UserEntity, UserDto> implements UserService {


    private final UserRepository userRepository;

    protected UserServiceImpl(UserMapper mapper, UserRepository repository, UserRepository userRepository) {
        super(mapper, repository);
        this.userRepository = userRepository;
    }

    /**
     * @param UserDto
     * @return
     */
    public UserDto saveUser(UserDto UserDto) {

        return super.save(UserDto);
    }

    public List<UserDto> saveAllUsers(List<UserDto> UserDtoList) {

        return super.saveAll(UserDtoList);
    }

    /**
     * @return
     */
    @Override
    public List<UserDto> findAll() {

        return super.findAll();
    }

    /**
     * @param uuid
     * @return
     */
    @Override
    public UserDto findById(UUID uuid) {

        return super.findById(uuid);
    }

    /**
     * @param userName
     * @return
     */
    @Override
    public UserDto findByUserName(String userName) {

        return mapper.entityToDto(userRepository.findByUserNameIgnoreCase(userName));
    }

    /**
     * @param UserDto
     */
    @Override
    public void delete(UserDto UserDto) {

        super.delete(UserDto);
    }

    /**
     * @param uuid
     */
    @Override
    public void deleteById(UUID uuid) {

        super.deleteById(uuid);
    }

    /**
     * @param UserDtos
     */
    @Override
    public void deleteAll(List<UserDto> UserDtos) {

        super.deleteAll(UserDtos);
    }
}
