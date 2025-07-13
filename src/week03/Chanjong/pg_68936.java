class Solution {
    public int[] solution(int[][] arr) {
        return quadtree(arr, 0, 0, arr[0].length);
    }
    
    public int[] quadtree(int[][] arr, int x, int y, int len){
        boolean isSame = true;
        
        //x, y는 배열의 시작 인덱스
        for(int i=x; i<x+len; i++){
            for(int j=y; j<y+len; j++){
                //압축이 안 되는 경우
                if(arr[i][j] != arr[x][y]){ 
                    isSame=false;
                    break;
                }
            }
            if(isSame==false) break;
        }
        
        //압축이 되는 경우
        if(isSame==true){
            if (arr[x][y]==0) return new int[]{1,0};
            else return new int[]{0,1};
        }
        
        int halfLen = len/2;
        
        int[] topLeft = quadtree(arr, x, y, halfLen);
        int[] topLight = quadtree(arr, x + halfLen, y, halfLen);
        int[] bottomLeft = quadtree(arr, x, y + halfLen, halfLen);
        int[] bottomLight = quadtree(arr, x + halfLen, y + halfLen, halfLen);
        
        return new int[] {
            topLeft[0]+topLight[0]+bottomLeft[0]+bottomLight[0],
            topLeft[1]+topLight[1]+bottomLeft[1]+bottomLight[1]};
    }
}