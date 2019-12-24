package com.xiaohao.jike;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头
 *
 * 链接：https://leetcode-cn.com/problems/plus-one
 *
 */
public class ArrayAdd {

    public static int[] plusOne(int[] digits) {
        if (digits == null)
            return null;

        //只有当0位置元素>=10需要扩容
        for (int i=digits.length-1;i>=0;i--) {
            digits[i] = digits[i] + 1;
            if (digits[i] / 10 > 0) {
                if(i == 0) {
                    int[] arr = new int[digits.length+1];
                    digits[i] = digits[i] % 10;
                    System.arraycopy(digits, 0, arr, 1, digits.length);
                    arr[0] = 1;
                    return arr;
                }else {
                    digits[i] = digits[i] % 10;
                    continue;
                }
            }
            return digits;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,6,5,9,9};
        System.out.println(Arrays.toString(plusOne(a)));

    }

}
