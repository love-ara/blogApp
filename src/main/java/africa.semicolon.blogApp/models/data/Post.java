package africa.semicolon.blogApp.models.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document("Posts")
public class Post {
    private String title;
    private String content;
    @Id
    private String id;
    private List<Comment> comments;
    private List<View> views;
    private LocalDateTime creationDate;

}
