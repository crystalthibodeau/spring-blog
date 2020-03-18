package com.codeup.springblog.controllers;

import com.codeup.springblog.controllers.models.Post;
import com.codeup.springblog.controllers.models.repositories.PostRepo;
import com.codeup.springblog.controllers.models.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    private UserRepository userDao;
    private PostRepo postDao;

    public PostController(UserRepository userDao, PostRepo postDao) {
        this.userDao = userDao;
        this.postDao = postDao;
    }
    // These two next steps are often called dependency injection, where we create a Repository instance and initialize it in the controller class constructor.



    //    GET	/posts	posts index page
    @GetMapping("/posts")
public String getPost(Model model){
    ArrayList<Post> postlist = new ArrayList<>();
    postlist.add(new Post( "second post", "lorem arqrg qrgqergqr post 2 aegqerg lorem", userDao.getOne(1L)));
    postlist.add(new Post("third post", "lorem arqrg qrgqergqr post 3 aegqerg lorem", userDao.getOne(1L)));
    model.addAttribute("posts", postlist);

    return "posts/index";
//        model.addAttribute("posts", postDao.findAll());
//        return "posts/index";
}

//    GET	/posts/{id}	view an individual post

    @GetMapping("/posts/{id}")
    public String getPostByID(@PathVariable int id, Model model){
        Post post1 = new Post(id, "Europas first post", "Remote learnig today..", userDao.getOne(1L));
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

//    Implement edit and delete functionality.

    @GetMapping("/posts/update/{id}/{title}")
    @ResponseBody
    public String updatePost(@PathVariable long id, @PathVariable String title) {
        Post post = postDao.getOne(id);
        post.setTitle(title);
        postDao.save(post);
        return "Updating post";
    }

    @PostMapping("posts/delete/{id}")
    public String updatePost(@PathVariable long id) {
//        Post post = postDao.getOne(id);
//        postDao.delete(post);
        postDao.deleteById(id);
        return "redirect:/posts";
    }
    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model) {
        Post postToEdit = postDao.getOne(id);
        model.addAttribute("post", postToEdit);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable long id, @RequestParam String title, @RequestParam String body) {
        Post p = postDao.getOne(id);
        p.setTitle(title);
        p.setBody(body);
        postDao.save(p);
        return "redirect:/posts";
    }
}
