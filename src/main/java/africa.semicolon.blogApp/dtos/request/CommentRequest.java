package africa.semicolon.blogApp.dtos.request;

import lombok.Data;
@Data
public class CommentRequest {
    private String commentId;
    private String commenter;
    private String comment;
    private String date;
}
