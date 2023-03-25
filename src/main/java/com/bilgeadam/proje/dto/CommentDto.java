package com.bilgeadam.proje.dto;

import com.bilgeadam.proje.common.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDto extends BaseDto {

    /**
     * Comment information
     */
    private String comment;

    /**
     * Food Id information
     */
    private UUID foodId;

    /**
     * Food Id information
     */
    private String postedBy;
}
