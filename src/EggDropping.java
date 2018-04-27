import java.util.Scanner;

public class EggDropping {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int noOfFloors = in.nextInt() + 1;
        int noOfEggs = in.nextInt() + 1;

        int[][] DP = new int[noOfEggs][noOfFloors];
        for(int i = 1; i < noOfEggs; i++){
            DP[i][1] = 1;
            DP[i][0] = 0;
        }
        for(int j = 1; j < noOfFloors; j++){
            DP[1][j] = j;
        }

        int temp;
        for(int i = 2; i < noOfEggs; i++){
            for(int j = 2; j < noOfFloors; j++){
                DP[i][j] = Integer.MAX_VALUE;
                for(int k = 1; k <= j; k++){
                    temp = 1 + Math.max(DP[i-1][k-1],DP[i][j-k]);
                    if(temp < DP[i][j]){
                        DP[i][j] = temp;
                    }
                }
            }
        }
        System.out.println(DP[noOfEggs-1][noOfFloors-1]);
    }
}
