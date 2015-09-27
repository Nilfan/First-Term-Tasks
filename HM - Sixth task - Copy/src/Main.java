/**
 * Created by НР on 18-Oct-14.
 */
public class Main {


//snubs - щелбаны


    static int Game (int ans, int leftBorder, int rightBorder){
        int snubs = 0, step = (rightBorder - leftBorder)/2, guess = leftBorder + step;
        System.out.println("Check " + guess + " " + step);
        snubs += MoreLess(ans, guess);
        while (ans != guess) {

            if (ans > guess) {leftBorder = guess;}
            else {rightBorder = guess;}



            step = (rightBorder - leftBorder)/2;
            guess = leftBorder + step;
            int sn = MoreLess(ans, guess);



            snubs += sn;

            step = step/2 ;
            //System.out.println("Check " + guess + " " + step);
        }

        return snubs;
    }


    static int NewGameF (int ans){
        System.out.println("\ni = " + ans);
        int t = 0,
            i = 0,
            a1 = 21,
            a2 = 13,
            guess = 1,
            snubs = 0,
            border1 = 34,
            border2 = 67,
            arr[] = new int [10];

        for(int j = 0; j < 10; j++){
            arr[j] = 0;
        }

        if(ans == border1) return 0; // Первая догадка - 34
        if(ans == guess) return 2;       // Если первая принесла два щелбана, то предполагаем 1
        if(ans == border2) return 1; // Вторая догадка - 67



        if (ans < border1){
            guess = 1;
            snubs = MoreLess(ans, border1) + MoreLess(ans, guess);
            arr[i] = border1;
            i++;
        }
        else if (ans < border2  ){
            guess = border1;
            snubs = MoreLess(ans, border1) + MoreLess(ans, border2);
            arr[i] = border1;
            i++;
            arr[i] = border2;
            i++;
        }
        else if (ans > border2){
            guess = border2;
            snubs = MoreLess(ans, border1) + MoreLess(ans, border2);
            arr[i] = border2;
            i++;
        }
        int sn , snPrevious , guessPrevious;

        do{
            guessPrevious = guess;
            sn = MoreLess(ans,guess);
            snPrevious = sn;
            if(InList(arr, guess) == 0){
                arr[i] = guess;
                i++;
            }
            while(InList(arr, guess) != 0 && ans != guess){
                int k = a1;
                a1 = a2;
                a2 = k - a2;

                sn = MoreLess(ans,guess);
                if (sn == 2){
                    guess -= a1;
                }
                else if(sn == 1){
                    guess += a1;
                }
            }

            sn = MoreLess(ans,guess);

            snubs += MoreLess(ans,guess);


        }while(snPrevious == sn  && (ans != guess));
        System.out.println("CheckPR " + guess + " " + guessPrevious + " " + sn + " " + snPrevious);
        if (ans != guess) {
            snubs += Game(ans, Min(guess, guessPrevious),Max(guess, guessPrevious) );
        }



        //System.out.println();

        /*for(int l: arr){
            System.out.print(l + " " );
                }
        *///System.out.println();

        return snubs ;



    }

    static int MoreLess(int ans,int guess){
        if (ans > guess) {return 1;}
        else if (ans < guess) {return 2;}
        else return 0;
    }

    static int InList (int arr[], int guess){
        int k = 0;
        for(int i: arr){
            if (guess == i) k = i;
        }
        return  k;
    }

    static int Min (int x, int y){
        if (x > y) return y;
        else return x;
    }

    static int Max (int x, int y){
        if (x < y) return y;
        else return x;
    }



    public static void main(String[] args){


        int k = 0, snubs, j = 0;

        for (int i = 1; i < 101; i++) {

            snubs = NewGameF(i);
            if(snubs == 10){
                System.out.println("i = " + i + "  Snubs ==================================> " + snubs);
            }

            System.out.println("i = " + i + "  Snubs = " + snubs);

            //System.out.println();
            //System.out.println();
            if (k < snubs) {k = snubs; j = i;}
        }

        System.out.println("Max = " + k + " " + j);


    }
}
