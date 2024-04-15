package africa.semicolon.blogApp.dtos.request;

import lombok.Data;

@Data
public class DeleteRequest {
    private String id;
    private String username;
}
