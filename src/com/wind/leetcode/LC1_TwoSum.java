package com.wind.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class LC1_TwoSum {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Set<Integer>> numMap = getNumMap(nums);
            for(int i=0;i<nums.length;i++){
                removeNum(numMap,nums[i],i);
                Set<Integer> indexs = numMap.get(target - nums[i]);
                if(null != indexs && indexs.size()>0){
                    return new int[]{i,indexs.iterator().next()};
                }
            }
            return new int[]{};
        }

        private Map<Integer, Set<Integer>> getNumMap(int[] nums) {
            Map<Integer, Set<Integer>> numMap = new HashMap<>(nums.length);
            for(int i=0;i<nums.length;i++){
                Set<Integer> indexs = numMap.computeIfAbsent(nums[i], k -> new HashSet<>());
                indexs.add(i);
           }
           return numMap;
        }
    
        private void removeNum(Map<Integer, Set<Integer>> numMap,int num,int index){
            numMap.get(num).remove(index);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,4,4,4};
        int[] ints = solution.twoSum(nums, 8);
        for(int i :ints){
           System.out.print(i+",");
        }
    }
}