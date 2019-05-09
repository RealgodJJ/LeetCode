package com.company.guessnumber_299;

public class GuessNumber {
    public String getHint(String secret, String guess) {
        int[] s = new int[10];
        int[] g = new int[10];
        int bull = 0, cow = 0;

        //统计bull数目
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i))
                bull++;
            s[secret.charAt(i) - '0']++;
            g[guess.charAt(i) - '0']++;
        }

        //统计cow数目
        for(int i = 0; i < s.length; i++){
            cow += Math.min(s[i], g[i]);
        }
        cow -= bull;

        //打印输出结果
        String result = bull + "A" + cow + "B";
        return result;
    }
}
