import java.io.*;
import java.util.*;

class Main {
    
    public static int cnt = 0;
    
	public static void main (String[] args) throws IOException {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    double a = 0;
	    double b = 0;
	        
	    for(int i=0; i<20; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        String str = st.nextToken();
	        double score = Double.parseDouble(st.nextToken());
	        String grade = st.nextToken();
	        
	        if(!(grade.equals("P"))) {
	            
	            if(grade.equals("A+")) {
	                a += 4.5 * score;
	            } else if(grade.equals("A0")) {
	                a += 4.0 * score;
	            } else if(grade.equals("B+")) {
	                a += 3.5 * score;
	            } else if(grade.equals("B0")) {
	                a += 3.0 * score;
	            } else if(grade.equals("C+")) {
	                a += 2.5 * score;
	            } else if(grade.equals("C0")) {
	                a += 2.0 * score;
	            } else if(grade.equals("D+")) {
	                a += 1.5 * score;
	            } else if(grade.equals("D0")) {
	                a += 1.0 * score;
	            } else if(grade.equals("F")) {
	                a += 0.0 * score;
	            }
	            
	            b += score;

	            }
	            
	        }
	        
	        System.out.print(String.format("%6f",(a/b)));
	        
	    }
	    
	}
	


