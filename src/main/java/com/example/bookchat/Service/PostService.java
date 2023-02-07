package com.example.bookchat.Service;

import com.example.bookchat.Entety.Post;
import com.example.bookchat.Repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class PostService {

    @Autowired
    PostRepo postRepo;

    public ArrayList<Post> submitPostToDB(Post postData){
        postRepo.save(postData);
        ArrayList<Post> result=retrivePostFromDB();
        return result;
    }

    public ArrayList<Post> retrivePostFromDB(){
        ArrayList<Post> result = postRepo.findAll();
        return result;

    }
    public ArrayList<Post> deletePostFromDB(UUID postID){
        postRepo.deleteById(postID);
        ArrayList<Post> result=retrivePostFromDB();
        return result;
    }
}
