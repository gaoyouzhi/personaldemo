package com.haochang.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 描述：打印矩阵
 * @author: youzhi.gao
 * @date: 2021-02-23 13:33
 */
public class Matrix {
    public static void main(String[] args) {
        int len = 5;
        int[][] nums = new int[len][len];
        int num = 1;
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                nums[i][j] = num++;
            }
        }

        List<Integer> result = matrix(nums);
        System.out.println(Arrays.toString(result.toArray()));
    }

    private static List<Integer> matrix(int[][] nums) {
        List<Integer> result = new ArrayList<>();

        if(null == nums || nums.length == 0|| nums[0].length == 0)
            return result;

        int rows = nums.length;
        int columns = nums[0].length;
        int total = rows * columns;
        int row = 0;
        int column = 0;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1},{-1, 0}};
        int directionIndex = 0;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < total; i++){
            result.add(nums[row][column]);
            visited[row][column] = true;

            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];

            if(nextColumn < 0 || nextRow < 0 || nextRow >= rows || nextColumn >= columns || visited[nextRow][nextColumn]){
                directionIndex = (directionIndex + 1) % 4;
            }

            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }

        return result;
    }
}
