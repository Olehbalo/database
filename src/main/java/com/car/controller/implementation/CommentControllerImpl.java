
package com.car.controller.implementation;


import com.car.model.dao.implementation.CommentDAOImpl;
import com.car.model.entity.Comment;


public class CommentControllerImpl extends AbstractControllerImp<Comment> {
    public CommentControllerImpl() {
        super(new CommentDAOImpl());
    }
}