package com.xiaohao.jike;

/**
 * 水滴计算
 *
 * 抛开整体看个体：找规律
 * 每个位置的水滴数量 = 一个高度 - 当前的值
 * 注：这个高度就是左右最高的高度（左边最高和右边最高） 的最小值
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
 */
public class RainCount {

    //双指针法
    public int trap(int[] a) {
        if (a == null || a.length == 0) return 0;
        int left = 0, right = a.length - 1;  //左右指针  记录的位置
        int lmax_value = a[0], rmax_value = a[a.length - 1]; //左右最大值  记录的值
        int ano = 0; // 统计值
        while(left <= right) {
            lmax_value = Math.max(lmax_value, a[left]);
            rmax_value = Math.max(rmax_value, a[right]);

            if(lmax_value < rmax_value) {
                ano += lmax_value - a[left];
                left++;
            } else {
                ano += rmax_value - a[right];
                right++;
            }
        }
        return ano;
    }

}
