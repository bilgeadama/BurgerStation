package com.bilgeadam.proje.service.impl;

import com.bilgeadam.proje.common.service.impl.BaseService;
import com.bilgeadam.proje.dto.UserDto;
import com.bilgeadam.proje.entity.Role;
import com.bilgeadam.proje.entity.User;
import com.bilgeadam.proje.repository.RoleRepository;
import com.bilgeadam.proje.repository.UserRepository;
import com.bilgeadam.proje.service.UserService;
import com.bilgeadam.proje.service.mapper.UserMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl extends BaseService<UserRepository, UserMapper, User, UserDto> implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    protected UserServiceImpl(UserMapper mapper, UserRepository repository, UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        super(mapper, repository);
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    /**
     * @param UserDto
     * @return
     */
    @Transactional
    public UserDto saveUser(UserDto UserDto) {

        return super.save(UserDto);
    }

    @Transactional
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
    public UserDto findByUsername(String userName) {

        return mapper.entityToDto(userRepository.findByUserNameIgnoreCase(userName).orElse(null));
    }

    /**
     * @param UserDto
     */
    @Transactional
    @Override
    public void delete(UserDto UserDto) {

        super.delete(UserDto);
    }

    /**
     * @param uuid
     */
    @Transactional
    @Override
    public void deleteById(UUID uuid) {

        super.deleteById(uuid);
    }

    /**
     * @param UserDtos
     */
    @Transactional
    @Override
    public void deleteAll(List<UserDto> UserDtos) {

        super.deleteAll(UserDtos);
    }

    @Override
    @Transactional
    public void makePayment(int spent) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User user = userRepository.findByUserNameIgnoreCase(auth.getName())
                .orElseThrow(() -> new IllegalStateException("User doesn't exist!"));

        user.setSpent(user.getSpent() + spent);
    }

    @Override
    public void registerUser(UserDto userDto) {

        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        super.save(userDto);
    }

    @Override
    public void makeAdmin(UUID id) {

        roleRepository.save(new Role(id,"ADMIN"));
    }

    @Override
    public void removeAdmin(UUID id) {

        roleRepository.deleteById(id);
    }

    @Override
    public void enableUser(UUID id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User does not exist"));
        user.setEnable(true);
        userRepository.save(user);
    }

    @Override
    public void disableUser(UUID id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User does not exist"));
        user.setEnable(false);
        userRepository.save(user);
    }

}
