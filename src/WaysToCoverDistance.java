import java.util.Scanner;

public class WaysToCoverDistance {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ways = -1;
        if(n == 0){
            ways = 1;
        }
        if(n == 1){
            ways = 1;
        }
        if(n == 2){
            ways = 2;
        }

        if(ways == -1){
            int[] DP = new int[n+1];
            DP[0] = DP[1] = 1; DP[2] = 2;
            for(int i = 3; i < n+1; i++){
                DP[i] = DP[i-1] + DP[i-2] + DP[i-3];
            }
            ways = DP[n];
        }
        System.out.println(ways);
    }
}
