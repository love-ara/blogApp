package africa.semicolon.blogApp.dtos.request;

import lombok.Data;


@Data
public class EditPostRequest {
    private String id;
    private String title;
    private String content;
    private String username;
    private String date;
}
