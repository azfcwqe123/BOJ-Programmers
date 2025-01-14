import java.util.*;
import java.io.*;

class Fire {
    int x;
    int y;
    
    public Fire(int x, int y) {
        this.x = x;
        this.y = y; 
    }
}

class Person {
    int x;
    int y;
    
    public Person(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    public static char[][] map;
    public static int w, h;
    
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, 1, -1, 0};
    
    public static Queue<Person> pQ;
    public static Queue<Fire> fQ;
    
    public static void main(String[] args) throws IOException {
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            
            st = new StringTokenizer(br.readLine());
            
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            
            map = new char[h][w];
            
            pQ = new LinkedList<>();
            fQ = new LinkedList<>();
            
            for(int i=0; i<h; i++) {
                String str = br.readLine();
                for(int j=0; j<w; j++) {
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == '*') fQ.offer(new Fire(i, j));
                    if(map[i][j] == '@') pQ.offer(new Person(i, j)); 
                }
            }
            
            int ch = BFS();
            
            if(ch == -1) System.out.println("IMPOSSIBLE");
            else System.out.println(ch);
            
        }
    }
    
    public static int BFS() {
        
        int cnt = 0;
        
        while(!pQ.isEmpty()) {
            
            int len = fQ.size();
            
            for(int i=0; i<len; i++) {
                Fire cur = fQ.poll();
                
                for(int d=0; d<4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    
                    if(rangeCheck(nx, ny) && (map[nx][ny] == '.' || map[nx][ny] == '@')) {
                        map[nx][ny] = '*';
                        fQ.offer(new Fire(nx, ny));
                    }
                }
            }
            
            len = pQ.size();
            
            for(int i=0; i<len; i++) {
                Person cur = pQ.poll();
                
                for(int d=0; d<4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    
                    if(!rangeCheck(nx, ny)) return cnt + 1;
                    
                    if(map[nx][ny] == '.') {
                        map[nx][ny] = '@';
                        pQ.offer(new Person(nx, ny));
                    }
                }
            }
            
            cnt++;
        }
        
        return -1;
    }
        
    
    public static boolean rangeCheck(int nx, int ny) {
        return nx >= 0 && nx < h && ny >= 0 && ny < w;
    }
}

