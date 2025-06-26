package datasturcture.list;

import java.util.*;

public class 풍선터뜨리기 {

    public static void main(String[] args) {

        Deque<int[]> q = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);

        int num = Integer.valueOf(sc.nextLine());
        int[] arr =new int[num];
        String[] s = sc.nextLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            arr[i]=Integer.valueOf(s[i]);
        }
        StringBuilder sb=new StringBuilder();
        sb.append("1 ");
        int in=arr[0];
        for (int i = 1; i < num; i++) {
            q.add(new int[] { (i+1) ,arr[i]});
        }
        while (!q.isEmpty()) {
            if (in > 0) {
                for (int i = 1; i < in; i++) {
                    q.add(q.poll());
                 }
                 int[] nxt= q.poll();
                 in =nxt[1];
                 sb.append(nxt[0]+" ");
                }
                else  {
                    for (int i = 1; i < -in; i++) {
                        q.addFirst(q.pollLast());
                    }
                    int[] nxt= q.pollLast();
                    in = nxt[1];
                    sb.append(nxt[0]+ " ");
                }

        }
        System.out.println(sb);

    }

}


//        Deque<Integer> deque = new ArrayDeque<>();
//        Scanner sc = new Scanner(System.in);
//
//        int num = Integer.valueOf(sc.nextLine());
//        int[] arr =new int[num];
//        String[] s = sc.nextLine().split(" ");
//        for (int i = 0; i < s.length; i++) {
//            arr[i]=Integer.valueOf(s[i]);
//        }
//
//        List<Integer> list = new ArrayList<>();
//        int start=1;
//        list.add(1);
//        while (deque.size() != 0) {
//            int initial = deque.poll();
//            if (initial > 0) {
//                int index = 0;
//                while (index <= initial) {
//                    if (index == initial) {
//                        list.add(++start);
//                        deque.poll();
//                        break;
//                    }
//                    deque.addFirst(deque.poll());
//                    index++;
//                }
//                if (initial < 0) {
//                    int index2 = 0;
//                    while (index2 <= initial) {
//                        if (index2 == initial) {
//                            list.add(start++);
//                            deque.poll();
//                            break;
//                        }
//                        int number = deque.pop();
//                        deque.add(number);
//                        index2--;
//                    }
//
//                }
//            }
//        }
//        System.out.println(list);
//    }
