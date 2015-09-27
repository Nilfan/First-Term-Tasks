
public class Tester {
    int[] arr;
    int n;
    Tester(int N) {
        n = N;
        arr = new int[(int) Math.pow(2, n)];
        int bins;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
        StringBuilder stb;
        for (int i = 1; i < arr.length; i++) {
            stb = new StringBuilder();
            bins = n - 1 - (int) (Math.log(i) / Math.log(2));
            for (int j = 1; j <= bins; j++) {
                stb.append('0');
            }
            stb.append(Integer.toBinaryString(i));
            stb.reverse();
            int num = Integer.valueOf(stb.toString(), 2);

            if (num < arr.length && i > num) {
                int k = arr[num];
                arr[num] = arr[i];
                arr[i] = k;
            }

        }
        System.out.println('\n');

    }
    public int[] test(){
        return arr;
    }
}