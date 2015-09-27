
public class Main {


    public static void main(String[] args) {
        int N = 7;
        int arr[] = new int[(int) Math.pow(2, N)];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int x = i;
            int b = 0;
            for (int j = N; j > 0; j--) {
                b <<= 1;
                b |= x & 1;
                x >>= 1;

            }
            if (i > b) {
                x = arr[b];
                arr[b] = arr[i];
                arr[i] = x;
            }
        }
        Tester tester = new Tester(N);
        boolean k = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != tester.arr[i]) {
                k = false;
            }
        }
        if (k) {
            System.out.println("Ok ");
        } else System.out.println("Error");
    }
}
