package br.com.mba.engenharia.de.software;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        String s = "He is a very very good boy, isn't he?";
        List<String> array = generateToken(s.replaceAll(",", ""));
        for (String out : array){
            System.out.println(out);
        }
        // Write your code here.
    }
    public static List<String> generateToken(String s){
        List<String> array = new ArrayList<>();
        char[] arrayChar = s.toCharArray();
        int numberOfTokens = 1;
        for (char ch : arrayChar){
            if (ch == ' ' || ch == '\'' || ch == ',' ){
                numberOfTokens++;
            }
        }
        int posOfString = 0;
        int init = 0;
        array.add(String.valueOf(numberOfTokens));
        for (char ch : arrayChar){
            if  (posOfString + 1 == numberOfTokens){
                array.add(s.substring(init));
            }
            else if(ch == ' ' || ch == '\''){
                array.add(s.substring(init, posOfString));
                init = posOfString + 1;
            }
            posOfString++;
        }
        return array;
    }
}
