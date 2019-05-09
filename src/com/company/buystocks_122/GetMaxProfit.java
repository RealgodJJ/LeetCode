package com.company.buystocks_122;

public class GetMaxProfit {
    //将邻近的所有增长段累加
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    //利用递归算法计算所有股价上升段
    public int easyMaxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        return fun(prices, 0, prices.length - 1);
    }

    private int fun(int[] prices, int start, int end) {
        int maxProfit = 0;
        while (start < end && prices[start] >= prices[start + 1]) {
            start++;
        }
        while (start < end && prices[end - 1] >= prices[end]) {
            end--;
        }
        if (start == end)
            return 0;

        int right = start;
        for (int i = start + 1; i <= end - 1; i++) {
            if (prices[i] > prices[right]) {
                right = i;
                maxProfit = prices[right] - prices[start];
            }
            if (prices[i] > prices[i + 1])
                return maxProfit + fun(prices, i + 1, end);
        }
        return prices[end] - prices[start];
    }


//    int len = nums.length;
//    // 先考虑极端输入
//        if (len <= 1)
//            return len;
//    // tail 数组的定义：长度为 i+1 的上升子序列的末尾最小是几
//    int[] tail = new int[len];
//    // 遍历一遍整个数组，使用二分查找算法
//    tail[0] = nums[0];
//    int res = 0;
//        for (int i = 1; i < len; i++)
//    {
//        // 比 tail 数组实际有效的末尾的那个元素还大
//        if (nums[i] > tail[res])
//        {
//            // 直接添加在那个元素的后面
//            tail[++res] = nums[i];
//        } else
//        {
//            // 二分查找到第 1 个比 nums[i] 还大的元素，更新到那个位置
//            int l = 0;
//            int r = res;
//            while (l < r)
//            {
//                int mid = l + (r - l) / 2;
//                // 有就啥都不做了
//                if (tail[mid] == nums[i])
//                {
//                    l = mid;
//                    break;
//                } else if (tail[mid] >= nums[i])
//                {
//                    r = mid;
//                } else
//                {
//                    l = mid + 1;
//                }
//            }
//            tail[l] = nums[i];
//        }
//    }
//        return ++res;
//}
}
