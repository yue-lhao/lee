package com.xiaohao.jike;

import com.xiaohao.authire.LeetCode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/
 */
public class RotateArray {

    public static int[] rotate1(int[] a, int k) {
        if (a == null || k <=0 || k > a.length) {
            return a;
        }

        int p = 0;
        for (int i=0;i<k;i++) {
            for (int j=i;j<a.length-k+i;j++) {
                p = a[j];
                a[j] = a[a.length - k + i];
                a[a.length - k + i] = p;
            }
        }
        return a;
    }

    public static int[] rotate2(int[] a, int k) {
        if (a == null || k <=0 || k > a.length) {
            return a;
        }

        int p = 0, q = 0;
        for (int i = 0; i < k; i++) {
            //取每次的最后一个
            q = a[a.length - 1];
            for (int j=0;j<a.length;j++) {
                p = q;
                q = a[j];
                a[j] = p;
            }
        }

        return a;
    }

    public static int[] rotate3(int[] a, int k) {
        if (a == null || k <= 0 || k > a.length) {
            return a;
        }
        k = k % a.length;
        reverse(a, 0, a.length -1);
        reverse(a, 0, k-1);
        reverse(a, k, a.length-1);
        return a;
    }

    /**
     * 可以使用递归树推导递归时间复杂度
     * @param a
     * @param start
     * @param end
     */
    private static void reverse(int[] a, int start, int end) {
        while (start < end) {
            int tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;

            start++;
            end--;
        }
    }

    // (i+k) % a.length 寻找位置
    public static int[] rotate4(int[] a, int k) {
        if (a == null || k <= 0 || k > a.length) {
            return a;
        }
        int[] tmp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            tmp[(i + k) % a.length] = a[i];
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = tmp[i];
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        int[] b = {-1,-100,3,99};
        System.out.println(Arrays.toString(rotate4(a, 3)));
    }

}
