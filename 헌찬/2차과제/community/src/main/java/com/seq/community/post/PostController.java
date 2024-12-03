package com.seq.community.post;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Controller
public class PostController {
    private final PostRepository postRepository;

    @Autowired
    PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/post")
    public String post(Model model) {
        List<Post> results = postRepository.findAll();

        model.addAttribute("post", results);
        return "post.html";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model) {
        Optional<Post> result = postRepository.findById(id);
        if(result.isPresent()) {
            model.addAttribute("post", result.get());
            return "detail.html";
        }else {
            return "redirect:/post";
        }
    }
}
