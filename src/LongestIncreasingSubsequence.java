import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args){
        //O(N2)
        /*Scanner in = new Scanner(System.in);
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

        System.out.println(max);*/

        //O(NlogN)
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];

        for(int i = 0; i < n; i++){
            A[i] = in.nextInt();
        }

        int len = 1;
        int[] tail = new int[n];
        tail[0] = A[0];

        for(int i = 1; i < n; i++){
            if(A[i] < tail[0]){
                tail[0] = A[i];
            }else if(A[i] > tail[len-1]){
                tail[len++] = A[i];
            }else{
                tail[index(tail,-1,len-1,A[i])] = A[i];
            }
        }
        System.out.println(len);
    }

    private static int index(int[] X, int l, int r, int key){
        int m;
        while(r - l > 1){
            m = l + (r - l)/2;
            if(key > X[m]){
                l = m;
            }else{
                r = m;
            }
        }
        return r;
    }
}
