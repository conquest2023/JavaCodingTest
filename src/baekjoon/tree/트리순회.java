package datasturcture.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class 트리순회 {

    static int[] left = new int[26];
    static int[] right = new int[26];

    static StringBuilder pre = new StringBuilder();
    static StringBuilder in  = new StringBuilder();
    static StringBuilder post= new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 초기화: 없다 표시를 -1로
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        for (int i = 0; i < n; i++) {
            String[] sp = br.readLine().split(" ");
            int p = sp[0].charAt(0) - 'A';
            char lc = sp[1].charAt(0);
            char rc = sp[2].charAt(0);

            if (lc != '.')
                left[p] = lc - 'A';
            if (rc != '.')
                right[p] = rc - 'A';
        }

        // 루트는 항상 'A'라고 문제에서 보장
        preorder(0);   // A
        inorder(0);
        postorder(0);

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    static void preorder(int cur) {
        if (cur == -1) return;
        pre.append((char)(cur + 'A'));
        preorder(left[cur]);
        preorder(right[cur]);
    }

    static void inorder(int cur) {
        if (cur == -1) return;
        inorder(left[cur]);
        in.append((char)(cur + 'A'));
        inorder(right[cur]);
    }

    static void postorder(int cur) {
        if (cur == -1) return;
        postorder(left[cur]);
        postorder(right[cur]);
        post.append((char)(cur + 'A'));
    }
}