package exceptionaltddexam;

import java.util.ArrayList;

public class SocialHandler {

    private ArrayList<String> handleList = new ArrayList<>();

    public ArrayList<String> getHandleList() {
        return handleList;
    }

    public boolean checkHandle(String handle) {
        try{
            if (handle != "" && handle.substring(handle.length() - 1).equals(handle.substring(handle.length() - 1).toLowerCase())) {
                System.out.println("This is a good handle");
                return true;
            } else {
                System.out.println("This handle doesn't work");
                return false;
            }
        }
        catch(NullPointerException e){
            System.out.println("Value is null.");
            return false;
        }
    }

    public void addHandle(String handle) {
        String atHandle = "@";
        if (checkHandle(handle)) {
            if (handle.length() > 9) {
                handle = handle.substring(0, 9);
            }
            atHandle += handle;
            if(handleList.isEmpty()){
                handleList.add(atHandle);
            }
            for (int i = 0; i < handleList.size(); i++) {
                if (!handleList.get(i).equals(atHandle)) {
                    if (i == handleList.size()-1 && i != 0) {
                        handleList.add(atHandle);
                    }
                }
            }
        }
        else{
            System.out.println("Could not add this handle.");
        }
    }
}
