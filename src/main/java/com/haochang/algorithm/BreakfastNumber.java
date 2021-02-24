package com.haochang.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 描述：早餐
 * @author: youzhi.gao
 * @date: 2021-02-24 10:44
 */
public class BreakfastNumber {
    private int[] milk = {8 , 9, 2, 3};
    private int[] bread = {3, 4, 5, 6};

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> t = new ArrayList<>();
    public int breadAndMilk(int[] milk, int[] bread, int sum){
        if(null == milk || null == bread || milk.length == 0 || bread.length == 0) return -1;
        for (int i = 0; i < milk.length; i++){
            int m = milk[i];
            if(m >= sum) continue;
            for (int j = 0; j < bread.length; j++){
                t.clear();
                if(bread[j] <= (sum - m)){
                    t.add(m);
                    t.add(bread[j]);
                    result.add(new ArrayList<>(t));
                }
            }
        }

        System.out.println(Arrays.toString(result.toArray()));
        return result.size();
    }

    public static void main(String[] args) {
        BreakfastNumber breakfastNumber = new BreakfastNumber();
        breakfastNumber.breadAndMilk(breakfastNumber.milk, breakfastNumber.bread, 8);
    }
}
