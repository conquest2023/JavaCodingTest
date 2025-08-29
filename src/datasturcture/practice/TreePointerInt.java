package datasturcture.practice;

import java.io.*;

public class TreePointer {
    static class Node {
        char val;
        Node left, right;
        Node(char v){
            this.val = v;
        }
    }

    static Node[] nodes = new Node[26];
    static StringBuilder pre = new StringBuilder();
    static StringBuilder in  = new StringBuilder();
    static StringBuilder post= new StringBuilder();

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 26; i++)
            nodes[i] = new Node((char) ('A' + i));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] hasParent = new boolean[26];

        for (int i = 0; i < n; i++) {
            String[] sp = br.readLine().split(" ");
            int p = sp[0].charAt(0) - 'A';
            char lc = sp[1].charAt(0), rc = sp[2].charAt(0);
            if (lc != '.') {
                nodes[p].left  = nodes[lc - 'A'];
                hasParent[lc - 'A'] = true;
            }
            if (rc != '.') {
                nodes[p].right = nodes[rc - 'A'];
                hasParent[rc - 'A'] = true;
            }
        }

        // 루트 찾기(일반화): 부모가 없는 노드
        Node root = nodes[0]; // 문제 가정상 A
        for (int i = 0; i < 26; i++) {
            if ((nodes[i].left != null || nodes[i].right != null) && !hasParent[i]) {
                root = nodes[i]; break;
            }
        }

        preorder(root);
        inorder(root);
        postorder(root);

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    static void preorder(Node cur) {
        if (cur == null) return;
        pre.append(cur.val);
        preorder(cur.left);
        preorder(cur.right);
    }
    static void inorder(Node cur) {
        if (cur == null) return;
        inorder(cur.left);
        in.append(cur.val);
        inorder(cur.right);
    }
    static void postorder(Node cur) {
        if (cur == null) return;
        postorder(cur.left);
        postorder(cur.right);
        post.append(cur.val);
    }
}
