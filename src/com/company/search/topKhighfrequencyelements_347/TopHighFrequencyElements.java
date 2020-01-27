package com.company.search.topKhighfrequencyelements_347;

import java.util.*;

public class TopHighFrequencyElements {
    private static List<Integer> topKFrequent(int[] nums, int k) {
        //时间复杂度：O(nlogk) = O(n) + O(nlogk)
        //空间复杂度：O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        //需要按照映射中的出现频率由大到小排序，将key值放入到优先队列中
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        priorityQueue.addAll(map.keySet());

        List<Integer> result = new ArrayList<>();

        //把排序在前面k个元素弹出队列，并放入到结果List中
        for (int i = 0; i < k; i++)
            result.add(priorityQueue.remove());

        return result;
    }

    private static List<Integer> topKFrequent_1(int[] nums, int k) {
        //时间复杂度：O(nlogk) = O(n) + O(nlogk)
        //空间复杂度：O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        //下一行代码表达的意思是：PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(map::get));

        //该方法只记录出现频率前k高的元素顺序，其中频率排列是由小到大的(利用堆排序的方式)
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
        Collections.reverse(result);

        return result;
    }

    private static List<Integer> topKFrequent_2(int[] nums, int k) {
        //时间复杂度：O(n) = O(n) + O(n) 采用桶排序的方式
        //空间复杂度：O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new List[nums.length + 1];
        for (int key : map.keySet()) {
            // 获取出现的次数作为下标，数字作为对应位置的数值
            int index = map.get(key);
            if (list[index] == null)
                list[index] = new ArrayList<>();
            list[index].add(key);
        }

        List<Integer> results = new ArrayList<>();
        for (int i = list.length - 1; i > 0; i--) {
            if (list[i] == null) continue;
            if (results.size() < k)
                results.addAll(list[i]);
        }

        return results;
    }

    private static List<Integer> topKFrequent_3(int[] nums, int k) {
        //时间复杂度：O(n) 采用桶排序的方式
        //空间复杂度：O(n)
        //为整数数组排序
        Arrays.sort(nums);

        //按照整数出现频率进行桶排序（在遍历数组时，直接统计整数出现频率并排序）
        List<Integer>[] arr = new LinkedList[nums.length + 1];
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[start]) {
                continue;
            }
            int d = i - start;//统计当前整数出现的频率
            if (arr[d] == null) {
                arr[d] = new LinkedList<>();
            }
            arr[d].add(nums[start]);
            start = i;
        }

        if (arr[nums.length - start] == null) {
            arr[nums.length - start] = new LinkedList<>();
        }
        arr[nums.length - start].add(nums[start]);

        LinkedList<Integer> res = new LinkedList<>();
        for (int i = nums.length; i >= 0; i--) {
            if (arr[i] == null) continue;
            if (res.size() < k)
                res.addAll(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums1 = {4, 1, -1, -1, 2, -1, 2, 3};
        int[] nums2 = {1};

        List<Integer> result = topKFrequent(nums, 2);
        List<Integer> result1 = topKFrequent(nums1, 1);

        for (Integer integer : result)
            System.out.println(integer);

        for (Integer integer1 : result1)
            System.out.println(integer1);

        List<Integer> result2 = topKFrequent_1(nums, 2);
        List<Integer> result3 = topKFrequent_1(nums1, 1);

        for (Integer integer : result2)
            System.out.println(integer);

        for (Integer integer1 : result3)
            System.out.println(integer1);

        List<Integer> result4 = topKFrequent_2(nums, 2);
        List<Integer> result5 = topKFrequent_2(nums1, 1);
        List<Integer> result6 = topKFrequent_2(nums2, 1);

        for (Integer integer : result4)
            System.out.println(integer);

        for (Integer integer1 : result5)
            System.out.println(integer1);

        for (Integer integer2 : result6)
            System.out.println(integer2);
    }
}
