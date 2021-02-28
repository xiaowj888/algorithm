package com.wind.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC41_FirstMissingPositive {
    /**
    * @description 递归解题
    * @date 2021/2/21 17:59
    * @params
    * @return
    **/
    static class Solution {
        public int firstMissingPositive(int[] nums) {
            Set<Integer> set = new HashSet<>(nums.length);
            int result = 1;
            for(int n : nums){
                if(result == n){
                    result ++;
                    while(set.contains(result)){
                        result ++;
                    }
                }
                if(n>0){
                    set.add(n);
                }
            }
            return result;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int []{ -1,-2,-3,9,-4,-5,19,8,7,2,1,3,4,5,6,10,12,14,13,11,19,20};
        int closest = solution.firstMissingPositive(nums);
        System.out.println(closest);
    }
}