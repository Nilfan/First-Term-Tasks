import java.io.*;

public class Main {


    public static void main(String args[]) {
        File file = new File("StackFile.txt");
        file.delete();
        try {
            file.createNewFile();
        } catch (IOException e) {System.out.println(e);}
        int N = 15;
        MyStack myStack = new MyStack(N);
        myStack.StringInput("Instances of this class support both reading and writing to a random access file. A random access file behaves like a large array of bytes stored in the file system. There is a kind of cursor, or index into the implied array, called the file pointer; input operations read bytes starting at the file pointer and advance the file pointer past the bytes read. If the random access file is created in read/write mode, then output operations are also available; output operations write bytes starting at the file pointer and advance the file pointer past the bytes written. Output operations that write past the current end of the implied array cause the array to be extended. The file pointer can be read by the getFilePointer method and set by the seek method.");
        byte[] a = myStack.pop();
        for(int i = 0; i < N; i++){
            System.out.print((char) a[i]);
        }
        a = myStack.pop();
        System.out.println();
        for(int i = 0; i < N; i++){
            System.out.print((char)a[i]);
        }
    }

}