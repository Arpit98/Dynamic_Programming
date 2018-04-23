import java.util.Scanner;

public class MinCoinChange {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        int noOfCoins = in.nextInt();
        int[] coinsvalue = new int[noOfCoins];

        for(int i = 0; i < noOfCoins; i++){
            coinsvalue[i] = in.nextInt();
        }

        int[] DP = new int[total+1];
        int[] cointrack = new int[total+1];

        DP[0] = 0;
        cointrack[0] = -1;
        for(int i = 1; i < total+1; i++){
            DP[i] = Integer.MAX_VALUE;
            cointrack[i] = -1;
        }

        for(int i = 0; i < noOfCoins; i++){
            for(int j = 1; j < total+1; j++){
                if(j-coinsvalue[i] > -1 && DP[j-coinsvalue[i]] != Integer.MAX_VALUE){
                    if(DP[j] > 1+DP[j-coinsvalue[i]]){
                        DP[j] = 1+DP[j-coinsvalue[i]];
                        cointrack[j] = i;
                    }
                }
            }
        }

        System.out.println(DP[total]);

        int index = total;
        while(cointrack[index] != -1){
            System.out.print(coinsvalue[cointrack[index]]+" ");
            index = index - coinsvalue[cointrack[index]];
        }
    }
}
