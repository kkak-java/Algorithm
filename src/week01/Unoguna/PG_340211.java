package week01.Unoguna;

public class PG_340211 {

    public static void main(String[] args){
        int[][] points = new int[][]{{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int[][] routes = new int[][]{{4, 2}, {1, 3}, {2, 4}};

        Solution s = new Solution();

        System.out.println(s.solution(points, routes));
    }

    public static class Solution {
        class Robot{
            int x;
            int y;

            int location_x;
            int location_y;

            int[] route;
            int route_idx;

            boolean end;

            Robot(int[] route, int x, int y, int location_x, int location_y){
                route_idx = 1;
                this.route = route;
                this.x = x;
                this.y = y;
                this.location_x = location_x;
                this.location_y = location_y;
                this.end = false;
            }
        }

        public int solution(int[][] points, int[][] routes) {
            int answer = 0;
            int end_num = 0;

            int[][] matrix = new int[101][101];

            Robot[] robot = new Robot[routes.length];

            for(int i=0; i<routes.length; i++){
                int point_idx = routes[i][0] - 1;
                int location_idx = routes[i][1] - 1;
                robot[i] = new Robot(routes[i], points[point_idx][1], points[point_idx][0],
                        points[location_idx][1], points[location_idx][0]);
            }

            while(end_num < routes.length){
                //현재 반영
                for(int i=0; i<robot.length; i++){
                    if(robot[i].end) continue;

                    int x = robot[i].x;
                    int y = robot[i].y;

                    matrix[y][x]++;
                }

                //count 체크
                for(int i=0; i<matrix.length; i++){
                    for(int j=0; j<matrix.length; j++){
                        if(matrix[j][i] > 1) answer++;
                        matrix[j][i] = 0;
                    }
                }

                //다음 동작
                for(int i=0; i<robot.length; i++){
                    if(robot[i].end) continue; //동작을 다 한 로봇

                    if(robot[i].x == robot[i].location_x && robot[i].y == robot[i].location_y){
                        if(robot[i].route_idx + 1 == robot[i].route.length){
                            end_num++;
                            robot[i].end=true;
                            continue;
                        }

                        //다음 location할당
                        robot[i].route_idx++;
                        int idx = robot[i].route[robot[i].route_idx];


                        robot[i].location_y = points[idx-1][0];
                        robot[i].location_x = points[idx-1][1];
                    }
                    if(robot[i].y != robot[i].location_y){
                        //세로 움직
                        robot[i].y += robot[i].y > robot[i].location_y ? -1 : 1;
                    }
                    else{
                        //가로 움직
                        robot[i].x += robot[i].x > robot[i].location_x ? -1 : 1;
                    }
                }
            }

            return answer;
        }
    }
}
