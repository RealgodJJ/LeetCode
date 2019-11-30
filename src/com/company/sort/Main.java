package com.company.sort;

public class Main {

    public static void main(String[] args) {
//        int[] nums = new int[10000];
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = (int) (Math.random() * 20000);
//        }

        int[] nums = {72, 6, 57, 88, 60, 42, 83, 73, 48, 85};

        //形成深拷贝
//        int[] nums_1 = new int[nums.length];
//        int[] nums_2 = new int[nums.length];
//        int[] nums_3 = new int[nums.length];
//        int[] nums_4 = new int[nums.length];
//        System.arraycopy(nums, 0, nums_1, 0, nums.length);
//        System.arraycopy(nums, 0, nums_2, 0, nums.length);
//        System.arraycopy(nums, 0, nums_3, 0, nums.length);
//        System.arraycopy(nums, 0, nums_4, 0, nums.length);

        QuickSort quickSort = new QuickSort();
        quickSort.newQuickSort(nums, 0, nums.length - 1);

//        InsertSort insertSort = new InsertSort();
//        long costTime2 = insertSort.insertSort(nums_2);
//
//        BubbleSort bubbleSort = new BubbleSort();
//        long costTime3 = bubbleSort.bubbleSort(nums_3);
//
//        SelectSort selectSort = new SelectSort();
//        long costTime4 = selectSort.selectSort(nums_4);

        for (int num : nums) {
            System.out.println(num);
        }

//        System.out.println("QuickSort Cost Time: " + costTime1);
//        System.out.println("InsertSort Cost Time: " + costTime2);
//        System.out.println("BubbleSort Cost Time: " + costTime3);
//        System.out.println("SelectSort Cost Time: " + costTime4);
    }
}
