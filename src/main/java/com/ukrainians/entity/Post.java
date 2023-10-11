package com.ukrainians.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import org.springframework.lang.NonNull;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @NotBlank(message = "The content must be complete and not contain only blanks.")
    @NotEmpty(message = "Content cannot be empty")
    private String content;

    private Timestamp createdAt;

    public Post(User user, @NonNull String content, Timestamp timestamp) {
        this.user = user;
        this.content = content;
        this.createdAt = timestamp;
    }

    public Post() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(user, post.user) && Objects.equals(content, post.content) && Objects.equals(createdAt, post.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, content, createdAt);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @NonNull
    public String getContent() {
        return content;
    }

    public void setContent(@NonNull String content) {
        this.content = content;
    }

    public void setCreatedAt(Timestamp timestamp) {
        this.createdAt = timestamp;
    }
}
