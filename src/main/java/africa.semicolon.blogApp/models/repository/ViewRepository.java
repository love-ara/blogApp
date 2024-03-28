package africa.semicolon.blogApp.models.repository;

import africa.semicolon.blogApp.models.data.View;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ViewRepository extends MongoRepository<View, String> {
}
