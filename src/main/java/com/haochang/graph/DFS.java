package com.haochang.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @description: 描述：深度优先
 * @author: youzhi.gao
 * @date: 2021-02-23 18:26
 */
public class DFS {

//    private int n;//表示行
//    private int m;//表示列
//
//    private int dx;//表示目标的横坐标
//    private int dy;//表示目标的纵坐标
//
//    private int[][] data;//表示图的矩阵  邻接矩阵
//    private boolean[][] mark;//表示到过的点
//
//    public DFS(int n, int m, int dx, int dy, int[][] data, boolean[][] mark) {
//        this.n = n;
//        this.m = m;
//        this.dx = dx;
//        this.dy = dy;
//        this.data = data;
//        this.mark = mark;
//    }

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> t =  new ArrayList<>();

    public void subset(int[] nums){
        for (int i = 0; i <= nums.length; i++){
            dfs(0, i, nums, t);
        }
    }

    private void dfs(int start, int size, int[] nums, List<Integer> list) {
        if(list.size() == size){
            res.add(new ArrayList<>(list));
            System.out.println(Arrays.toString(list.toArray()));
            return;
        }

        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);
            dfs(i + 1, size, nums, list);
            list.remove(list.size() - 1);
//            System.out.println("remove element:" + list.remove(list.size() - 1));
        }
    }

    public static void main(String[] args) {

        DFS subSets = new DFS();
        int[] nums = {1,3,6,12};
        subSets.subset(nums);

        System.out.println(Arrays.toString(subSets.res.toArray()));
    }
}
