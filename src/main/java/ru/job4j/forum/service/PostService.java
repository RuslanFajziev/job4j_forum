package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepos;

import java.util.Collection;

@Service
public class PostService {
    private PostRepos repos;

    public PostService(PostRepos repos) {
        this.repos = repos;
    }

    public Collection<Post> getPosts() {
        return repos.getPosts();
    }

    public Post getPost(int id) {
        return repos.getPost(id);
    }

    public Post savePost(Post postTmp) {
        return repos.savePost(postTmp);
    }

    public void deletePost(Integer id) {
        repos.deletePost(id);
    }
}