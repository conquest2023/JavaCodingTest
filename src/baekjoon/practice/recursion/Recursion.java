package datasturcture.practice.recursion;

public class Recursion {

    static int[] a = {1, 2, 3}; // 여기 바꿔서 원소 수정
    static int n = a.length;
    static int r = 3;           // r을 바꿔가며 연습 (0 <= r <= n)

    static void print() {
        for (int i = 0; i < r; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    static void swap(int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    static void makePermutation(int n, int r, int depth) {
        if (r == depth) {
            print();
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(i, depth);
            makePermutation(n, r, depth + 1);
            swap(i, depth); // 원상복구
        }
    }

    public static void main(String[] args) {
        makePermutation(n, r, 0);
    }

}
