package week01.Unoguna;

import java.io.*;
import java.util.Stack;

public class BOJ_2493 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //수신자 탑이 될 수 있는 탑의 idx를 담는 스택
        Stack<Integer> stack= new Stack<>();

        // 1<= N <= 500000
        int N = Integer.parseInt(br.readLine());
        int[] tower = new int[N];
        int[] answer = new int[N];

        String[] str = br.readLine().split(" ");

        //각 탑의 높이를 받으면서 동시에 수신 탑의 idx를 탐색
        for(int i=0; i<N; i++){
            tower[i] = Integer.parseInt(str[i]);

            //스택이 빌 때까지 loop
            //스택에서 수신자 탑을 찾으면 스택이 비기 전에 loop가 종료됨
            while(!stack.isEmpty()){
                int receiverIdx = stack.peek(); //스택의 가장 윗부분 탑의 idx

                if(tower[receiverIdx] >= tower[i]){ //현재 탑보다 높으면 수신자 탑이 된다.
                    answer[i] = receiverIdx + 1;    //해당 탑의 순서를 저장
                    break;
                }
                else{   //해당 탑이 현재 탑의 높이보다 작으면 추후에도 수신자 탑이 될 수 없기 때문에 스택에서 제거
                    stack.pop();
                }
            }

            //스택이 비면 수신자 탑을 찾을 수 없기 때문에 0 저장
            if(stack.isEmpty()){
                answer[i] = 0;
            }

            stack.push(i);  //현재 탑은 추후에 수신자 탑이 될 수 있기 때문에 스택에 push
        }

        for(int num : answer)
            System.out.print(num + " ");
    }
}
