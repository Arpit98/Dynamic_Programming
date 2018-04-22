import java.util.Scanner;

public class LCS {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb1 = new StringBuilder(in.nextLine());
        StringBuilder sb2 = new StringBuilder(in.nextLine());
        int len1 = sb1.length();
        int len2 = sb2.length();
        int[][] DP = new int[len1+1][len2+1];

        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(sb1.charAt(i) == sb2.charAt(j)){
                    DP[i+1][j+1] = DP[i][j] + 1;
                }else{
                    DP[i+1][j+1] = Math.max(DP[i][j+1],DP[i+1][j]);
                }
            }
        }

        System.out.println(DP[len1][len2]);

    }
}
