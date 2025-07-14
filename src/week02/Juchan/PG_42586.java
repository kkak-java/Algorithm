package week02.Juchan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PG_42586 {
    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            // 각 작업이 완료되기까지 남은 '일 수'를 저장할 큐
            Queue<Integer> queue = new LinkedList<>();

            //(100-진도율)/개발 속도를 통해 남은 일 수 계산
            for (int i = 0; i < progresses.length; i++) {
                int day = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]); //ex 3.8888 일이면 4일 필요하기에 ceil 함수를 사용해서 올림 처리 후 형 변환
                queue.offer(day);
            }
            List<Integer> result = new ArrayList<>();

            // 첫번 째 배포 일 수를 뽑아냅니다.
            while (!queue.isEmpty()) {
                int current = queue.poll();
                int count = 1;

                // 배포일과 비교하여 큐의 첫 번째 일 수가 작거나 같으면 같이 묶어서 리스트에 저장합니다.
                while (!queue.isEmpty() && queue.peek() <= current) {
                    queue.poll();
                    count++;
                }
                result.add(count);
            }
            int[] answer = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                answer[i] = result.get(i);
            }
            return answer;
        }
    }

    public static void main(String[] args) { //테스트
        Solution solution = new Solution();


        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] result = solution.solution(progresses, speeds);


        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i != result.length - 1) { //마지막 요소는 , 를 빼줍니다.
                System.out.print(", ");
            }
        }
        System.out.println("]");
        // 예상 출력: [2, 1]
    }
}


/**
 * 문제
 * 각각 기능은 진도(progress) 가 있고, 매일 각 기능마다 개발 속도(speed) 만큼 진도가 올라간다.
 * 기능은 진도가 100% 이상이 되어야 배포 할 수 있다.
 * 배포는 하루에 한 번, 하루가 끝난 후 진행한다.
 * 진도가 뒤에 있는 기능이 앞 기능보다 빨리 끝날 수 있는데 뒤에 있는 기능은 앞 기능이 배포되는 시점에 같이 배포된다.
 * <p>
 * 풀이 방법
 * 1. 각 기능마다 100%가 될 때까지 걸리는 날을 계산한다.(100-진도율)/개발 속도
 * 2. 큐에서 가장 앞에 있는 기능을 꺼내 배포일을 지정한다.
 * 3. 배포일보다 작업이 먼저 끝난 뒤에 있는 기능도 같이 묶어준다.
 * 4. 묶인 기능의 수를 리스트에 넣어준다.
 * 5. 리스트를 출력한다.
 */