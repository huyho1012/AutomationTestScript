package Debug;

import Project.Newsfeed.Newsfeed.NewsfeedHomepage;

import java.util.Scanner;

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
    public static void main (String [] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhập Họ");
//        String firstName = sc.nextLine();
//        System.out.println("Nhập Tên");
//        String lastName = sc.nextLine();
//        System.out.println("Nhập Tên lót");
//        String middname = sc.nextLine();
//        System.out.println(getFullName(firstName,middname,lastName));



        System.out.println(removeAllWhitespace("       hahaha        anh       yeu      em     "));
    }
}