package com.Recursion.StringsSubsetsSubsequence;

public class SkipChar {
    public static void main(String[] args) {
        System.out.println( skip("","ababab"));
    }
    //The unprocessed string gets processed later
    static String skip(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            //When the whole string gets processed, unprocessed is empty
            return " ";
        }
        char ch = unprocessed.charAt(0);
        if(ch=='a'||ch == 'A' ){
           return skip(processed, unprocessed.substring(1));
           //Removes 'a' or 'A'
        }
        else{
           return skip(processed+ch,unprocessed.substring(1));
           // adds remaining elements
        }
    }
}
