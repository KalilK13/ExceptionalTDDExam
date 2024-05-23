package exceptionaltddexam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SocialHandler {

    private ArrayList<String> handleList = new ArrayList<>();

    public ArrayList<String> getHandleList() {
        return handleList;
    }

    public boolean checkHandle(String handle){
//        try{
            if (handle != "" && handle != null && !handle.trim().equals("")) {
//                System.out.println("This is a good handle");
                return true;
            } else {
                System.out.println("This handle doesn't work");
                return false;
            }
//        }
//        catch(NullPointerException e){
//            System.out.println("Value is null.");
//            return false;
//        }
    }

    public void addHandle(String handle) {
        String atHandle = "@";
        if (checkHandle(handle)) {
            handle = handle.toLowerCase();
            if (handle.length() > 9) {
                handle = handle.substring(0, 9);
            }
            atHandle += handle;
            if(handleList.isEmpty()){
                handleList.add(atHandle);
            }
            for (int i = 0; i < handleList.size(); i++) {
                if (!handleList.get(i).equalsIgnoreCase(atHandle)) {
                    if (i == handleList.size()-1) {
                        handleList.add(atHandle);
                    }
                }
            }
        }
        else{
            System.out.println("Could not add this handle.");
        }
    }
    public void removeHandle(String handle){
        if(handle.substring(0,1) != "@"){
            handle = "@" + handle;
        }
//        handleList.remove(handle);
        for(int i = 0; i < handleList.size(); i++){
            if(handleList.get(i).equalsIgnoreCase(handle)){
                handleList.remove(i);
            }
        }
    }
    public void updateHandle(String handle, String udatedHandle){
        if(checkHandle(handle)) {
            if(handle.substring(0,1) != "@"){
                handle = "@" + handle;
            }
            for (int i = 0; i < handleList.size(); i++) {
                if (handleList.get(i).equalsIgnoreCase(handle)) {
                    handleList.remove(i);
                    handleList.add(i, "@" + udatedHandle.toLowerCase());
                }
            }
        }
    }
    public void addSocialMediaHandlesToFile(){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("/Users/kalilkennedy/Desktop/exceptions/src/main/resources/handleList");
            for (String handle : handleList) {
                fileWriter.write(handle + "\n");
//                System.out.println("file written successfully.");
            }
        }
        catch (IOException e){
            System.out.println("unable to write to file.");
        }
        try{
            fileWriter.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void printSocialMediaHandleFromFile(){
        File file = new File("/Users/kalilkennedy/Desktop/exceptions/src/main/resources/handleList");
        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

