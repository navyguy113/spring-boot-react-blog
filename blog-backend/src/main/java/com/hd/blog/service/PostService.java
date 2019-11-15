package com.hd.blog.service;

import com.hd.blog.model.domain.Post;
import com.hd.blog.model.domain.User;
import com.hd.blog.repository.PostRepository;
import com.hd.blog.security.service.CustomUserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Optional<Post> findForId(Long id){
        return postRepository.findById(id);
    }

    public Post registerPost(Post post, CustomUserDetails customUserDetails) {
        Post newPost = new Post();
        newPost.setTitle(post.getTitle());
        newPost.setBody(post.getBody());
        newPost.setCreatedBy(customUserDetails.getName());
        newPost.setCreatedDate(LocalDateTime.now());
        newPost.setUser(new User(customUserDetails.getId())); // temporary code
//        return new Post(postRepository.saveAndFlush(newPost));
        return postRepository.saveAndFlush(newPost);
    }
}
