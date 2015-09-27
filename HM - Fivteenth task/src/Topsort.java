import java.util.*;


public class Topsort {
    List<Integer>[] graph;
    boolean[] used;
    boolean[] inStack;
    Stack<Integer> stack;
    int[] weights;

    Topsort(int N) {
        //int[][] array = {{0, 2}, {1, 6}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 5}};
        graph = new Vector[N];
        inStack = new boolean[N];
        used = new boolean[N];
        weights = new int[]{2, 4, 6, 4, 8, 4, 6, 1, 9};
        int[][] array = {{0, 3}, {0, 4}, {1, 4}, {3, 4}, {3, 5}, {5, 8}, {6, 5}, {6, 7}, {7, 8}};
        for (int i = 0; i < N; i++) {
            graph[i] = new Vector<Integer>();
        }
        for (int[] arr : array) {
            graph[arr[0]].add(arr[1]);
        }
        stack = new Stack<Integer>();

    }

    public void dfs(int pos) {
        this.used[pos] = true;
        for (int next : this.graph[pos])
            if (!this.used[next])
                dfs(next);
        if (!inStack[pos]) {
            inStack[pos] = true;
            stack.push(pos);
        }


    }
}