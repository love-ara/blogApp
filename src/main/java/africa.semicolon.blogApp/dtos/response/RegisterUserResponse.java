package africa.semicolon.blogApp.dtos.response;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("RegisterUserResponse")
public class RegisterUserResponse {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String responseDate;
}
