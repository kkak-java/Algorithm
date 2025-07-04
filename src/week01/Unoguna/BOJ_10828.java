package week01.Unoguna;
import java.io.*;
import java.util.*;

public class BOJ_10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack= new Stack<>();    //스택 생성

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String[] op = br.readLine().split(" ");
            if(op.length == 1){
                if(op[0].equals("top")){    //stack의 최상단 element를 출력 stack이 비어있을 경우 -1 출력
                    if(!stack.isEmpty()) System.out.println(stack.lastElement());
                    else System.out.println("-1");
                }
                else if(op[0].equals("size")){  //stack의 현재 크기를 출력
                    System.out.println(stack.size());
                }
                else if(op[0].equals("empty")){ //stack이 비어있으면 1, 그렇지 않으면 0 출력
                    if(stack.isEmpty()) System.out.println("1");
                    else System.out.println("0");
                }
                else if(op[0].equals("pop")){   //stack의 최상단 element를 삭제하고 해당 element를 출력
                    if(!stack.isEmpty()) System.out.println(stack.pop());
                    else System.out.println("-1");
                }
            }

            //push
            else{
                int num = Integer.parseInt(op[1]);  //input을 stack에 저장
                stack.push(num);
            }
        }
    }

}
