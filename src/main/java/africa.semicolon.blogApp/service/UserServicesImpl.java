package africa.semicolon.blogApp.service;

import africa.semicolon.blogApp.dtos.response.*;
import africa.semicolon.blogApp.dtos.request.*;
import africa.semicolon.blogApp.models.data.*;

import africa.semicolon.blogApp.models.repository.UserRepository;
import exception.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static africa.semicolon.blogApp.utils.Mapping.*;

@Service
@AllArgsConstructor
public class UserServicesImpl implements UserServices{
    private UserRepository userRepository;
    private PostServices postServices;


    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest regRequest) {
        validate(regRequest.getUsername());
        User user = map(regRequest);
        RegisterUserResponse response = mapper(user);
        userRepository.save(user);
        return response;
    }

    private void validate(String username) {
        boolean userExits = userRepository.existsByUsername(username.toLowerCase());
        if(userExits)throw new UserAlreadyExistException(username + " already exist");
    }

    @Override
    public  User findUserBy(String username) {
        User user = userRepository.findByUsername(username.toLowerCase());
        if(user == null) throw new UsernameNotFoundException(username +" not found");
        return user;
    }


    @Override
    public CreatePostResponse createPost(CreatePostRequest createRequest) {
        User user = findUserBy(createRequest.getUsername());
        Post post = postServices.createPost(createRequest);
        CreatePostResponse createPostResponse = map(post);
        user.getPosts().add(post);
        userRepository.save(user);
        return createPostResponse;
    }

    @Override
    public EditPostResponse editPost(EditPostRequest editRequest) {
        User user = findUserBy(editRequest.getUsername());
        EditPostResponse post = postServices.updatePost(editRequest);
        userRepository.save(user);
        return post;
    }

    @Override
    public DeletePostResponse deletePost(DeletePostRequest deleteRequest) {
        User user = findUserBy(deleteRequest.getUsername());
        DeletePostResponse deletePostResponse = postServices.deletePost(deleteRequest);
        userRepository.save(user);

        return deletePostResponse;
    }

    @Override
    public ViewPostResponse viewPost(ViewPostRequest viewPostRequest) {
        User viewer = findUserBy(viewPostRequest.getViewer());
        return postServices.viewPost(viewPostRequest, viewer);
    }

    @Override
    public CommentResponse comment(CommentRequest commentRequest) {
        User user = findUserBy(commentRequest.getCommenter());

        return postServices.addComment(commentRequest, user);
    }


    @Override
    public LoginResponse loginUser(LoginRequest loginRequest) {
        User user = findUserBy(loginRequest.getUsername());
        if(!user.getPassword().equals(loginRequest.getPassword())){
            throw new IncorrectPasswordException("Password is incorrect");
        }
        userRepository.save(user);
        return null;
    }

    @Override
    public LogoutResponse logoutUser(LogoutRequest logoutRequest) {
        User user = findUserBy(logoutRequest.getUsername());

        return null;
    }




}
