package com.company.merginginterval_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergingInterval {
    private static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1)
            return intervals;

        List<int[]> result = new ArrayList<>();
        //先按照每个区间的起始值进行升序排序（lambda表达式排序是真的慢）
//        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
//        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int i = 0;
        int n = intervals.length;
        while (i < n) {
            //确定区间的右半边
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < n - 1 && right >= intervals[i + 1][0]) {
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            result.add(new int[]{left, right});
            i++;
        }
        return result.toArray(new int[result.size()][2]);
    }

    private static int[][] merge_1(int[][] intervals) {
        if (intervals.length < 2 || intervals[0].length == 0) {
            return intervals;
        }
        //按数组头元素升序排序（lambda表达式排序是真的慢）
        //Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        ArrayList<int[]> itvs = new ArrayList<>();
        for (int i = 0; i < intervals.length - 1; i++) {
            //寻找重叠区间
            if (intervals[i][1] >= intervals[i + 1][0]) {
                //排除完全重叠区间，如[1,4]与[2,3]
                intervals[i + 1][0] = intervals[i][0];
                intervals[i + 1][1] = intervals[i][1] > intervals[i + 1][1] ? intervals[i][1] : intervals[i + 1][1];
            } else {
                itvs.add(intervals[i]);
            }
        }
        itvs.add(intervals[intervals.length - 1]);
        return itvs.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] merge = {{2, 6}, {1, 3}, {8, 10}, {9, 18}};
        int[][] newMerge = merge(merge);
        for (int[] ints : newMerge) {
            for (int j = 0; j < 2; j++)
                System.out.println(ints[j]);
            System.out.println();
        }
    }
}
