package Z_MuitiThread;

public class CpuNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int i = runtime.availableProcessors();
        System.out.println(i);
    }
}
