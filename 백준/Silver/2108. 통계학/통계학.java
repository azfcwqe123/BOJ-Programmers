import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        
        double sum = 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            
            sum += arr[i];
            
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }
        
        // 중앙값 구하기 위한 정렬
        Arrays.sort(arr);
        
        // 최빈값 구하기 
        int count = 0;
        for(int x : map.values()) {
            count = Math.max(count, x);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int x : map.keySet()) {
            if(map.get(x) == count) list.add(x);
        }
        
        int mode = 0;
        
        Collections.sort(list);
        
        if(list.size() >= 2) mode = list.get(1);
        else mode = list.get(0);
        
        
        
        System.out.println((int) Math.round(sum / n)); // 산술 평균값
        System.out.println(arr[n / 2]); // 중앙값
        System.out.println(mode);
        System.out.print(max - min); // 범위
        
    }
    
}
    


