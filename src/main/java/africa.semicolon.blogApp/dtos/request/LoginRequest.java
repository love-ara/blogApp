package africa.semicolon.blogApp.dtos.request;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("LoginRequest")
public class LoginRequest {
    public String username;
    public String password;
    @Id
    private String id;
}
