package com.wind.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LC53_MaxSubArray {
    /**
    * @description 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     *
     * 输入：nums = [1]
     * 输出：1
     *
     * 输入：nums = [0]
     * 输出：0
     *
     * 输入：nums = [-1]
     * 输出：-1
     *
     * 输入：nums = [-100000]
     * 输出：-100000
     *
     * 提示：
     *
     * 1 <= nums.length <= 3 * 104
     * -105 <= nums[i] <= 105
     *
     * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
    * @date 2021/2/21 17:59
    * @params
    * @return
    **/
    static class Solution {
        public int maxSubArray(int[] nums) {
            int sum = 0;
            int ans = nums[0];
            for(int i=0;i<nums.length;i++){
                if(sum > 0){
                    sum += nums[i];
                }else{
                    sum = nums[i];
                }
                ans = Math.max(sum,ans);
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int []{1,2,-1,-2,2,1,-2,1,4,-5,4,-8,10};
        int closest = solution.maxSubArray(nums);
        System.out.println(closest);
    }
}