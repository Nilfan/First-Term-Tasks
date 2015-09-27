import java.lang.*;
import java.util.*;


public class Main {


    static Stack<Integer> Nonrecursive(int N){
        Stack<Integer> R = new Stack<Integer>();
        int[] positions = new int[N+1];
        for(int i = 0; i < N+1; i++){
            positions[i]=0;
        }
        int a = N%2 == 0 ? 1 : 0;

        for(int i = 1; i < (int)Math.pow(2,N); i++) {
            int ring = NumOfRing(i, 1 << N);
            int nextPosition = (positions[ring] + 3 + (int) Math.pow(-1, ring + a)) % 3;
            positions[ring] = nextPosition;
            R.push(ring);
            System.out.print(ring + " " );
        }
        return  R;
    }

    static int NumOfRing(int spot, int N){
        int a =  (N - 1)^spot ;
        a = (a + 1) & spot;
        a = ((int) (Math.log10(a) / Math.log10(2)) + 1);
        return a;
    }

    static Stack<Integer> FillStack(int N){
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = N; i > 0 ; i--){
            stack.push(i);
        }
        return stack;
    }

    static Stack<Integer> RecursiveMethod(int N){
        Stack<Integer> A = FillStack(N);
        Stack<Integer> B = new Stack<Integer>();
        Stack<Integer> C = new Stack<Integer>();
        Stack<Integer> R = new Stack<Integer>();
        if(N != 0){
            Transposition(N, A, B, C, R);
        }
        return R;
    }

    static void Transposition(int N, Stack<Integer> A, Stack<Integer> B, Stack<Integer> C, Stack<Integer> R){
        if(N == 1){
            C.push(A.pop());
            R.push(C.peek());
        }
        else{
            Transposition(N-1, A, C, B, R);
            C.push(A.pop());
            R.push(C.peek());
            Transposition(N-1, B, A, C, R);
        }

    }

    public static void main(String[] args) {

        int N = 7;

        Stack stack2 = RecursiveMethod(N);

        if(stack2.equals(Nonrecursive(N))){
            System.out.println("Okey");
        };

    }
}
