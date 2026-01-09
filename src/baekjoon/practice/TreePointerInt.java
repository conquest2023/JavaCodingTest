package datasturcture.practice;

import java.io.*;
import java.util.*;

public class TreePointerInt {
    static class Node {
        int val;
        Node left, right;
        Node(int v){ this.val = v; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Node> nodes = new HashMap<>();
        Set<Integer> hasParent = new HashSet<>();
        Set<Integer> appeared  = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("\\s+");
            int p = Integer.parseInt(s[0]);
            int l = Integer.parseInt(s[1]);
            int r = Integer.parseInt(s[2]);

            Node P = nodes.computeIfAbsent(p, Node::new);
            appeared.add(p);

            if (l != -1) {
                Node L = nodes.computeIfAbsent(l, Node::new);
                P.left = L;
                hasParent.add(l);
                appeared.add(l);
            }
            if (r != -1) {
                Node R = nodes.computeIfAbsent(r, Node::new);
                P.right = R;
                hasParent.add(r);
                appeared.add(r);
            }
        }

        // 루트 찾기
        Node root = null;
        for (int id : appeared) {
            if (!hasParent.contains(id)) { root = nodes.get(id); break; }
        }
        if (root == null) return;

        // 전위/중위/후위(재귀 예시)
        StringBuilder pre = new StringBuilder();
        StringBuilder in  = new StringBuilder();
        StringBuilder post= new StringBuilder();

        preorder(root, pre);
        inorder(root, in);
        postorder(root, post);

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    static void preorder(Node cur, StringBuilder sb){
        if (cur == null) return;
        sb.append(cur.val).append(' ');
        preorder(cur.left, sb);
        preorder(cur.right, sb);
    }
    static void inorder(Node cur, StringBuilder sb){
        if (cur == null) return;
        inorder(cur.left, sb);
        sb.append(cur.val).append(' ');
        inorder(cur.right, sb);
    }
    static void postorder(Node cur, StringBuilder sb){
        if (cur == null) return;
        postorder(cur.left, sb);
        postorder(cur.right, sb);
        sb.append(cur.val).append(' ');
    }
}
