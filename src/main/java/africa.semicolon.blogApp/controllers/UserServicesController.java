package africa.semicolon.blogApp.controllers;


import africa.semicolon.blogApp.dtos.request.*;
import africa.semicolon.blogApp.dtos.response.ApiResponse;
import africa.semicolon.blogApp.service.UserServices;
import exception.BlogAppExceptions;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@AllArgsConstructor
@RequestMapping("/userService")
public class UserServicesController {
    private UserServices userServices;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserRequest registerUserRequest) {
        try{
           var reg = userServices.registerUser(registerUserRequest);
           return new ResponseEntity<>(new ApiResponse(true, reg), CREATED);
        }catch (BlogAppExceptions e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }

    @PostMapping("/create-post")
    public ResponseEntity<?> createPost(@RequestBody CreatePostRequest createPostRequest) {
        try{
            var post = userServices.createPost(createPostRequest);
            return new ResponseEntity<>(new ApiResponse(true, post), CREATED);
        }catch (BlogAppExceptions e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }

    @PostMapping("/edit-post")
    public ResponseEntity<?> editPost(@RequestBody EditRequest editPostRequest) {
        try{
            var post = userServices.editPost(editPostRequest);
            return new ResponseEntity<>(new ApiResponse(true, post), OK);
        }catch (BlogAppExceptions e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-post")
    public ResponseEntity<?> deletePost(@RequestBody DeleteRequest deletePostRequest) {
        try{
            var post = userServices.deletePost(deletePostRequest);
            return new ResponseEntity<>(new ApiResponse(true, post), OK);
        }catch (BlogAppExceptions e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }

    @GetMapping("/view-post")
    public ResponseEntity<?> viewPost(@RequestBody ViewPostRequest viewPostRequest) {
        try{
            var post = userServices.viewPost(viewPostRequest);
            return new ResponseEntity<>(new ApiResponse(true, post), OK);
        }catch (BlogAppExceptions e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }

    @PutMapping("/add-comment")
    public ResponseEntity<?> addComment(@RequestBody CommentRequest commentRequest) {
        try{
            var post = userServices.comment(commentRequest);
            return new ResponseEntity<>(new ApiResponse(true, post), OK);
        }catch (BlogAppExceptions e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
        try{
            var page = userServices.loginUser(loginRequest);
            return new ResponseEntity<>(new ApiResponse(true, page), OK);
        }catch (BlogAppExceptions e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(@RequestBody LogoutRequest logoutRequest){
        try{
            var page = userServices.logoutUser(logoutRequest);
            return new ResponseEntity<>(new ApiResponse(true, page), OK);
        }catch (BlogAppExceptions e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
}
