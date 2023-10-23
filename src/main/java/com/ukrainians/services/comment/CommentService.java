package com.ukrainians.services.comment;

import com.ukrainians.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(Comment comment);

    Comment getCommentById(Long commentId);

    List<Comment> getAllComments();

    List<Comment> getCommentsByPostId(Long postId);

    void deleteComment(Long commentId);
}

