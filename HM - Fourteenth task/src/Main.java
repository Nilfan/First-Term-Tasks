import java.util.HashSet;

public class Main {

    static int Max(int a, int b){
        if(a > b) return a;
        else if(a < b) return b;
        else return 0;
    }

    static int Min(int a, int b){
        if(a < b) return a;
        else if(a > b) return b;
        else return 0;
    }


    public static void main(String[] args){
        ListsOfEdges listsOfEdges = new ListsOfEdges(9);
        listsOfEdges.FillLists();
        listsOfEdges.Algo();


    }
}
