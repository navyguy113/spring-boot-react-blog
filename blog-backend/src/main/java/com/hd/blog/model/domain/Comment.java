package com.hd.blog.model.domain;

import com.hd.blog.model.BaseModel;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(name = "body", columnDefinition = "TEXT")
    private String body;

    @Column(name = "created_date", nullable = false, updatable = false)
    @NotNull
    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "post_id", nullable = false)
    @NotNull
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @NotNull
    private User user;

    public Long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public Post getPost() {
        return post;
    }

    public User getUser() {
        return user;
    }

    public void setBody( String body ) {
        this.body = body;
    }

    public void setLastModifiedDate( LocalDateTime lastModifiedDate ) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setPost( Post post ) {
        this.post = post;
    }

    public void setUser( User user ) {
        this.user = user;
    }
}
