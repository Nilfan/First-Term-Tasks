import java.util.*;


public class Main {

    static int[] QS(int[] A, int l, int r){
        if(l>=r){
            return A;
        }
        int m = Partition(A,l,r);
        QS(A,l,m-1);
        QS(A,m+1,r);
        return A;
    }

    static int Partition(int[] A,int l,int r){
        int i = l-1;
        for(int j = l; j <=r; j++){
            if(A[j] <= A[r]){
                int num = A[j];
                A[j] = A[i+1];
                A[i+1] = num;
                i++;
            }
        }
        return i;
    }


    static void qsort(Vector<Integer> vector, int[] A){

        Vector<Integer> newVector = new Vector<Integer>();
        newVector.add(-1);
        int k = 0;
        for(int count = 0; count < vector.size()-1; count ++ ){
            int L = vector.get(count) + 1;
            int R = vector.get(count + 1) - 1;
            if(L >= R){
                continue;
            }
            int i = L - 1;
            for(int j = L; j <= R; j++){
                if(A[j] <= A[R]){
                    int num = A[j];
                    A[j] = A[i+1];
                    A[i+1] = num;
                    i++;
                }
            }
            if(i != L - 1) newVector.add(i);
        }

        newVector.add(vector.get(vector.size()-1));
        //System.out.println(i);
        if(newVector.size() < Math.sqrt(A.length))qsort(newVector,A);
        return;
    }

    static void QuickSort(Vector<Integer> vector, int l, int r){
        do {
            int i = l, j = r, med = vector.get((i + j) / 2);

            do {
                while (vector.get(i) < med) i++;
                while (vector.get(j) > med) j--;
                if (i <= j){
                    if (i < j) {
                        int n = vector.get(i);
                        vector.set(i, vector.get(j));
                        vector.set(j, n);
                    }
                    i++;
                    j--;
                }
            } while (i <= j);
            if (j - l < r - i){
                if (l < j) QuickSort(vector, l, j);
                l = i;
            } else{
                if (i < r) QuickSort(vector, i, r);
                r = j;
            }
        } while (l != r);
    }



    public static void main(String[] args){
        Vector<Integer> vector = new Vector<Integer>();
        int A[] = new int[1000];
        for(int i = 0; i < 1000; i++){
            int num = (int) (Math.random() * 1000);
            vector.add(num);
            A[i] = num;
        }
        QuickSort(vector,0,vector.size()-1);
        Arrays.sort(A);
        boolean check = true;
        for(int i = 0; i < vector.size(); i++){
            if(A[i] != vector.get(i)) check = false;
        }
        if(check){
            System.out.println("Okey");
        }
        else{
            System.out.println("Not okey");
        }
    }

}
