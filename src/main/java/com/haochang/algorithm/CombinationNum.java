package com.haochang.algorithm;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 描述：组合数字
 * @author: youzhi.gao
 * @date: 2021-02-24 14:01
 */
public class CombinationNum {
    public List<List<Integer>> res = new ArrayList<>();


    public List<Integer> t = new ArrayList<>();

    public void combinationsNums(int n, int start, List<Integer> t, int sum){
        if(n == t.size() || sum <= 0){
            if(n == t.size() && sum == 0){
                res.add(new ArrayList<>(t));
            }
            return;
        }

        for (int i = start; i <= 9; i++){
            t.add(i);
            combinationsNums(n, i + 1, t, sum - i);
            t.remove(t.size() - 1);
        }
    }


    public static void main(String[] args) {
        CombinationNum combinationNum = new CombinationNum();
        combinationNum.combinationsNums(3, 1, new ArrayList<>(), 10);
        System.out.println(Arrays.toString(combinationNum.res.toArray()));
    }
}
