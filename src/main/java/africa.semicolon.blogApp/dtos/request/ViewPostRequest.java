package africa.semicolon.blogApp.dtos.request;


import lombok.Data;

@Data
public class ViewPostRequest {
    private String postId;
    private String postTitle;
    private String viewer;
}
