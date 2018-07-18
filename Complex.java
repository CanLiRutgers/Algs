
public class Complex {
	private double re;
	private double im;

	public Complex(double real, double imag) {
		// TODO Auto-generated constructor stub
		re = real;
		im = imag;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(im==0) return re + "";
		if(re==0) return im + "i";
		if(im<0) return re + " - " + (-im) + "i";
		return re + " + " + im + "i";
	}
	
	public Complex plus(Complex b) {
		Complex a = this;
		double real = a.re + b.re;
		double imag = a.im + b.im;
		return new Complex(real, imag);
	}
	
	public Complex minus(Complex b) {
		Complex a = this;
		double real = a.re - b.re;
		double imag = a.im - b.im;
		return new Complex(real, imag);
	}
	
	public Complex times(Complex b) {
		Complex a = this;
		double real = a.re * b.re - a.im * b.im;
		double imag = a.re * b.im + a.im * b.re;
		return new Complex(real, imag);
	}

    public Complex conjugate() {
		return new Complex(re, -im);
    }

	public Complex scale(double alpha) {
	    return new Complex(alpha * re, alpha * im);
	}
}
