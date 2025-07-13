package week02.Unoguna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_7569 {

    static class Location{
        int h;
        int n;
        int m;

        int time;

        Location(int h, int n, int m, int time){
            this.h = h;
            this.n = n;
            this.m = m;

            this.time = time;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] MNH = (br.readLine()).split(" ");

        //2 <= M <= 100, 2 <= N <= 100, 1 <= H <= 100
        int M = Integer.parseInt(MNH[0]);
        int N = Integer.parseInt(MNH[1]);
        int H = Integer.parseInt(MNH[2]);

        int[][][] box = new int[H][N][M];

        int[] dh = {0,0,0,0,1,-1};
        int[] dn = {0,0,1,-1,0,0};
        int[] dm = {1,-1,0,0,0,0};

        //박스가 익은 토마토로 다 찼는지 확인하기 위한 변수
        int count = 0;

        Queue<Location> queue = new LinkedList<>();

        for(int h=0; h<H; h++){
            for(int n=0; n<N; n++){
                String[] str = br.readLine().split(" ");
                for(int m=0; m<M; m++){
                    box[h][n][m] = Integer.parseInt(str[m]);

                    //익은 토마토 or 빈 공간은 count + 1을 실행
                    if(box[h][n][m] == 1){
                        count++;
                        queue.add(new Location(h, n, m, 0));
                    }
                    else if(box[h][n][m] == -1) count++;
                }
            }
        }


        int output = 0;
        //bfs
        while(!queue.isEmpty()){
            Location curr = queue.poll();
            int curr_h = curr.h;
            int curr_n = curr.n;
            int curr_m = curr.m;

            int curr_time = curr.time;

            output = Math.max(output, curr_time);

            for(int d=0; d<6; d++){
                int next_h = curr_h + dh[d];
                int next_n = curr_n + dn[d];
                int next_m = curr_m + dm[d];

                if(next_h >= 0 && next_h < H && next_n >= 0 && next_n < N && next_m >= 0 && next_m < M){
                    if(box[next_h][next_n][next_m] == 0){
                        count++;
                        queue.add(new Location(next_h, next_n, next_m, curr_time + 1));
                        box[next_h][next_n][next_m] = 1;
                    }
                }
            }
        }

        if(count != H * N * M) output = -1;

        System.out.println(output);

        br.close();
    }
}
