import java.util.Date;
import java.util.Random;

/**
 * Created by НР on 08-Nov-14.
 */
public class Main {

    static double[] FillMatrix(int n){
        double[] matrix = new double[n * n];
        Random rand = new Random();
        for(int i = 0; i < matrix.length; i++){
            matrix[i] = rand.nextInt()%100;
        }
        return matrix;
    }

    static void ShowMatrix (double[] matrix, int n){
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(matrix[i*n + j] + "|");
            }
            System.out.println();
        }
    }

    static double[] Transpose(double[] matrix, int n){
        for(int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++) {
                double num = matrix[i*n + j];
                matrix[i*n + j] = matrix[j*n + i];
                matrix[j*n + i] = num;
            }
        }
        return matrix;
    }

    static double[] WithTranspose(double[] matrix1, double[] matrix2, int n){
        double[] thirdMatrix = new double[matrix1.length];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
            thirdMatrix[i*n + j] = 0;
                for (int k = 0; k < n; ++k){
                    thirdMatrix[i * n + j] += ( thirdMatrix[i * n + k] * thirdMatrix[j * n + k] );
                }
            }
        }
        return thirdMatrix;
    }

    static double[] WithoutTranspose(double[] matrix1, double[] matrix2, int n){
        double[] thirdMatrix = new double[matrix1.length];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                thirdMatrix[i*n + j] = 0;
                for (int k = 0; k < n; ++k){
                    thirdMatrix[i * n + j] += ( thirdMatrix[i * n + k] * thirdMatrix[k * n + j] );
                }
            }
        }
        return thirdMatrix;

    }


    public static void main(String arg[]){



        for(int i = 2; i < 12;i ++){
            int N = (int)Math.pow(2,i);
            double[] matrix1 = FillMatrix(N);
            double[] matrix2 = FillMatrix(N);


            long startTime1 = System.nanoTime();
            WithoutTranspose(matrix1,matrix2, N);
            long time1 = System.nanoTime() - startTime1;

            matrix1 = FillMatrix(N);
            matrix2 = FillMatrix(N);

            matrix2 = Transpose(matrix2,N);
            long startTime2 = System.nanoTime();
            WithTranspose(matrix1,matrix2,N);
            long time2 = System.nanoTime() - startTime2;

            System.out.println("Размерность матриц = " + N + "\nБез транспонирования = " + time1/Math.pow(N,3) + "\nТранспонирования = " + time2/Math.pow(N,3));
            System.out.println("Ассимптотическая разница = " + (double)(time2 - time1)/Math.pow(N,3)+ "\n\n");
        }




        long startTime1 = System.nanoTime();
        long time1 = System.nanoTime();



    }
}
