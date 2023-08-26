package Leetcode.weeklycontest.Normal.NO342;

public class t1 {
  public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
    int sum = arrivalTime + delayedTime;
    return sum % 24;
  }
}
