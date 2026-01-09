package datasturcture.practice;

import java.io.*;
import java.util.*;

/** Binary Search Tree (no duplicates) */
public class BST {
    static class Node {
        int key;
        Node left;
        Node right;
        Node(int k) { this.key = k; }
    }

    private Node root;

    /* -------- 기본 연산 -------- */

    // 삽입 (반복) - 중복은 무시
    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            parent = cur;
            if (key < cur.key)
                cur = cur.left;
            else if (key > cur.key)
                cur = cur.right;
            else return; // duplicate -> ignore
        }
        if (key < parent.key)
            parent.left = new Node(key);
        else
            parent.right = new Node(key);
    }

    // 탐색 (반복)
    public boolean contains(int key) {
        Node cur = root;
        while (cur != null) {
            if (key < cur.key) cur = cur.left;
            else if (key > cur.key) cur = cur.right;
            else return true;
        }
        return false;
    }

    // 삭제 (반복) - 3가지 경우 처리
    public void delete(int key) {
        Node cur = root, parent = null;
        // 1) 삭제할 노드 찾기
        while (cur != null && cur.key != key) {
            parent = cur;
            cur = (key < cur.key) ? cur.left : cur.right;
        }
        if (cur == null)
            return; // not found

        // 2) 두 자식 모두 있는 경우: 우측 서브트리의 최솟값(후계자)로 치환
        if (cur.left != null && cur.right != null) {
            Node succ = cur.right;
            Node succParent = cur;
            while (succ.left != null)
            {
                 succParent = succ;
                 succ = succ.left;
            }
            cur.key = succ.key;     // 키만 복사
            // 이제 succ(후계자) 삭제로 문제 축소 (succ는 왼자식 없음)
            cur = succ;
            parent = succParent;
        }

        // 3) 자식 0개 또는 1개 처리
        Node child = (cur.left != null) ? cur.left : cur.right;  // null일 수 있음
        if (parent == null) {
            root = child; // 루트 삭제
        } else if (parent.left == cur) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    /* -------- 순회(반복) -------- */

    // 중위: 정렬된 오름차순 출력
    public List<Integer> inorder() {
        List<Integer> ans = new ArrayList<>();
        Deque<Node> st = new ArrayDeque<>();
        Node cur = root;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) { st.push(cur); cur = cur.left; }
            cur = st.pop();
            ans.add(cur.key);
            cur = cur.right;
        }
        return ans;
    }

    public List<Integer> preorder() {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<Node> st = new ArrayDeque<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node n = st.pop();
            ans.add(n.key);
            if (n.right != null) st.push(n.right);
            if (n.left  != null) st.push(n.left);
        }
        return ans;
    }

    public List<Integer> postorder() {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<Node> st = new ArrayDeque<>();
        Node cur = root, prev = null;
        while (cur != null || !st.isEmpty()) {
            if (cur != null) { st.push(cur); cur = cur.left; }
            else {
                Node peek = st.peek();
                if (peek.right != null && prev != peek.right) {
                    cur = peek.right;
                } else {
                    ans.add(peek.key);
                    prev = st.pop();
                }
            }
        }
        return ans;
    }

    public List<Integer> bfsLevelOrder() {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node n = q.poll();
            ans.add(n.key);
            if (n.left  != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
        return ans;
    }

    /* -------- 전위(preorder)만으로 BST 재구성 --------
       (BST의 전위가 주어지면 같은 트리를 유일하게 복원 가능) */
    public static BST fromPreorder(int[] pre) {
        if (pre.length == 0) return new BST();
        Deque<Node> st = new ArrayDeque<>();
        BST tree = new BST();
        tree.root = new Node(pre[0]);
        st.push(tree.root);

        for (int i = 1; i < pre.length; i++) {
            Node node = new Node(pre[i]);
            if (pre[i] < st.peek().key) {
                // 왼쪽 자식
                st.peek().left = node;
                st.push(node);
            } else {
                // 오른쪽으로 갈 부모를 찾기
                Node parent = null;
                while (!st.isEmpty() && pre[i] > st.peek().key) parent = st.pop();
                parent.right = node;
                st.push(node);
            }
        }
        return tree;
    }

    /* -------- 데모 -------- */
    public static void main(String[] args) throws Exception {
        // 1) 삽입 시퀀스로 구성
        BST t = new BST();
        int[] keys = {8, 3, 10, 1, 6, 4, 7, 14, 13};
        for (int k : keys) t.insert(k);

        System.out.println("In   (sorted): " + t.inorder());
        System.out.println("Pre           : " + t.preorder());
        System.out.println("Post          : " + t.postorder());
        System.out.println("BFS           : " + t.bfsLevelOrder());

        // 2) 삭제 예시
        t.delete(3);  // 두 자식
        t.delete(14); // 한 자식
        t.delete(1);  // 리프
        System.out.println("After delete  : " + t.inorder());

        // 3) 전위만으로 복원
        int[] preorder = {8, 3, 1, 6, 4, 7, 10, 14, 13};
        BST t2 = BST.fromPreorder(preorder);
        System.out.println("Rebuilt inorder: " + t2.inorder()); // 정렬 확인
    }
}
