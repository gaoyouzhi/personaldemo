package com.ikang.sort;

import java.util.Arrays;

/**
 *
 * @author gaoyouzhi
 * @date 2020/2/10
 * @Description 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
//        bubbleSort(new int[]{1,21,13,45,25}, 5);
        bubbleSort1(new int[]{1,13,21,13,45,25}, 6);
    }

    private static void bubbleSort1(int[] ints, int m) {
        if(m <= 1) {
            return;
        }

        for(int i = m - 1; i >= 0; i--){
            boolean flag = false;
            for(int j = i - 1; j >= 0; j --){
                if(ints[j] > ints[j+1]){
                    int tmp = ints[j+1];
                    ints[j+1] = ints[j];
                    ints[j] = tmp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }

        System.out.println(Arrays.toString(ints));
    }

    private static void bubbleSort(int[] a, int n) {
        if(n <= 1){
            return;
        }
        for(int i = 0; i < n; i ++){
            boolean flag = false;
            for(int j = 0;j < n - i - 1; j++){
                if (a[j] > a[j+1]){
                    int tmp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tmp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }

        System.out.println(Arrays.toString(a));
    }

}
