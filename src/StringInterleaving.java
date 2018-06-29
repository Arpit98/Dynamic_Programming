import java.util.Scanner;

public class StringInterleaving {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        String s3 = in.nextLine();

        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if(len1+len2 != len3){
            System.out.println("Not Possible");
            return;
        }
        if(len1 == 0){
            if(s2.equals(s3)){
                System.out.println("Possible");
                return;
            }
        }
        if(len2 == 0){
            if(s1.equals(s3)){
                System.out.println("Possible");
                return;
            }
        }

        boolean[] DP = new boolean[len2+1];

        for(int i = 0; i < len1+1; i++){
            for(int j = 0; j < len2+1; j++){
                if(i == 0 && j == 0){
                    DP[j] = true;
                }else if(i == 0){
                    if(s2.charAt(j-1) == s3.charAt(j-1))    DP[j] = DP[j-1];
                }else if(j == 0){
                    if(s1.charAt(i-1) != s3.charAt(i-1))    DP[j] = false;
                }else if((s1.charAt(i-1) == s3.charAt(i+j-1)) && (s2.charAt(j-1) == s3.charAt(i+j-1))){
                    DP[j] = DP[j] || DP[j-1];
                }else if(s2.charAt(j-1) == s3.charAt(i+j-1)){
                    DP[j] = DP[j-1];
                }else if(s1.charAt(i-1) != s3.charAt(i+j-1)){
                    DP[j] = false;
                }
            }
        }
        if(DP[len2]){
            System.out.println("Possible");
            return;
        }
        System.out.println("Not Possible");
    }
}
