package BISHI.Codesignal.databricks;

public class blackAndWhiteImage {
    public static void main(String[] args) {
        int[][] image = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int radius = 1;

        int[][] updatedImage = solution(image, radius);
        printImage(updatedImage);
    }

    public static int[][] solution(int[][] image, int radius) {
        int rows = image.length;
        int cols = image[0].length;
        int[][] updatedImage = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                updatedImage[r][c] = (image[r][c] + getNeighborsMean(image, r, c, radius)) / 2;
            }
        }

        return updatedImage;
    }

    public static int getNeighborsMean(int[][] image, int r, int c, int radius) {
        int rows = image.length;
        int cols = image[0].length;
        int sum = 0;
        int count = 0;

        for (int i = -radius; i <= radius; i++) {
            for (int j = -radius; j <= radius; j++) {
                if (r + i >= 0 && r + i < rows && c + j >= 0 && c + j < cols) {
                    count++;
                    sum += image[r + i][c + j];
                }
            }
        }

        if (count <= 1) {
            return image[r][c];
        }

        return (sum - image[r][c]) / (count - 1);
    }

    public static void printImage(int[][] image) {
        for (int r = 0; r < image.length; r++) {
            for (int c = 0; c < image[0].length; c++) {
                System.out.print(image[r][c] + " ");
            }
            System.out.println();
        }
    }
}
