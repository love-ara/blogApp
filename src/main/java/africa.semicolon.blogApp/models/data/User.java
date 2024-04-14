package africa.semicolon.blogApp.models.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;

@Data
@Document("users")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String lastName;
    private String firstName;
    @DBRef
    private List<Post> posts = new ArrayList<>();
    private LocalDateTime dateCreated = LocalDateTime.now();
    private boolean isLoggedIn = true;

}
