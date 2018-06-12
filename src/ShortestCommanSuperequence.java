import java.util.Scanner;

public class ShortestCommanSuperequence {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();

        int len1 = str1.length() + 1;
        int len2 = str2.length() + 1;

        int[][] DP = new int[len1][len2];

        for(int i = 0; i < len1; i++){
            DP[i][0] = i;
        }
        for(int j = 0; j < len2; j++){
            DP[0][j] = j;
        }

        for(int i = 1; i < len1; i++){
            for(int j = 1; j < len2; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    DP[i][j] = DP[i-1][j-1] + 1;
                }else{
                    DP[i][j] = Math.min(DP[i-1][j],DP[i][j-1]) + 1;
                }
            }
        }

        System.out.println(DP[len1-1][len2-1]);
    }
}
