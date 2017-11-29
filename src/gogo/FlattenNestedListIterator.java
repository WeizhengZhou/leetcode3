package gogo;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;


  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
  interface NestedInteger {
 
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();
 
      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();
 
      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }
 
public class NestedIterator implements Iterator<Integer> {
    Iterator<NestedInteger> it;
    Stack<Iterator<NestedInteger>> stack;
    NestedInteger cur;
    public NestedIterator(List<NestedInteger> nestedList) {
        it=nestedList.iterator();        
        stack=new Stack<> ();
    }

    @Override
    public Integer next() {
        return cur.getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!it.hasNext() && !stack.isEmpty()) {
            it=stack.pop();
        }
        if (!it.hasNext()) {
            return false;
        }
        cur=it.next();
        if (!cur.isInteger()){
            while(!cur.isInteger()) {
                stack.push(it);
                it=cur.getList().iterator();
                while (!it.hasNext() && !stack.isEmpty()) {
                    it=stack.pop();
                }
                if (!it.hasNext()) {
                    return false;
                }
                cur=it.next();
            }
        }
        return true;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */