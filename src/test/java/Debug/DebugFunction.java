package Debug;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import java.time.LocalTime;
import java.util.Random;

public class DebugFunction {

    static Lorem lorem;
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

    public static String randomName(int numPassChar) {
        String text = null;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder bd = new StringBuilder(numPassChar);
        for (int i = 0; i < numPassChar; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            text = bd.append(AlphaNumericString.charAt(index)).toString();
        }
        return text;
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
        lorem = LoremIpsum.getInstance();
//        System.out.println(randomVirtualEmail());
//        System.out.println(LocalTime.now());
//        System.out.println(randomName(1000));
//        System.out.println(getLinkOnAvatarlink());
//        String phoeData = "huy123456789ho123456789doan132";
//        String a =  phoeData.replaceAll("[^\\d]","");
//        if(a.length()>20){
//             a = a.substring(0,20);
//        }
//        System.out.println(a);
        String text = lorem.getParagraphs(2,5);
        text = text.replaceAll("^ +| +$|( )+", "$1");
        System.out.println(text.replaceAll("\n",""));
    }

    public static String getLinkOnAvatarlink(){
        String url = "url('https://test-media.hahalolo.com/2020/09/29/09/13/5f72983fbc502609c2256036200929091357aF_240-xauto_high.jpg')";
        String[] a = url.split("/");
        return a[a.length-1].replaceAll("[^\\w\\.\\-]", "");
    }
}