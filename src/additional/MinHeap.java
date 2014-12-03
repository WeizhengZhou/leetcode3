package additional;

public class MinHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinHeap m=new MinHeap();
		m.add(4);
		m.add(3);
		m.add(2);
		m.add(1);
		System.out.print("size="+m.size);
		m.print();
		m.remove();
		System.out.print("size="+m.size);
		m.print();
	}
	int size=0;
	int[] A=new int[100];
	public	void add(int x){
		size++;
		A[size-1]=x;
		int i=size;
		while(i/2-1>=0 && x<A[i/2-1]){
			int temp=A[i-1];
			A[i-1]=A[i/2-1];
			A[i/2-1]=temp;
			i=i/2;
		}
	}
	public void print(){
		System.out.println("");
		System.out.print("[");
		for(int i=0; i<size;i++)
		{
			System.out.print(A[i]+",");
		}
		System.out.print("]");
		System.out.println("");
	}
	public 	int remove(){
		if(size==0){
			return 0;
		}
		size--;
		int r=A[0];
		A[0]=A[size];
		int i=1;
		while(i*2-1<size ){
			if(A[i*2-1]<A[i-1] ||A[i*2]<A[i-1]){
				int smallIndex=A[i*2-1]<=A[i*2]?(i*2-1):(i*2);
				int temp=A[smallIndex];
				A[smallIndex]=A[i-1];
				A[i-1]=temp;
				i=i*2;
			}
			else{
				break;
			}
		}
		
		return r;
	}
	public	int size(){
		return size;
	}
	
}
