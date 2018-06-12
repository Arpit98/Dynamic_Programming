import java.util.Scanner;

public class MaximalProductCuttingRope {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n == 2 || n == 3){
            System.out.println(n-1);
            return;
        }

        int[] DP = new int[n+1];
        DP[0] = DP[1] = 0;
        DP[2] = 2;
        DP[3] = 3;
        for(int i = 4; i < n+1; i++){
            for(int j = 2; j <= (i/2); j++){
                DP[i] = Math.max(DP[i],DP[j]*DP[i-j]);
            }
        }
        System.out.println(DP[n]);
    }
}
