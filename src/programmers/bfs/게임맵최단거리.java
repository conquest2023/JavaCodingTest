package programmers.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class 게임맵최단거리 {


    static boolean[][] visited;
    static int[][] arr;

    static int count;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        int[][] map = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };
        int solution = solution(new int[][]
                {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}
        );
        System.out.println(solution);

    }


    public static int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});



        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                // 1. 범위를 벗어나면 패스
                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;

                // 2. 벽(0)이거나 이미 방문(1보다 큰 값)했다면 패스
                if (maps[ny][nx] == 0 || maps[ny][nx] > 1)
                    continue;

                // 처음 방문하는 길인 경우 (maps[ny][nx] == 1)
                if (maps[ny][nx] == 1) {
                    // 이전 칸의 거리 + 1을 현재 칸에 저장!
                    maps[ny][nx] = maps[y][x] + 1;
                    queue.add(new int[]{ny, nx});
                }
            }
        }

        // 도착지의 값이 1이면 도달 못한 것 (처음 길 그대로니까)
        int answer = maps[n - 1][m - 1];
        return (answer == 1) ? -1 : answer;
    }
}