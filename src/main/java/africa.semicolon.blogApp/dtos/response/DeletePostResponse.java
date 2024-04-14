package africa.semicolon.blogApp.dtos.response;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class DeletePostResponse {
    @Id
    private String postId;
    private String username;
}
