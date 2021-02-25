package com.haochang.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 描述：深度优先搜索 deep first search
 * @author: youzhi.gao
 * @date: 2021-02-23 09:27
 */
public class DFS {
    public List<Integer> t = new ArrayList<>();
    public List<List<Integer>> ans = new ArrayList<>();


    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if(cur == nums.length){
            ans.add(new ArrayList<>(t));
            System.out.println(Arrays.toString(t.toArray()));
            return;
        }

        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{12,14,15,11};
        DFS dfs = new DFS();
        List<List<Integer>> subsets = dfs.subsets(arr);
        System.out.println(Arrays.toString(subsets.toArray()));
    }
}
