package Atcoder;

import java.io.*;

public class BufferReader {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        // 读取一整行
        String str = br.readLine();
        String[] arr = str.split(" ");
        int a1 = Integer.valueOf(arr[0]);
        int a2 = Integer.valueOf(arr[1]);
        out.flush();
    }
}
