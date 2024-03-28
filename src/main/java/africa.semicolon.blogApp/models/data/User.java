package africa.semicolon.blogApp.models.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;

@Data
@Document("users")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;
    private LocalDateTime dateCreated = LocalDateTime.now();
}
