import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                set.add(arr[i] + arr[j]);
            }    
        }
        
        int[] arr2 = new int[set.size()];
        
        Iterator<Integer> iter = set.iterator();
        
        int i = 0;
        while(iter.hasNext()) {
            arr2[i] = iter.next();
            i++;
        }
        
        Arrays.sort(arr2);
        
        return arr2;
        
    }
}