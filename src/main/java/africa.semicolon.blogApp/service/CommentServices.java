package africa.semicolon.blogApp.service;

import africa.semicolon.blogApp.dtos.request.CommentRequest;
import africa.semicolon.blogApp.dtos.request.DeleteRequest;
import africa.semicolon.blogApp.dtos.request.EditRequest;
import africa.semicolon.blogApp.dtos.response.DeleteResponse;
import africa.semicolon.blogApp.models.data.Comment;
import africa.semicolon.blogApp.models.data.User;
import africa.semicolon.blogApp.models.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CommentServices {
    Comment addComment(CommentRequest commentRequest, User user);
    DeleteResponse deleteComment(DeleteRequest deleteRequest);
    void updateComment(EditRequest editRequest);
    List<Comment> searchForComment(String id);
}
