# [Gold III] 말이 되고픈 원숭이 - 1600 

[문제 링크](https://www.acmicpc.net/problem/1600) 

### 성능 요약

메모리: 89928 KB, 시간: 468 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 2월 14일 15:34:04

### 문제 설명

<p>동물원에서 막 탈출한 원숭이 한 마리가 세상구경을 하고 있다. 그 녀석은 말(Horse)이 되기를 간절히 원했다. 그래서 그는 말의 움직임을 유심히 살펴보고 그대로 따라 하기로 하였다. 말은 말이다. 말은 격자판에서 체스의 나이트와 같은 이동방식을 가진다. 다음 그림에 말의 이동방법이 나타나있다. x표시한 곳으로 말이 갈 수 있다는 뜻이다. 참고로 말은 장애물을 뛰어넘을 수 있다.</p>

<table class="table table-bordered" style="width: 15%;">
	<tbody>
		<tr>
			<td style="width: 3%; text-align: center;"> </td>
			<td style="width: 3%; text-align: center;">x</td>
			<td style="width: 3%; text-align: center;"> </td>
			<td style="width: 3%; text-align: center;">x</td>
			<td style="width: 3%; text-align: center;"> </td>
		</tr>
		<tr>
			<td style="width: 3%; text-align: center;">x</td>
			<td style="width: 3%; text-align: center;"> </td>
			<td style="width: 3%; text-align: center;"> </td>
			<td style="width: 3%; text-align: center;"> </td>
			<td style="width: 3%; text-align: center;">x</td>
		</tr>
		<tr>
			<td style="width: 3%; text-align: center;"> </td>
			<td style="width: 3%; text-align: center;"> </td>
			<td style="width: 3%; text-align: center;">말</td>
			<td style="width: 3%; text-align: center;"> </td>
			<td style="width: 3%; text-align: center;"> </td>
		</tr>
		<tr>
			<td style="width: 3%; text-align: center;">x</td>
			<td style="width: 3%; text-align: center;"> </td>
			<td style="width: 3%; text-align: center;"> </td>
			<td style="width: 3%; text-align: center;"> </td>
			<td style="width: 3%; text-align: center;">x</td>
		</tr>
		<tr>
			<td style="width: 3%; text-align: center;"> </td>
			<td style="width: 3%; text-align: center;">x</td>
			<td style="width: 3%; text-align: center;"> </td>
			<td style="width: 3%; text-align: center;">x</td>
			<td style="width: 3%;"> </td>
		</tr>
	</tbody>
</table>

<p>근데 원숭이는 한 가지 착각하고 있는 것이 있다. 말은 저렇게 움직일 수 있지만 원숭이는 능력이 부족해서 총 K번만 위와 같이 움직일 수 있고, 그 외에는 그냥 인접한 칸으로만 움직일 수 있다. 대각선 방향은 인접한 칸에 포함되지 않는다.</p>

<p>이제 원숭이는 머나먼 여행길을 떠난다. 격자판의 맨 왼쪽 위에서 시작해서 맨 오른쪽 아래까지 가야한다. 인접한 네 방향으로 한 번 움직이는 것, 말의 움직임으로 한 번 움직이는 것, 모두 한 번의 동작으로 친다. 격자판이 주어졌을 때, 원숭이가 최소한의 동작으로 시작지점에서 도착지점까지 갈 수 있는 방법을 알아내는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 정수 K가 주어진다. 둘째 줄에 격자판의 가로길이 W, 세로길이 H가 주어진다. 그 다음 H줄에 걸쳐 W개의 숫자가 주어지는데, 0은 아무것도 없는 평지, 1은 장애물을 뜻한다. 장애물이 있는 곳으로는 이동할 수 없다. 시작점과 도착점은 항상 평지이다. W와 H는 1이상 200이하의 자연수이고, K는 0이상 30이하의 정수이다.</p>

### 출력 

 <p>첫째 줄에 원숭이의 동작수의 최솟값을 출력한다. 시작점에서 도착점까지 갈 수 없는 경우엔 -1을 출력한다.</p>

---

BFS, 최단경로

```java
import java.util.*;
import java.io.*;

class Main {
    
    static class Point {
        int x;
        int y;
        int jump;
        int time;
        
        Point(int x, int y, int jump, int time) {
            this.x = x;
            this.y = y;
            this.jump = jump;
            this.time = time;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int w, h, k;
    static int[][] map;
    static boolean[][][] visited;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    static int[] hdx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] hdy = {-1, 1, -2, 2, -2, 2, -1, 1};
    
    public static void main(String[] args) throws IOException {
        
        k = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        map = new int[h][w];
        visited = new boolean[h][w][k+1];
        
        for(int i=0; i<h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(BFS());
        
    }
    
    static int BFS() {
        Queue<Point> pQ = new LinkedList<>();
        pQ.offer(new Point(0, 0, 0, 0));
        visited[0][0][0] = true;
        
        while(!pQ.isEmpty()) {
            Point cur = pQ.poll();
            
            if(cur.x == h-1 && cur.y == w-1) return cur.time;
            
            // 제자리에서 사방면 이동
            for(int d=0; d<4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                    
                if(!rangeCheck(nx, ny)) continue;
                    
                if(map[nx][ny] == 0 && !visited[nx][ny][cur.jump]) {
                    pQ.offer(new Point(nx, ny, cur.jump, cur.time + 1));
                    visited[nx][ny][cur.jump] = true;
                }
            }
            
            // 점프 횟수가 남은 원숭이는 제자리에서 팔방면도 이동
            if(cur.jump < k) {
                
                for(int d=0; d<8; d++) {
                    int nx = cur.x + hdx[d];
                    int ny = cur.y + hdy[d];
                    
                    if(!rangeCheck(nx, ny)) continue;
                    
                    if(map[nx][ny] == 0 && !visited[nx][ny][cur.jump + 1]) {
                        pQ.offer(new Point(nx, ny, cur.jump + 1, cur.time + 1));
                        visited[nx][ny][cur.jump + 1] = true;
                    }
                }
            }
        }
        
        return -1;
    }
    
    static boolean rangeCheck(int nx, int ny) {
        return nx>=0 && ny>=0 && nx<h && ny<w;
    }
}


```

---

![image](https://github.com/user-attachments/assets/6d02b3ff-100a-402d-bc04-04f692523572)

---

오답 코드

```java
import java.util.*;
import java.io.*;

class Main {
    
    static class Point {
        int x;
        int y;
        int jump;
        int time;
        
        Point(int x, int y, int jump, int time) {
            this.x = x;
            this.y = y;
            this.jump = jump;
            this.time = time;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int w, h, k;
    static int[][] map;
    static boolean[][][] visited;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    static int[] hdx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] hdy = {1, -1, 2, -2, 2, -2, 1, -1};
    
    public static void main(String[] args) throws IOException {
        
        k = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        map = new int[h][w];
        visited = new boolean[h][w][k+1];
        
        for(int i=0; i<h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.print(BFS());
    }
    
    static int BFS() {
        Queue<Point> pQ = new LinkedList<>();
        pQ.offer(new Point(0, 0, 0, 0));
        visited[0][0][0] = true;
        
        while(!pQ.isEmpty()) {
            Point cur = pQ.poll();
            
            if(cur.x == h-1 && cur.y == w-1) return cur.time;
            
            if(cur.jump < k) { // 점프 가능한 원숭이는 제자리에서 '팔방면'만 이동
                
                for(int d=0; d<8; d++) {
                    int nx = cur.x + hdx[d];
                    int ny = cur.y + hdy[d];
                    
                    if(!rangeCheck(nx, ny)) continue;
                    
                    if(map[nx][ny] == 0 && !visited[nx][ny][cur.jump + 1]) {
                        pQ.offer(new Point(nx, ny, cur.jump + 1, cur.time + 1));
                        visited[nx][ny][cur.jump + 1] = true;
                    }
                }
            }
            
            else { // 팔방면을 이동한 원숭이는 제자리에서 사방면을 이동하지 못하게됨.
                for(int d=0; d<4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    
                    if(!rangeCheck(nx, ny)) continue;
                    
                    if(map[nx][ny] == 0 && !visited[nx][ny][cur.jump]) {
                        pQ.offer(new Point(nx, ny, cur.jump, cur.time + 1));
                        visited[nx][ny][cur.jump] = true;
                    }
                }
            }
            
        }
        
        return -1;
    }
    
    static boolean rangeCheck(int nx, int ny) {
        return nx>=0 && ny>=0 && nx<h && ny<w;
    }
}


```

오답 코드 같은 경우, 아래와 같은 케이스에서 시작점에서부터 아예 움직이지 못하게된다.


```
2
8 12
0 0 0 0 0 0 0 0
0 1 1 1 1 1 1 0
0 1 1 1 1 1 1 0
0 1 1 0 0 0 0 0
0 1 1 0 1 1 1 1
0 1 1 0 1 1 1 1
0 1 1 0 0 0 0 0
0 1 1 0 1 1 1 0
0 1 1 1 1 1 1 0
1 1 0 0 0 0 1 1
1 1 1 1 1 1 1 1
1 1 1 0 1 1 0 0
```

오답 코드 같은 경우, 아래와 같은 케이스는 통과된다. 이유는 팔방면으로만 이동하기 때문

```
30
7 10
0 1 1 1 0 1 1
1 1 0 1 1 1 0
1 1 1 1 1 1 1
1 1 1 1 1 0 1
1 1 1 0 1 1 1
1 0 1 1 1 1 1
1 1 1 1 1 1 1
1 1 0 1 1 1 1
1 1 1 1 0 1 1
1 1 1 1 1 1 0
```
