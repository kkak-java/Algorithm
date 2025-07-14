package week03.Juchan;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n]; // 합을 넣어둘 배열 생성

        dp[0][0] = triangle[0][0]; // 초기값은 꼭대기의 값

        for (int i = 1; i < n; i++) {
            //맨 왼쪽
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j]; // 중간에 있는 값은 전 인덱스의 왼쪽 값과 오른쪽 값중 큰 값으로 설정
            }

            // 맨 오른쪽
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[n - 1][i]); // 최댓값을 갱신
        }
        return answer;
    }
}

public class PG_43105 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        int result = s.solution(triangle);
        System.out.println(result); // 예상 출력: 30
    }
}


/**
 * 문제
 * 숫자가 들어간 피라미드 형태의 삼각형이 주어진다.
 * 꼭대기부터 바닥까지 인접한 숫자를 따라 내려가면서 만들 수 있는 최대 합을 구하라.
 * <p>
 * 풀이 요약
 * - 각 위치까지의 최대 합을 저장할 dp 배열을 선언한다.
 * - 첫 번째 행(dp[0][0])은 초기값으로 triangle[0][0]을 넣는다.
 * - 그다음 행부터는 규칙적으로 채운다:
 * 1. 맨 왼쪽 값(dp[i][0])은 바로 위 행의 같은 인덱스(dp[i-1][0])에서만 내려올 수 있다.
 * 2. 맨 오른쪽 값(dp[i][i])은 바로 위 행의 오른쪽 대각선 왼쪽(dp[i-1][i-1])에서만 내려올 수 있다.
 * 3. 그 외 중간 값(dp[i][j])은 바로 위(dp[i-1][j]) 또는 왼쪽 대각선(dp[i-1][j-1]) 중 큰 값에 현재 triangle[i][j]를 더한다.
 * - 마지막 행(dp[n-1])에서 최댓값을 찾아서 반환한다.
 */