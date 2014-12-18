package additional;

import java.util.LinkedList;
import java.util.List;

public class HashTable<K,V> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable<String, Integer> h=new HashTable<String,Integer>();
		h.put("a", 1);
		h.put("b", 2);
		h.put("c", 3);
		System.out.println(h.get("a"));
		System.out.println(h.get("b"));
		System.out.println(h.get("d"));
		h.delete("b");
		System.out.println(h.get("b"));

	}
	
	@SuppressWarnings("unchecked")
	List<Pair<K,V>>[] A=new LinkedList[100];
	int a=3;
	int b=4;
	int p=103;
	int m=A.length;
	
	public void put(K key,V value){
		int hashCode=key.hashCode();
		hashCode=((a*hashCode+b)%p)%m;
		if (A[hashCode]==null){
			List<Pair<K,V>> list=new LinkedList<Pair<K,V>>();
			list.add(new Pair<K,V>(key,value));
			A[hashCode]=list;
		}
		else{
			A[hashCode].add(new Pair<K,V>(key,value));
		}
	}
	
	public V get(K key){
		int hashCode=key.hashCode();
		hashCode=((a*hashCode+b)%p)%m;
		if(A[hashCode]==null){
			return null;
		}
		List<Pair<K,V>> list=A[hashCode];
		for(Pair<K,V> p:list){
			if(p.key.equals(key)){
				return p.value;
			}
		}
		return null;
	}
	
	public void delete(K key){
		int hashCode=key.hashCode();
		hashCode=((a*hashCode+b)%p)%m;
		if(A[hashCode]==null){
			return;
		}
		List<Pair<K,V>> list=A[hashCode];
		for(Pair<K,V> p:list){
			if(p.key.equals(key)){
				list.remove(p);
			}
		}
	}

}

class Pair<K,V>{
	K key;
	V value;
	Pair(K k, V v){
		key=k;
		value=v;
	}
}