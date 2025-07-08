import java.util.HashMap;

// 1
class Solution {
    
    private static HashMap<String, String> map = new HashMap<>();
    
    public int solution(String s) {
        // map 구성
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        
        for(String key : map.keySet()){
            s = s.replaceAll(key, map.get(key));
        }

        int answer = Integer.parseInt(s);
        return answer;
    }
}

// 2
//class Solution2 {
//    public int solution(String s) {
//        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
//        for(int i = 0; i < strArr.length; i++) {
//            s = s.replaceAll(strArr[i], Integer.toString(i));
//        }
//        return Integer.parseInt(s);
//    }
//}
