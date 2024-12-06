package SS3;

public class MatrixMaxValue {
    public static void main(String[] args) {
        // Khởi tạo nhanh ma trận 2 chiều
        double[][] matrix = {
                {1.2, 4.5, 6.7},
                {8.9, 3.4, 2.1},
                {7.8, 9.6, 5.5}
        };

        double maxValue = matrix[0][0];
        int maxRow = 0, maxCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > maxValue) {
                    maxValue = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println("Phần tử lớn nhất trong ma trận: " + maxValue);
        System.out.println("Tọa độ: [" + maxRow + ", " + maxCol + "]");
    }
}
