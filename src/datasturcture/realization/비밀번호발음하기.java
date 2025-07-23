package datasturcture.realization;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 비밀번호발음하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int idx1 = 0;
            int idx2 = 0;
            boolean result = false;
            StringBuilder s=new StringBuilder();
            String split = sc.nextLine();
            if (split.equals("end")){
                return;
            }
            for (int i = 0; i < split.length(); i++) {

                if (split.charAt(i) == 'a' || split.charAt(i) == 'e' || split.charAt(i) == 'i' || split.charAt(i) == 'o' || split.charAt(i) == 'u') {
                    result = true;
                    idx1 += 1;
                    idx2 = 0;
                    s.append(split.charAt(i));
                    if (s.length()==2) {
                        if ((s.toString().equals("ee") || s.toString().equals("oo"))) {
                            continue;
                        } else {
                            result = false;
                            break;
                        }
                    }
                }else {
                    idx2+=1;
                    idx1=0;

                }
                if(idx2==3 || idx1==3){
                    result=false;
                    break;
                }
            }
            if (!result) {
                System.out.println("<" + split + "> "+"is not acceptable.");
            }else {
                System.out.println("<" + split + "> "+"is acceptable.");
            }
        }
    }
}
