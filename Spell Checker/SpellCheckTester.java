//Katherine Brea
//klb2180
//This is my SpellCheckTester class. It takes the command line arguments words.txt PersonalDictionary inputText
//It instantiates a dictionary, which is a hash table that takes strings (defined by me in another class)
//It also provides the spellchecking capability- it adds a letter where one is needed, subtracts if needed, or exchanges characters if needed



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class SpellCheckTester {

	public static void main(String[] args) {
		BufferedReader bufferedReader;
		Dictionary dictionary = new Dictionary();//this is the instance of my hash table
 		try {
 			bufferedReader = new BufferedReader(new FileReader(args[0]));
 			//the command line argument I'm looking for here is words.txt
 			String line;
 			
 			ArrayList<String> words = new ArrayList<String>();
 			while ((line = bufferedReader.readLine()) != null) {
 				//aka while there is another line to be read, tokenize the next string
 				StringTokenizer st = new StringTokenizer(line);
 				
 				while (st.hasMoreTokens()){
 					words.add(st.nextToken().toLowerCase());
 					//and here, add the lower case version of the next token to the words variable.
 					
 					
 				}
 				
 				
 			}
 			bufferedReader.close(); 
 			bufferedReader = new BufferedReader(new FileReader(args[1]));
 			//the command line argument that should be here is PersonalDictionary
 			while ((line = bufferedReader.readLine()) != null) {
 				StringTokenizer st = new StringTokenizer(line); 
 				//st is an instance of the stringtokenizer class. It takes in line
 	
 				while (st.hasMoreTokens()){
 					words.add(st.nextToken().toLowerCase());
 					//and like above, st tokenizes line and outputs lower case words of the line.
 					
 					
 				}	
 			}
 			dictionary.populateDictionary(words); 
 			//this fills the dictionary with the words that were the result of tokenizing line.
 			
 			bufferedReader.close();
 			bufferedReader = new BufferedReader(new FileReader(args[2]));
 			//this should take in the inputText file, which will contain misspelled and correctly spelled words.
 			int mispelledwordLine=1; //This will start the line number counter.
 			while ((line = bufferedReader.readLine()) != null) {
 				//everything here does the same thing as above. It reads in the lines, and tokenizes/lowercases them.
 				StringTokenizer st = new StringTokenizer(line);
 				while (st.hasMoreTokens()){
 					String word=st.nextToken().toLowerCase();
 					if (dictionary.contains(word))
 						System.out.println( "");
 					//I'm just printing a blank character here so there's a case in 
 					//which the spelling is correct, which is good for testing.
 					else
 					{
 						System.out.println("word is not spelled correctly "+word+" Line:"+mispelledwordLine);
 						StringBuffer stringBuffer = new StringBuffer(word); 
 						//this will take in the word and allow it to change- because strings are immutable
 						for (int j=0; j<stringBuffer.length(); j++){
 							//I'm going to loop through each of the letters and add each letter of the alphabet after it
 							//this will let me see whether the words with addendums map to a correctly spelled word in the dictionary.
 							for(short s=97; s<123; s++){
 								//97 is ascii for a and 122 is ascii for z. 
 								char c= (char)s;//casting the stringbuffer to a char so I can use charAt
 								stringBuffer.insert(j, c);//the c (if it completes a correct word) will go after j.
 								if (dictionary.contains(stringBuffer.toString())){
 									
 									System.out.println("Try "+stringBuffer);
 									
 								}
 								stringBuffer.deleteCharAt(j);
 							}
 						}
 						for (int j=0; j<stringBuffer.length(); j++){
 							char c = stringBuffer.charAt(j);
 							stringBuffer.deleteCharAt(j);
 								if (dictionary.contains(stringBuffer.toString())){
 									
 									System.out.println("Try "+stringBuffer);
 									
 								}
 								stringBuffer.insert(j, c);
 						}
 						
 						for (int j=0; j<stringBuffer.length()-1; j++){
 							//this is for the swapping capability
 							char a = stringBuffer.charAt(j);
 							char b = stringBuffer.charAt(j+1);
 							stringBuffer.replace(j, j+1, b+"");
 							stringBuffer.replace(j+1, j+2, a+"");
 							//System.out.println(stringBuffer);
 							if (dictionary.contains(stringBuffer.toString())){
									
									System.out.println("Try "+stringBuffer);
									
								}
 							stringBuffer.replace(j, j+1, a+"");
 							stringBuffer.replace(j+1, j+2, b+"");	
 						}
 						
 							
 					}
 				}
 				mispelledwordLine++;
 				
 			}
 			
 			
 			
 		} catch (IOException e) {
 			//stderr.println("Cannot open file: " + fileName);
 			System.out.println(e.toString());
 		}

	}

}
