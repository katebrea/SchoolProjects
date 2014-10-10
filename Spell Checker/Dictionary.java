//Katherine Brea
//klb2180
//This is my dictionary class.  
//It defines a hashTable variable that takes the code provided by Weiss and modified by me.
//This connects the hashing capabilities from the Weiss code and allows me to specify that 
//the hash table should take a string and it adds the populateDictionary method which allows me 
//add the words tokenized in the tester method to the hashTable.


import java.util.ArrayList;


public class Dictionary {

	QuadraticProbingHashTable<String> hashTable;//this is going to be a hashTable that takes strings
	public Dictionary(){ 
	//constructor for the dictionary class which includes a hashTable instance of the QuadraticProbingHashTable class.
		hashTable= new QuadraticProbingHashTable<String>();
		
	}
	
	public void populateDictionary(ArrayList<String> words) 
	//this is going to insert words from words.txt into the dictionary hashTable
	{
		for (int i=0; i<words.size(); i++)
			hashTable.insert(words.get(i));
		

	}
	public boolean contains(String word){
		//this is a contains method that will check whether the word is already in the hashTable.
		return hashTable.contains(word);
	}
}
