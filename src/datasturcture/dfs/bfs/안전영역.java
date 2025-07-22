package datasturcture.dfs.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class 안전영역 {


    static int[][] arr;
    static int[][] visited;

    static  int a;
    static int[] dy={-1,0,1,0};
    static int[] dx={0,1,0,-1};
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        a= sc.nextInt();
        int count=0;
        sc.nextLine();
        arr= new int[a][a];
        int max=0;
        visited=new int[a][a];
        for (int i = 0; i < a; i++) {
            int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(o -> Integer.valueOf(o)).toArray();
            int idx = Arrays.stream(array).max().getAsInt();
            if(max<idx){
                max=idx;
            }
            for (int j = 0; j < a; j++) {
                arr[i][j]=array[j];
            }
        }
        int idx=1;
        int[] answer=new int[max];
        while (max!=0) {
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    if (visited[i][j] == 0 && arr[i][j]>=idx) {
                        bfs(i, j,idx);
                        count += 1;
                    }
                }
            }
            visited=new int[a][a];
            answer[idx-1]=count;
            count = 0;
            idx+=1;
            max-=1;
        }
        System.out.println(Arrays.stream(answer).max().getAsInt());
    }

    public static void bfs(int x,int y,int idx){
        visited[x][y]=1;
        Queue<int[]> queue=new ArrayDeque<>();
        queue.add(new int[]{x,y});
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny= poll[0]+dy[i];
                int nx= poll[1]+dx[i];
                if ( ny<0 || nx<0 || ny>=a | nx>=a)continue;
                if (visited[ny][nx]==0 && arr[ny][nx]>=idx){
                    visited[ny][nx]=1;
                    queue.add(new int[]{ny,nx});
                }
            }
        }
    }
}
