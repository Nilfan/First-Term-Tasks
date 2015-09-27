import java.util.Stack;
import java.util.Vector;

public class Main {

    static boolean test(Stack<Integer> stack){
        Stack<Integer> testStack = new Stack<Integer>();
        testStack.add(6);
        testStack.add(7);
        testStack.add(2);
        testStack.add(1);
        testStack.add(0);
        testStack.add(3);
        testStack.add(5);
        testStack.add(8);
        testStack.add(4);
        if(stack.equals(testStack)){
            return true;
        }
        else return false;
    }

    public static void main(String[] args){
        int N = 9;
        Topsort topsort = new Topsort(N);
        for(int i = 0; i < N; i++) {
            topsort.dfs(i);
        }
        if(test(topsort.stack)){
            System.out.println("False");
        }
        else {
            int time = 0;
            for (int i = 0; i < N; i++) {
                System.out.println("Task " + topsort.stack.peek() + " begins in " + time);
                time += topsort.stack.pop();
            }
            System.out.println("Okey");
        }
    }

}
