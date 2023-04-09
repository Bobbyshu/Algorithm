package BitManipulation;

public class bitset {
  int[] bit;
  int flipped;
  // cnt amount of "1"
  int cnt;

  public bitset(int size) {
    bit = new int[size];
    flipped = 0;
    cnt  = 0;
  }

  public void fix(int idx) {
    // only in this two circumstance should we flipped
    // bit[idx] == 1 and flipped(1) -> current is zero
    // bit[idx] == 0 and unflipped(0) -> is zero
    if (bit[idx] == flipped) {
      bit[idx] = flipped ^ 1;
      ++cnt;
    }
  }

  public void unfix(int idx) {
    // only in this two circumstance should we flipped
    // bit[idx] == 1 and unflipped(0) -> is one
    // bit[idx] == 0 and flipped(1) -> current is one
    if(bit[idx] == (flipped ^ 1)){
      bit[idx] = flipped;
      cnt--;
    }
  }

  public void flip() {
    flipped ^= 1;
    // remain
    cnt = bit.length - cnt;
  }

  public boolean all() {
    return cnt == bit.length;
  }

  public boolean one() {
    return cnt > 0;
  }

  public int count() {
    return cnt;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i : bit) {
      sb.append(String.valueOf((i ^ flipped)));
    }
    return sb.toString();
  }
}
