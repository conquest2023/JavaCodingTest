package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 수열과쿼리 {


    public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringBuilder sb = new StringBuilder();

                int m = Integer.parseInt(br.readLine());

                long sumResult = 0;
                int xorResult = 0;

                for (int i = 0; i < m; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    int type = Integer.parseInt(st.nextToken());

                    if (type == 1) {
                        int x = Integer.parseInt(st.nextToken());
                        sumResult += x;
                        xorResult ^= x;
                    } else if (type == 2) {
                        int x = Integer.parseInt(st.nextToken());
                        sumResult -= x;
                        xorResult ^= x;
                    } else if (type == 3) {
                        sb.append(sumResult).append("\n");
                    } else if (type == 4) {
                        sb.append(xorResult).append("\n");
                    }
                }
                System.out.print(sb);
        }
   }
