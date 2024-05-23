package exceptionaltddexam;

public class Main {
    public static void main(String[] args) {
        SocialHandler socialHandler = new SocialHandler();

        String handle1 = "Mike jones";
        String handle2 = "Dan Lake";
        String handle3 = "Sasha Jackson";

        socialHandler.addHandle(handle1);
        socialHandler.addHandle(handle2);
        socialHandler.addHandle(handle3);

        socialHandler.addSocialMediaHandlesToFile();
        socialHandler.printSocialMediaHandleFromFile();
    }
}
