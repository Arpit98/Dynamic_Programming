import java.util.Scanner;

//Not Working..
public class WayCoinChange {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        int noOfCoins = in.nextInt();
        int[] coinvalue = new int[noOfCoins];

        for(int i = 0; i < noOfCoins; i++){
            coinvalue[i] = in.nextInt();
        }

        int[][] DP = new int[noOfCoins][total+1];
        for(int j = 0; j < total+1; j++){
            DP[0][j] = 1;
        }
        for(int i = 0; i < noOfCoins; i++){
            DP[i][0] = 1;
        }

        for(int i = 1; i < noOfCoins; i++){
            for(int j = 1; j < total+1; j++){
                if(j-coinvalue[i] > -1){
                    DP[i][j] = DP[i-1][j] + DP[i][j-coinvalue[i]];
                }else{
                    DP[i][j] = DP[i-1][j];
                }
            }
        }

        System.out.println(DP[noOfCoins-1][total]);

    }
}
