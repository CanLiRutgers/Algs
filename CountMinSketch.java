
public class CountMinSketch {
	
	static int d = 5; // 5个hash函数
	static int w = 100; // 每个hash函数的取值空间
	static long a[] = new long[d];
	static long b[] = new long[d];
	static long c[][] = new long[d][w];
	
	public static void main(String[] args) {
		
		int values[] = {1,3,3,5,2,2,1,4,4,6,6,4,7,4,8,4};
		int frequencyOfNumber = 1;
		
		for(int i=0; i<d; i++) {
			a[i] = (int) (Math.random()*100);
			b[i] = (int) (Math.random()*100);
		}
		
		for(int i=0; i<values.length; i++) {
			for(int j = 0; j<d; j++) {
				c[j][hash(values[i],j)]++;
			}
		}
		
		long minimum = Integer.MAX_VALUE;
		for(int i=0; i<d; i++) {
			minimum = Math.min(minimum, c[i][hash(frequencyOfNumber, i)]);
		}
		
		System.out.println(minimum);
		
	}

	private static int hash(int value, int i) {


		long p = Integer.MAX_VALUE;
		// TODO Auto-generated method stub
		return (int) (((a[i])*value + b[i])%p%w);
	}

}
