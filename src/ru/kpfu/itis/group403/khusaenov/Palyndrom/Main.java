package ru.kpfu.itis.group403.khusaenov.Palyndrom;

import  java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write a word in a lower case font:");
        String s = scan.next();
        scan.close();
        System.out.print(isPalindrome(s));
    }


    public static boolean isPalindrome (String s, int first, int last){

        if(first > last){
            return  true;
        }
        if(s.charAt(first)== s.charAt(last)){
            return isPalindrome(s, first + 1, last - 1);
        }

        return false;

    }

    private static boolean isPalindrome(String a){
        return isPalindrome(a,0,a.length()-1);
    }
}
