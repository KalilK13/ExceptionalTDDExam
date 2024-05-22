package exceptionaltddexam;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SocialHandlerTest {

    @Test
    void checkHandle() {
       SocialHandler socialHandler = new SocialHandler();
       String handle = "mikejones";
//
       boolean actual = socialHandler.checkHandle(handle);
       boolean expected = true;
//
       assertEquals(expected, actual);

    }

    @Test
    void addHandle() {
        SocialHandler socialHandler = new SocialHandler();

        String handle = "mike jones";

        socialHandler.addHandle(handle);
        socialHandler.addHandle("MiKE JONEs");

        ArrayList<String> actual = socialHandler.getHandleList();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("@" + handle.substring(0,9));

        assertEquals(expected, actual);
    }
}