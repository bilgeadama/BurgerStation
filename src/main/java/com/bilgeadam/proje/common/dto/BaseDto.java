package com.bilgeadam.proje.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseDto implements Serializable {

    /**
     * Dto id information
     */
    private UUID id;

    /**
     * Dto state information
     */
    private short state=1;

    /**
     * Dto version information
     */
    private Long version;
}
