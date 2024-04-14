package africa.semicolon.blogApp.models.repository;

import africa.semicolon.blogApp.models.data.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void createAUser_countIsOne(){
        User user = new User();
        user.setId("1");
        user.setFirstName("firstname");
        user.setLastName("lastname");

        userRepository.save(user);

        assertThat(userRepository.count(), is(1L));

    }

}