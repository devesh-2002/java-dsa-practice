package com.Recursion.StringsSubsetsSubsequence;

import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        subseq("","abcd");
    }
    static void subseq(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.print(processed+" ");
            //Processed data is printed
            return;
        }
        char ch = unprocessed.charAt(0);
        //The first element of unprocessed, gets processed
        subseq(processed + ch, unprocessed.substring(1));
        subseq(processed,unprocessed.substring(1));
        //Recursive calls
        //Substring creates new object
    }
}
