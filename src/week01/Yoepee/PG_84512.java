package week01.Yoepee;

import java.util.*;

public class PG_84512 {
    // 만들어질 수 있는 최대 단어 길이
    static int MAX_LENGTH = 5;
    // 모음 사전 만들어지는 목록
    // 빈문자 고려해서 index 계산하려고 "" 초기값으로 추가
    static List<String> list = new ArrayList<>(Arrays.asList(""));
    // 알파벳 모음 배열
    static char[] v = "AEIOU".toCharArray();

    // 완전탐색을 통해 모음사전 순회
    public static void backtrack(StringBuffer path,int depth, String target){
        // 최대 글자수를 초과하면 종료
        if(depth > MAX_LENGTH) return;

        String current = path.toString();
        // 단어의 길이가 1 이상이면 저장
        if (depth >= 1) list.add(current);
        // 현재 단어가 주어진 단어라면 순회 종료
        if (current.equals(target)) return;

        for (char c: v){
            // 새로운 모음 추가
            path.append(c);
            // 신규 모음 기준으로 모음사전 재귀
            backtrack(path, depth+1, target);
            // 기존 값으로 초기화 시켜야지 sb가 제대로 동작함
            path.deleteCharAt(depth);
        }
    }

    public static int solution(String word) {
        StringBuffer sb = new StringBuffer("");
        backtrack(sb, 0, word);

        int answer = list.indexOf(word);
        return answer;
    }

    public static void main(String[] args) {
        // 기댓값 : 6
        System.out.println(solution("AAAAE"));
        // 기댓값 : 10
        System.out.println(solution("AAAE"));
        // 기댓값 : 1189
        System.out.println(solution("EIO"));
    }
}
