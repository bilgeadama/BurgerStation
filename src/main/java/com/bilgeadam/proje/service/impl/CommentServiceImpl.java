package com.bilgeadam.proje.service.impl;

import com.bilgeadam.proje.common.service.impl.BaseService;
import com.bilgeadam.proje.dto.CommentDto;
import com.bilgeadam.proje.entity.CommentEntity;
import com.bilgeadam.proje.repository.CommentRepository;
import com.bilgeadam.proje.service.CommentService;
import com.bilgeadam.proje.service.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentServiceImpl extends BaseService<CommentRepository, CommentMapper, CommentEntity, CommentDto> implements CommentService {

    private final CommentRepository commentRepository;

    protected CommentServiceImpl(CommentMapper mapper, CommentRepository repository, CommentRepository commentRepository) {
        super(mapper, repository);
        this.commentRepository = commentRepository;
    }

    /**
     * @param CommentDto
     * @return
     */
    public CommentDto saveComment(CommentDto CommentDto) {

        return super.save(CommentDto);
    }

    public List<CommentDto> saveAllComments(List<CommentDto> CommentDtoList) {

        return super.saveAll(CommentDtoList);
    }

    /**
     * @return
     */
    @Override
    public List<CommentDto> findAll() {

        return super.findAll();
    }

    /**
     * @param uuid
     * @return
     */
    @Override
    public CommentDto findById(UUID uuid) {

        return super.findById(uuid);
    }

    /**
     * @param foodId
     * @return
     */
    @Override
    public List<CommentDto> findByFoodId(UUID foodId) {

        return mapper.entityListToDtoList(commentRepository.findByFoodIdOrderByCreateDateDesc(foodId));
    }

    /**
     * @param CommentDto
     */
    @Override
    public void delete(CommentDto CommentDto) {

        super.delete(CommentDto);
    }

    /**
     * @param uuid
     */
    @Override
    public void deleteById(UUID uuid) {

        super.deleteById(uuid);
    }

    /**
     * @param CommentDtos
     */
    @Override
    public void deleteAll(List<CommentDto> CommentDtos) {

        super.deleteAll(CommentDtos);
    }
}
