package datasturcture.practice;

import java.io.*;
import java.util.*;

public class TreeArrayDense {
    static int[] left, right;
    static StringBuilder pre = new StringBuilder();
    static StringBuilder in  = new StringBuilder();
    static StringBuilder post= new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int maxId = 0;
        int[][] edge = new int[N][3];
        boolean[] hasParent;

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("\\s+");
            edge[i][0] = Integer.parseInt(s[0]);
            edge[i][1] = Integer.parseInt(s[1]);
            edge[i][2] = Integer.parseInt(s[2]);
            maxId = Math.max(maxId, Math.max(edge[i][0], Math.max(edge[i][1], edge[i][2])));
        }

        left = new int[maxId + 1];
        right= new int[maxId + 1];
        hasParent = new boolean[maxId + 1];
        Arrays.fill(left, -1);
        Arrays.fill(right,-1);

        boolean[] appeared = new boolean[maxId + 1];

        for (int[] e : edge) {
            int p = e[0], l = e[1], r = e[2];
            appeared[p] = true;
            if (l != -1) { left[p] = l;  hasParent[l] = true; appeared[l] = true; }
            if (r != -1) { right[p]= r;  hasParent[r] = true; appeared[r] = true; }
        }

        // 루트: 등장했지만 부모 없는 것
        int root = -1;
        for (int i = 0; i <= maxId; i++) {
            if (appeared[i] && !hasParent[i]) { root = i; break; }
        }

        preorder(root);
        inorder(root);
        postorder(root);

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    static void preorder(int cur){
        if (cur == -1) return;
        pre.append(cur).append(' ');
        preorder(left[cur]);
        preorder(right[cur]);
    }
    static void inorder(int cur){
        if (cur == -1) return;
        inorder(left[cur]);
        in.append(cur).append(' ');
        inorder(right[cur]);
    }
    static void postorder(int cur){
        if (cur == -1) return;
        postorder(left[cur]);
        postorder(right[cur]);
        post.append(cur).append(' ');
    }
}
