package africa.semicolon.blogApp.models.repository;

import africa.semicolon.blogApp.models.data.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
