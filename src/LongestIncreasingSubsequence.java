import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        int[] DP = new int[n];

        for(int i = 0; i < n; i++){
            A[i] = in.nextInt();
        }

        for(int i = 0; i < n; i++){
            DP[i] = 1;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(A[j] < A[i]){
                    DP[i] = Math.max(DP[i],1+DP[j]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(DP[i] > max){
                max = DP[i];
            }
        }

        System.out.println(max);
    }
}
