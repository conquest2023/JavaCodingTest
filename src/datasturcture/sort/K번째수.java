package datasturcture.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class K번째수 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) - 1;

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quickSelect(0, n - 1, k);
        System.out.println(arr[k]);
    }

    private static void quickSelect(int left, int right, int k) {
        if (left >= right)
            return;

        int pivot = partition(left, right);
        if (pivot == k)
            return;
        else if (pivot > k)
            quickSelect(left, pivot - 1, k);
        else quickSelect(pivot + 1, right, k);
    }

    private static int partition(int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot)
                swap(++i, j);
        }

        swap(i + 1, right);
        return i + 1;
    }

    private static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
