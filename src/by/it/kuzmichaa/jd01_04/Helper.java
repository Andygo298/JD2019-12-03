package by.it.kuzmichaa.jd01_04;

public class Helper {
    static double findMin(double[] arr) {
        if (0 == arr.length) {
            return Double.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double d : arr) {
                if (min > d) min = d;
            }

            return min;
        }
    }

    static double findMax(double[] arr) {
        if (0 == arr.length) {
            return Double.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double d : arr) {
                if (max < d) max = d;
            }
            return max;
        }
    }

    static void sort(double[] arr){
        boolean swap;
        int last = arr.length-1;
        do {
            swap = false;
            for (int i = 0; i < last ; i++) {
                if (arr[i] > arr[i+1]){
                    double buffer = arr[i];
                    arr[i] = arr [i+1];
                    arr[i+1] = buffer;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);
    }

    static double[] mul(double[][] matrix, double[] vector){
            double [] mas = new double[matrix.length];
            for (int i = 0; i < matrix.length ; i++) {
                for (int j = 0; j < vector.length ; j++) {
                    mas[i] = mas[i] + matrix[i][j] * vector[j];
                }
            }
        return mas;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight){
        double[][] mas = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length ; i++) {
            for (int j = 0; j < matrixRight[0].length ; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    mas[i][j] = mas[i][j]+matrixLeft[i][k] * matrixRight[j][k];

                }
            }
        }
        return mas;

    }
}
