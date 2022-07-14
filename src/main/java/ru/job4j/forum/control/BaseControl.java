package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class BaseControl {
    private final PostService postService;

    public BaseControl(PostService postService) {
        this.postService = postService;
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
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        return "post_edit";
    }

    @PostMapping("/post_save")
    public String postSave(Model model, Post post) {
        postService.savePost(post);
        model.addAttribute("posts", postService.getPosts());
        return "redirect:/";
    }
}