package week01.Yoepee;

import java.util.*;

public class PG_42576 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i =0; i<participant.length; i++){
            if (i == participant.length-1) return participant[i];
            if (participant[i].equals(completion[i]) == false) {
                return participant[i];
            }
        }
        return answer;
    }

    public static String solution2(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(int i =0; i<participant.length;i++){
            map.merge(participant[i], 1, (v1, v2) -> Math.max(v1,v2)+1);
        }
        for(int i =0; i<completion.length;i++){
            map.merge(completion[i], 0, (v1, v2) -> v1-1);
        }
        for(int i =0; i<participant.length;i++){
            if(map.get(participant[i]) == 1){
                answer =participant[i];
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 정상 결과: "leo"
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        // 정상 결과: "vinko"
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        // 정상 결과: "mislav"
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
        // 정상 결과: "b"
        System.out.println(solution(new String[]{"a", "b", "a", "c", "d"}, new String[]{"a", "a", "c", "d"}));
        // 정상 결과: "b"
        System.out.println(solution(new String[]{"a", "a", "b", "a", "c", "d"}, new String[]{"a", "a", "a", "c", "d"}));
    }
}
