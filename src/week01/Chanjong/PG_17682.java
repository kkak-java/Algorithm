import java.util.ArrayList;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        ArrayList<Integer> scores = new ArrayList<>(); //최종 점수 3개를 저장하는 배열
        int i = 0;
        
        //점수 저장 부분
        while(i<dartResult.length()){
            int num = 0;
            
            if (Character.isDigit(dartResult.charAt(i)) && Character.isDigit(dartResult.charAt(i+1))){ //연속으로 숫자가 2자리일때(10일 경우)
                num = 10;
                i+=2;
            }
            else if (Character.isDigit(dartResult.charAt(i))){
                num = dartResult.charAt(i) - '0';
                i++;
            }
            
            //문자 저장 부분
            if(dartResult.charAt(i) == 'S'){
                scores.add(num);
            }
            else if(dartResult.charAt(i) == 'D'){
                scores.add(num*num);
            }
            else{
                scores.add(num*num*num);
            }
            
            //마지막에 옵션 없으므로 종료
            i++;
            if(i==dartResult.length()){
                break;
            }
            
            //옵션 적용 부분
            int index = scores.size()-1; //옵션을 적용할 점수가 몇번째인지
            if(dartResult.charAt(i)=='*'){
                scores.set(index, scores.get(index)*2);
                if(index!=0){
                    scores.set(index-1, scores.get(index-1)*2);
                }
                i++;
            }
            else if(dartResult.charAt(i)=='#'){
                scores.set(index, scores.get(index)*(-1));
                i++;
            }
        }
        
        for (int score : scores){
            answer+=score;
        }
        return answer;
    }
}