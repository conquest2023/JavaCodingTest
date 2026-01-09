package datasturcture.practice;

import java.io.*;
import java.util.*;

public class TreeAdjListInt {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> children = new HashMap<>();
        Set<Integer> hasParent = new HashSet<>();
        Set<Integer> appeared  = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("\\s+");
            int p = Integer.parseInt(s[0]);
            int l = Integer.parseInt(s[1]);
            int r = Integer.parseInt(s[2]);

            children.computeIfAbsent(p, k -> new ArrayList<>());
            appeared.add(p);

            if (l != -1) {
                children.computeIfAbsent(l, k -> new ArrayList<>());
                children.get(p).add(l);
                hasParent.add(l);
                appeared.add(l);
            }
            if (r != -1) { children.computeIfAbsent(r, k -> new ArrayList<>());
                children.get(p).add(r);
                hasParent.add(r);
                appeared.add(r);
            }
        }

        // 루트 찾기
        Integer root = null;
        for (int id : appeared) {
            if (!hasParent.contains(id)) { root = id; break; }
        }
        if (root == null) return;

        // 전위 DFS
        StringBuilder pre = new StringBuilder();
        dfsPre(root, children, pre);
        System.out.println(pre.toString().trim());

        // 레벨 순회(BFS)
        System.out.println(bfs(root, children));
    }

    static void dfsPre(int cur, Map<Integer, List<Integer>> g, StringBuilder sb){
        sb.append(cur).append(' ');
        for (int nxt : g.getOrDefault(cur, Collections.emptyList())) {
            dfsPre(nxt, g, sb);
        }
    }

    static String bfs(int root, Map<Integer, List<Integer>> g){
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            int u = q.poll();
            sb.append(u).append(' ');
            for (int v : g.getOrDefault(u, Collections.emptyList())) q.add(v);
        }
        return sb.toString().trim();
    }
}
