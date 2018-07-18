public class RSA {
    public static int[] extendedEuclid(int a, int b){
        int d, x, y;
        if(b == 0) {
            return new int[]{a, 1, 0};
        } else {
            int[] tmp = extendedEuclid(b, a%b);
            d = tmp[0];
            x = tmp[1];
            y = tmp[2];
        }
        return new int[]{d, y, (int)(x- Math.floor(a/b)*y)};
    }

    public static int[] modLinearEquation(int a, int b, int n){
        int d, x, y;
        int[] tmp = extendedEuclid(a, n);
        d = tmp[0];
        x = tmp[1];
        y = tmp[2];
        int[] X = new int[d];

        if(d%b == 0){
            X[0] = (x*(b/d)) % n;
            if(X[0]<0) X[0] += n;
            for (int i = 0; i < d - 1; i++) {
                X[i] = (X[0] + i*(n/d)) % n;
                if(X[i] < 0) X[i] += n;
            }
            return X;
        } else {
            X[0] = -1;
            return X;
        }
    }

    public static int ModulaExponentiation(int a, int b, int n){
        int c = 0;
        int d = 1;
        String bb = Integer.toBinaryString(b);
        for (int i = 0; i < bb.length(); i++) {
            c = 2*c;
            d = (d*d) % n;
            if(bb.charAt(i) == '1'){
                c = c + 1;
                d = (d*a) % n;
            }
        }
        return d;
    }
    public static void main(String[] args) {
//        for (int i=0; i<3; i++) {
//            System.out.println(extendedEuclid(115, 367)[i]);
//        }
//        System.out.println(modLinearEquation(3,1,352)[0]);
        int M = 41;
        int p = 17;
        int q = 23;
        int n = p*q;
        int e = 3;
        int d = modLinearEquation(e,1, (p-1)*(q-1))[0];

        int PM = ModulaExponentiation(M, e, n);
        int SC = ModulaExponentiation(PM, d, n);
        System.out.println("Message: " + M);
        System.out.println("Secret key(d): " + d);
        System.out.println("Encrypted: " + PM);
        System.out.println("Decrypted: " + SC);
    }
}
