package com.example.restfulwebservices.post;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    List<Post> findALl() {
        return postRepository.findAll();
    }

    Post findOne(Long id) {
        return postRepository.findOneById(id).orElse(null);
    }

    public Post createPost(Post post) {
        return  postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
