package datasturcture.dfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 적록색약 {

    static  int a;

    static int[] dy={-1,0,1,0};
    static int[] dx={0,1,0,-1};


    static int[][] visited;
    static String[][] arr;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        sc.nextLine();
        arr=new String[a][a];
        visited=new int[a][a];
        for (int i = 0; i < a; i++) {
            String split = sc.nextLine();
            for (int j = 0; j < a ; j++) {
                arr[i][j]=String.valueOf(split.charAt(j));
            }
        }
        int count1=0;
        int count2=0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if(visited[i][j]==0){
                    count1+=1;
                    bfs(i,j,arr[i][j]);
                    }
            }
        }
        visited= new int[a][a];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if(visited[i][j]==0) {
                    count2 += 1;
                    bfs_2(i, j, arr[i][j]);
                }
            }
        }
        System.out.print(count1+" ");
        System.out.println(count2);
    }
        private static void bfs(int i, int j, String s) {
            visited[i][j] = 1;
            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{i, j});
            while (!deque.isEmpty()) {
                int[] poll = deque.pop();
                for (int k = 0; k < 4; k++) {
                    int ny = poll[0] + dy[k];
                    int nx = poll[1] + dx[k];
                    if (ny >= a || nx >= a || nx < 0 || ny < 0)
                        continue;
                    if (visited[ny][nx] == 1)
                        continue;
                    if (arr[ny][nx].equals(s)) {
                        visited[ny][nx] = 1;
                        deque.add(new int[]{ny, nx});
                    }
                }
            }
        }

        private static void bfs_2(int i, int j, String s){
            visited[i][j] = 1;
            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{i, j});
            while (!deque.isEmpty()) {
                int[] poll = deque.pop();
                for (int k = 0; k < 4; k++) {
                    int ny = poll[0] + dy[k];
                    int nx = poll[1] + dx[k];
                    if (ny >= a || nx >= a || nx < 0 || ny < 0)
                        continue;

                    if (visited[ny][nx] == 1)
                        continue;
                    if (arr[ny][nx].equals(s)) {
                        visited[ny][nx] = 1;
                        deque.add(new int[]{ny, nx});
                        continue;
                    }
                    if (s.equals("R") || s.equals("G")){
                        if (arr[ny][nx].equals("R") || arr[ny][nx].equals("G")) {
                            visited[ny][nx] = 1;
                            deque.add(new int[]{ny, nx});
                        }
                    }
                }
            }
        }
}
