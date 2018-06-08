import java.util.Scanner;

public class Partition {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] set = new int[n];

        int sum = 0;
        for(int i = 0; i < n; i++){
            set[i] = in.nextInt();
            sum = sum + set[i];
        }
        if(sum % 2 != 0){
            System.out.println("false");
            return;
        }

        boolean[][] DP = new boolean[n][(sum/2)+1];
        
        DP[0][set[0]] = true;
        for(int i = 0; i < n; i++){
            DP[i][0] = true;
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < (sum/2)+1; j++){
                if(j < set[i]){
                    DP[i][j] = DP[i-1][j];
                }else{
                    DP[i][j] = DP[i-1][j] || DP[i-1][j-set[i]];
                }
            }
        }

        if(DP[n-1][sum/2]){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

        /*for(boolean[] row : DP){
            for(boolean col : row){
                System.out.print(col+" ");
            }
            System.out.println();
        }*/
    }
}
