import java.io.*;
import java.util.*;

class Main {
    
    public static int cnt = 0;
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String[] A = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
	    double[] B = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};
	        
	    double sum1 = 0;
	    double sum2 = 0;
	    
	    for(int i=0; i<20; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        String str = st.nextToken();
	        double score = Double.parseDouble(st.nextToken());
	        String grade = st.nextToken();
	        
	        for(int j=0; j<A.length; j++) {
	            if(A[j].equals(grade)) {
	                sum1 += B[j] * score;
	                sum2 += score;
	                break;
	            }   
	        }
	        
	    }
	        
	   System.out.print(String.format("%6f", (sum1 / sum2)));
	        
	        
	}
	    
}
	


