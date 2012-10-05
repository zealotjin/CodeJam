import java.io.*;
import java.lang.*;
import java.util.*;

public class StoreCredit{

	public static void main(String[] args){
		try{
			FileInputStream in = new FileInputStream("input.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			int numTestCases =Integer.parseInt(br.readLine());
			String nextLine = br.readLine();
			ArrayList values = new ArrayList();
			ArrayList numOfLines = new ArrayList();
			ArrayList<String> items = new ArrayList<String>();
			int counter =1;
			while(nextLine != null){
				switch(counter){
					case 1:
						values.add(nextLine);
						counter++;
						break;
					case 2:
						numOfLines.add(nextLine);
						counter++;
						break;
					case 3:
						items.add(nextLine);
						counter =1;
						break;
				}
				nextLine = br.readLine();
			}
			//Reads the input.rtf file and stores these into three different arrays. 
			//All of the items have the same index numbers.
			ArrayList<Tuples> lower = new ArrayList<Tuples>();
			ArrayList<Tuples> higher = new ArrayList<Tuples>();
			int mid = 0;
			for(int i =0;i<numTestCases;i++){
				mid = Integer.parseInt((String)values.get(i))/2;
				String[] item = items.get(i).split(" ");
				int[] itemValues = new int[item.length];
				for(int j = 0;j<item.length; j++){
					int temp = Integer.parseInt(item[j]);
					if (temp < mid){
						lower.add(new Tuples(j,temp));
					}else{
						higher.add(new Tuples(j,temp));
					}
				}
				if(lower.size()>higher.size()){
					for(int l=0;l<lower.size();l++){
						for(int k=0;k<higher.size();k++){
							if(((Integer)lower.get(l).getSecond()) + ((Integer)higher.get(k).getSecond())==Integer.parseInt((String)values.get(i))){
								System.out.println("Case #" + i + ": " + lower.get(l).getFirst() + " "+ higher.get(k).getFirst());
							}
						}
					}
				}else{
					for(int l=0;l<higher.size();l++){
						for(int k=0;k<lower.size();k++){
							if(((Integer)lower.get(k).getSecond()) + ((Integer)higher.get(l).getSecond())==Integer.parseInt((String)values.get(i))){
							System.out.println("Case #" + i + ": " + lower.get(k).getFirst() + " "+ higher.get(l).getFirst());
							}
						}
					}
				}
			}

		}
		catch(Exception e){
		}
	}
}
class Tuples{
	Object firstElem;
	Object secondElem;

	public Tuples(Object x, Object y){
		firstElem = x;
		secondElem =y;
	}
	public Object getFirst(){
		return firstElem;
	}
	public Object getSecond(){
		return secondElem;
	}
}


