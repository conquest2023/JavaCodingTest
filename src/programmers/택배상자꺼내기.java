package programmers;

public class 택배상자꺼내기 {

    public static void main(String[] args) {
        int n=2;
        int w=1;
        int num=1;
        int answer = 0;
        if(n%w!=0){
            answer = n / w + 1;
        }else {
            answer=n/w;
        }
        int start=1;
        if (num<=w){
            System.out.println(answer);
            return;
        }
        System.out.println(answer);
        while (true){
            if (num<start+w &&start<=num ){
                System.out.println(answer);
                break;
            }
            start+=w;
            answer--;

        }
    }

}
