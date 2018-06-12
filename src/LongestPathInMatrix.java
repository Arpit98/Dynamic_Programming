import java.util.Scanner;

public class LongestPathInMatrix {
    private static int n;
    private static int[][] mat;
    private static int[][] DP;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        mat = new int[n][n];
        DP = new int[n][n];
        int longestPath = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                mat[i][j] = in.nextInt();
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                DP[i][j] = findLongestPath(i,j);
                if(DP[i][j] > longestPath){
                    longestPath = DP[i][j];
                }
            }
        }
        System.out.println(longestPath);
    }

    private static int findLongestPath(int x, int y){
        if(DP[x][y] != 0){
            return DP[x][y];
        }

        if(x+1 < n && mat[x][y]+1 == mat[x+1][y]){
            return DP[x][y] = 1 + findLongestPath(x+1,y);
        }
        if(x-1 > -1 && mat[x][y]+1 == mat[x-1][y]){
            return DP[x][y] = 1 + findLongestPath(x-1,y);
        }
        if(y+1 < n && mat[x][y]+1 == mat[x][y+1]){
            return DP[x][y] = 1 + findLongestPath(x,y+1);
        }
        if(y-1 > -1 && mat[x][y]+1 == mat[x][y-1]){
            return DP[x][y] = 1 + findLongestPath(x,y-1);
        }

        return DP[x][y] = 1;
    }
}
