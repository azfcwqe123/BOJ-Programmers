import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    if((n % 4 == 0) && ((n % 100 != 0) || (n % 400 == 0))) System.out.print(1);
	    else System.out.print(0);
	    
	}
}   

---

	
import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int res = (n % 4 == 0) ? (n % 400 == 0 ? 1 : (n % 100 != 0 ? 1 : 0)) : 0;
	    
	    System.out.print(res);

	    
	}
}   


