package com.Recursion.StringsSubsetsSubsequence;

public class SkipString {
    public static void main(String[] args) {
        String a = "hdwhellokdw";
        String word = "hello";
        System.out.println(skipWord("",a,word));
    }
    static String skipWord(String processed, String unprocessed,String word){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            //When the whole string gets processed, unprocessed is empty
            return " ";
        }

        if(unprocessed.startsWith(word)){
            return skipWord(processed,unprocessed.substring(5),word);
            //Removes 'a' or 'A'
        }
        else{
            return unprocessed.charAt(0)+skipWord(processed,unprocessed.substring(1),word);
            // adds remaining elements
        }
}}
