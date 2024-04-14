package africa.semicolon.blogApp.dtos.response;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class EditPostResponse {
    @Id
    private String id;
    private String title;
    private String content;
    private String username;
    private String date;
}
