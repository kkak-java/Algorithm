package week01.Juchan;

import java.util.*;

public class PG_42889 {
    static int N; // 전체 스테이지의 갯수
    static int[] stages; // 사용자들의 멈춰있는 스테이지의 번호들

    public static void main(String[] args) {

        N = 5;
        stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};

        Solution sol = new Solution();
        int[]answer = sol.solution(N, stages);
        System.out.println(Arrays.toString(answer)); //배열을 출력

    } // 테스트 케이스

    public static class Solution {
        public int[] solution(int N, int[] stages) {
            int[] result = new int[N]; // 결과 배열 (정렬된 스테이지 번호 저장)
            int totalPlayers = stages.length; // 전체 플레이어 수

            // 실패율과 스테이지 번호 저장 리스트 ([0] 스테이지 번호, [1] 실패율)
            List<double[]> stageList = new ArrayList<>();

            // 1부터 N까지 스테이지별 실패율 계산
            for (int i = 1; i <= N; i++) {
                int failCount = 0; //실패한 플레이어 수
                for (int s : stages) {
                    if (s == i) {
                        failCount++;  // 각 플레이어가 멈춰 있는 스테이지가 i번이면 실패로 간주
                    }
                }
                double failureRate = 0;
                if (totalPlayers > 0) { // 도달한 플레이어가 있을 경우에만 실패율 계산
                    failureRate = (double) failCount / totalPlayers;
                }

                stageList.add(new double[]{i, failureRate}); // 스테이지 번호와 실패율을 리스트에 추가

                totalPlayers -= failCount; // 다음 스테이지에는 실패하지 않은 플레이어만 도달하므로 갱신
            }

            // 실패율 내림차순, 실패율 같으면 스테이지 번호 오름차순 정렬
            stageList.sort((a, b) -> {
                if (b[1] == a[1]) {
                    return Double.compare(a[0], b[0]); //오름차순 정렬
                } else {
                    return Double.compare(b[1], a[1]); //내림차순 정렬
                }
            });

            // 정렬된 스테이지 번호를 결과 배열에 담기
            for (int i = 0; i < N; i++) {
                result[i] = (int) stageList.get(i)[0];
            }

            return result;
        }
    }
}



/**
 * 실패율 = 스테이지에 도달 했지만 깨지 못한 플레이어 수 / 스테이지 도달 한 플레이어 수
 * <p>
 * 조건: 전체 스테이지의 갯수 N , 사용자가 현재 멈춰있는 스테이지 번호가 담긴 배열 stages
 * <p>
 * 요구 사항: 실패율이 높은 스테이지부터 내림차순으로 번호가 담겨있는 배열을 return
 */