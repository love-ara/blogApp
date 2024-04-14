package africa.semicolon.blogApp.dtos.response;

import africa.semicolon.blogApp.models.data.Post;
import africa.semicolon.blogApp.models.data.User;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ViewPostResponse {
    private String id;
    private String viewer;
    private String timeOfView;
}
