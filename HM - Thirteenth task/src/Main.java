import java.util.*;

public class Main {

    static int GetRoad(int a, int b, HashSet<Edge> hashSet){
        if (a == b) {
            //System.out.println("Выбрано только одно ребро " + a + " " + 0);
            return 0;
        }
        Edge edge = new Edge(a,b);
        if(hashSet.contains(edge)){
            return 1;
        }
        else{
            return -1;
        }
    }

    static void PutRoad(int a, int b,  HashSet<Edge> hashSet){
        if(a == b){
            //System.out.println("Выбрано только одно ребро " + a);
            return;
        }
        Edge edge = new Edge(a,b);
        hashSet.add(edge);
        //System.out.println("Добавлено ребро " + a + "<->" + b + " длинной " + length);
        return;
    }


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

    static void Test(HashSet<Edge> hashSet){
        PutRoad(1, 10,  hashSet);
        PutRoad(10, 2,  hashSet);
        PutRoad(40, 30,  hashSet);
        PutRoad(5, 2,  hashSet);

        if(GetRoad(1, 1, hashSet) == 0) { // Выбрана одна и та же вершина
            System.out.println("Okey");
        } else System.out.println("Not okey");

        if(GetRoad(2, 10, hashSet) == 1) { // Найти ребро длиной 10
            System.out.println("Okey");
        } else System.out.println("Not okey");

        if(GetRoad(40, 30, hashSet) == 1) { // Найти ребро длиной 11
            System.out.println("Okey");
        } else System.out.println("Not okey");

        if(GetRoad(6, 3, hashSet) == -1) { // Поиск несуществующего ребра
            System.out.println("Okey");
        } else System.out.println("Not okey");
    }


    public static void main(String[] args){
        HashSet<Edge> hashSet = new HashSet<Edge>();
        Test(hashSet);
    }
}
