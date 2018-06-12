import java.util.Scanner;

public class MatrixChainMultiplication {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int noOfMatrix = in.nextInt();
        int[] sizes = new int[noOfMatrix+1];
        sizes = input1DArray(sizes,noOfMatrix+1,in);
        int[][] DP = new int[noOfMatrix][noOfMatrix];

        for(int i = 0; i < noOfMatrix; i++){
            DP[i][i] = 0;
        }

        for(int gap = 1; gap < noOfMatrix; gap++){
            for(int i = 0,j = gap; j < noOfMatrix; i++,j++){
                DP[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    DP[i][j] = Math.min(DP[i][j],DP[i][k]+DP[k+1][j]+sizes[i]*sizes[k+1]*sizes[j+1]);
                }
            }
        }
        print2DArray(DP);
        System.out.println(DP[0][noOfMatrix-1]);
    }

    //Take Input in 1D Array
    private static int[] input1DArray(int[] array1D, int length, Scanner in){
        for(int i = 0; i < length; i++){
            array1D[i] = in.nextInt();
        }
        return array1D;
    }

    //print 1D Array
    private static void print1DArray(int[] array1D){
        for(int x : array1D){
            System.out.print(x+" ");
        }
    }

    //Take Input in 2D Array
    private static int[][] input2DArray(int[][] array2D, int rowLength, int colLength, Scanner in){
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                array2D[i][j] = in.nextInt();
            }
        }
        return array2D;
    }

    //print 2D Array
    private static void print2DArray(int[][] array2D){
        for(int[] row: array2D){
            for(int col: row){
                System.out.print(col+"\t");
            }
            System.out.println();
        }
    }
}



