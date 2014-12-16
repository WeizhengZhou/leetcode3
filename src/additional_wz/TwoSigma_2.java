package additional_wz;
import java.util.*;
public class TwoSigma_2 {	
	public void backupDataCenters(List<DataCenter> dataCenters){
		if(dataCenters == null) return;
		syncDataCenters(dataCenters, 0, dataCenters.size()-1);	
		System.out.println("done");
	}
	/**
	 * sync a list of data centers from index "start" to index "end"
	 * @param dcList a list of data centers to be sync
	 * @param start start index of list
	 * @param end end index of list
	 */
	private void syncDataCenters(List<DataCenter> dcList, int start, int end){
		if(start >= end){
			return;
		}
		else if(start + 1 == end){//sync between two datacenters 
			syncTwoCenters(dcList.get(start), dcList.get(end));
			return;
		}
		else{
			int middle = start + (end-start)/2;//divide dcList[start,end] into two sublists
			syncDataCenters(dcList,start,middle);//sync left list, i.e. dcList[start,middle]
			syncDataCenters(dcList,middle+1,end);//sync right list, i.e. dcList[middle,end]
			int i = start;
			int j = middle+1;
			while(i<=middle || j <= end){//sync(dcList[i],dcList[j])
				if(i > middle)//maybe left list is shorter, then i should reset to start
					i = start;
				if(j > end)//maybe right list is shorter, then j should reset to middle+1
					j = middle+1;
				syncTwoCenters(dcList.get(i),dcList.get(j));
				i++;
				j++;
			}
		}
	}
	/**
	 * sync two data centers 
	 * @param A data center A
	 * @param B data center B
	 */
	private void syncTwoCenters(DataCenter A, DataCenter B){
		Set<Integer> unionDataSet = getUnionSet(A,B);//compute the union dataSet of two data centers
		for(Integer dataIndex:unionDataSet){//copy missing data from A to B
			if(!B.dataSet.contains(dataIndex)){
				copyData(dataIndex,A,B);
			}
			if(!A.dataSet.contains(dataIndex)){
				copyData(dataIndex,B,A);
			}
		}		
	}
	/**
	 * compute the union data sets of two data centers
	 * @param A data center A
	 * @param B data center B
	 * @return the union data set of A and B
	 */
	private Set<Integer> getUnionSet(DataCenter A, DataCenter B){
		Set<Integer> unionSet = new HashSet<>();
		for(Integer dataIndex:A.dataSet){
			unionSet.add(dataIndex);
		}
		for(Integer dataIndex:B.dataSet){
			unionSet.add(dataIndex);
		}
		return unionSet;		
	}
	/**
	 * copy data from "fromCenter" to "toCenter"
	 * @param dataIndex index of data to be copied
	 * @param fromCenter data copied from "fromCenter" 
	 * @param toCenter data copied to "toCenter"
	 */
	private void copyData(int dataIndex, DataCenter fromCenter, DataCenter toCenter){
		if(fromCenter == null || toCenter == null) return;
		toCenter.dataSet.add(dataIndex);//can implement the real copy here
		System.out.println("Copying dataIndex = " + dataIndex + " from " + fromCenter.id + " to " + toCenter.id);		
	}
	/**
	 * print the dataSet in data center lists
	 * @param dcList a list of data center
	 */
	public void printDataCentersInfo(List<DataCenter> dcList){
		for(DataCenter dc : dcList){
			System.out.println(dc);
		}
	}
	public static void main(String[] args){		
		TwoSigma_2 solu = new TwoSigma_2();
		List<DataCenter> dataCenters = solu.createDataCenters();	
		solu.printDataCentersInfo(dataCenters);
		solu.backupDataCenters(dataCenters);
		solu.printDataCentersInfo(dataCenters);					
	}
	public List<DataCenter> createDataCenters(){
		List<DataCenter> dataCenters = new ArrayList<>();
		
		DataCenter dataCenter1 = new DataCenter(1);	
		dataCenter1.dataSet.add(1);
		dataCenter1.dataSet.add(3);
		dataCenter1.dataSet.add(4);
		dataCenter1.dataSet.add(5);
		dataCenter1.dataSet.add(7);
		
		DataCenter dataCenter2 = new DataCenter(2);	
		dataCenter2.dataSet.add(1);
		dataCenter2.dataSet.add(3);
		
		DataCenter dataCenter3 = new DataCenter(3);
		dataCenter3.dataSet.add(2);
		
		dataCenters.add(dataCenter1);
		dataCenters.add(dataCenter2);
		dataCenters.add(dataCenter3);
		return dataCenters;
	}
}
/**
 * a class represents a data center
 */
class DataCenter{
	int id = 0;//data center's id
	Set<Integer> dataSet = null;//data center's data set
	public DataCenter(int id){
		this.id = id;
		this.dataSet = new HashSet<>();
	}
	public String toString(){//information of data center
		return this.id + ", " + dataSet;
	}
}
