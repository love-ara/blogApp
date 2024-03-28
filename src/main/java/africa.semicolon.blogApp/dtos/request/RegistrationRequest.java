package africa.semicolon.blogApp.dtos.request;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document("RegistrationRequest")
public class RegistrationRequest {
        @Id
        private String id;
        private String username;
        private String password;
        private String firstName;
        private String lastName;
}

