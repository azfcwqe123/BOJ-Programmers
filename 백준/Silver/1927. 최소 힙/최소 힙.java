import java.util.*;
import java.io.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        
        MinHeap heap = new MinHeap();
        
        while(n-- > 0) {
            int k = Integer.parseInt(br.readLine());
            
            if(k == 0) sb.append(heap.delete()).append('\n');
            else heap.insert(k);
        }
        
        System.out.print(sb);
    }
    
}

class MinHeap {
    
    private ArrayList<Integer> heap;
    
    public MinHeap() {
        heap = new ArrayList<>();
        heap.add(0);
    }
    
    public void insert(int val) {
        heap.add(val);
        
        int cur_idx = heap.size() - 1;
        int par_idx = cur_idx / 2;
        
        while(cur_idx > 1 && (val < heap.get(par_idx))) {
            int tmp = heap.get(par_idx);
            heap.set(par_idx, val);
            heap.set(cur_idx, tmp);
            
            cur_idx = par_idx;
            par_idx = cur_idx / 2;
        }
    }
    
    public int delete() {
        if(heap.size() == 1) return 0;
        
        int root = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        
        int cur_idx = 1;
        while(cur_idx * 2 < heap.size()) {
            
            int lt_idx = cur_idx * 2;
            int rt_idx = cur_idx * 2 + 1;
            
            int min_idx = lt_idx;
            int min_val = heap.get(lt_idx);
            
            if(rt_idx < heap.size() && min_val > heap.get(rt_idx)) {
                min_val = heap.get(rt_idx);
                min_idx = rt_idx;
            }
            
            if(min_val > heap.get(cur_idx)) break;
            
            int tmp = heap.get(cur_idx);
            heap.set(cur_idx, heap.get(min_idx));
            heap.set(min_idx, tmp);
            cur_idx = min_idx;
        }
        
        return root;
    }
}

