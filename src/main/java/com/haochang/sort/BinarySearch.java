package com.haochang.sort;

/**
 * @description: 描述：二分查找
 * @author: youzhi.gao
 * @date: 2021-02-22 13:52
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{3,5,14,16,17,22,34};
        int target = 17;
        int a = binarySearch(nums, target);
        System.out.println(a);
    }

    private static int binarySearch(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
