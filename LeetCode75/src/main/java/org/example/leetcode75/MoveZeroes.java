package org.example.leetcode75;

import java.util.Arrays;


public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,3,0,12};
        MoveZeroes.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {
        int insertPos = 0;

        for(int num : nums) {
            if(num != 0){
                nums[insertPos++] = num;
            }
        }

        while(insertPos < nums.length){
            nums[insertPos++] = 0;
        }

    }
}
