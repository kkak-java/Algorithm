class Solution {
    
    // 정수 값을 이진수 배열로 변환하는 함수
    // value: 변환할 정수
    // length: 결과 이진수 배열의 길이 (지도 가로 길이)
    private static int[] toBinary(int value, int length) {
        int[] answer = new int[length];
        
        // 이진수는 뒤에서부터 채워야 하므로, 배열의 끝에서부터 채움
        for (int i = 0; i < length; i++) {
            answer[length - i - 1] = value % 2; // 2로 나눈 나머지를 저장 (0 또는 1)
            value /= 2; // 다음 비트를 위해 2로 나눔
        }
        
        return answer;
    }

    // 이진수 배열을 문자열로 변환하는 함수
    // 0은 공백 ' ', 1은 벽 '#'
    private static String toString(int[] binary) {
        StringBuilder answer = new StringBuilder();
        final char[] TILES = {' ', '#'}; // 매핑 테이블: 0 -> ' ', 1 -> '#'
        
        for (int bit : binary) {
            answer.append(TILES[bit]); // bit 값에 따라 문자 추가
        }
        
        return answer.toString(); // 최종 문자열 반환
    }

    // 메인 로직 함수
    // n: 지도의 크기 (정사각형이므로 n x n)
    // arr1, arr2: 두 장의 지도를 나타내는 정수 배열
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n]; // 정답 배열 (각 행의 문자열 저장)

        for (int row = 0; row < n; row++) {
            // 두 지도의 같은 위치를 OR 연산하여 겹치는 벽 찾기
            int mergedRow = arr1[row] | arr2[row]; // 비트 OR 연산

            // OR 연산 결과를 이진수 배열로 변환 후, 문자열로 변환
            answer[row] = toString(toBinary(mergedRow, n));
        }
        
        return answer; // 최종 지도 문자열 배열 반환
    }
}
