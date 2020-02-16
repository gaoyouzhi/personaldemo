package com.ikang.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description 插入排序
 * @author gaoyouzhi
 * @date 2020/2/10
 */
public class InsertionSort {
    public static void main(String[] args) {
        insertSort(new int[]{101,3,5,61,23,11}, 6);
    }

    private static void insertSort(int[] ints, int n) {
        if(n <= 1){
            return;
        }

        for(int i = 1;i < n;i ++){
            int value = ints[i];
            int j = i - 1;
            for(;j >= 0; j--){
                if(value > ints[j]){
                    ints[j+1] = ints[j];
                }else{
                    break;
                }
            }
            ints[j+1] = value;
        }
        System.out.println(Arrays.toString(ints));
    }
}
