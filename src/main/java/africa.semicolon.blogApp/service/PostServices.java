package africa.semicolon.blogApp.service;

import africa.semicolon.blogApp.dtos.request.*;
import africa.semicolon.blogApp.dtos.response.*;
import africa.semicolon.blogApp.models.data.Post;
import africa.semicolon.blogApp.models.data.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostServices {
    Post createPost(CreatePostRequest createPostRequest);
    EditPostResponse updatePost(EditPostRequest editPostRequest);
    DeletePostResponse deletePost(DeletePostRequest deletePostRequest);
    ViewPostResponse viewPost(ViewPostRequest viewPostRequest, User viewer);
    List<Post> getPosts();
    CommentResponse addComment(CommentRequest commentRequest, User user);

}
