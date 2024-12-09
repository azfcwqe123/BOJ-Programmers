class Solution {
    public int solution(int[][] lines) {
        
        int[] arr = new int[200]; // 0~1, 1~2, ... 199~200
        
        for(int[] x : lines) {
            
            int a = x[0] + 100;
            int b = x[1] + 100;
            
            for(int i=a; i<b; i++) arr[i]++;
        }
        
        int cnt = 0;
        
        for(int x : arr) {
            if(x > 1) cnt++;
        }
        
        return cnt;
        
        
    }
}