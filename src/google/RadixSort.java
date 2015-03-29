import java.util.*;
public class RadixSort {
	public List<Person> sort(List<Person> persons){
		
	}
	private class NameComparator<PersonNode> implements Comparator<PersonNode>{

		@Override
		public int compare(PersonNode o1, PersonNode o2) {
			System.out.println(o1.name);
		}
		
	}
	class PersonNode{
		String name;
		int age;
		public PersonNode(String name, int age){
			this.name = name;
			this.age = age;
		}
		public String toString(){
			return "(" + this.name + ", " + this.age + ")";
		}
	}
}

