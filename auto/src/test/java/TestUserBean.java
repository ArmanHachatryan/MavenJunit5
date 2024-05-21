import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aston.exercise.Parser.models.People;
import org.junit.jupiter.api.*;

public class TestUserBean {

    @Test
    public void testUserBeanFor() throws JsonProcessingException {
        People user = new People(1, "test@email", "arman", "hachatryan", "avatar");

        String resultJson = new ObjectMapper().writeValueAsString(user);
        System.out.println(resultJson);
    }
}
