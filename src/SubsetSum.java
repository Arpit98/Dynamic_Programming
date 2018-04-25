import java.util.Scanner;

public class SubsetSum {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        int size = in.nextInt();
        int[] set = new int[size];

        for(int i = 0; i < size; i++){
            set[i] = in.nextInt();
        }

        boolean[][] DP = new boolean[size][sum+1];
        for(int i = 0; i < size; i++){
            DP[i][0] = true;
        }
        if(set[0] < sum+1){
            DP[0][set[0]] = true;
        }

        for(int i = 1; i < size; i++){
            for(int j = 1; j < sum+1; j++){
                if(j-set[i] > -1){
                    DP[i][j] = DP[i-1][j] || DP[i-1][j-set[i]];
                }else{
                    DP[i][j] = DP[i-1][j];
                }
            }
        }

        if(DP[size-1][sum]){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
