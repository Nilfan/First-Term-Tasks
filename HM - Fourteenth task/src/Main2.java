/**
 * Created by НР on 18-Dec-14.
 */
import java.util.*;

public class Main2{

    public static List<Integer>[] Graph6(){
        int n = 6;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}, {2, 3}, {3, 4}, {4, 5}, {3, 5}};
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        return graph;
    }

    public static List<Integer>[] Graph7(){
        int n = 7;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}, {2, 3}, {3, 4}, {4, 5}, {3, 5}, {0,6}};
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        return graph;
    }

    public static List<Integer>[] Graph9(){
        int n = 9;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {1, 3}, {3, 4}, {3, 6}, {3, 5},{4, 6},{5, 7},{0, 8}};
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }



    public static void main(String[] args) {


        List<Integer>[] graph = Graph9();
        ComponentsLists bc = new ComponentsLists();
        List<List<Integer>> components = bc.biconnectedComponents(graph);

        System.out.println("biconnected components:" + components);
        System.out.println("cutPoints: " + bc.cutPoints);
        System.out.println("bridges:" + bc.bridges);


    }
}