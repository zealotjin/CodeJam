import java.lang.*;
import java.io.*;

public class ReverseWord{
	
	public static void main(String[] args){
		try{
			FileInputStream in = new FileInputStream("B-large-practice.in");
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			int numTestCases = Integer.parseInt(br.readLine());
			for(int i = 0; i<numTestCases;i++){
				String actual = br.readLine();
				String[] line = actual.split(" ");
				int left = 0;
				int right = line.length-1;
				while(right>left){
					if(right == left){
						break;
					}
					String temp = "" ;
					temp = line[left];
					line[left] = line[right];
					line[right] = temp;
					left++;
					right--;
				}
				String output = "Case#" + (1+i) + ": ";
				for(int j = 0; j<line.length;j++){
					output += " "+line[j];
				}
				System.out.println(output);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
