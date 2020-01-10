package com.company.array.findkthlargest_215;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class FindKthLargest {
    private static int findKthLargest(int[] nums, int k) {
        //时间复杂度：O(N)
        //空间复杂度：O(1)
        //利用快排的返回中轴位置，通过kth大的元素和中轴位置进行比较，确定下一轮在中轴位置的哪一部分查找kth大的元素
        int middle = partition(nums, 0, nums.length - 1);
        int target = nums.length - k;
        while (middle != target) {
            if (middle > target)
                middle = partition(nums, 0, middle - 1);
            else
                middle = partition(nums, middle + 1, nums.length - 1);
        }

        return nums[middle];
    }

    private static int partition(int[] nums, int left, int right) {
        int temp = nums[left];

        while (left < right) {
            while (temp <= nums[right] && left < right) {
                right--;
            }

            if (left < right) {
                nums[left] = nums[right];
                left++;
            }

            while (temp >= nums[left] && left < right) {
                left++;
            }

            if (left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = temp;
        return left;
    }

    private static int findKthLargest_1(int[] nums, int k) {
        //时间复杂度：O(N)
        //快速排序改良后的快速选择算法
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int left, int right, int targetK) {
        if (left == right) return nums[left];

        //利用随机的方式设定中轴值
        Random random_num = new Random();
        int pivotIndex = left + random_num.nextInt(right - left);
        pivotIndex = partition(nums, left, right, pivotIndex);

        if (targetK == pivotIndex) return nums[targetK];
        else if (targetK > pivotIndex) return quickSelect(nums, pivotIndex + 1, right, targetK);
        else return quickSelect(nums, left, pivotIndex - 1, targetK);
    }

    private static int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];

        //交换pivotIndex和right位置的数值
        int temp = nums[pivotIndex];
        nums[pivotIndex] = nums[right];
        nums[right] = temp;

        int storeIndex = left;  //用于标记最终的中轴位置
        for (int i = left; i <= right; i++) {   //把小于pivot的值全部放到前面
            if (nums[i] < pivot) {
                int temp1 = nums[storeIndex];
                nums[storeIndex] = nums[i];
                nums[i] = temp1;
                storeIndex++;
            }
        }

        int temp2 = nums[storeIndex];
        nums[storeIndex] = nums[right];
        nums[right] = temp2;

        return storeIndex;
    }

    private static int findKthLargest_2(int[] nums, int k) {
        //时间复杂度：O(Nlogk)
        //维护一个小顶堆，家数组中的元素依次加入到小顶堆中，并维持堆的大小不超过k
        PriorityQueue<Integer> smallTopHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n));

        for (int num : nums) {
            smallTopHeap.add(num);
            if (smallTopHeap.size() > k)
//                smallTopHeap.remove();
                smallTopHeap.poll();
        }
        assert smallTopHeap.peek() != null;
        return smallTopHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums_1 = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest_1(nums_1, 2));
        int[] nums_2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums_2, 4));
    }
}
