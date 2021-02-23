package com.haochang.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 描述：回溯算法
 * @author: youzhi.gao
 * @date: 2021-02-23 10:39
 */
public class BackTrack {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            result.add(new ArrayList<Integer>(t));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12,14,15,11};
        BackTrack backTrack = new BackTrack();
        List<List<Integer>> subsets = backTrack.subsets(arr);
        System.out.println(Arrays.toString(subsets.toArray()));
    }
}
