import java.util.*;
import java.io.*;

class Main {
    
    static class Person {
        int x;
        int y;
        int z;
        
        Person(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static char[][][] apt;
	private static int[] dz = {-1, 0, 0, 1, 0, 0};
	private static int[] dy = {0, -1, 1, 0, 0, 0};
	private static int[] dx = {0, 0, 0, 0, -1, 1};
    
    public static int L, R, C;
    public static Queue<Person> Q;
    
    public static void main(String[] args) throws IOException {
        
        while(true) {
            st = new StringTokenizer(br.readLine());
            Q = new LinkedList<>();
            
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            
            if(L == 0 && R == 0 && C == 0) return;
            
            apt = new char[L][R][C];
            
            for(int i=0; i<L; i++) {
               for(int j=0; j<R; j++) {
                    String str = br.readLine();
                    for(int k=0; k<C; k++) {
                        apt[i][j][k] = str.charAt(k);
                        
                        if(apt[i][j][k] == 'S') Q.offer(new Person(i, j, k));
                    }
                }   
                br.readLine();
            }
            
            int ans = BFS();
            
            if(ans == -1) System.out.println("Trapped!");
            else System.out.println("Escaped in " + ans + " minute(s).");
        }
        
    }
    
    public static int BFS() {
        
        int cnt = 0;
        
        while(!Q.isEmpty()) {
            int len = Q.size();
            
            for(int i=0; i<len; i++) {
                Person cur = Q.poll();
                
                for(int d=0; d<6; d++) {
                    
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    int nz = cur.z + dz[d];
                    
                    if(!rangeCheck(nx, ny, nz)) continue;
                    
                    if(apt[nx][ny][nz] == 'E') return cnt + 1;
                    
                    if(apt[nx][ny][nz] == '.') {
                        apt[nx][ny][nz] = 'S';
                        Q.offer(new Person(nx, ny, nz));
                    }
                }
            }
            
            cnt++;
        }
        
        return -1;
        
    }
    
    public static boolean rangeCheck(int nx, int ny, int nz) {
        return nx >= 0 && ny >= 0 && nz >= 0 && nx < L && ny < R && nz < C;
    }
    
}

