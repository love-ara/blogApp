package africa.semicolon.blogApp.models.repository;

import africa.semicolon.blogApp.models.data.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
