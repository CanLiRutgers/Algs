import java.util.ArrayList;

public class ActivitySelector {
	
    public static ArrayList<Integer> greedyActivitySelection(int[] s, int[] f, int i, int n, ArrayList<Integer> activities){
        //��ʼ����ʱ i = 0, ����a(1)�Ǳ�ѡ��(ע��:�����Ѿ�������ʱ������)
        int m = i + 1;
        
        //s[m] < f[i] ��ζ�Ż a(m) �� a(i)��ͻ��
        while(m <= n && s[m] < f[i])
            m++;//ѡ����һ���
        
        if(m <= n){
            activities.add(m);
            greedyActivitySelection(s, f, m, n, activities);
        }
        return activities;
    }
    
    //̰���㷨�ķǵݹ��, assume f[] has been sorted and actId 0/n+1 is virtually added
    public static ArrayList<Integer> greedyActivitySelection2(int[] s, int[] f, ArrayList<Integer> acitivities){
        //���������Ļ(������ �0�� �n+1)��,����ʱ��������Ǹ��һ���������ݻ�����е� �.
        int n = s.length;
    	acitivities.add(1);
        int k = 1;
        
        for(int m = 2; m < n; m++){
            if(s[m] >= f[k])
            {
                acitivities.add(m);
                k = m;
            }
        }
        return acitivities;
    }
	
    public static void main(String[] args) {
        //����� a(0) �� a(n+1)�. ����s(0)=f(0)=0, s(n+1)=f(n+1)=Integer.MAX_VALUE
        int[] s = {0,1,3,0,5,3,5,6,8,8,2,12};//start time
        int[] f = {0,4,5,6,7,8,9,10,11,12,13,14};//finish time
        int n = 11;//��ĸ���
        
        ArrayList<Integer> acts = new ArrayList<Integer>();
        greedyActivitySelection(s, f, 0, n, acts);
        for (Integer activityId : acts)
            System.out.print(activityId + " ");
        
        System.out.println();
        
        ArrayList<Integer> acts2 = new ArrayList<Integer>();
        greedyActivitySelection2(s, f, acts2);
        for (Integer activityId : acts2)
            System.out.print(activityId + " ");
             
    }
}
