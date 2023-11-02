package com.ukrainians.dto;

import java.sql.Timestamp;

public class PostResponse {
    private Long postId;
    private Long userId;
    private String content;
    private Timestamp timestamp;

    public PostResponse() {
    }

    public PostResponse(Long postId, Long userId, String content, Timestamp timestamp) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.timestamp = timestamp;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
