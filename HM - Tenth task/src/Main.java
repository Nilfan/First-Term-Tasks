import java.util.Stack;

public class Main {
    //**a/bc+de
    static int Priority(char ch) {
        if (ch == '+') {
            return 1;
        }
        if (ch == '/' || ch == '*') {
            return 2;
        }
        if( ch == '-'){
            return -1;
        }
         else return 0;
    }

    public static void main(String[] args) {
        String input = "*-a/bc--nx/al";
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
                int priority = 1;
                //System.out.println(str1.str + " " + str2.str);
                if (str1.priority != 0) {
                    str1.str = "(" + str1.str + ")";
                    priority = 0;
                }
                if (str2.priority != 0) {
                    str2.str = "(" + str2.str + ")";
                    priority = 0;
                }
                stack.push(new StringWP(priority, "" + str1.str + input.charAt(i) + str2.str));
            }
            if (pr == -1){
                StringWP str1, str2;
                str1 = stack.pop();
                str2 = stack.pop();
                if (str1.priority != 0) {
                    str1.str = "(" + str1.str + ")";
                }
                if (str2.priority != 0) {
                    str2.str = "(" + str2.str + ")";
                }
                stack.push(new StringWP(4, "" + str1.str + input.charAt(i) + str2.str));
            }

        }
        System.out.println(stack.pop().str);
    }
}
