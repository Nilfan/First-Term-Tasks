import java.util.*;


public class ListsOfEdges {
    List<Integer>[] lists;
    int N;

    ListsOfEdges(int n){
        N = n+1;
        lists = new List[N];
        for(int i = 0; i < N ; i++){
            lists[i] = new Stack<Integer>() ;
        }
    }

    public void AddEdge(int a, int b){
        if(a == b){
            System.out.println("Error: a == b");
            return;
        }
        if(a < N && b < N){
            lists[a].add(b);
            lists[b].add(a);
        }
        else{
            System.out.println("Wrong input: a > N or b > N");
        }
    }

    public void FillLists(){

        AddEdge(1,2);
        AddEdge(1,3);
        AddEdge(2,3);
        AddEdge(2,4);
        AddEdge(4,5);
        AddEdge(4,7);
        AddEdge(4,6);
        AddEdge(5,7);
        AddEdge(6,8);
        AddEdge(1,9);
    }



    public void Algo(){
        int[] connections = new int[N];
        for(int i = 0; i < N; i++){
            connections[i] = lists[i].size();
        }
        ArrayList<Stack> simpleCycles = new  ArrayList<Stack>();
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[N];
        int parent = 1;
        int p = 1;
        int compn = 0;
        int k = 0;
        visited[p] = true;
        stack.push(p);
        while(!stack.empty()){
            if(!lists[p].isEmpty() && k < lists[p].size()) {
                if (!visited[lists[p].get(k)]) {
                    parent = p;
                    p = lists[p].get(k);
                    lists[parent].remove(k);
                    stack.push(p);
                    visited[p] = true;
                    k = 0;
                } else {
                    int son = lists[p].get(k);
                    if (parent != son) {
                        simpleCycles.add(compn,new Stack<Integer>() );
                        Stack<Integer> cycleStack = simpleCycles.get(compn);
                        cycleStack.add(lists[p].get(k));
                        for (int i = stack.size() - 1; lists[p].get(k) != stack.get(i); i--) {
                            cycleStack.add(stack.get(i));
                        }
                        cycleStack.add(lists[p].get(k));
                        compn++;
                    }
                    k++;
                }
            }
            else{
                visited[stack.peek()] = false;
                stack.pop();

                if(stack.size() > 1){
                    int temp = stack.pop();
                    parent = stack.peek();
                    stack.push(temp);
                }
                else{
                    parent = 1;
                }
                if(!stack.empty()) p = stack.peek();
                k = 0;
            }
        }
        int[] inCompon = new int[N];
        for(int i = 0; i < N; i++){
            inCompon[i] = -1;
        }
        Stack<Edge>[] edgeStacks = new Stack[simpleCycles.size()];
        for(int i = 0; i < simpleCycles.size(); i++){
            edgeStacks[i] = new Stack<Edge>();
        }
        HashSet<Edge> hashSet = new HashSet<Edge>();
        int count = 0;
        System.out.println("Components:");
        for(int i = 0; i < simpleCycles.size(); i++){
            Stack<Integer> cycleStack = simpleCycles.get(count);
            int numberComp = count;
            if(i != 0){
                for(int j = 0; j < cycleStack.size(); j++) {
                    if (inCompon[cycleStack.get(j)] > -1) {
                        numberComp = inCompon[cycleStack.get(j)];
                        break;
                    }
                }
            }
            else{
                numberComp = count;
                count++;
            }
            for(int j = 0; cycleStack.size() - 1 > j; j++){
                Edge edge = new Edge(cycleStack.get(j),cycleStack.get(j+1));
                inCompon[cycleStack.get(j)] = numberComp;
                if(!hashSet.contains(edge)){
                    edgeStacks[numberComp].push(edge);
                    hashSet.add(edge);
                }
            }
            if(!edgeStacks[i].empty()){
                System.out.println(i+1 + ") " + edgeStacks[i].toString());
            }
        }
        System.out.println("\nBridges:");
        stack.clear();

        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        for(int i = 1; i < lists.length;i++){
            for (int j = 0; j < lists[i].size(); j++){
                p = lists[i].get(j);
                if(inCompon[p] != inCompon[i] || (inCompon[p] == -1 && inCompon[i] == -1)){
                    System.out.println("[" + p + " " + i + "]");
                    if(connections[p] > 1){
                        treeMap.put(p,p);
                    }
                    if(connections[i] > 1) {
                        treeMap.put(i, i);
                    }
                }
            }

        }
    System.out.println("\nPoints:\n" + treeMap.keySet());
    }




}
