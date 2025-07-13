package week01.Unoguna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20304 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 1<= N <= 1,000,000
        int N = Integer.parseInt(br.readLine());

        // 1<=M <= 100,000
        int M = Integer.parseInt(br.readLine());
        int[] passwords = new int[M];
        String[] input = new String[M];

        input = br.readLine().split(" ");

        for(int i=0; i< M; i++){
            passwords[i] = Integer.parseInt(input[i]);
        }




    }
}
