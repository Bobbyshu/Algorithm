package BISHI.GuideWire;

public class playGameRound {

  public static int solution(String A, String B) {
    // Create an array for start time, splitting hours and minutes
    String[] start = A.split(":");
    int startHour = Integer.parseInt(start[0]);
    int startMinute = Integer.parseInt(start[1]);

    // Create an array for end time, splitting hours and minutes
    String[] end = B.split(":");
    int endHour = Integer.parseInt(end[0]);
    int endMin = Integer.parseInt(end[1]);

    // If the end time is earlier than the start time, adjust the end time's hours
    if (endHour < startHour || (endHour == startHour && endMin < startMinute)) {
      endHour += 24;
    }

    // If the start time's minutes are not divisible by 15, adjust them
    if (startMinute % 15 != 0) {
      startMinute = startMinute - (startMinute % 15) + 15;
      if (startMinute == 60) {
        startHour++;
        startMinute = 0;
      }
    }

    // If the end time's minutes are not divisible by 15, adjust them
    if (endMin % 15 != 0) {
      endMin -= (endMin % 15);
    }

    // Calculate the number of minutes within the given period
    int minutesWithinPeriod = (endHour - startHour) * 60 + (endMin - startMinute);

    // Ensure the result is non-negative
    minutesWithinPeriod = Math.max(minutesWithinPeriod, 0);

    // Calculate the maximum number of full rounds played within the given period
    int rounds = minutesWithinPeriod / 15;

    // Return the maximum number of full rounds played within the given period
    return rounds;
  }

  public static void main(String[] args) {
    System.out.println(solution("12:01", "12:44"));  // Should return 1
    System.out.println(solution("20:00", "06:00"));  // Should return 40
    System.out.println(solution("00:00", "23:59"));  // Should return 95
    System.out.println(solution("12:03", "12:03"));  // Should return 0
  }
}
