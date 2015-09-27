import java.io.*;

/**
 * Created by НР on 26-Oct-14.
 */
public class Tester {


    public String alp;
    public FileOutputStream outfile;


    Tester(){
        try {
            outfile = new FileOutputStream("Input.txt");

            for (int i = 0; i < 1000; i++) {
                int k = 64 + (int) (Math.random() * 26);
                if(k == 64){k = 32;}

                outfile.write((char) k);
                }
            outfile.write(' ');
            outfile.write(' ');
            outfile.close();
            }
            catch (FileNotFoundException e){System.out.println(e + "1");}
            catch (IOException e) {System.out.println(e + "2");}


        }

        void TestStr (StringBuilder strbui){
            char ch = '1',chPr = '1';
            int sym = 100;
            try{
            FileInputStream file = new FileInputStream("Input.txt");
            while ((chPr != ' ' || sym != ' ') && sym != -1){
                chPr = ch;
                sym = file.read();
                ch = (char)sym;
            }
            }catch(Exception e){System.out.println(e);}
            if(sym != -1){
                System.out.println("Ok");
            }
            else {
                System.out.println("Not Ok");
            }
        }

}


