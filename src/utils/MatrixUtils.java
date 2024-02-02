package utils;

import java.util.Random;

public class MatrixUtils {
    public static double[][] initilizeWeights(int rows, int cols) {
        double[][] weights = new double[rows][cols];

        Random r = new Random(123);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                weights[i][j] = r.nextGaussian();
            }
        }
        return weights;
    }

    public static int getMaxIndex(double[] input) {
        int output = 0;

        for(int i=0; i<input.length; i++) {
            if(input[i] > input[output])
                output = i;
        }

        return output;
    }

    public static double[] multiplyScalar(double[] input, double scalar) {
        double[] output = new double[input.length];

        for(int i=0; i<input.length; i++) {
            output[i] = input[i] * scalar;
        }

        return output;
    }

    public static double[] addArrays(double[] arr1, double[] arr2){
        double[] output = new double[arr1.length];

        for(int i=0; i<arr1.length; i++) {
            output[i] = arr1[i] + arr2[i];
        }

        return output;
    }
}
