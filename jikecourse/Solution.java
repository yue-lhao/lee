package com.xiaohao.jike;

public class Solution {

    //分析: 排序数组 -> 有序
    //      需要原地删除 -> 不能使用额外的空间 -> 不能用数组、集合（index/contains）等存放新数据
    //思路：依次比较相邻的元素，当相同时移动后面元素覆盖数据,先固定一位依次比较，慢慢移动
    public static int removeDuplicates(int[] a) {
        if(a == null || a.length == 0)
            return 0;

        int i = 0;
        int j = 0;
        int count = 1;
        while(j < a.length) {
            if(a[i] == a[j]) {
                j++;
                continue;
            }

            a[++i] = a[j++];
            count++;
        }

        for (int k=0;k<count;k++) {
            System.out.print(a[k] + "\t");
        }
        System.out.println();

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4,4,5,7,8,9,9,9,10,10,24,47};
        int a = removeDuplicates(nums);
        System.out.println("不重复的元素个数 ： " + a);
    }

}
