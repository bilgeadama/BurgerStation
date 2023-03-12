package com.bilgeadam.proje.dto;

import com.bilgeadam.proje.common.dto.BaseDto;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleDto extends BaseDto {

    /**
     * Role entity user relation information
     */
    private UUID userId;

    /**
     * Role Entity name information
     */
    private String name;
}
