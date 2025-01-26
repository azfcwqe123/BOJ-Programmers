import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        String[] DNA = new String[n];
        
        for(int i=0; i<n; i++) DNA[i] = br.readLine();
        
        int sum = 0;
        
        for(int i=0; i<m; i++) {
            int[] ACGT = new int[4];
            
            for(int j=0; j<n; j++) {
                
                switch(DNA[j].charAt(i)) {
                    
                    case 'A' : 
                        ACGT[0]++;
                        break;
                        
                    case 'C' :
                        ACGT[1]++;
                        break;
                        
                    case 'G' :
                        ACGT[2]++;
                        break;
                        
                    case 'T' :
                        ACGT[3]++;
                        break;
                }
            }
            
            int max = ACGT[0], idx = 0;
            
            for(int k=1; k<4; k++) {
                if(max < ACGT[k]) {
                    max = ACGT[k];
                    idx = k;
                }
            }
            
            sum += n - max;
            
            switch(idx) {
                case 0 :
                    sb.append('A');
                    break;
                
                case 1 :
                    sb.append('C');
                    break;
                
                case 2 :
                    sb.append('G');
                    break;
                    
                case 3 :
                    sb.append('T');
                    break;
            }
            
        }
        
        System.out.println(sb);
        System.out.println(sum);
    }
    
}

