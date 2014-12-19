package additional;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class testPeekIt {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l=new LinkedList<Integer>();
		Iterator<Integer> it=l.iterator();
		//PeekIterator<Integer> pi=PeekIterator.getPeekIterator(it);
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		/*System.out.println(pi.peek());//1
		System.out.println(pi.next());//1
		System.out.println(pi.next());//2
		System.out.println(pi.peek());//3
		*/

	}

}
