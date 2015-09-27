/**
 * Created by НР on 18-Oct-14.
 */
public class Main {

//snubs - щелбаны

    static int Search(int ans, int leftBorder, int rightBorder) {
        int guess, shift = (rightBorder - leftBorder) / 3 + 1;
        if ((3 + rightBorder % 3 - leftBorder % 3) % 3 == 2) {
            shift++;
        }
        guess = leftBorder + shift;
        if (guess - 1 > ans) {
            return Search(ans, leftBorder, guess - 2) + 2;
        }
        if (guess - 1 < ans) {
            return Search(ans, guess, rightBorder) + 1;
        } else {
            return 0;
        }

    }

    public static void main(String[] args) {
        int max = 0, snubs = 0, j = 0;
        for (int i = 1; i <= 100; i++) {
            snubs = Search(i, 1, 100);
            System.out.println("i = " + i + "  Snubs = " + snubs);
            if (max < snubs) {
                max = snubs;
                j = i;
            }
        }
        System.out.println("Max = " + max + " " + j);
        if(max == 9){
            System.out.println("Okey");
        }
    }
}
