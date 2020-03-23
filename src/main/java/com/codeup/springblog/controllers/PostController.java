package com.codeup.springblog.controllers;
import com.codeup.springblog.Services.MailService;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepo;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {


    private UserRepository userDao;
    private PostRepo postDao;

    @Autowired
    private final MailService emailService;


    public PostController(UserRepository userDao, PostRepo postDao, MailService emailService) {
        this.userDao = userDao;
        this.postDao = postDao;
        this.emailService = emailService;

    }
    // These two next steps are often called dependency injection, where we create a Repository instance and initialize it in the controller class constructor.

    //    GET	/posts	posts index page
    @GetMapping("/posts")

public String getPost(Model model){
//    ArrayList<Post> postlist = new ArrayList<>();
//    postlist.add(new Post( "second post", "lorem arqrg qrgqergqr post 2 aegqerg lorem", userDao.getOne(1L)));
//    postlist.add(new Post("third post", "lorem arqrg qrgqergqr post 3 aegqerg lorem", userDao.getOne(1L)));
//    model.addAttribute("posts", postlist);

//    return "posts/index";

        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
}

//    GET	/posts/{id}	view an individual post

@GetMapping("/posts/{id}")
public String getPost(@PathVariable long id, Model model) {
    model.addAttribute("user", (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    model.addAttribute("post",postDao.getOne(id));
    return "posts/show";
//    model.addAttribute("post",postDao.getOne(id));
//    return "posts/show";
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
        System.out.println((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loggedInUser.getId() == postDao.getOne(id).getUser().getId()){
            // delete post
            System.out.println(loggedInUser.getId());
            System.out.println(postDao.getOne(id).getUser().getId());
            System.out.println(postDao.getOne(id).getId());
            postDao.deleteById(id);
        }else{
            return "redirect:/posts";
        }

        return "redirect:/posts";
//        postDao.deleteById(id);
//        return "redirect:/posts";
    }
    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model) {
        Post postToEdit = postDao.getOne(id);
        model.addAttribute("post", postToEdit);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@ModelAttribute Post post, @PathVariable long id) {
        Post p = postDao.getOne(id);
        p.setTitle(p.getTitle());
        p.setBody(p.getBody());
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String createForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
//        Post post = new Post();
        String emailSubject = "This is the email subject";
        String emailBody = "Email Body Test";
        post.setUser(userDao.getOne(1L));
        postDao.save(post);
        emailService.prepareAndSend(post, emailSubject, emailBody);
//        post.setTitle(title);
//        post.setBody(body);
//        postDao.save(post);
        return "redirect:/posts";
    }
}
