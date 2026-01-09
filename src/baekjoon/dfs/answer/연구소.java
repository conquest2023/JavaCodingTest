package datasturcture.dfs.answer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 연구소 {
    static int N, M;
    static int[][] grid;
    static List<int[]> empties = new ArrayList<>();
    static List<int[]> viruses = new ArrayList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 0)
                    empties.add(new int[]{i, j});
                else if (grid[i][j] == 2)
                    viruses.add(new int[]{i, j});
            }
        }

        int E = empties.size();
        int answer = 0;

        // 빈 칸 3곳 조합
        for (int i = 0; i < E; i++) {
            for (int j = i + 1; j < E; j++) {
                for (int k = j + 1; k < E; k++) {
                    int[][] copy = copyOf(grid);
                    // 벽 세우기
                    int[] a = empties.get(i);
                    int[] b = empties.get(j);
                    int[] c = empties.get(k);
                    copy[a[0]][a[1]] = 1;
                    copy[b[0]][b[1]] = 1;
                    copy[c[0]][c[1]] = 1;

                    // 바이러스 퍼뜨리기 (BFS)
                    bfsSpread(copy);

                    // 안전 영역 세기
                    int safe = countSafe(copy);
                    answer = Math.max(answer, safe);
                }
            }
        }

        System.out.println(answer);
    }

    static int[][] copyOf(int[][] src) {
        int[][] dst = new int[N][M];
        for (int i = 0; i < N; i++)
            System.arraycopy(src[i], 0, dst[i], 0, M);
        return dst;
    }

    static void bfsSpread(int[][] g) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[N][M];

        // 모든 바이러스 시작점 큐에 추가
        for (int[] v : viruses) {
            q.add(new int[]{v[0], v[1]});
            vis[v[0]][v[1]] = true;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M)
                    continue;
                if (vis[ny][nx])
                    continue;
                if (g[ny][nx] != 0)
                    continue; // 벽(1)이나 바이러스(2)는 못감
                g[ny][nx] = 2; // 감염
                vis[ny][nx] = true;
                q.add(new int[]{ny, nx});
            }
        }
    }

    static int countSafe(int[][] g) {
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (g[i][j] == 0) cnt++;
        return cnt;
    }
}
