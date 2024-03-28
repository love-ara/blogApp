package africa.semicolon.blogApp.models.repository;

import africa.semicolon.blogApp.models.data.View;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@DataMongoTest
public class ViewRepositoryTest {
    @Autowired
    private ViewRepository viewRepository;

    @Test
    public void createOneView_countIsOne(){
        View view = new View();
        view.setId("1");

        viewRepository.save(view);

        assertThat(viewRepository.count(), is(1L));
    }


}
