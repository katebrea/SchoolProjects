

import AvlTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AvlTester {
	 static AvlTree<String> t = new AvlTree<String>( );
    
	 // Test program
   public static void main( String [ ] args )
   {
      
        		BufferedReader bufferedReader;
 		try {
 			bufferedReader = new BufferedReader(new FileReader(args[0]));
 			String line;
 			int intCounter = 1;
 			while ((line = bufferedReader.readLine()) != null) {
 				StringTokenizer st = new StringTokenizer(line);
 				ArrayList<String> words = new ArrayList<String>();
 				while (st.hasMoreTokens()){
 					words.add(st.nextToken());
 					
 					
 				}
 				insertWords(words, intCounter);
 				intCounter++;
 				
 			}
 			bufferedReader.close();
 		} catch (IOException e) {
 			//stderr.println("Cannot open file: " + fileName);
 			System.out.println(e.toString());
 		}
 		
 		t.printTree();
 		
   
   }
   
   public static void insertWords(ArrayList<String> words, int lineNumber)
      {
	   for (int i=0; i<words.size(); i++)
	   {
	   t.insert(words.get(i), lineNumber);
	   }
      }

}
