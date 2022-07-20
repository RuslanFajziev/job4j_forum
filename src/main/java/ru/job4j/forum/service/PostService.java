package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private PostRepository repos;

    public PostService(PostRepository repos) {
        this.repos = repos;
    }

    public Collection<Post> getPosts() {
        List<Post> lstPost = new ArrayList<Post>();
        repos.findAll().forEach(lstPost::add);
        return lstPost;
    }

    public Post getPost(int id) {
        Optional<Post> optionalPost = repos.findById(id);
        if (optionalPost.isEmpty()) {
            return new Post();
        }
        return optionalPost.get();
    }

    public Post savePost(Post postTmp) {
        return repos.save(postTmp);
    }

    public void deletePost(Integer id) {
        repos.deleteById(id);
    }
}