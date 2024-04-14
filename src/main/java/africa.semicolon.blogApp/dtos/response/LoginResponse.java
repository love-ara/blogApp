package africa.semicolon.blogApp.dtos.response;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class LoginResponse {
    @Id
    private String UserId;
    private String username;
    private String password;
}
