package com.plat.study;

/**
 * Created by heyugang on 2021/4/1.
 */
public class Solution {

    /*
    给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。

    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

    你可以按任意顺序返回答案。
    * **/
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int n = 0; n < nums.length; n++) {
            arr[0] = n;
            for (int i = (n + 1); i < nums.length; i++) {
                if (nums[n] + nums[i] == target) {
                    arr[1] = i;
                    return arr;
                }
            }
        }
        return null;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return null;
    }



    public static void main(String[] args) {

        for (int i : twoSum(new int[]{-1, -2, -3, -4, -5}, -8)) {
            System.out.println(i);
        }
    }
}
