package additional;

public class RunningAverage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunningAverage r=new RunningAverage();
		r.add(1);
		System.out.println(r.getAverage());
		r.add(2);
		System.out.println(r.getAverage());
		r.add(3);
		System.out.println(r.getAverage());
		r.add(4);
		System.out.println(r.getAverage());

	}
	int count=0;
	double average=0;
	public void add(int x){
		average=(average*count+x)/(count+1);
		count++;
	}
	
	public double getAverage(){
		return average;
	}

}
