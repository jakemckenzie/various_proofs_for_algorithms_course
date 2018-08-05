import java.util.*;
public class test {
    public static void main(String[] args) {
        int[] a = new int[100000000];
        for (int i = 0; i < 100000000;i++) {
            a[i] =  (int)XORShift128plus();
        }
        
        System.out.println(Arrays.stream(a).average().getAsDouble());
        System.out.println(Arrays.stream(a).summaryStatistics().getCount());
        System.out.println(Arrays.stream(a).summaryStatistics().getMin());
        System.out.println(Arrays.stream(a).summaryStatistics().getMax());
    }
    private static long XORShift() {
        long x = System.currentTimeMillis();
        x ^= (x << 21);
        x ^= (x >>> 35);
        x ^= (x << 4);
        return x;
    }
    private static long XORShift128plus() {
        long x = System.currentTimeMillis();
        long y = XORShift();    
        x ^= (x << 23);
        long z = x ^ y ^ (x >> 26);
        return z + x;
    }
}