package com.seq.community.post;

import com.seq.community.account.AccountRepository;
import com.seq.community.account.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class WriteController {
    private final PostRepository postRepository;

    @GetMapping("/write")
    String write() {
        return "write.html";
    }

    @PostMapping("/write/posting")
    String posting(@RequestParam Map<String, String> data, Authentication auth) {


        Post post = new Post();
        var user = (CustomUser) auth.getPrincipal();

        post.setTitle(data.get("title"));
        post.setContent(data.get("content"));
        post.setWriter(user.getUsername());

        ZonedDateTime koreaTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        post.setDate(koreaTime.format(formatter));

        postRepository.save(post);
        return "redirect:/post";
    }
}
