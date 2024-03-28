package africa.semicolon.blogApp.dtos.reponse;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("RegistrationResponse")
public class RegistrationResponse {
    @Id
    private String id;
    private String username;
    private String responseDate;
}
