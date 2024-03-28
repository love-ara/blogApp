package africa.semicolon.blogApp.models.repository;

import africa.semicolon.blogApp.models.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByUsername(String username);
}
