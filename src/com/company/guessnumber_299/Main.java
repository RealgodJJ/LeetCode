package com.company.guessnumber_299;

public class Main {

    public static void main(String[] args) {
//        String secret = "1987";
//        String guess = "9167";
        GuessNumber guessNumber = new GuessNumber();
//        System.out.println(guessNumber.getHint(secret, guess));     //正确答案应为1A2B

        System.out.println("======Next Test======");

        String secret1 = "1123";
        String guess1 = "0111";
        System.out.println(guessNumber.getHint(secret1, guess1));   //正确答案应为1A1B
    }
}
