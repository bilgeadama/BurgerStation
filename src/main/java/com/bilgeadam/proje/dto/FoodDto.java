package com.bilgeadam.proje.dto;

import com.bilgeadam.proje.common.dto.BaseDto;
import com.bilgeadam.proje.consts.MessageConstants;
import com.bilgeadam.proje.model.Comment;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FoodDto extends BaseDto {

    /**
     * Food category information
     */
    @NotBlank(message = MessageConstants.MESSAGE_NOT_BLANK)
    private String category;

    /**
     * Food title information
     */
    @NotBlank(message = MessageConstants.MESSAGE_NOT_BLANK)
    @Size(min = 5, max = 30)
    private String title;

    /**
     * Food description information
     */
    @NotBlank(message = MessageConstants.MESSAGE_NOT_BLANK)
    @Size(min = 4, max = 500)
    private String description;

    /**
     * Food price information
     */
    @NotNull(message = MessageConstants.MESSAGE_NOT_BLANK)
    @Min(50)
    @Max(1000)
    private int price;

    /**
     * List of Foods relation between comments
     */
    private Set<CommentDto> commentDtos;
}
