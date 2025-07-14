package week01.Yoepee;

// 괄호 변환
public class PG_60058 {
    static class Solution {
        public String solution(String p) {
            String answer = "";
            // 빈 문자열인 경우, 빈 문자열 반환
            if (p.length() == 0) return "";
            // string의 길이가 2일 경우 올바른 괄호 문자열은 () 밖에 없으므로 () 반환
            else if (p.length() == 2) return "()";

            // u가 끝나는 index
            int start = 0;
            // 괄호가 제대로 닫혔는지 확인하는 변수
            int count = 0;
            // 균형잡힌 괄호 문자열 u가 올바른 괄호 문자열인지 확인하는 변수
            boolean isRight = true;

            // 균형잡힌 문자열 p를 u와 v로 나누는 로직
            for (int i = 0; i<p.length(); i++){
                count += p.charAt(i) == '(' ? 1 : -1;
                // count가 음수로 한번이라도 변경되면 올바른 괄호 문자열이 아님.
                if (count < 0) isRight = false;

                // count가 0이 되면 괄호의 열림과 닫힘이 짝이 맞음
                // 균형잡힌 괄호 문자열임.
                if (count == 0){
                    start = i+1;
                    answer += p.substring(0, start);
                    break;
                }
            }
            // 반복문을 모두 돌았는데 균형잡힌 문자열이 아닌 경우 u의 값을 문자열 전체로 지정
            if (count != 0) {
                start = p.length();
                answer += p.substring(0, start);
            }

            // p에서 u를 제외한 문자열 v를 재귀함수를 통해 반환
            String v = solution(p.substring(start));
            // 수행한 결과를 문자열 u에 이어 붙임
            answer+=v;

            // 문자열 u가 올바른 괄호 문자열이 아닌 경우 로직에 따라 processU 진행
            if (!isRight) {
                return processU(p.substring(0, start), v);
            }

            // 최종 결과 answer 반환
            return answer;
        }

        // 문자열 u가 올바른 괄호 문자열이 아닌경우 동작하는 로직
        private String processU(String p, String v){
            String answer = "";
            // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
            answer += "(";
            // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            answer += v;
            // 4-3. ')'를 다시 붙입니다.
            answer += ")";
            // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
            for (int i = 1; i<p.length()-1; i++){
                answer += p.charAt(i) =='(' ? ')' : '(';
            }

            // 4-5. 생성된 문자열을 반환합니다.
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // 정상 결과 : "(()())()"
        System.out.println(s.solution("(()())()"));
        // 정상 결과 : "()"
        System.out.println(s.solution(")("));
        // 정상 결과 : "()(())()"
        System.out.println(s.solution("()))((()"));
    }
}
