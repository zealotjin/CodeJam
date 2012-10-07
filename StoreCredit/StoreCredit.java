import java.io.*;
import java.lang.*;
import java.util.*;

/**
The basic algorithm I used was that:
I first took in the input from the file called ‘input.txt’ and then seperated all the values accordingly to a seperate ArrayList.
Then, I noticed that for each case, there are three lines respectively that give the input: 
1. gives the total credit you have, 2. gives the number of items in the list and 3. gives the values of the items in the store.
Thus I looped through to insert the values into arrays with the an index for each case. (Ex. for case one, all the data for this will be stored in the three arrays with the index of 0) Next, I assumed that because there are no negative numbers and the sum is to be the credit, I can then assume that one value will be smaller and one value will be bigger than the mid (= credit/2). This way I can keep track of which one is the smaller value so it eases the part when I need to print them in order. Time-wise, this does have a 0(n^2) time, however, I believe that for the large inputs, it will be much faster than blindly going through two arrays and comparing all the values.
I manually created a ‘Tuples’ class that just simply takes in two objects and groups them into two.
This is because I wanted to store the first object to be the index of the value in the list, and the second to be its original value (lookup Dictionary for reference) and thus when I made the ‘lower’ and ‘higher’, I made them to accept Tuples that contain these information. 
Then depending on which array was bigger, I would go through two arrays and see if their sum would equal the credit.

Possible implementations I thought of to improve may be to implement the binary tree with the root as the mid value of the list. (Not sure, but maybe possible to shorten the time). 

*/

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


