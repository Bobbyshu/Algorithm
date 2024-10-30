package A_OnsiteClassical.Tiktok;

import java.util.PriorityQueue;

public class NO295_MedianFromDataStream {
  PriorityQueue<Integer> small;
  PriorityQueue<Integer> large;

  public NO295_MedianFromDataStream() {
    small = new PriorityQueue<>();
    large = new PriorityQueue<>((o1, o2) -> o2 - o1);
  }

  public void addNum(int num) {
    if (small.size() >= large.size()) {
      small.offer(num);
      large.offer(small.poll());
    } else {
      large.offer(num);
      small.offer(large.poll());
    }
  }

  public double findMedian() {
    if (large.size() < small.size()) {
      return small.peek();
    } else if (large.size() > small.size()) {
      return large.peek();
    }

    return (double) (large.peek() + small.peek()) / 2;
  }
}
