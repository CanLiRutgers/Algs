

public class lis {
	public static int lis(int[] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		
		int[] dp = new int[array.length];
		dp[0] = 1;

		int res = 0 ;
		
		for(int i = 1; i < array.length; i++) {
			System.out.println("dp[" + i + "]:" + dp[i] + " " + "res:" + res);
			
			for(int j = 0; j < i; j++) {
				if(array[i] > array[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
					res = Math.max(res, dp[i]);
				} 
			}
		
		}
		return res;
		
	}
	
	public static void main(String[] args) {
		int[] arr = {3,1,4,1,5,9,2,6,5};
		int result = lis(arr);
		System.out.println(result);
	}
}
