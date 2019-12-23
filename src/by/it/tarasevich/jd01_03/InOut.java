package by.it.tarasevich.jd01_03;

public class InOut {
    static double[] getArray(String line) {
        String[] str = line.split(" ");
        double[] result = new double[str.length];
        for (int i = 0; i < str.length; i++) {
            result[i] = Double.parseDouble(str[i]);
        }
        return result;
    }

    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=% -10.2f", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || (i + 1) == arr.length)
                System.out.println();
        }
    }
}
