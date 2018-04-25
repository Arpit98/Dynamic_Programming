import java.util.Scanner;

public class LongestPalindromicSubsequence {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(in.nextLine());
        int len = sb.length();
        int[][] DP = new int[len][len];

        int i,j;
        for(int k = 0; k < len; k++){
            i = 0;
            for(j = k; j < len; j++,i++){
                if(i == j){
                    DP[i][j] = 1;
                }else{
                    /*if(i+1 == j){
                        if(sb.charAt(i) == sb.charAt(j)){
                            DP[i][j] = 2;
                        }else{
                            DP[i][j] = 1;
                        }
                    }else{
                        if(sb.charAt(i) == sb.charAt(j)){
                            DP[i][j] = 2 + DP[i+1][j-1];
                        }else{
                            DP[i][j] = Math.max(DP[i][j-1],DP[i+1][j]);
                        }
                    }*/
                    if(sb.charAt(i) == sb.charAt(j) && i+1 == j){
                        DP[i][j] = 2;
                    }else if(sb.charAt(i) == sb.charAt(j)){
                        DP[i][j] = 2 + DP[i+1][j-1];
                    }else{
                        DP[i][j] = Math.max(DP[i][j-1],DP[i+1][j]);
                    }
                }
            }
        }

        System.out.println(DP[0][len-1]);
    }
}
