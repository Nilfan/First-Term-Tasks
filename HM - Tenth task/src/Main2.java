import java.util.Stack;
import java.util.Vector;

/**
 * Created by НР on 15-Nov-14.
 */
public class Main2 {


    static public boolean InStr(char ch) {
        String str = "+-/*";
        boolean k = false;
        for (int i = 0; i < str.length(); i++) {
            if (ch == str.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    static void Show(Vector<String> arr){
        for(String str: arr){
            System.out.println(str);
        }
    }

    public static void main(String[] arg) throws Exception {


        StringBuilder stringBuilder = new StringBuilder("*/+de-fe+a-rs");

        Vector<String> objects = new Vector<String>();
        StringBuilder signs = new StringBuilder("");
        while (stringBuilder.length() != 0) {
            if (!InStr(stringBuilder.charAt(0))) {
                char ch = stringBuilder.charAt(0);
                objects.add("" + ch);
                stringBuilder.deleteCharAt(0);
                continue;
            } else if (InStr(stringBuilder.charAt(0)) & !InStr(stringBuilder.charAt(1)) & !InStr(stringBuilder.charAt(2))) {
                objects.add("" + stringBuilder.charAt(1) + stringBuilder.charAt(0) + stringBuilder.charAt(2));
                stringBuilder.deleteCharAt(0);
                stringBuilder.deleteCharAt(0);
                stringBuilder.deleteCharAt(0);
                continue;
            } else {
                signs.append(stringBuilder.charAt(0));
                stringBuilder.deleteCharAt(0);
            }
        }
        Show(objects);
        if (signs.length() + 1 != objects.size()) {
            System.out.println("Error");
        } else {
            stringBuilder.append(objects.get(0));

            for (int i = 1; i < objects.size(); i++) {
                stringBuilder.append(signs.charAt(i - 1) + objects.get(i));
            }
            System.out.println(stringBuilder);
            if(stringBuilder.toString().equals("a*(b/c)*(d+e)")){
                System.out.print("Okey");
            }
        }
    }


}

























/*import java.util.Stack;

public class Main {

    static int Priority(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        }
        if (ch == '/' || ch == '*') {
            return 2;
        } else return 0;
    }

    public static void main(String[] args) {
        String input = "+dc*fe+a-rs";
        Stack<StringWP> stack = new Stack<StringWP>();
        for (int i = input.length() - 1; i >= 0; i--) {
            int pr = Priority(input.charAt(i));
            if (pr == 0) {
                stack.push(new StringWP(pr, "" + input.charAt(i)));
            }
            if (pr == 1) {
                StringWP str1, str2;
                str1 = stack.pop();
                str2 = stack.pop();
                stack.push(new StringWP(4, "" + str1.str + input.charAt(i) + str2.str));
            }
            if (pr == 2) {
                StringWP str1, str2;
                str1 = stack.pop();
                str2 = stack.pop();
                if (str1.priority == 4) {
                    str1.str = "(" + str1.str + ")";
                }
                if (str2.priority == 4) {
                    str2.str = "(" + str2.str + ")";
                }
                stack.push(new StringWP(0, "" + str1.str + input.charAt(i) + str2.str));
            }
        }
        System.out.println(stack.pop().str);
    }
}
*/