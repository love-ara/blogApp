package africa.semicolon.blogApp.dtos.response;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class CreatePostResponse {
    @Id
    private String postId;
    private String title;
    private String content;
    private String username;
    private String postCreationDate;
}
