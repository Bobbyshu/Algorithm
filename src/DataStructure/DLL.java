package DataStructure;

public class DLL {
  public static void main(String[] args) {
    TextEditor te = new TextEditor();
    te.addText("leetcode");
    te.deleteText(4);
    te.addText("practice");
    te.cursorRight(3);
    te.cursorLeft(8);
    te.deleteText(10);
    te.cursorLeft(2);
    te.cursorRight(6);
  }
}
class TextEditor {
  Node root, cur;

  public TextEditor() {
    root = cur = new Node();
//    cur = new Node();
    root.pre = root;
    root.next = root;
  }

  public void addText(String text) {
    for (char c : text.toCharArray()) {
      cur = cur.insert(new Node(c));
    }
  }

  public int deleteText(int k) {
    int temp = k;
    while (cur != root && temp > 0) {
      cur = cur.pre;
      cur.next.remove();
      --temp;
    }
    return k - temp;
  }

  String text() {
    StringBuilder sb = new StringBuilder();
    Node cur = this.cur;
    for (int k = 10; k > 0 && cur != root; --k) {
      sb.append(cur.ch);
      cur = cur.pre;
    }
    return sb.reverse().toString();
  }

  public String cursorLeft(int k) {
    for (; k > 0 && cur != root; --k) {
      cur = cur.pre;
    }
    return text();
  }

  public String cursorRight(int k) {
    for (; k > 0 && cur.next != root; --k)
      cur = cur.next;
    return text();
  }
}

class Node {
  Node pre, next;
  char ch;

  Node() {}

  Node(char ch) {
    this.ch = ch;
  }

  // insert node in the back of this
  // and return insert node
  Node insert(Node node) {
    node.pre = this;
    node.next = this.next;
    node.pre.next = node;
    node.next.pre = node;
    return node;
  }

  void remove() {
    this.pre.next = this.next;
    this.next.pre = this.pre;
  }
}
