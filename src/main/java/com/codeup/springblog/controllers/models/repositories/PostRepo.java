package com.codeup.springblog.controllers.models.repositories;

import com.codeup.springblog.controllers.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {

}
