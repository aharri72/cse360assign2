
package cse360assign2;

/**
 * @author austinharris
 * Class ID: 106
 * Assignment 1
 *Contents: SimpleList class for operations on a list  
 */
public class SimpleList {
	
	
	public int[] list;
	
	/**
	 * the total number of entries in list
	 */
	public int count; 
	
	/**
	 * Creating new array for the object and initializing count
	 */
	SimpleList() {
		
		list = new int[10];
		
		count = 0;
	}
	
	/**
	 * Add an element to the list
	 *
	 * @param addelem the element being added to the list
	 */
	public void add(int addelem) {
		
		if (count != 10) //update the total number of elements
			count++;
		
		int counter = count;
		
		while(counter > 0) {
			
			list[counter] = list[counter - 1]; //move all elements one space to the right
			
			counter--;
		}

		list[0] = addelem; 
	}
	
	/**
	 * Remove all instances of an integer from list
	 * 
	 * @param removeelem the integer whose occurrences will be removed from list
	 */
	public void remove(int removeelem) {
		
		int counter = 0;
				
		while(counter < count) {
			
			if(list[counter] == removeelem) { //if removeelem is found in list
				
				int index = counter; //store the index removeelem was found in
				
				while(index < count) { //for the rest of the elements in the list
				
					list[index] = list[index + 1]; //move them one place to the left 
					
					index++;
				}
			
				counter = 0; //in case the shifting of elements left moves another
							//occurence of removeelem to the first's spot,
							//this re-check the list starting from index 1 on
			}
			
			counter++;
		}
		
		if(list[0] == removeelem) { //in case another occurence of removeelem
									//got moved to index 0, this will re-check
									//index 0 and shift all elements in the list
									//left to remove removeelem at index 0
			
			int counter2 = 0;
			
			while(counter2 < count) {
			
				list[counter2] = list[counter2 + 1];
				
				counter2++;
			}
		}
	}
	
	/**
	 * Returns the amount of elements in list
	 * 
	 * @return the amount of elements in list
	 */
	public int count() {
		
		return count;
	}
	
	/**
	 * Returns the array list as a string
	 * 
	 * @return a string with the elements of list in order of the array
	 */
	public String toString() {
		
		String stringlist = String.valueOf(list[0]); //start with first elem
												//and then successively add on
		
		int counter = 1;
		
		while(counter < count) {

			String storedelem = String.valueOf(list[counter]);
			
			stringlist = stringlist + " " + storedelem; 
			
			counter++;
		}

		return stringlist;
	}
	
	/**
	 * Search list for a particular element
	 * 
	 * @param searchelem the element being searched for
	 * @return the index of the first occurrence of searchelem 
	 * or -1 if there are no occurrences
	 */
	public int search(int searchelem) {
		
		int counter = 0;
		
		while(counter < count) {
			
			if(list[counter] == searchelem)
				return counter;
			
			counter++;
		}
		
		return -1;
	}
}
