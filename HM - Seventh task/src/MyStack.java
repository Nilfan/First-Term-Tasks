import java.util.*;
import java.io.*;


public class MyStack {
    byte[] stack;
    int point;
    int N;
    int counter;
    int head;


    MyStack(int n) {
        N = n;
        stack = new byte[2*n];
        point = 0;
        counter = 0;
        head = 0;

    }


    public void StringInput(String str){
        for(int i = 0; i < str.length(); i++){
            push((byte) str.charAt(i));
        }
    }

    public void push(byte a){
        if(counter == 2*N){
            FileInsert();
        }
        stack[(counter + head)%(2*N)] = a;
        counter++;
    }

    public void FileInsert(){
        try{
            RandomAccessFile raf = new RandomAccessFile(new File("StackFile.txt"), "rwd");
            byte[] byteArray = new byte[N];
            for(int i = 0; i < N; i++){
                byteArray[i] = stack[head + i];
            }
            raf.seek(point);
            raf.write(byteArray);
            this.point += N;
            head = (head + N) % (2*N);
            counter = N;
            raf.close();
        }catch (Exception e){System.out.println(e+ " Check FileInsert");}
    }

    public byte[] pop() {
        byte[] array = new byte[N];
        for (int i = 0; i < N; i++) {
            array[i] = 0;
        }
        if (counter >= N) {
            for (int i = 0;  i < N; i++) {
                array[i] = stack[(head + counter - N + i)%(2*N)];
            }
            counter -= N;
        } else {
            try {
                for (int i = 0; i < counter; i++) {
                    array[i + N - counter] = stack[head + i];
                }
                RandomAccessFile raf = new RandomAccessFile(new File("StackFile.txt"), "r");
                point = point -  (N - counter);
                if(point > 0){
                    raf.seek(point);
                }
                else{
                    point = 0;
                }

                for (int i = 0; i < N - counter && point - i > 0; i++) {
                    array[i] = raf.readByte();
                }
                counter = 0;
                raf.close();

            } catch (Exception e) {System.out.println(e + " Check OpenFile");}
        }
        return array;
    }

    public String test(int N, String str){
        for(int i = 0; )
    }

}
