import java.util.Random;

public class MillerRabin {
    public static final int ORDER = 10000;
    public static final int MIN = 1000;

    public static void main(String[] args) {
        int x = getPrime();
        boolean flag = true;
        for (int i=0; i<10; i++){
            if (!isPrime(x)){
                flag = false;
                break;
            }
        }
        if (flag) System.out.println(x + ": is prime, test passed.");
        else System.out.println(x + ": not a prime");
    }

    private static boolean isPrime(int n) {
        int[] arr = intTOIndex(n-1);
        int k = arr[0];
        int m = arr[1];
        Random r = new Random();
        int a = 0;
        do {
            a = r.nextInt(n-1);
        } while (a<2);
        int b = Square_and_Multiply(a,m,n);
        if (b==1) return true;
        for (int i = 0; i < k; i++) {
            if (b == (n-1)) return true;
            else b = (b * b) % n;
        }
        return false;
    }

    private static int[] intTOIndex(int n) {
        int[] arr = new int[2];
        int k = 0;
        int x;
        do {
            k++;
            n >>= 1;
            x = n & 1;
        } while (x==0);
        arr[0] = k;
        arr[1] = n;
        return arr;
    }

    private static int Square_and_Multiply(int a, int m, int n) {
        int d = 1;
        byte[] bm = getByte(m);
        for (int i = 0; i < bm.length; i++) {
            d = (d*d) % n;
            if (bm[i] == 49)
                d = (d*a) % n;
        }
       return d;
    }

    private static byte[] getByte(int m) {
        String sb = "";
        while (m>0){
            sb = (m % 2) + sb;
            m = m/2;
        }
        return sb.getBytes();
    }

    public static int getPrime() {
        int x = 0;
        while (x%2 == 0 || !isPrime(x)) x = getRandom();
        return x;
    }

    public static int getRandom() {
        int x = 3;
        Random rd = new Random();
        do {
            x = rd.nextInt(ORDER);
        }while (x<MIN || x%2 == 0);
        return x;
    }
}
