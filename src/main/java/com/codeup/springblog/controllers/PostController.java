package com.codeup.springblog.controllers;

import com.codeup.springblog.controllers.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {
//    GET	/posts	posts index page

@GetMapping("/posts")
public String getPost(Model model){
    ArrayList<Post> postlist = new ArrayList<>();
    postlist.add(new Post(2, "second post", "lorem arqrg qrgqergqr post 2 aegqerg lorem"));
    postlist.add(new Post(3, "third post", "lorem arqrg qrgqergqr post 3 aegqerg lorem"));
    model.addAttribute("posts", postlist);

    return "posts/index";
}

//    GET	/posts/{id}	view an individual post

    @GetMapping("/posts/{id}")
    public String getPostByID(@PathVariable int id, Model model){
        Post post1 = new Post(id, "Europas first post", "Remote learnig today..");
        model.addAttribute("title", post1.getTitle());
        model.addAttribute("body", post1.getBody());
        return "posts/show";
    }

    //    GET	/posts/create	view the form for creating a post
    @GetMapping("/posts/create")
    @ResponseBody
    public String getCreateBlogPost(){
        return "Here you will create a new post!";
    }

    //    POST	/posts/create	create a new post
//    @PostMapping("/posts/create")
    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String getPostCreateBlogPost() {
        return "Your post will be submitted here!";
    }

}
