import java.util.Scanner;

public class CuttingRod {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int lengthOfRod = in.nextInt();
        int[] prices = new int[lengthOfRod+1];
        int[] DP = new int[lengthOfRod+1];

        for(int i = 1; i < lengthOfRod; i++){
            prices[i] = DP[i] = in.nextInt();
        }

        for(int i = 1; i < lengthOfRod+1; i++){
            for(int j = 1; j < i; j++){
                DP[i] = Math.max(DP[i],prices[j] + DP[i-j]);
            }
        }

        System.out.println(DP[lengthOfRod]);
    }
}
