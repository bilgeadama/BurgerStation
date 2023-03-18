package com.bilgeadam.proje.dto;

import com.bilgeadam.proje.common.dto.BaseDto;
import com.bilgeadam.proje.consts.MessageConstants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto extends BaseDto {

    /**
     * username information in User Table
     */
    @NotBlank(message = MessageConstants.MESSAGE_NOT_BLANK)
    @Size(min = 4, max = 15)
    private String userName;

    /**
     * password information in User Table
     */
    @NotBlank(message = MessageConstants.MESSAGE_NOT_BLANK)
    @Size(min = 4, max = 50)
    private String password;

    /**
     * Confirmation password
     */
    @Size(min = 4, max = 50)
    private String cPassword;

    /**
     * Entity Email information
     */
    @Email
    @NotBlank(message = MessageConstants.MESSAGE_NOT_BLANK)
    @Size(min = 10, max = 50)
    private String email;

    /**
     * Entity Phone Number information
     */
    @Size(min = 6, max = 20)
    private String phoneNumber;

    /**
     * User gender information
     */
    @NotBlank(message = MessageConstants.MESSAGE_NOT_BLANK)
    private String gender;

    /**
     * User enabled information
     */
    private boolean isEnable = true;

    /**
     * Relation of role entity
     */
    private Set<RoleDto> roleDtos;
}
