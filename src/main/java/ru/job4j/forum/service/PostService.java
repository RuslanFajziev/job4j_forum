package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final List<Post> posts = new ArrayList<>();

    public PostService() {
        posts.add(Post.of("Продаю тачку, ладу 2114.",
                "Продаю тачку очень дешево"));
        posts.add(Post.of("Продаю книгу.",
                "Продаю книгу Война и Мир."));
//        posts.add(Post.of("fsfsfsf_fsf_fsf",
//                "dsd_dsdfsa"));
    }

    public List<Post> getAll() {
        return posts;
    }
}