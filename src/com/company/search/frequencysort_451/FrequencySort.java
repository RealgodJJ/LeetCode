package com.company.search.frequencysort_451;

import java.util.*;

public class FrequencySort {
    private static String frequencySort(String s) {
        //使用Map映射统计所有字母出现的频率
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char ch : s.toCharArray())
            charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch, 0) + 1);

        //对List中Entry按照value由大到小排序
        List<Map.Entry<Character, Integer>> mapList = new ArrayList<>(charFrequencyMap.entrySet());
        mapList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        //按照出现频率从大到小将字符串添加到结果中
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : mapList) {
            for (int i = 0; i < entry.getValue(); i++)
                stringBuilder.append(entry.getKey());
        }
        return stringBuilder.toString();
    }

    private static String frequencySort_1(String s) {
        //使用Map映射统计所有字母出现的频率
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char ch : s.toCharArray())
            charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch, 0) + 1);

        //创建一个利用字母出现频率由高到低排序的优先级队列
        Queue<Map.Entry<Character, Integer>> frequencyQueue = new PriorityQueue<>((f1, f2) ->
                f2.getValue().compareTo(f1.getValue()));
        for (Map.Entry<Character, Integer> entry : charFrequencyMap.entrySet())
            frequencyQueue.offer(entry);

        //从优先级队列中依次出队，并添加字母的出现频率到结果中
        StringBuilder stringBuilder = new StringBuilder();
        while (!frequencyQueue.isEmpty()) {
            Map.Entry<Character, Integer> entry = frequencyQueue.poll();
            for (int i = 0; i < entry.getValue(); i++)
                stringBuilder.append(entry.getKey());
        }
        return stringBuilder.toString();
    }

    private static String frequencySort_2(String s) {
        //使用数组统计所有字母出现的频率
        int[] frequency = new int[128];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i)]++;
        }

        //形成<字幕出现频率，出现该频率的字母拼接城的字符串>映射
        HashMap<Integer, String> charFrequencyMap = new HashMap<>();
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] != 0) {
                char ch = (char) i;

                String value = charFrequencyMap.get(frequency[i]);
                //判断map中是否存在该字母
                if (value != null) {
                    String strNew = value.concat(buildSameAlpha(ch, frequency[i]));
                    //出现同样频率的字符也将其字符串拼接在后面放在map中
                    charFrequencyMap.put(frequency[i], strNew);
                } else
                    charFrequencyMap.put(frequency[i], buildSameAlpha(ch, frequency[i]));
            }
        }

        //对List中Entry按照key由大到小排序
        List<Map.Entry<Integer, String>> mapList = new ArrayList<>(charFrequencyMap.entrySet());
        mapList.sort((e1, e2) -> e2.getKey().compareTo(e1.getKey()));

        //按照出现频率从大到小将字符串添加到结果中（此部分采用单循环节省了时间）
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, String> entry : mapList) {
                stringBuilder.append(entry.getValue());
        }
        return stringBuilder.toString();
    }

    private static String buildSameAlpha(char ch, int freq) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < freq; i++) {
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s1 = "tree";
        String s2 = "cccaaa";
        String s3 = "Aabb";

        System.out.println(frequencySort(s1));
        System.out.println(frequencySort(s2));
        System.out.println(frequencySort(s3));

        System.out.println(frequencySort_1(s1));
        System.out.println(frequencySort_1(s2));
        System.out.println(frequencySort_1(s3));

        System.out.println(frequencySort_2(s1));
        System.out.println(frequencySort_2(s2));
        System.out.println(frequencySort_2(s3));
    }
}
