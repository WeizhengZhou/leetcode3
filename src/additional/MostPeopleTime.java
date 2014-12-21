package additional;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MostPeopleTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval i1=new Interval(1,4);
		Interval i2=new Interval(2,3);
		Interval i3=new Interval(1,6);
		Interval i4=new Interval(3,6);
		List<Interval> L=new LinkedList<Interval>();
		L.add(i1);
		L.add(i2);
		L.add(i3);
		L.add(i4);
		MostPeopleTime m=new MostPeopleTime();
		System.out.println(m.findTime(L));

	}
	
	public int findTime(List<Interval> L){
		int[] start=new int[L.size()];
		int[] end=new int[L.size()];
		int i=0;
		for(Interval interval:L){
			start[i]=interval.start;
			end[i]=interval.end;
			i++;
		}
		Arrays.sort(start);
		Arrays.sort(end);
		System.out.println(Arrays.toString(start));
		System.out.println(Arrays.toString(end));
		int max=0;
		int count=0;
		int time=0;
		int endTime=0;
		int last=0;
		int startIndex=0;
		int endIndex=0;
		while(startIndex<L.size()){
			if(start[startIndex]>=end[endIndex]){
				System.out.println("endIndex="+endIndex+",end[Index]="+end[endIndex]);
				if(count>max){
					max=count;
					time=start[last];
					endTime=end[endIndex];
				}
				count--;
				endIndex++;
			}
			if(start[startIndex]<=end[endIndex]){
				System.out.println("startIndex="+startIndex+",start[Index]="+start[startIndex]);
				count++;
				last=startIndex;
				//if(startIndex<L.size()-1)
				//{
					startIndex++;
				//}
			}
			
		}
		System.out.println("end time="+endTime);
		return time;
	}
	
}
class Interval{
	int start;
	int end;
	Interval(int x,int y){
		start=x;
		end=y;
	}
}
