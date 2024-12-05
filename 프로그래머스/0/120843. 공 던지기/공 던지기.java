import java.util.*;

class Solution {
    public int solution(int[] numbers, int k) {
        
        Queue<Integer> Q = new LinkedList<>();
        
        for(int x : numbers) Q.offer(x);
        
        while(k-- > 1) {
            Q.offer(Q.poll());
            Q.offer(Q.poll());    
        }
        
        return Q.poll();
    }
}
