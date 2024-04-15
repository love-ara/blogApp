package africa.semicolon.blogApp.service;

import africa.semicolon.blogApp.dtos.request.*;
import africa.semicolon.blogApp.dtos.response.*;
import africa.semicolon.blogApp.models.data.User;
import org.springframework.stereotype.Service;

@Service
public interface UserServices {
    //void registerUser(RegisterUserRequest regRequest);
    RegisterUserResponse registerUser(RegisterUserRequest regRequest);
    LoginResponse loginUser(LoginRequest loginRequest);
    LogoutResponse logoutUser(LogoutRequest logoutRequest);
    CreatePostResponse createPost(CreatePostRequest createRequest);
    EditPostResponse editPost(EditRequest editRequest);
    DeleteResponse deletePost(DeleteRequest deleteRequest);
    ViewPostResponse viewPost(ViewPostRequest viewPostRequest);
    CommentResponse comment(CommentRequest commentRequest);
    User findUserBy(String username);

}
