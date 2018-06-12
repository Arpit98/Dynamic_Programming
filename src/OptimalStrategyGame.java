import java.util.Scanner;

public class OptimalStrategyGame {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] values = new int[n];
        int[][] DP = new int[n][n];

        for(int i = 0; i < n; i++){
            values[i] = in.nextInt();
        }

        int x,y,z;
        for(int gap = 0; gap < n; gap++){
            for(int i = 0,j = gap; j < n; i++,j++){

                x = i+2 > j ? 0 : DP[i+2][j];
                y = i+1 > j-1 ? 0 : DP[i+1][j-1];
                z = i > j-2 ? 0 : DP[i][j-2];

                DP[i][j] = Math.max(values[i]+Math.min(x,y), values[j]+Math.min(y,z));
            }
        }

        System.out.println(DP[0][n-1]);
    }
}
