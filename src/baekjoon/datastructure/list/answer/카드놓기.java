package baekjoon.list.answer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 카드놓기 {

        static int N,k,arr[];
        static HashSet<String> card = new HashSet<>();
        static boolean visit[];
        public static void main(String[] args)throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N=4;
            k=2;
            arr=new int[N];
            visit=new boolean[N];

            arr[0]=1;
            arr[1]=2;
            arr[2]=12;
            arr[3]=1;

            back(0,"");
            System.out.println(card.size());

        }

        public static void back(int depth, String a){
            if(depth==k){
                card.add(a);
                return;
            }

            for(int i=0; i<N; i++){
                if(!visit[i]){
                    visit[i]=true;
                    back(depth+1,a+arr[i]);
                    visit[i]=false;
                }
            }
        }
    }

