package africa.semicolon.blogApp.service;

import africa.semicolon.blogApp.dtos.request.CommentRequest;
import africa.semicolon.blogApp.dtos.request.DeleteRequest;
import africa.semicolon.blogApp.dtos.request.EditRequest;
import africa.semicolon.blogApp.dtos.response.DeleteResponse;
import africa.semicolon.blogApp.models.data.Comment;
import africa.semicolon.blogApp.models.data.User;
import africa.semicolon.blogApp.models.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static africa.semicolon.blogApp.utils.Mapping.commentMap;

@Service
@AllArgsConstructor
public class CommentServicesImp implements CommentServices {
    private CommentRepository commentRepository;

    @Override
    public Comment addComment(CommentRequest commentRequest, User user) {
        Comment comment = commentMap(commentRequest, user);
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public DeleteResponse deleteComment(DeleteRequest deleteRequest) {

    }

    @Override
    public void updateComment(EditRequest comment) {

    }


    @Override
    public List<Comment> searchForComment(String id) {
        return null;
    }
}
