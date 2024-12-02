import java.util.*;
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	    
	    int g = Integer.parseInt(br.readLine());
	    
	    int lt = 1, rt = 2;
	    
	    ArrayList<Integer> list = new ArrayList<>();
	    
	    while(lt < rt) {
	        
	        int diff = (int) (Math.pow(rt,2) - Math.pow(lt,2));
	        
	        if(diff > g) lt++;
	        else if(diff < g) rt++;
	        else {
	            list.add(rt);
	            lt++;
	            rt++;
	        }
	    }
	    
	    list.sort((a,b) -> a - b);
	    
	    if(list.isEmpty() || g == 1) {
	        System.out.print(-1);
	        return;
	    } else {
            for(int x : list) {
                System.out.println(x);
            }
	    }
	    
	    
	    
    }
    
}
