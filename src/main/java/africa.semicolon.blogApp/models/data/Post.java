package africa.semicolon.blogApp.models.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document("Posts")
public class Post {
    private String title;
    private String content;
    @Id
    private String id;
    @DBRef
    private List<Comment> comments = new ArrayList<>();
    @DBRef
    private List<View> views = new ArrayList<>();
    private String username;
    private LocalDateTime creationDate = LocalDateTime.now();

}
