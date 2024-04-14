package africa.semicolon.blogApp.dtos.response;

import africa.semicolon.blogApp.models.data.User;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
public class CommentResponse {
    @Id
    private String commentId;
    private String comment;
    private String commenter;
    private String date;
}
