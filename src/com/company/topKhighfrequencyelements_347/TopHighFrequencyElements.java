package com.company.topKhighfrequencyelements_347;

import java.util.*;

public class TopHighFrequencyElements {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else
                map.put(nums[i], map.get(nums[i]) + 1);
        }

        //需要按照映射中的value排序，将key值放入到优先队列中
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (int key : map.keySet()) {
            if (priorityQueue.size() < k)
                priorityQueue.add(key);
            else if (map.get(key) > map.get(priorityQueue.peek())) {
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.remove());
        }

        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums = {4, 1, -1, 2, -1, 2, 3};

        List<Integer> result = topKFrequent(nums, 2);

        for (Integer integer : result)
            System.out.println(integer);
    }
}
