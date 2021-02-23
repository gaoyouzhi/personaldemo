package com.haochang.sort;

import java.util.Scanner;

/**
 * @description: 描述：美团
 * @author: youzhi.gao
 * @date: 2021-02-22 14:12
 */
public class MeiTuan {
    public static void main(String[] args) {
        //W 公司总人数  Y 平均年龄 离职率 x 0-1 新员工平均年龄21
        int N = 5;
        int W = 100;
        int Y = 30;
        double x = 0.1;
        int XYG = 21;
        double AVG = 0;

        for(int i = 1; i <= N; i++){
            Y = (int) Math.ceil((Y + 1) * (1-x) + x*21);
        }

        Scanner scanner = new Scanner(System.in);


    }

}
