package BISHI.MicroStrategy.front;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class deque {
  public static int getScoreDifference(List<Integer> numSeq) {
    int firstScore = 0;
    int secondScore = 0;
    boolean isFirstPlayerTurn = true;

    Deque<Integer> deque = new ArrayDeque<>(numSeq);

    while (!deque.isEmpty()) {
      int pickedNumber;
      if (isFirstPlayerTurn) {
        if (deque.peekFirst() % 2 == 0) {
          pickedNumber = deque.pollFirst();
        } else {
          pickedNumber = deque.pollFirst();
        }
      } else {
        if (deque.peekFirst() % 2 == 0) {
          pickedNumber = deque.pollLast();
        } else {
          pickedNumber = deque.pollLast();
        }
      }

      if (isFirstPlayerTurn) {
        firstScore += pickedNumber;
      } else {
        secondScore += pickedNumber;
      }

      isFirstPlayerTurn = !isFirstPlayerTurn;
    }

    return firstScore - secondScore;
  }
}
