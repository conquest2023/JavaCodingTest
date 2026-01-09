package datasturcture.list;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 나는야포켓몬마스터이다솜 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String,String> map=new HashMap<>();
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= a; i++) {
            String s = sc.nextLine();
            map.put(s,String.valueOf(i));
        }
        for (int i = 0; i < b; i++) {
            String sb = sc.nextLine();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey().equals(sb)){
                    System.out.println(entry.getValue());
                    break;
                }if (entry.getValue().equals(sb)){
                    System.out.println(entry.getKey());
                    break;
                }
            }
//            import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.StringTokenizer;
//
//            public class Main {
//
//                public static void main(String[] args) throws IOException {
//                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//                    StringTokenizer st = new StringTokenizer(br.readLine());
//                    int N = Integer.parseInt(st.nextToken());
//                    int M = Integer.parseInt(st.nextToken());
//                    StringBuilder sb = new StringBuilder();
//                    //조건에 따라 다르게 쓰일 두개의 HashMap
//                    HashMap<Integer, String> hash1 = new HashMap<Integer, String>();
//                    HashMap<String, Integer> hash2 = new HashMap<String, Integer>();
//
//
//                    for(int i = 1; i <= N; i++) {
//                        String S = br.readLine();
//                        hash1.put(i, S);
//                        hash2.put(S, i);
//                    }
//
//                    for(int i = 0; i < M; i++) {
//                        String S = br.readLine();
//                        //입력값이 번호인지 포켓몬이름인지 판별
//                        if(49 <= S.charAt(0) && S.charAt(0) <= 57) {
//                            sb.append(hash1.get(Integer.parseInt(S))).append("\n");
//                        }else {
//                            sb.append(hash2.get(S)).append("\n");
//                        }
//                    }
//                    System.out.println(sb);
//                }
//
//            }
        }




    }
}
