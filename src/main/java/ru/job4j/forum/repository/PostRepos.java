package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostRepos {
    private static AtomicInteger POST_ID = new AtomicInteger();
    private HashMap<Integer, Post> hashMapPosts;

    public PostRepos() {
        this.hashMapPosts = new HashMap<>();
    }

    public Collection<Post> getPosts() {
        return hashMapPosts.values();
    }

    public Post getPost(int id) {
        return hashMapPosts.get(id);
    }

    public Post savePost(Post postTmp) {
        if (postTmp.getId() == 0) {
            Integer idPost = POST_ID.incrementAndGet();
            postTmp.setId(idPost);
            return hashMapPosts.put(idPost, postTmp);
        }
            return hashMapPosts.put(postTmp.getId(), postTmp);
    }

    public void deletePost(Integer id) {
        hashMapPosts.remove(id);
    }
}