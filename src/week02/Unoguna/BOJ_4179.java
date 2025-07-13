package week02.Unoguna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_4179 {

    static class Location {
        int x;
        int y;
        boolean fire;

        Location(int y, int x, boolean fire){
            this.y = y;
            this.x = x;
            this.fire = fire;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int MAX = 10000000;

        String[] str = br.readLine().split(" ");
        Queue<Location> queue = new LinkedList<>();

        //1 <= x,y <= 1000
        int Y = Integer.parseInt(str[0]);
        int X = Integer.parseInt(str[1]);

        int start_x = 0;
        int start_y = 0;

        //해당 칸에 최초로 불 또는 사람이 오는 시간을 넣음
        int[][] matrix = new int[Y][X];

        for(int i=0; i<Y; i++){
            String s = br.readLine();

            for(int j=0; j<X; j++){
                char ch = s.charAt(j);
                matrix[i][j] = MAX;   //기본적으로 각 칸에는 최대값을 넣어줌

                //해당 칸이 벽일 경우 -1, 사람의 시작점, 불의 시작점일 경우 0을 넣어서 시작.
                if(ch == '#') matrix[i][j] = -1;
                else if(ch == 'F'){
                    //불의 위치를 큐에 먼저 넣음
                    queue.add(new Location(i, j, true));
                    matrix[i][j] = 0;
                }
                else if(ch == 'J'){
                    start_y = i;
                    start_x = j;
                    matrix[i][j] = 0;
                }
            }
        }
        //사람의 위치는 불의 위치를 다 넣은 후 넣음 (이제 불이 붙으려는 칸으로 이동할 수 없기 때문에)
        queue.add(new Location(start_y, start_x, false));

        //탈출하기 위한 최소 시간
        int answer = 0;

        //BFS
        while(!queue.isEmpty()){
            Location l = queue.poll();
            int curr_y = l.y;
            int curr_x = l.x;
            boolean fire = l.fire;

            for(int d=0; d<4; d++){
                int next_y = curr_y + dy[d];
                int next_x = curr_x + dx[d];

                //matrix를 벗어나지 않는 경우
                if(next_y >= 0 && next_y < Y && next_x >= 0 && next_x < X){

                    //이동할 칸의 값이 현재 값 + 1보다 큰 경우 현재 값 + 1로 대체(더 빨리 갈 수 있기 때문에)
                    if(matrix[next_y][next_x] > matrix[curr_y][curr_x] + 1){
                        matrix[next_y][next_x] = matrix[curr_y][curr_x] + 1;
                        queue.add(new Location(next_y, next_x, fire));  //그런 경우 해당 위치를 큐에 삽입
                    }
                }
                //matrix를 벗어나는 경우
                else{
                    if(!fire){  //해당 객체가 불이 아닌 사람일 경우 탈출에 성공
                        //bfs이기 때문에 해당 값 + 1이 최솟값임
                        answer = matrix[curr_y][curr_x] + 1;

                        System.out.println(answer);
                        return;
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");

        br.close();
    }
}
