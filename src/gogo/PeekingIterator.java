package gogo;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    Integer cur;
    Iterator<Integer> it;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
		it=iterator;
	    if (iterator!=null && iterator.hasNext()) {
	    	cur=iterator.next();
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return cur;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer r=cur;
	    if (it.hasNext()) {
	    	cur=it.next();
	    } else {
	    	cur=null;
	    }
	    return r;
	}

	@Override
	public boolean hasNext() {
	    return cur!=null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}
