package africa.semicolon.blogApp.service;

import africa.semicolon.blogApp.dtos.request.CreatePostRequest;
import africa.semicolon.blogApp.dtos.request.EditPostRequest;
import africa.semicolon.blogApp.dtos.request.LoginRequest;
import africa.semicolon.blogApp.dtos.request.RegisterUserRequest;
import africa.semicolon.blogApp.models.data.User;
import africa.semicolon.blogApp.models.repository.PostRepository;
import africa.semicolon.blogApp.models.repository.UserRepository;
import exception.UserAlreadyExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServicesImplTest {
    private final UserServices userServices;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Autowired
    public UserServicesImplTest(UserServices userServices, UserRepository userRepository,
                                PostRepository postRepository){
        this.userServices = userServices;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @BeforeEach
    public void setUp(){
        userRepository.deleteAll();
        postRepository.deleteAll();
    }

    @Test
    public void registerOneUser_userIsOne(){
        RegisterUserRequest userRegisterRequest = new RegisterUserRequest();
        userRegisterRequest.setUsername("username");
        userRegisterRequest.setPassword("password");
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");

        userServices.registerUser(userRegisterRequest);
        assertEquals(1, userRepository.count());
    }

    @Test
    public void cantRegisterUserWithSameUsername(){
        RegisterUserRequest userRegisterRequest = new RegisterUserRequest();
        userRegisterRequest.setUsername("username");
        userRegisterRequest.setPassword("password");
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");

        userServices.registerUser(userRegisterRequest);
        assertThrows(UserAlreadyExistException.class, ()->userServices.registerUser(userRegisterRequest));
        assertEquals(1, userRepository.count());
    }

    @Test
    public void userCanLoginTest() {
        RegisterUserRequest userRegisterRequest = new RegisterUserRequest();
        userRegisterRequest.setUsername("username");
        userRegisterRequest.setPassword("password");
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userServices.registerUser(userRegisterRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        userServices.loginUser(loginRequest);
        assertThat(userServices.findUserBy("username").isLoggedIn(), is(true));

    }
    @Test
    public void userCanMakeAPostTest(){
        RegisterUserRequest userRegisterRequest = new RegisterUserRequest();
        userRegisterRequest.setUsername("username");
        userRegisterRequest.setPassword("password");
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userServices.registerUser(userRegisterRequest);

        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setTitle("Welcome on Board Aramide");
        createPostRequest.setContent("I should be hopefully that what i am doing is correct cos i am so unsure");
        createPostRequest.setUsername("username");
        userServices.createPost(createPostRequest);
        assertEquals(1, postRepository.count());
    }
    @Test
    public void userCanMakeMoreThanPostTest(){
        RegisterUserRequest userRegisterRequest = new RegisterUserRequest();
        userRegisterRequest.setUsername("username");
        userRegisterRequest.setPassword("password");
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userServices.registerUser(userRegisterRequest);

        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setTitle("Welcome on Board Aramide");
        createPostRequest.setContent("I should be hopefully that what i am doing is correct cos i am so unsure");
        createPostRequest.setUsername("username");
        userServices.createPost(createPostRequest);
        assertEquals(1, postRepository.count());

        CreatePostRequest createAnotherPostRequest = new CreatePostRequest();
        createAnotherPostRequest.setTitle("Who is proud of you?");
        createAnotherPostRequest.setContent("I am. I'm proud you could get to fix that bug earlier and you weren't " +
                "overwhelmed, you can do stuff");
        createAnotherPostRequest.setUsername("username");
        userServices.createPost(createAnotherPostRequest);
        assertEquals(2, postRepository.count());

    }
    @Test
    public void userCanEditPostTest(){
        RegisterUserRequest userRegisterRequest = new RegisterUserRequest();
        userRegisterRequest.setUsername("username");
        userRegisterRequest.setPassword("password");
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userServices.registerUser(userRegisterRequest);


        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setTitle("Welcome on Board Aramide");
        createPostRequest.setContent("I should be hopefully that what i am doing is correct cos i am so unsure");
        createPostRequest.setUsername("username");
        userServices.createPost(createPostRequest);
        var  poster = userRepository.findByUsername(userRegisterRequest.getUsername().toLowerCase());
        var savedPost = poster.getPosts().getFirst();
        assertThat(savedPost.getContent(), containsString("I should be hopefully that what i am doing is " +
                "correct cos i am so unsure"));

        EditPostRequest editPostRequest = new EditPostRequest();
        editPostRequest.setTitle("Lol, just tying this");
        editPostRequest.setContent("I should be hopefully that what i am doing is correct cos i am so unsure again");
        editPostRequest.setUsername("username");
        editPostRequest.setId(savedPost.getId());
        var editPostResponse = userServices.editPost(editPostRequest);
        poster = userRepository.findByUsername(userRegisterRequest.getUsername().toLowerCase());
        //savedPost = poster.getPosts().getFirst();
        assertThat(editPostResponse.getId(), notNullValue());
        assertThat(editPostResponse.getContent(), containsString("I should be hopefully that what i am doing is correct cos i am so unsure again"));
        assertThat(poster.getPosts().size(), is(1));

    }
}


