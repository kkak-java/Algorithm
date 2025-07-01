package week01.Unoguna;
import java.util.*;

public class PG_340211 {

    public static void main(String[] args){
        int[][] points = new int[][]{{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int[][] routes = new int[][]{{4, 2}, {1, 3}, {2, 4}};

        Solution s = new Solution();

        System.out.println(s.solution(points, routes));
    }

    public static class Solution {
        class Robot{
            int x;  //로봇의 현재 좌표x
            int y;  //로봇의 현재 좌표y

            int location_x; //로봇의 현재 목적지의 좌표x
            int location_y; //로봇의 현재 목적지의 좌표y

            int[] route;    //로봇의 이동경로
            int route_idx;  //현재 가야하는 route의 idx

            boolean end;    //최종 목적지에 도착하면 true 아니면 false

            Robot(int[] route, int x, int y, int location_x, int location_y){
                route_idx = 1;  //0은 시작지점이기 때문에 첫 목적지의 idx는 1
                this.route = route;
                this.x = x;
                this.y = y;
                this.location_x = location_x;
                this.location_y = location_y;
                this.end = false;
            }
        }

        //points는 특정 지점의 위치를 담고 있다.
        //routes는 각 로봇들의 이동경로를 담고 있다.
        public int solution(int[][] points, int[][] routes) {
            int answer = 0;
            int end_num = 0;    //최종 목적지까지 도착이 완료된 로봇의 개수

            //int[][] matrix = new int[101][101]; //해당 위치의 로봇의 개수를 표시하기위한 배열 생성 전체 가로, 세로의 최대 길이가 100이라 101로 할당

            Robot[] robot = new Robot[routes.length];

            //로봇들을 생성
            for(int i=0; i<routes.length; i++){
                int point_idx = routes[i][0] - 1;   //문제에서 첫 idx를 0이 아닌 1로 주어서 1을 뺌
                int location_idx = routes[i][1] - 1;
                robot[i] = new Robot(routes[i], points[point_idx][1], points[point_idx][0],
                        points[location_idx][1], points[location_idx][0]);
            }

            //로봇 이동 및 충돌횟수 체크
            while(end_num < routes.length){ //모든 로봇이 최종 목적지에 도착하면 종료
                //현재 로봇들의 위치를 matrix에 반영 matrix는 (x,y)좌표에 있는 로봇의 개수를 갖게됨

                ArrayList<String> arr = new ArrayList<>();  //로봇이 한개 이상인 좌표
                ArrayList<String> dup = new ArrayList<>();  //로봇이 두개 이상인 좌표

                for(int i=0; i<robot.length; i++){
                    if(robot[i].end) continue; //최종 목적지까지 도착한 로봇은 계속 그 위치에 있는게 아니라 제거해야하기 때문에 도착한 경우 matrix에 반영하지 않는다.

                    int x = robot[i].x;
                    int y = robot[i].y;

                    String tmp = Integer.toString(x) +" " +  Integer.toString(y);

                    if(!dup.contains(tmp) && arr.contains(tmp)){
                        dup.add(tmp);
                        answer++;
                    }
                    else if(!arr.contains(tmp)) arr.add(tmp);
                }

                //count 체크
                //matrix의 크기가 최대 100*100이고 while문의 최대 loop횟수가 200이라 시간복잡도에 크게 지장이 없다고 생각하여 이중 for문으로 구현
//                for(int i=0; i<matrix.length; i++){
//                    for(int j=0; j<matrix.length; j++){
//                        if(matrix[j][i] > 1) answer++;  //해당위치에 로봇의 개수가 2개이상일 경우 충돌이 발생
//                        matrix[j][i] = 0;   //해당위치 확인후 초기화 시켜준다.
//                    }
//                }

                //string을 통해서 체크하는 방법

                //로봇들을 다음 이동할 위치로 이동
                for(int i=0; i<robot.length; i++){
                    if(robot[i].end) continue; //최종목적지까지 도착한 로봇

                    //로봇이 현재 목적지에 도착한 경우
                    if(robot[i].x == robot[i].location_x && robot[i].y == robot[i].location_y){

                        //현재 목적지가 최종 목적지인 경우
                        if(robot[i].route_idx + 1 == robot[i].route.length){
                            end_num++;
                            robot[i].end=true;
                            continue;
                        }

                        //다음 목적지가 존재할 경우 다음 목적지 할당
                        robot[i].route_idx++;
                        int idx = robot[i].route[robot[i].route_idx];
                        robot[i].location_y = points[idx-1][0];
                        robot[i].location_x = points[idx-1][1];
                    }

                    //정해진 규칙(세로방향 우선 이동)대로 이동
                    if(robot[i].y != robot[i].location_y){
                        //세로 이동
                        robot[i].y += robot[i].y > robot[i].location_y ? -1 : 1;
                    }
                    else{
                        //가로 이동
                        robot[i].x += robot[i].x > robot[i].location_x ? -1 : 1;
                    }
                }
            }

            return answer;
        }
    }
}
