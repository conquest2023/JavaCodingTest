package datasturcture.dfs.bfs;

import java.util.*;

public class 영역구하기 {

    static  int[][] arr;

    static  int[][] visited;

    static int[] dy={-1,0,1,0};
    static int[] dx={0,1,0,-1};

    static  int a,b;
    static  int x1,y1,x2,y2;

    static List<Integer> rnt;

    static  int idx;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(o -> Integer.valueOf(o)).toArray();
        a=array[0];
        b=array[1];
        arr=new int[a][b];
        visited=new int[a][b];
        rnt=new ArrayList<>();
        int count=0;
        for (int i = 0; i < array[2]; i++) {
            int[] split = Arrays.stream(sc.nextLine().split(" ")).mapToInt(o -> Integer.valueOf(o)).toArray();
            x1=split[0]; x2=split[2]; y1=split[1]; y2=split[3];
            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2 ; k++) {
                     arr[k][j]=1;
                }
            }
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b ; j++) {
                if(visited[i][j]==0  && arr[i][j]==0){
                    bfs(i,j);
                    count+=1;
                }
            }
        }
        System.out.println(count);
        Collections.sort(rnt);
        for (Integer i : rnt) {
            System.out.print(i+" ");
        }
    }
    static  void bfs(int x, int y){
        idx=0;
        visited[x][y]=1;
        Queue<int[]> queue=new ArrayDeque<>();
        queue.add(new int[]{x,y});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + dy[i];
                int nx = poll[1] + dx[i];
                if (nx < 0 || ny < 0 || nx >= b || ny >= a) continue;
                if (visited[ny][nx] == 0 && arr[ny][nx] == 0) {
                    queue.add(new int[]{ny, nx});
                    visited[ny][nx]=1;
                    idx+=1;
                }
            }
        }
        rnt.add(idx+1);
    }
}
