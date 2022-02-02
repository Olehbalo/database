package com.car.service;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.car.domain.Comment;
import com.car.repository.CommentRepository;
import com.car.service.AbstractService;

@AllArgsConstructor
@Service
public class CommentService extends AbstractService<Comment, Integer> {
    private final CommentRepository commentRepository;

    @Override
    protected JpaRepository<Comment, Integer> getRepository() {
        return commentRepository;
    }
}
