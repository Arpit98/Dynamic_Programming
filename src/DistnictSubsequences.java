import java.util.Scanner;

public class DistnictSubsequences {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String t = in.nextLine();
        int slen = s.length();
        int tlen = t.length();

        if(tlen == 0) {
            System.out.println("1");
            return;
        }

        if(slen == 0) {
            System.out.println("0");
            return;
        }

        if(tlen > slen) {
            System.out.println("0");
            return;
        }

        int count,temp;
        int[] DP = new int[slen];

        for(int j = 0; j < slen; j++){
            if(t.charAt(0) == s.charAt(j)){
                DP[j] = 1;
            }else{
                DP[j] = 0;
            }
        }

        for(int i = 1; i < tlen; i++){
            count = 0;
            for(int j = 0; j < slen; j++){
                temp = DP[j];
                if(t.charAt(i) == s.charAt(j)){
                    DP[j] = count;
                }else{
                    DP[j] = 0;
                }
                count = count + temp;
            }
        }

        int dsub = 0;
        for(int j = 0; j < slen; j++){
            dsub = dsub + DP[j];
        }
        System.out.println(dsub);
    }
}
