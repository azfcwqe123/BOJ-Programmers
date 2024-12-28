import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int k = 0;
        
        for(int i=0; i<3; i++) {
            String tmp = br.readLine();
            
            if(check(tmp)) {
                k += Integer.parseInt(tmp) + (3 - i);
                break;
            }
        }
        
        if(k % 3 == 0 && k % 5 == 0) System.out.print("FizzBuzz");
        else if(k % 3 == 0) System.out.print("Fizz");
        else if(k % 5 == 0) System.out.print("Buzz");
        else System.out.print(k);
        
    }
    
    public static boolean check(String str) {
        
        if(!str.equals("Fizz") && !str.equals("Buzz") && !str.equals("FizzBuzz")) return true;
        else return false;
    }
    
}

