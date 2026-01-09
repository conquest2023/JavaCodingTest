package datasturcture.dfs;

import java.lang.reflect.InvocationHandler;
import java.util.*;

public class 연구소 {

    static int a;

    static int b;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int max;

    static int[][] arr;

    static int[][] visited;

    static List<int[]> empties;
    static  List<int[]> virus;

    static List<int[]> wall;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        sc.nextLine();
        arr = new int[a][b];
        virus=new ArrayList<>();
        wall=new ArrayList<>();
        empties=new ArrayList<>();
        for (int i = 0; i < a; i++) {
            int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            for (int j = 0; j < b; j++) {
                arr[i][j] = array[j];
                if (arr[i][j] == 0){
                    empties.add(new int[]{i, j});
                }
                if (array[j]==1){
                    wall.add(new int[]{i,j});
                }
                if (array[j]==2){
                    virus.add(new int[]{i,j});
                }
            }
        }
        int E = empties.size();

        for (int i = 0; i < E ; i++) {
            for (int j = i + 1; j < E; j++) {
                for (int k = j + 1; k <E; k++) {
                    visited = new int[a][b];
                    int[][] copies = copyOf(wall);
                    int[] e1 = empties.get(i);
                    int[] e2 = empties.get(j);
                    int[] e3 = empties.get(k);
                    copies[e1[0]][e1[1]]=1;
                    copies[e2[0]][e2[1]]=1;
                    copies[e3[0]][e3[1]]=1;
                    Deque<int[]> deque=new ArrayDeque<>();
                    for (int[] v : virus) {
                        deque.add(new int[]{v[0], v[1]});
                        visited[v[0]][v[1]] =2;
                    }
                    while (!deque.isEmpty()){
                        int[] poll = deque.pop();
                        for (int z = 0; z < 4; z++) {
                            int ny=poll[0] +dy[z];
                            int nx=poll[1] +dx[z];
                            if (ny >=a || nx>=b ||ny <0 || nx<0) {
                                continue;
                            }
                            if (visited[ny][nx]==2) {
                                continue;
                            }
                            if (copies[ny][nx]==1){
                                continue;
                            }
                            visited[ny][nx]=2;
                            deque.add(new int[]{ny,nx});
                        }
                    }
                    max= Math.max(max,count(copies,visited));
                }
            }
        }
        System.out.println(max);
    }

    static int[][] copyOf(List<int[]> walls){
        int[][] copy= new int[a][b];
        for (int i = 0; i < walls.size(); i++) {
            int[] ints = walls.get(i);
            copy[ints[0]][ints[1]]=1;
        }
        return copy;
    }

    static int count(int[][] walls,int[][] arrays){
        int answer=0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j <b ; j++) {
                if (walls[i][j]==0 && arrays[i][j]==0)
                    answer+=1;
            }
        }

        return answer;
    }
}
