package com.example.bookchat.Controller;

import com.example.bookchat.Entety.Post;
import com.example.bookchat.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/api/postService")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/save")
    public ArrayList<Post> submitPost(@RequestBody Post body){
        ArrayList<Post> result=postService.submitPostToDB(body);
        return  result;

    }
    @GetMapping("/getPost")
    public ArrayList<Post> retrieveAllPost(){
        ArrayList<Post> result=postService.retrivePostFromDB();
        return result;

    }

    @DeleteMapping("/delete")
    public  ArrayList<Post> deleteParticularPost(@PathVariable("postId")UUID postID){
        ArrayList<Post> result=postService.deletePostFromDB(postID);
        return result;
    }
    //30:17
}
