import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JazzTeamUser on 20.11.2015.
 */
public class MainTest {

    ObjectMapper mapper;

    User u1;
    User u2;
    User u3;

    @Before
    public void init() {
        mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        u1 = new User();
        u2 = new User();
        u3 = new User();

        Map<String, String> map1 = new HashMap<>();
        map1.put("address1", "street1");
        map1.put("cup", "monitor");
        Map<String, String> map2 = new HashMap<>();
        map2.put("key", "value");
        Map<String, String> map3 = new HashMap<>();
        map3.put("mouse", "keybord");

        u1.setMap(map1);
        u1.setName("vasya pupkin 1");
        u1.setMessages(Arrays.asList("item1", "item2", "item3"));

        u2.setMap(map2);
        u2.setName("zaa team user 2");
        u2.setMessages(Arrays.asList("j1", "j2", "j3"));

        u3.setMap(map3);
        u3.setName("noob user 3");
        u3.setMessages(Arrays.asList("m1", "m2"));
    }

    @Test
    public void writeTest() throws IOException {
        mapper.writeValue(new File("d:/file.json"), u1);
    }

    @Test
    public void readTest() throws IOException {
        User user = mapper.readValue(new File("d:/file.json"), User.class);
        String r = "";
    }

}
