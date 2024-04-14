package africa.semicolon.blogApp.dtos.request;

import lombok.Data;

@Data
public class DeletePostRequest {
    private String id;
    private String username;
}
