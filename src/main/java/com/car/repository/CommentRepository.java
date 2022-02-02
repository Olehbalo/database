package com.car.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.car.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}