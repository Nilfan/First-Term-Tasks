import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by НР on 20-Dec-14.
 */
public class ComponentsLists {

    List<Integer>[] graph;
    boolean[] visited;
    Stack<Integer> stack;
    int time;
    int[] tin;
    int[] lowlink;
    List<List<Integer>> components;
    List<Integer> cutPoints;
    List<String> bridges;

    public List<List<Integer>> biconnectedComponents(List<Integer>[] graph) {
        int n = graph.length;
        this.graph = graph;
        visited = new boolean[n];
        stack = new Stack<Integer>();
        time = 0;
        tin = new int[n];
        lowlink = new int[n];
        components = new ArrayList<List<Integer>>();
        cutPoints = new ArrayList<Integer>();
        bridges = new ArrayList<String>();

        for (int u = 0; u < n; u++) {
            if (!visited[u])
                DFS(u, -1);
        }
        for(int i = components.size() - 1; i >= 0; i--){
            if(components.get(i).size() < 2){
                components.remove(i);
            }
        }
        return components;
    }

    void DFS(int u, int p) {
        visited[u] = true;
        lowlink[u] = tin[u] = time++;
        stack.add(u);
        int children = 0;
        boolean cutPoint = false;
        for (int v : graph[u]) {
            if (v == p)
                continue;
            if (visited[v]) {

                lowlink[u] = Math.min(lowlink[u], tin[v]);
            } else {
                DFS(v, u);
                lowlink[u] = Math.min(lowlink[u], lowlink[v]);
                cutPoint |= lowlink[v] >= tin[u];
                if (lowlink[v] > tin[u])
                    bridges.add("(" + u + "," + v + ")");
                ++children;
            }
        }
        if (p == -1)
            cutPoint = children >= 2;
        if (cutPoint)
            cutPoints.add(u);
        if (lowlink[u] == tin[u]) {
            List<Integer> component = new ArrayList<Integer>();
            while (true) {
                int x = stack.pop();
                component.add(x);
                if (x == u)
                    break;
            }
            components.add(component);
        }
    }
}
