package programmers;

public class 자릿수더하기 {

    public static void main(String[] args) {

        int solution = solution(123);
        System.out.println(solution);
    }


    static int solution(int n) {
        int answer = 0;
        String num=String.valueOf(n);
        int length = num.length();
        int idx=1;
        for (int i = 0; i < length-1; i++) {
            idx*=10;
        }
        while (idx>0){
            answer+=n/idx;
            n%=idx;
            idx/=10;
        }
        return answer;
    }

//    while (n > 0) {
//        answer += n % 10; // 가장 오른쪽에 있는 숫자를 더함
//        n /= 10;          // 가장 오른쪽 숫자를 제거
//    }
}
