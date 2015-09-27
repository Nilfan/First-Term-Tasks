import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static void Sort(int leftBorder, int rightBorder, int[] arr, int k){
        int L = leftBorder, R = rightBorder, x = arr[k];
        do  {
            while (arr[L] < x) L++;
            while (arr[R] > x) R--;
            if (R >= L) {
                int num = arr[L];
                arr[L] = arr[R];
                arr[R] = num;
                L++;
                R--;
            }
            View(arr);
            System.out.println(L + " " + R);
        }while ((L < R));
        if (L <= k) {
            Sort(L, rightBorder, arr, k);
        }
        if(R >= k){
            Sort(leftBorder, R, arr, k);
        }
    }

    static void Test(int arr[], int num, int k){
        Arrays.sort(arr);
        if(arr[k] == num){
            System.out.println("Okey");
        }
        else {
            System.out.println("Grust");
        }
    }

    static void View(int[] arr){
        for(int i = 1; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void SortFromFile (int correctNum){
        int arr[] = null;
        try{
            String str ;
            StringTokenizer sto;
            BufferedReader reader = new BufferedReader(new FileReader("Input.txt"));
            str = reader.readLine();
            sto = new StringTokenizer(str);
            arr = new int [sto.countTokens()+1];
            int i = 0;
            while(sto.hasMoreTokens()){
                i++;
                arr[i] = Integer.parseInt(sto.nextToken());
            }
        }
        catch (NullPointerException e){System.out.println(e);}
        catch (IOException e) {System.out.println(e);}
        System.out.println(arr);
        Sort(1, arr.length-1, arr, correctNum);
        View(arr);
        System.out.println(correctNum + " число по возрастанию это" + arr[correctNum]);
    }

    static public void main(String[] args){
        int[] arr = new int [] {0, 4, 4, 17, 12, 32,  11, 3, 2,6, 1,  1, 3,  3, 1};
        int[] arr2 = new int [] {0, 4, 4, 17, 12, 32,  11, 3, 2,6, 1,  1, 3,  3, 1};
        int correctNum = 5;
        Sort(1, arr.length-1, arr, correctNum);
        //SortFromFile(correctNum);
        View(arr);


        System.out.println(correctNum + " число по возрастанию это " + arr[correctNum]);
        Test(arr2, arr[correctNum], correctNum);
    }

}
