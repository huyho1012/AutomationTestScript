package Debug;

import java.time.LocalTime;
import java.util.Random;

public class DebugFunction {

    public static String getFullName(String firstName,String middleName, String lastName) {
        if(firstName.trim() == ""){
            return middleName.trim() + " " + lastName.trim();
        }
        else if(middleName.trim()==""){
            return firstName.trim() + " " + lastName.trim();
        }
        else if(lastName.trim()==""){
            return firstName.trim() + " " + middleName.trim();
        }
        else
            return firstName.trim() + middleName.trim() + lastName.trim();
    }

    public static String removeAllWhitespace(String data) {
        String sentence = data.trim();
        return sentence.replaceAll(" ", "");
    }
    protected static String randomVirtualEmail(){
        String userName = "huyho";
        String domainEmail = "@mailinator.com";
        Random random = new Random();
        return userName + random.nextInt(2000000) + domainEmail;
    }
    public static void main (String [] args) {
        System.out.println(randomVirtualEmail());
        System.out.println(LocalTime.now());
    }
}