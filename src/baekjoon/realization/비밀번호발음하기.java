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
            StringBuilder s1=new StringBuilder();
            StringBuilder s2=new StringBuilder();

            String split = sc.nextLine();
            if (split.equals("end")){
                return;
            }
            for (int i = 0; i < split.length(); i++) {
                if (split.charAt(i) == 'a' || split.charAt(i) == 'e' || split.charAt(i) == 'i' || split.charAt(i) == 'o' || split.charAt(i) == 'u') {
                    result = true;
                    idx1 += 1;
                    idx2 = 0;
                    s1.append(split.charAt(i));
                    s2=new StringBuilder();

                    if (s1.length()==2) {
                        if (!(s1.toString().equals("ee") || s1.toString().equals("oo"))) {
                           if(s1.charAt(0)==s1.charAt(1)) {
                               result = false;
                               break;
                           }
                        }
                        s1= new StringBuilder();
                    }
                }else {
                    s2.append(split.charAt(i));
                    s1=new StringBuilder();
                    idx2+=1;
                    idx1=0;
                    if (s2.length()==2) {
                        if (!(s2.toString().equals("ee") || s2.toString().equals("oo"))) {
                            if (s2.charAt(0) == s2.charAt(1)) {
                                result = false;
                                break;
                            }
                        }
                        s2= new StringBuilder();

                    }
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
