
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
		
		if (count != list.length) { //update the total number of elements
			
			int counter = count;
		
			while(counter > 0) {
			
				list[counter] = list[counter - 1]; //move all elements one space to the right
			
				counter--;
			
			}

			list[0] = addelem; 
			
			count++;
		
		}
		
		else {
			
			int[] holder = list; //create another pointer to the list array to preserve the data in the array
			
			list = new int[(int) (holder.length * 1.5)]; //create a new array for list; list now points to a different object
		
			int counter = count();
			
			while(counter > 1) {
			
				list[counter] = holder[counter - 1]; //move all elements one space to the right
			
				counter--;
			
			}
			
			list[0] = addelem; //add the new element to list

			count++; 
		}
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
				
					
					if (list[index + 1] != removeelem) {
						
						
						list[index] = list[index + 1]; //move them one place to the left 
					}
					
					else {
						
						int index2 = counter + 1;
						
						while(list[index2] == removeelem && index2 < list.length) { //while the next element is still the one we are 
																					//trying to replace
							
							index2++; //skip it
						}
						
						list[index] = list[index2];
						list[index2] = 0; //so multiple elements won't copy the value originally here

					}
					
					index++;
				} 
			
				count --;
			}
			
			counter++;
			
		}
		
		if((list.length * .25) < size()) {
			
			int[] holder = list; //create another pointer to the list array to preserve the data in the array
			
			list = new int[(int) (holder.length * .75)]; //create a new array for list; list now points to a different object
		
			int counter2 = 0;
			
			while(counter2 < count()) {
			
				list[counter2] = holder[counter2]; //move all elements one space to the right
			
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
		
		String stringlist = ""; //default return if no elements in list
		
		if (count() > 0) {
			
			stringlist = String.valueOf(list[0]); //start with first elem
												//and then successively add on
		
			int counter = 1;
		
			while(counter < count) {

				String storedelem = String.valueOf(list[counter]);
			
				stringlist = stringlist.concat(" ").concat(storedelem); 
			
				counter++;
			}
		
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
		
		int counter = count - 1;
		
		int found = -1; //will return -1 by default if searchelem not found
		
		while(counter >= 0) {
			
			if(list[counter] == searchelem) {
				found = counter; //reassings found to index if found
			}
			
			counter--;
		}
		
		return found;
	}
	
	/**
	 * Append an element to the end of the list
	 * 
	 * @param newint the integer being appended to the list
	 */
	public void append(int newint) {
		
		if (count() != list.length) { //if the array isn't full
			
			list[count()] = newint;
			
			count++;
		}
		
		else { //if the array is full
			
			int[] holder = list; //create another pointer to the list array to preserve the data in the array
			
			list = new int[(int) (holder.length * 1.5)]; //create a new array for list; list now points to a different object
			
			int index = 0;
			
			while(index < holder.length) { //for each element in holder
				
				list[index] = holder[index]; //copy it to list
			}
			
			list[count()] = newint; //add the new element to list

			count++;
		}
			
	}
	
	/**
	 * Return the first element of the list
	 * 
	 * @return the first element of the list or -1 if no elements in list
	 */
	public int first() {
		
		if(count() == 0) //where count returns the number of elements in the list currently
			return -1; 
		else
			return list[0];
	}
	
	/**
	 * Return the last element of the list
	 * 
	 * @return the last element of the list or -1 if no elements in list
	 */
	public int last() {
		
		if(count() == 0) //where count() is the number of elements in the list currently
			return -1; 
		else
			return list[count() - 1];
	}
	
	/**
	 * Return the current number of possible locations in the list
	 * 
	 * @return the current number of possible locations in the list
	 */
	public int size() {
		
		return list.length - count(); //where count returns the number of elements in the list currently
	}
}