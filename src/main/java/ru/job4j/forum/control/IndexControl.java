package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class IndexControl {
    private final PostService posts;

    public IndexControl(PostService posts) {
        this.posts = posts;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("posts", posts.getAll());
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/post_form")
    public String postForm() {
        return "post_form";
    }

    @GetMapping("/post_edit")
    public String postEdit(Model model, int id) {
        Post post = posts.getAll().get(id);
        model.addAttribute("post", post);
        return "post_edit";
    }
}