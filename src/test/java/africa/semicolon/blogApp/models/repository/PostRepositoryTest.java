package africa.semicolon.blogApp.models.repository;

import africa.semicolon.blogApp.models.data.Post;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;


@DataMongoTest
public class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;

    @Test
    public void canCreatePost_countIsOne(){
        Post post = new Post();
        post.setId("1");
        post.setTitle("title");
        post.setContent("content");
        postRepository.save(post);
        var foundPost = postRepository.findById("1");

        assertThat(postRepository.count(), is(1L));
        assertThat(foundPost, is(notNullValue()));

        assertEquals(1, postRepository.count());
    }
}
