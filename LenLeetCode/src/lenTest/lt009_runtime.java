package lenTest;

public class lt009_runtime {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("max:"+ runtime.maxMemory());
        System.out.println("free:"+ runtime.freeMemory());
        double a = (int)2;
    }
}
