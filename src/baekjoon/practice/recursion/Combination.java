package datasturcture.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    static int n = 5, k = 3;
    static int[] a = {1, 2, 3, 4, 5}; // 값 배열 (원하면 수정)

    public static void main(String[] args) {
        List<Integer> b = new ArrayList<>();
        combi(-1, b);  // C++의 combi(-1, b)와 동일
    }

    // 조합 생성: start 이후의 인덱스들에서 선택
    static void combi(int start, List<Integer> b) {
        if (b.size() == k) {
            // 원하는 출력 방식 선택!
            printValues(b);  // a[인덱스] 값 출력
            // printIndices(b); // 인덱스 자체 출력 (원하면 이 줄로 바꿔)
            return;
        }
        for (int i = start + 1; i < n; i++) {
            b.add(i);
            combi(i, b);
            b.remove(b.size() - 1);
        }
    }

    // 인덱스 출력 (C++ 원본의 print와 동일 의미)
    static void printIndices(List<Integer> b) {
        for (int idx : b) System.out.print(idx + " ");
        System.out.println();
    }

    // 값 출력 (a[idx])
    static void printValues(List<Integer> b) {
        for (int idx : b) System.out.print(a[idx] + " ");
        System.out.println();
    }
}
