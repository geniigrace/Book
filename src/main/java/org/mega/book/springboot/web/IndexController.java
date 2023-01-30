package org.mega.book.springboot.web;

import lombok.RequiredArgsConstructor;
import org.mega.book.springboot.config.auth.LoginUser;
import org.mega.book.springboot.config.auth.dto.SessionUser;
import org.mega.book.springboot.service.PostsService;
import org.mega.book.springboot.web.dto.PostsResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;

    private final HttpSession httpSession;
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){

        model.addAttribute("posts",postsService.findAllDesc());

        //SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null){
            System.out.println(user.getName());
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }


}
