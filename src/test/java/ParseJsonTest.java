import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class ParseJsonTest {
    static ObjectMapper objectMapper = new ObjectMapper();
    private final ClassLoader cl = ParseJsonTest.class.getClassLoader();

    @Test
    void jacksonTest() throws IOException {
        try(InputStream inputStream = cl.getResourceAsStream("user.json")) {
        User user = objectMapper.readValue(inputStream, User.class);
        Assertions.assertEquals(32, user.getUserId());
        }
    }
}
