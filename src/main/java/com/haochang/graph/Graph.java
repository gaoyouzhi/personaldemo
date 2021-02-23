package com.haochang.graph;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @description: 描述：图
 * @author: youzhi.gao
 * @date: 2021-02-23 14:03
 */
public class Graph {

    private int n;//表示行
    private int m;//表示列

    private int dx;//表示目标的横坐标
    private int dy;//表示目标的纵坐标

    private int[][] data;//表示图的矩阵  邻接矩阵
    private boolean[][] mark;//表示到过的点

    public Graph(int n, int m, int dx, int dy, int[][] data, boolean[][] mark) {
        this.n = n;
        this.m = m;
        this.dx = dx;
        this.dy = dy;
        this.data = data;
        this.mark = mark;
    }

    public void bfs(int startx, int starty){//表示我的位置
        mark[startx][starty] = true;
        Queue<Point> queue = new ArrayBlockingQueue<Point>(n * m);

        Point start = new Point();
        start.x = startx;
        start.y = starty;
        queue.add(start);
        //定义一个方向变量
        int[][] directions = {{0, 1}, {1, 0},{0, -1},{-1, 0}};

        while (!queue.isEmpty()){
            Point curPoint = queue.poll();
            for(int j = 0; j < 4; j++){
                int nextx = curPoint.x + directions[j][0];
                int nexty = curPoint.y + directions[j][1];
                //越界不可继续走
                if(nextx < 1 || nexty < 1 || nextx > n || nexty > m){
                    continue;
                }

                System.out.println("下一个点：" + nextx + ":" + nexty);
                //未走过 并且不是障碍
                if(!mark[nextx][nexty] && data[nextx][nexty] == 0){
                    if(nextx == dx && nexty == dy){
                        System.out.println("true");
                        return;
                    }
                    Point point = new Point();
                    point.x = nextx;
                    point.y = nexty;
                    queue.add(point);
                    mark[nextx][nexty] = true;
                }

            }
        }
        System.out.println("false");
        return;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int data[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                data[i][j] = scanner.nextInt();
            }
        }

        int dx = scanner.nextInt();
        int dy = scanner.nextInt();
        boolean[][] mark = new boolean[n + 1][m + 1];
        Graph graph = new Graph(n, m, dx, dy, data, mark);
        int startx = scanner.nextInt();
        int starty = scanner.nextInt();
        graph.bfs(startx, starty);

    }

    class Point{
        int x;
        int y;
    }

// 4 4
// 0 0 0 0
// 1 0 0 1
// 0 1 1 0
// 0 0 1 0
// 2 2
// 0 0
}
