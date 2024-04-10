package africa.semicolon.blogApp.service;

import africa.semicolon.blogApp.models.data.User;
import africa.semicolon.blogApp.models.data.View;
import org.springframework.stereotype.Service;

@Service
public interface ViewPostServices {
    View viewPost(User viewer);
}
