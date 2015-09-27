import java.io.*;
import java.util.*;


public class Main {
    public static void main(String args[]){
        HashMap<String,Integer> hashMap = new HashMap<String, Integer>();
        String str = Test.getString(2000000).toString();
        Scanner scanner = new Scanner(str);
        while (scanner.hasNext()) {
            String nextString = scanner.next();
            if(!hashMap.containsKey(nextString)){
                hashMap.put(nextString,1);
            }
            else {
                hashMap.put(nextString,hashMap.get(nextString) + 1);
            }
        }
        for(int i = 0; i < Test.nums.length;i++){
            if(hashMap.get(Test.nums[i]) != null) {
                if (Test.A[i] == hashMap.get(Test.nums[i])) {
                    System.out.println( i + " is Okey");
                }
                else System.out.println(i + " is NotOkey");
            }
            else System.out.println(i + " is Okey");
        }
        System.out.println(hashMap.entrySet());
    }
}
