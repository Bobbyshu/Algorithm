package A_OUEI.Citadel;

public class evenOrOddString {
  public static boolean checkComputation(String data[]) {
    boolean isStringEvenArray[] = new boolean[data.length];
    int tempVal;
    boolean isEvenPresent = false;

    for (int i = 0; i < data.length; i++) {
      isEvenPresent = false;
      for (int j = 0; j < data[i].length(); j++) {
        tempVal = (int) data[i].charAt(j);
        if (tempVal % 2 == 0) {
          isEvenPresent = true;
        }
      }
      isStringEvenArray[i] = isEvenPresent;
    }

    int oddCount = 0;
    for (int i = 0; i < data.length; i++) {
      if (!isStringEvenArray[i])
        oddCount++;
    }

    if (oddCount % 2 != 0) return false;

    else return true;


  }
}
