

public class DPCoinCharge {
	public static void main(String[] args) {
		int[] coinsValues = {1,2,3};
		int n = 5;
		int maxTypes = chargeTypes(coinsValues, n);
		System.out.println(maxTypes);
	}

	public static int chargeTypes(int[] coinsValues, int n) {
		// TODO Auto-generated method stub
		int m = coinsValues.length;
		int [][] c = new int[m+1][n+1];
		
		for(int i = 0; i <= m; i++) {
			c[i][0] = 1; // true base case
		}
		for(int i = 1; i <= n; i++) {
			c[0][i] = 0; // To be override
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(j < coinsValues[i-1]) { // if the ith coin unavailable
					c[i][j] = c[i-1][j];
					continue;
				}
				
				c[i][j] = c[i-1][j] + c[i][j-coinsValues[i-1]];
			}
		}
		return c[m][n];
	}
}
