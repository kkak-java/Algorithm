package week03.Unoguna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2240 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] TW = (br.readLine()).split(" ");
        int T = Integer.parseInt(TW[0]);
        int W = Integer.parseInt(TW[1]);

        //dp[w][t]에는 자두가 t번 떨어지는 동안 w번 위치를 바꿨을 때 얻을 수 있는 자두의 최대 개수.
        int[][] dp = new int[W + 1][T + 1];

        //t=0인 경우 자두가 한번도 떨어지지 않았기 때문에 + index가 -1이 되기 때문에 고려X
        for(int t = 1; t <= T; t++){
            int drop_idx = Integer.parseInt(br.readLine());

            //w=0인 경우는 index가 -1이 될 수 있기 때문에 따로 계산
            if(drop_idx == 1) dp[0][t] = dp[0][t - 1] + 1;  //1번 나무에 자두가 떨어짐
            else dp[0][t] = dp[0][t-1]; //2번 나무에 자두가 떨어짐

            //자두가 t번 떨어졌을 때 자두는 최대 min(t, W)번 움직일 수 있다.
            int max_w=Math.min(t, W);
            for(int w = 1; w <= max_w; w++){
                //점화식
                if(drop_idx == 1){  //1번 나무에 자두가 떨어짐
                    if(w%2 == 0){   //자두의 현재 위치에 자두가 떨어질 때
                        dp[w][t] = Math.max(dp[w][t-1], dp[w-1][t-1]) + 1;
                    }
                    else{   //현재 위치에 자두가 떨어지지 않았을 때
                        dp[w][t] = Math.max(dp[w][t-1], dp[w-1][t-1]);
                    }
                }
                else{   //2번 나무에 자두가 떨어짐
                    if(w%2 == 1){   //자두의 현재 위치에 자두가 떨어질 때
                        dp[w][t] = Math.max(dp[w][t-1], dp[w-1][t-1]) + 1;
                    }
                    else{   //현재 위치에 자두가 떨어지지 않았을 때
                        dp[w][t] = Math.max(dp[w][t-1], dp[w-1][t-1]);
                    }
                }
            }
        }

        //자두가 다 떨어졌을 때 얻을 수 있는 자두의 최대 개수 계산
        int answer = 0;
        for(int w=0; w<W+1; w++){
            answer = Math.max(answer, dp[w][T]);
        }

        System.out.println(answer);
    }
}
