package week01.Unoguna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_6198 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //수신자 탑이 될 수 있는 탑의 idx를 담는 스택
        Stack<Integer> stack= new Stack<>();

        // 1<= N <= 80,000
        int N = Integer.parseInt(br.readLine());

        //탑의 높이 1<= h <= 1,000,000,000
        int[] tower = new int[N];

        //answer이 될 수 있는 최댓값이 80000 * 80001 / 2 라 int overflow가 발생 할 수 있어 Long으로 설정
        Long answer = 0L;

        //탑의 높이를 받으면서 output 계산
        for(int i=0; i<N; i++){
            tower[i] = Integer.parseInt(br.readLine());

            //현재 탑보다 stack에서 가져온 탑의 높이가 높으면 거리 계산 후 stack에서 제거
            while(!stack.isEmpty()){
                int idx = stack.peek();
                if(tower[idx] <= tower[i]){
                    answer += i - idx - 1;
                    stack.pop();
                }
                else{
                    break;
                }
            }
            stack.add(i);
        }

        while(!stack.isEmpty()){
            answer +=  N - stack.pop() - 1;
        }
        System.out.println(answer);
    }
}
