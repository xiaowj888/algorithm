package com.wind.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC29_TwoDivide {
    /**
    * @description 递归解题
    * @date 2021/2/21 17:59
    * @params
    * @return
    **/
    static class Solution {
        public int divide(int dividend, int divisor) {
            if(dividend==Integer.MIN_VALUE&&divisor==-1)
                return Integer.MAX_VALUE;
            boolean isNegative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
            dividend=-Math.abs(dividend);
            divisor=-Math.abs(divisor);
            // 阶梯被除数
            List<Integer> divisorList = new ArrayList<>();
            // 阶梯被除数对应的倍数
            List<Integer> stepList = new ArrayList<>();
            int currentStep=1;
            while(dividend - divisor <=0){
                divisorList.add(divisor);
                stepList.add(currentStep);
                divisor += divisor;
                currentStep += currentStep;
                if(divisor>=0) {
                    break;
                }
            }
            int result = 0;
            for(int i = divisorList.size()-1;i>=0;i--){
                if(dividend - divisorList.get(i) <= 0){
                    dividend -= divisorList.get(i);
                    result = result + stepList.get(i);
                }
            }
            return isNegative?0-result:result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int closest = solution.divide(Integer.MIN_VALUE,-1);
        System.out.println(closest);
    }
}