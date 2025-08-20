package datasturcture.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DSLR {

    static final int MAX = 10000;

    static int D(int n) { return (n * 2) % MAX; }
    static int S(int n) { return n == 0 ? 9999 : n - 1; }
    static int L(int n) { return (n % 1000) * 10 + (n / 1000); }
    static int R(int n) { return (n % 10) * 1000 + (n / 10); }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[MAX];
            int[] prev = new int[MAX];     // 이전 정점
            char[] how = new char[MAX];    // 어떤 연산으로 왔는지

            Arrays.fill(prev, -1);

            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.add(start);
            visited[start] = true;

            while (!q.isEmpty() && !visited[target]) {
                int cur = q.poll();

                int[] nexts = { D(cur), S(cur), L(cur), R(cur) };
                char[] ops   = { 'D',    'S',    'L',    'R'    };

                for (int i = 0; i < 4; i++) {
                    int nx = nexts[i];
                    if (!visited[nx]) {
                        visited[nx] = true;
                        prev[nx] = cur;
                        how[nx] = ops[i];
                        q.add(nx);
                        if (nx == target) break; // 약간의 가지치기
                    }
                }
            }

            // 경로 복원
            StringBuilder sb = new StringBuilder();
            for (int v = target; v != start; v = prev[v]) {
                sb.append(how[v]);
            }
            out.append(sb.reverse()).append('\n');
        }

        System.out.print(out);
    }
}