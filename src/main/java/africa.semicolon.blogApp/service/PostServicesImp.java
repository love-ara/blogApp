package africa.semicolon.blogApp.service;

import africa.semicolon.blogApp.dtos.request.*;
import africa.semicolon.blogApp.dtos.response.*;
import africa.semicolon.blogApp.models.data.Comment;
import africa.semicolon.blogApp.models.data.Post;
import africa.semicolon.blogApp.models.data.User;
import africa.semicolon.blogApp.models.data.View;
import africa.semicolon.blogApp.models.repository.PostRepository;
import africa.semicolon.blogApp.models.repository.UserRepository;
import exception.PostNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static africa.semicolon.blogApp.utils.Mapping.*;

@AllArgsConstructor
@Service
public class PostServicesImp implements PostServices{
    private PostRepository postRepository;
    private CommentServices commentServices;
    private ViewPostServices viewPostServices;


    @Override
    public Post createPost(CreatePostRequest post) {
        Post newPost = map(post);
       // CreatePostResponse createPostResponse = map(newPost);
        postRepository.save(newPost);
        //return createPostResponse;
        return newPost;
    }

    @Override
    public EditPostResponse updatePost(EditPostRequest editPostRequest) {
        Post editPost = findPost(editPostRequest.getId());
        editPost.setTitle(editPostRequest.getTitle());
        editPost.setContent(editPostRequest.getContent());
        EditPostResponse response = mapEditPost(editPost);
        postRepository.save(editPost);

        return response;
    }

    private Post findPost(String id) {
        Optional<Post> post = postRepository.findById(id);
        if(post.isEmpty()) {
            throw new PostNotFoundException("Post not found");
        }
        return post.get();
    }


    @Override
    public DeletePostResponse deletePost(DeletePostRequest deletePostRequest) {

        DeletePostResponse deletePostResponse = new DeletePostResponse();
        deletePostResponse.setPostId(deletePostRequest.getId());
        Post foundPost = findPost(deletePostRequest.getId());
        postRepository.delete(foundPost);
        return deletePostResponse;
    }

    @Override
    public ViewPostResponse viewPost(ViewPostRequest viewPostRequest, User viewer) {
        Post post = findPost(viewPostRequest.getPostId());
        View view = viewPostServices.viewPost(viewer);
        post.getViews().add(view);
        postRepository.save(post);
        return viewPostResponseMap(view);
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public CommentResponse addComment(CommentRequest commentRequest, User user){
        Post post = findPost(commentRequest.getCommentId());

        Comment comment = commentServices.addComment(commentRequest, user);
        post.getComments().add(comment);
        CommentResponse commentResponse = commentResponseMap(comment);
        postRepository.save(post);
        return commentResponse;
    }
}
