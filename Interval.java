import java.util.Arrays;

class Interval implements Comparable<Interval> {
		int start;		
		int end;	
		Interval(int s,  int e)  {
			start  =  s;			
			end  =  e;
		}
		public String toString()  {
			return String.format("%d %d" ,start, end);
		}
		@Override
		public int compareTo(Interval o) {
			if(start!= o.start)
			    return start  -  o.start;
			else
			    return end  -  o.end;		
		}
		
		
	int minNumberOfIntervals(Interval[] list, Interval interval) {
	    Arrays.sort(list);
	    System.out.println(Arrays.toString(list));
	    
	    int i = 0;
	    int start = interval.start;
	    int max = -1;
	    int num = 0;
	    while (i < list.length && max < interval.end) { 
	      if (list[i].end <= start) {
	    	  i++;	    	  
	      } else {
	          if (list[i].start > start) break;
	          while (i < list.length && max < interval.end && list[i].start <= start) {            
	              if (list[i].end > max) {
	                  max = list[i].end;                 
	              }     
	              i++;
	          }  
	          if (start != max) {
	              start = max;
	              num++;
	          }
	          
	      }    
	    }
	    if (max < interval.end)
	        return 0;   
	    return num;
	}
}