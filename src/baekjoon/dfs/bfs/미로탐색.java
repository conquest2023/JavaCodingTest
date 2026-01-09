package datasturcture.dfs.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색 {

    static int[][] visited;

    static  int[][] arr;
    static  int a;

    static  int b;
    static int[] dy={-1,0,1,0};
    static int[] dx={0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();
        sc.nextLine();
        arr= new int[a][b];

        visited=new int[a][b];

        for (int i = 0; i < a; i++) {
            int[] split = Arrays.stream(sc.nextLine().split("")).mapToInt(o->Integer.valueOf(o)).toArray();
            for (int j = 0; j < split.length; j++) {
                arr[i][j]=split[j];
            }
        }
        bfs();
        System.out.println(visited[a-1][b-1]);
    }
    public static void bfs() {
        visited[0][0] = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int k = 0; k < 4; k++) {
                int ny = poll[0] + dy[k];
                int nx = poll[1] + dx[k];
                if (nx < 0 || ny < 0 || ny >= a || nx >= b) continue;
                if (arr[ny][nx] == 0 || visited[ny][nx] != 0) continue;
                visited[ny][nx] = visited[poll[0]][poll[1]] + 1;
                queue.add(new int[]{ny, nx});
            }
        }
    }
}
