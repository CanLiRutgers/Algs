
public class FFT {

	public static void main(String[] args) {
		Complex[] x = {
				new Complex(1,0),
				new Complex(0,0),
				new Complex(1,0),
				new Complex(-1,0)};

        show(x,"x");

		Complex[] y = fft(x);
		show(y, "y = fft(x)");
		
		Complex[] z = ifft(x);
		show(z, "z = ifft(x)");
		
	}

    private static Complex[] ifft(Complex[] x) {
	    int N = x.length;
	    Complex[] y = new Complex[N];
//	    take conjugate
        for (int i = 0; i < N; i++) {
            y[i] = x[i].conjugate();
        }
        y = fft(y);
//      take conjugate again
        for (int i = 0; i < N; i++) {
            y[i] = y[i].conjugate();
        }

        for (int i = 0; i < N; i++) {
            y[i] = y[i].scale(1.0/N);
        }
        return y;
    }

    private static Complex[] fft(Complex[] x) {
		// TODO Auto-generated method stub  
		int N = x.length;
		if(N==1) return new Complex[] {x[0]};

		if(N%2 != 0) { throw new RuntimeException("N is not a power of 2 "); }
		
		Complex[] even = new Complex[N/2];
		for (int k=0; k<N/2; k++) {
			even[k] = x[2*k];
		}
		Complex[] y0 = fft(even);
		
		Complex[] odd = even;
		for (int k=0; k<N/2; k++) {
			odd[k] = x[2*k+1];
		}
		Complex[] y1 = fft(odd);

        Complex[] y = new Complex[N];
        for (int k = 0; k < N/2; k++) {
            double kth = 2 * Math.PI * k / N;
            Complex wk = new Complex(Math.cos(kth), Math.sin(kth));
            y[k] = y0[k].plus(wk.times(y1[k]));
            y[k+N/2] = y0[k].minus(wk.times(y1[k]));
        }
        return y;
	}

	private static void show(Complex[] x, String title) {
		// TODO Auto-generated method stub
		System.out.println(title);
		System.out.println("-------------------");
		for(int i=0; i<x.length; i++) {
			System.out.println(x[i]);
		}
		System.out.println();
	}
	
}
