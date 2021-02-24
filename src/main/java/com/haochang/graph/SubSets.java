package com.haochang.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 描述：子集问题
 * @author: youzhi.gao
 * @date: 2021-02-24 09:22
 */
public class SubSets {

    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> subset(int[] nums){
        dfs(0, nums);
        System.out.println(Arrays.toString(res.toArray()));
        return res;
    }

    private void dfs(int i, int[] nums) {

        if(i == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        dfs(i + 1, nums);
        temp.remove(temp.size() - 1);
        dfs(i + 1, nums);
    }

    public static void main(String[] args) {
        SubSets subSets = new SubSets();
        int[] nums = {1,3,6,12};
        subSets.subset(nums);
    }
}
