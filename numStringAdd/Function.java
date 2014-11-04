import java.util.*; 
import java.io.*;

class Function {  
  static String NumberSearch(String str) { 
  
    // code goes here   
    /* Note: In Java the return type of a function and the 
       parameter types being passed are defined, so this return 
       call must match the return type of the function.
       You are free to modify the return type. */
    String output;
    int len = str.length();
    String[] temp = str.replaceAll("[^0-9]+"," ").split(" ");
    System.out.println(temp.length);
    int total = 0;
    int tempNum;
    for(int i =0;i<temp.length; i++){
      if(!temp[i].equals("")){

        tempNum = Integer.parseInt(temp[i]);
        total+= tempNum;
      }
    }
    double tempOutput = total/len;
    int reference = total/len;
    if(tempOutput < reference + 0.5){
      output = ""+reference;
    }else{
      output = "" +(reference + 1);
    }
    return output;
    
  } 
  
  public static void main (String[] args) {  
    // keep this function call here     
    String input = "H3ello9-9";
    System.out.println("The output: ");
    System.out.println(Function.NumberSearch(input));
  }   
  
}








  