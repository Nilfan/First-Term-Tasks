/**
 * Created by НР on 30-Nov-14.
 */
public class Test {
    static int[] A = new int[11];

    static public String nums[] = {"zero","one","two","three","four","five","six","seven","eight","nine","ten"};

    static public StringBuilder getString (int N){
        for(int i = 0; i < A.length; i++){
            A[i] = 0;
        }
        StringBuilder strb = new StringBuilder("");
        for(int i = 0; i <= N; i++){
            int number = (int)(Math.random()*10);
            strb.append(nums[number] + " ");
            A[number]++;
        }
        return strb;
    }

}
