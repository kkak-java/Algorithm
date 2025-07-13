package week02.Unoguna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2206 {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        // 1 <= N,M <= 1,000
        int[][] matrix = new int[N][M];
        int [][][] count = new int [2][N][M];

        for(int n=0; n<N; n++){
            String input = br.readLine();
            for(int m=0; m<M; m++){
                matrix[n][m] = input.charAt(m) - '0';
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,0});
        count[0][0][0] = 1;
        matrix[0][0] = 0;

        if(N == 1 && M == 1){
            System.out.println(1);
            return;
        }

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            int curr_y = curr[0];
            int curr_x = curr[1];
            int isCrash = curr[2];

            int curr_count = count[isCrash][curr_y][curr_x];

            for(int d=0; d<4; d++){
                int next_y = curr_y + dy[d];
                int next_x = curr_x + dx[d];

                if(next_y < 0 || next_y >= N || next_x < 0 || next_x >= M) {
                    continue;
                }

                if(matrix[next_y][next_x] == 0){
                    if(count[isCrash][next_y][next_x] == 0){
                        queue.add(new int[]{next_y, next_x, isCrash});
                        count[isCrash][next_y][next_x] = curr_count + 1;
                        if(next_y == N - 1 && next_x == M - 1){
                            System.out.println(count[isCrash][next_y][next_x]);
                            return;
                        }
                    }
                }
                else{
                    if(isCrash == 0){
                        if(count[1][next_y][next_x] == 0){
                            queue.add(new int[] {next_y, next_x, 1});
                            count[1][next_y][next_x] = curr_count + 1;
                            if(next_y == N - 1 && next_x == M - 1){
                                System.out.println(count[1][next_y][next_x]);
                                return;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(-1);
        return;
    }
}
