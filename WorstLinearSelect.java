
import java.util.Arrays;
import java.util.Random;

public class WorstLinearSelect {

	public static void main(String[] args) {
		int n = 34, k = 7;/* 34��Ԫ�����ҳ���7С��Ԫ�� */
		int[] a = new int[n];
		Random rd = new Random();
		for (int i = 0; i < n; i++) {
			a[i] = rd.nextInt(100);
		}
		System.out.println(Arrays.toString(a));
		System.out.println(select(a, 0, n - 1, k));/* �������Բ��� */
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));/* ����������������֤ */
	}

	private static int select(int[] a, int low, int high, int k) {
		if (high - low < 5) {
			insertSort(a, low, high);
			return a[low + k - 1];
		}
		int teams = (high - low + 5) / 5;// ����
		for (int i = 0; i < teams; i++) {
			/* ��һ���������������n��Ԫ�ػ���Ϊn/5�飬ÿ��5��Ԫ�أ�������ֻ��һ������ʣ�µ�n mod5��Ԫ����� */
			int left = low + i * 5;
			int right = (low + i * 5 + 4) > high ? high : low + i * 5 + 4;
			int mid = (left + right) / 2;
			/* �ڶ�����Ѱ��(n+4)/5������ÿһ�����λ�������ȶ�ÿ���е�Ԫ�أ�����Ϊ5�������в�������Ȼ����������������ѡ����λ�� */
			insertSort(a, left, right);
			swap(a, low + i, mid);// ����λ����ǰ
		}
		/* ���������Եڶ������ҳ���(n+4)/5����λ�����ݹ����select���ҳ�����λ��x */
		int pivot = select(a, low, low + teams - 1, (teams + 1) / 2);
		/* ���Ĳ��������޸Ĺ���partition���̣�����λ������λ��x������������л��� */
		int pos = partition(a, low, high, pivot);
		/* ���岽���ж�posλ���Ƿ�ΪҪ�ҵ��������������ڵ������߸����ݹ�select */
		int leftNum = pos - low;
		if (k == leftNum + 1)
			return a[pos];
		else if (k <= leftNum)
			return select(a, low, pos - 1, k);
		else
			return select(a, pos + 1, high, k - leftNum - 1);
	}

	private static int partition(int[] a, int low, int high, int pivot) {
		int index = low;
		for (int i = low; i <= high; i++) {
			if (a[i] == pivot) {
				index = i;
				break;
			}
		}/* �ҵ���Ŧ��λ�� */
		swap(a, index, high);
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (a[j] <= pivot) {
				swap(a, j, ++i);
			}
		}
		swap(a, high, ++i);
		return i;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/* �������� */
	private static void insertSort(int[] a, int low, int high) {
		for (int i = low + 1; i <= high; i++) {
			int key = a[i];
			int j = i - 1;
			while (j >= low && a[j] > key) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = key;
		}
	}
	
	
}