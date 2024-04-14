package africa.semicolon.blogApp.dtos.response;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class LogoutResponse {
    @Id
    private String userId;
    private String username;
}
