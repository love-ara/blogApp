package africa.semicolon.blogApp.utils;


import africa.semicolon.blogApp.dtos.request.*;
import africa.semicolon.blogApp.dtos.response.*;
import africa.semicolon.blogApp.models.data.Comment;
import africa.semicolon.blogApp.models.data.Post;
import africa.semicolon.blogApp.models.data.User;
import africa.semicolon.blogApp.models.data.View;

import java.time.format.DateTimeFormatter;

public class Mapping {

    public static User map(RegisterUserRequest registerRequest) {
        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setPassword(registerRequest.getPassword());
        user.setUsername(registerRequest.getUsername().toLowerCase());
        return user;
    }
    public static RegisterUserResponse mapper(User user) {
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setId(user.getId());
        registerUserResponse.setUsername(user.getUsername());
        registerUserResponse.setResponseDate(DateTimeFormatter
                .ofPattern("dd-MM-yyyy  hh:mm:ss a").format(user.getDateCreated()));
        return registerUserResponse;
    }

    public static Post map(CreatePostRequest createPostRequest) {
        Post post = new Post();
        post.setTitle(createPostRequest.getTitle());
        post.setContent(createPostRequest.getContent());
        return post;
    }

    public static CreatePostResponse map(Post post) {
        CreatePostResponse createPostResponse = new CreatePostResponse();
        createPostResponse.setPostId(post.getId());
        createPostResponse.setTitle(post.getTitle());
        createPostResponse.setContent(post.getContent());
        createPostResponse.setPostCreationDate(DateTimeFormatter
                .ofPattern("dd/MMM/yyyy 'at' HH:mm:ss a").format(post.getCreationDate()));
        return createPostResponse;
    }

    public static Post map(EditPostRequest editPostRequest, Post post) {
        post.setTitle(editPostRequest.getTitle());
        post.setContent(editPostRequest.getContent());
        return post;
    }

    public static EditPostResponse mapEditPost(Post post) {
        EditPostResponse editPostResponse = new EditPostResponse();
        editPostResponse.setId(post.getId());
        editPostResponse.setTitle(post.getTitle());
        editPostResponse.setContent(post.getContent());
        editPostResponse.setDate(DateTimeFormatter
                .ofPattern("dd-MM-yyyy  hh:mm:ss a").format(post.getCreationDate()));
        return editPostResponse;
    }

    public static Comment commentMap(CommentRequest commentRequest, User user){
        Comment comment = new Comment();
        comment.setComment(commentRequest.getComment());
        comment.setCommenter(user);
        return comment;
    }

    public static CommentResponse commentResponseMap(Comment comment) {
        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setCommentId(comment.getId());
        commentResponse.setComment(comment.getComment());
        commentResponse.setCommenter(comment.getCommenter().getUsername());
        commentResponse.setDate(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a").format(comment.getTimeOfComment()));
        return commentResponse;
    }
    public static View mapView(User viewer){
        View view = new View();
        view.setViewer(viewer);
        return view;
    }
    public static ViewPostResponse viewPostResponseMap(View view){
        ViewPostResponse viewPostResponse = new ViewPostResponse();
        viewPostResponse.setId(view.getId());
        viewPostResponse.setViewer(view.getViewer().getUsername());
        viewPostResponse.setTimeOfView(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a").format(view.getViewDate()));
        return viewPostResponse;
    }




}