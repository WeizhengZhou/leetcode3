package additional;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/*public class PeekIterator<T> {
	
	final Iterator<T> iter;
	static int peekIndex;
	static int nextIndex;
	static T next;
	
	public static <T> PeekIterator<T> getPeekIterator(Iterator<T> it){
		return new PeekIterator<T>(it);
	}
	
	public PeekIterator(Iterator<T> iter){
		this.iter=iter;
		peekIndex=0;
		nextIndex=0;
	};
	public static boolean hasNext(Iterator<T> iter){
		return iter.hasNext();
	};
	public static <T> T next(Iterator<T> iter){
		if(!iter.hasNext()){
			throw new NoSuchElementException();
		}
		if(peekIndex==nextIndex+1){
			nextIndex++;
			return next;
		}
		else{
			nextIndex++;
			return iter.next();
		}		
	};
	public T peek(){
		if(peekIndex<=nextIndex){
			if(!iter.hasNext()){
				return null;
			}
			next=iter.next();
			peekIndex=nextIndex+1;
			return next;
		}
		else{
			return next;
		}
	}
	
	public void remove() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}*/
