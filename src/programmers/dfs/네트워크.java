package programmers.dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class 네트워크 {


    static ArrayList<Integer>[] list;
    static boolean[] visited;


    public static void main(String[] args) {


        int solution = solution(2, new int[][]{{1,1}, {1,1}});
        System.out.println(solution);
    }


    public static int solution(int n, int[][] computers) {
        int answer=1;
        list=new ArrayList[n+1];
        for (int i = 0; i < n; i++) {
            list[i]=new ArrayList<>();
        }
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (i==j) {
                    list[i].add(0);
                }else {
                    list[i].add(computers[i][j]);
                }
            }
        }
        visited=new boolean[n+1];
        if (n==1){
            return 1;
        }
        dfs(0,list,n);
        for (int i = 0; i < visited.length-1; i++) {
            if (!visited[i]){
                answer+=1;
            }
        }
        if (answer>n){
            return n;
        }
        return  answer;
    }

    private  static void dfs(int start,ArrayList<Integer>[] list,int size){
        for (int i = start; i < size ; i++) {
            for (int j = 0; j < size ; j++) {
                if (!visited[i] && list[i].get(j)==1){
                    dfs(start+1,list,size);
                    visited[i]=true;
                }
            }
        }
    }
}