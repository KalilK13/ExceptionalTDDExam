package exceptionaltddexam;

import org.junit.jupiter.api.DisplayName;
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
    @Test
    @DisplayName("To check if a social media handle was created successfully")
    void checkHandleTest(){
        SocialHandler socialHandler = new SocialHandler();

        String handle = "Sydney Smith";

        socialHandler.addHandle(handle);

        ArrayList<String> actual = socialHandler.getHandleList();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("@" + handle.substring(0,9));

        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("To check if handle was created with 9 characters or less")
    void checkHandleLessThan9CharactersTest() {
        SocialHandler socialHandler = new SocialHandler();

        String handle = "mike jones";

        socialHandler.addHandle(handle);

        int actual = socialHandler.getHandleList().get(0).length();

        assertTrue(actual <= 10);
    }


    @Test // This is an example of how to test an exemption
    @DisplayName("To check if social media handle input is null")
    void checkIfNullTest() {
        SocialHandler socialHandler = new SocialHandler();
        assertThrows(NullPointerException.class, ()-> socialHandler.checkHandle(null));
    }


    @Test
    @DisplayName("To check if social media handle is empty or blank")
    void checkEmptyOrBlankCharactersTest(){
        SocialHandler socialHandler = new SocialHandler();

    }
    @Test
    @DisplayName("To check if handle was added despite multiple attempts")
    void addHandleTest(){
        SocialHandler socialHandler = new SocialHandler();

        String handle1 = "Mike jones";
        String handle2 = "Mike Jones";
        String handle3 = "mike Jones";

        socialHandler.addHandle(handle1);
        socialHandler.addHandle(handle2);
        socialHandler.addHandle(handle3);

        ArrayList<String> actual = socialHandler.getHandleList();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("@" + handle1.substring(0,9));

        assertEquals(expected, actual);
    }


}