import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int[] calender = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    
    public static void main(String[] args) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        
        int tmp = day;
        
        for(int i=0; i<month-1; i++) {
            tmp += calender[i];
        }
        
        System.out.print(week[tmp % 7]);
        
    }
    
}

