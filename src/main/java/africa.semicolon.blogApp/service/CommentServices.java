package africa.semicolon.blogApp.service;

import africa.semicolon.blogApp.dtos.request.CommentRequest;
import africa.semicolon.blogApp.models.data.Comment;
import africa.semicolon.blogApp.models.data.User;
import africa.semicolon.blogApp.models.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CommentServices {
    Comment addComment(CommentRequest commentRequest, User user);
    void deleteComment(Comment comment);
    void updateComment(Comment comment);
    List<Comment> getAllComments();
    List<Comment> searchForComment(String id);
}
