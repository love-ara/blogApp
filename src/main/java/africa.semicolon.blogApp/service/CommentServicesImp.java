package africa.semicolon.blogApp.service;

import africa.semicolon.blogApp.dtos.request.CommentRequest;
import africa.semicolon.blogApp.models.data.Comment;
import africa.semicolon.blogApp.models.data.User;
import africa.semicolon.blogApp.models.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static africa.semicolon.blogApp.utils.Mapping.commentMap;

@Service
public class CommentServicesImp implements CommentServices {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addComment(CommentRequest commentRequest, User user) {
        Comment comment = commentMap(commentRequest, user);
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public void deleteComment(Comment comment) {

    }

    @Override
    public void updateComment(Comment comment) {

    }

    @Override
    public List<Comment> getAllComments() {
        return null;
    }

    @Override
    public List<Comment> searchForComment(String id) {
        return null;
    }
}
