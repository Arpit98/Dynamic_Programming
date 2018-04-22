import java.util.Scanner;

public class knapsack {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int weight = in.nextInt();
        int[] W = new int[n];
        int[] V = new int[n];

        for(int i = 0; i < n; i++){
            W[i] = in.nextInt();
            V[i] = in.nextInt();
        }

        int[][] DP = new int[n+1][weight+1];

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < weight+1; j++){
                if(j-W[i-1] > -1){
                    DP[i][j] = Math.max(V[i-1] + DP[i-1][j-W[i-1]],DP[i-1][j]);
                }else{
                    DP[i][j] = DP[i-1][j];
                }
            }
        }

        System.out.println(DP[n][weight]);
    }
}
