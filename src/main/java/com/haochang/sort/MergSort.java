package com.haochang.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergSort {

    public static void main(String[] args) {
        int[] nums = {9, 5, 6, 8, 0, 3, 7, 1, 22, 26};
        mergeSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

   public static void mergeSort(int[] data, int left, int right){
        if(left < right){
            int mid = (right + left) / 2;
            mergeSort(data, left, mid);
            mergeSort(data, mid + 1, right);
            merge(data, left, mid, right);
        }
   }
   public static void merge(int[] data, int left, int mid, int right){
        int[] temp = new int[data.length];

        int point1 = left;
        int point2 = mid + 1;

        int loc = left;
        while (point1 <= mid && point2 <= right){
            if(data[point1] <= data[point2]){
                temp[loc] = data[point1];
                loc++;
                point1++;
            } else {
                temp[loc] = data[point2];
                loc++;
                point2++;
            }
        }

        while (point1 <= mid){
            temp[loc] = data[point1];
            loc++;
            point1++;
        }

        while (point2 <= right){
            temp[loc] = data[point2];
            loc++;
            point2++;
        }

        for (int i = left; i <= right; i ++){
            data[i] = temp[i];
        }

   }
}
