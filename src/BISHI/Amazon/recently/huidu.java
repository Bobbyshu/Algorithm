package BISHI.Amazon.recently;
/*

 */
public class huidu {
    int greyDegree(String[] arr) {
        int[] rowGrey = new int[arr.length];
        int[] colGrey = new int[arr[0].length()];
        int rowMax = Integer.MIN_VALUE, colMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length(); j++) {
                if (arr[i].charAt(j) == '1') {
                    rowGrey[i]++;
                    colGrey[j]++;
                } else {
                    rowGrey[i]--;
                    colGrey[j]--;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            rowMax = Math.max(rowMax, rowGrey[i]);
        }

        for (int i = 0; i < arr[0].length(); i++) {
            colMax = Math.max(colMax, colGrey[i]);
        }

        return rowMax + colMax;
    }
}
