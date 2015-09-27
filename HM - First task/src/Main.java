import java.io.*;


public class Main {
    static void ReadingInFile(FileInputStream file, StringBuilder strBui) {
        int sym = '1', lastSym = 0;
        try {
            lastSym = file.read();
            while(lastSym != -1 & ((char)lastSym != ' ' || (char)sym != ' ')){
                strBui.append((char) lastSym);
                sym = lastSym;
                lastSym = file.read();
                System.out.println((char)lastSym + " " + (char)sym);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        Tester tester = new Tester();
        StringBuilder strbui = new StringBuilder();
        try {
            FileInputStream file = new FileInputStream("Input.txt");
            ReadingInFile(file,strbui);
        } catch (FileNotFoundException e) {
            System.out.print("Error1 :" + e);
        }
        System.out.println(strbui.reverse());
        tester.TestStr(strbui);
    }
}


//static String str = "";

        /*static void Reading (char last){

            int b = 0;
            byte bi[] = new byte[1000];
            try {
                b = System.in.read();

            } catch (Exception e) {
                System.out.println("Catch " + e);
            }
            if ((char)b != ' ' | last != ' ') Reading((char) b);

            str += (char)b;
        }*/


    /* static  void CopyFile(FileInputStream file){
            int i = 0;
            try{
                FileInputStream copy = new FileInputStream("Copy.txt");
                do{
                    i = file.read();
                    if (i != -1) copy;
                }
                file.close();
                System.out.println(copy);
            } catch (Exception e) {System.out.println(e);}

        }*/