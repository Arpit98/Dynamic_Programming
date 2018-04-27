import java.util.Scanner;

public class LongestCommonSubstring {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb1 = new StringBuilder(in.nextLine());
        StringBuilder sb2 = new StringBuilder(in.nextLine());
        int len1 = sb1.length();
        int len2 = sb2.length();

        int[][] DP = new int[len1][len2];
        for(int i = 0; i < len1; i++){
            if(sb1.charAt(i) == sb2.charAt(0)){
                DP[i][0] = 1;
            }
        }
        for(int j = 0; j < len2; j++){
            if(sb1.charAt(0) == sb2.charAt(j)){
                DP[0][j] = 1;
            }
        }

        for(int i = 1; i < len1; i++){
            for(int j = 1; j < len2; j++){
                if(sb1.charAt(i) == sb2.charAt(j)){
                    DP[i][j] = 1 + DP[i-1][j-1];
                }else{
                    DP[i][j] = 0;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(DP[i][j] > max){
                    max = DP[i][j];
                }
            }
        }

        System.out.println(max);
    }
}
