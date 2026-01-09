package datasturcture.practice;

import java.io.*;
import java.util.*;

public class TreeAdjListChar {
    static List<Integer>[] children = new ArrayList[26];
    static boolean[] hasParent = new boolean[26];

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 26; i++) children[i] = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] sp = br.readLine().split(" ");
            int p = sp[0].charAt(0) - 'A';
            char lc = sp[1].charAt(0), rc = sp[2].charAt(0);
            if (lc != '.') { children[p].add(lc - 'A'); hasParent[lc - 'A'] = true; }
            if (rc != '.') { children[p].add(rc - 'A'); hasParent[rc - 'A'] = true; }
        }

        // 루트 찾기
        int root = 0; // 기본 A
        for (int i = 0; i < 26; i++) {
            if ((!children[i].isEmpty() || hasParent[i]) && !hasParent[i]) { root = i; break; }
        }

        // 전위(일반 트리): 자기 → 자식들(왼→오)
        StringBuilder pre = new StringBuilder();
        dfsPre(root, pre);
        System.out.println(pre.toString());

        // BFS(레벨 순회) 예시
        System.out.println(bfsOrder(root));
    }

    static void dfsPre(int cur, StringBuilder sb) {
        sb.append((char)(cur + 'A'));
        for (int nxt : children[cur]) dfsPre(nxt, sb);
    }

    static String bfsOrder(int root) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int u = q.poll();
            sb.append((char)(u + 'A'));
            for (int v : children[u]) q.add(v);
        }
        return sb.toString();
    }
}