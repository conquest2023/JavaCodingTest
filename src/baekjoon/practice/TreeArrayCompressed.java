package datasturcture.practice;

import java.io.*;
import java.util.*;

public class TreeArrayCompressed {
    static int[] left, right, idByIdx;
    static Map<Integer, Integer> idxOfId = new HashMap<>();
    static StringBuilder pre = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> rows = new ArrayList<>();
        Set<Integer> ids = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("\\s+");
            int p = Integer.parseInt(s[0]);
            int l = Integer.parseInt(s[1]);
            int r = Integer.parseInt(s[2]);
            rows.add(new int[]{p, l, r});
            ids.add(p);
            if (l != -1) ids.add(l);
            if (r != -1) ids.add(r);
        }

        // ID 압축 (정렬 후 0..M-1로 매핑)
        List<Integer> order = new ArrayList<>(ids);
        Collections.sort(order);
        idByIdx = new int[order.size()];
        for (int i = 0; i < order.size(); i++) {
            idxOfId.put(order.get(i), i);
            idByIdx[i] = order.get(i);
        }

        left  = new int[order.size()];
        right = new int[order.size()];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        boolean[] hasParent = new boolean[order.size()];
        boolean[] appeared  = new boolean[order.size()];

        for (int[] e : rows) {
            int pi = idxOfId.get(e[0]);
            appeared[pi] = true;
            if (e[1] != -1) { left[pi]  = idxOfId.get(e[1]);
                hasParent[left[pi]]  = true;
                appeared[left[pi]]  = true;
            }
            if (e[2] != -1) { right[pi] = idxOfId.get(e[2]);
                hasParent[right[pi]] = true;
                appeared[right[pi]] = true;
            }
        }

        int root = -1;
        for (int i = 0; i < appeared.length; i++) {
            if (appeared[i] && !hasParent[i]) { root = i; break; }
        }
        preorder(root);
        System.out.println(pre);
    }

    static void preorder(int cur){
        if (cur == -1) return;
        pre.append(idByIdx[cur]).append(' ');
        preorder(left[cur]);
        preorder(right[cur]);
    }
}
