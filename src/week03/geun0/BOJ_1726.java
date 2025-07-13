package week03.geun0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * <a href = "https://www.acmicpc.net/problem/1726">백준 1726번 - 로봇</a>
 * @since 2025-07-13
 * @author 장근영
 * @apiNote 예상 시간 복잡도 {@code O(NM)}
 */
public class BOJ_1726 {

    static int n, m;
    static int[][] map;
    static boolean[][][] visit;
    static int[] dx = {0, 0, 1, -1}; //동서남북
    static int[] dy = {1, -1, 0, 0}; //동서남북
    static int[] turnLeft = {3, 2, 0, 1};
    static int[] turnRight = {2, 3, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); //세로
        n = Integer.parseInt(st.nextToken()); //가로

        map = new int[m][n];
        visit = new boolean[m][n][4]; //방향(동서남북)을 포함한 3차원 방문 배열 필요

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //로봇의 출발 지점과 바라보는 방향
        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken()) - 1;
        int sy = Integer.parseInt(st.nextToken()) - 1;
        int sdir = Integer.parseInt(st.nextToken()) - 1;

        //로봇의 도착 지점과 바라보는 방향
        st = new StringTokenizer(br.readLine());
        int ex = Integer.parseInt(st.nextToken()) - 1;
        int ey = Integer.parseInt(st.nextToken()) - 1;
        int edir = Integer.parseInt(st.nextToken()) - 1;

        bfs(sx, sy, sdir, ex, ey, edir);
    }

    private static void bfs(int sx, int sy, int sdir, int ex, int ey, int edir) {
        Queue<int[]> qu = new ArrayDeque<>();
        qu.offer(new int[]{sx, sy, sdir, 0}); //{x 좌표, y 좌표, 바라보는 방향, 명령 횟수}

        visit[sx][sy][sdir] = true; //시작 위치 방문 처리

        while (!qu.isEmpty()) {
            int[] cur = qu.poll();

            int x = cur[0], y = cur[1]; //좌표
            int dir = cur[2];           //바라보는 방향
            int count = cur[3];         //명령 횟수

            //도착 지점 + 바라보는 방향까지 같아야 함 주의
            if (x == ex && y == ey && dir == edir) {
                System.out.println(count);
                return;
            }

            //명령 1 - 현재 향하고 있는 방향으로 1~3칸 만큼 움직인다.
            for (int i = 1; i <= 3; i++) {
                int nx = x + (i * dx[dir]);
                int ny = y + (i * dy[dir]);

                //범위를 벗어나는 경우
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

                //2칸 이상 움직일 때 중간에 갈 수 없는 지점이 있으면 break
                //continue를 해버리면 갈 수 없는 지점을 점프해버리는 문제가 발생한다.
                if (map[nx][ny] == 1) break;

                if (!visit[nx][ny][dir]) {
                    visit[nx][ny][dir] = true;
                    qu.offer(new int[]{nx, ny, dir, count + 1});
                }
            }

            //명령 2 - 왼쪽 90도 회전
            int left = turnLeft[dir];
            if (!visit[x][y][left]) {
                visit[x][y][left] = true;
                qu.offer(new int[]{x, y, left, count + 1});
            }

            //명령 2 - 오른쪽 90도 회전
            int right = turnRight[dir];
            if (!visit[x][y][right]) {
                visit[x][y][right] = true;
                qu.offer(new int[]{x, y, right, count + 1});
            }
        }
    }
}
