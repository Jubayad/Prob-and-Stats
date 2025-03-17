import java.util.ArrayList;

public class Birthday {
    
    	public ArrayList<Integer> union(ArrayList<Integer> A, ArrayList<Integer> Subset)
	{
		ArrayList<Integer> union = new ArrayList<Integer>();                            //Makes a new array list called union
        
		for (int i = 0; i < A.size(); i++)                                              //Loops through the size of the array list.
		{
			union.add(A.get(i));                                                        //Adds the value of A to the union arraylist.
		}
		for (int i = 0; i < Subset.size(); i++)
		{
			union.add(Subset.get(i));                                                        //Adds the value of A to the union arraylist.
		}
		
		ArrayList<Integer> together = new ArrayList<Integer>();                         //Makes a new array list called together.

		for (int i = 0; i < union.size(); i++)                                          //Loops through the size of the array list.
		{
			if (!together.contains(union.get(i)))                                       //If the values of union are not in the array list together.
			{
				together.add(union.get(i));                                             //Add the values to the arraylist together.
			}
		}
	
		return together;
	}
	
	public ArrayList<Integer> intersect(ArrayList<Integer> A, ArrayList<Integer> Subset)
	{
		ArrayList<Integer> intersect = new ArrayList<Integer>();                        //Creates a new array list called intersect.

		for (int i = 0; i < A.size(); i++)                                             //Loops through the size of the array list A.
		{
			for (int j = 0; j < Subset.size(); j++)                                         //Loops through the size of the array list B.
		
			{
				if (Subset.get(j) == A.get(i))                                              //If value of array list B matches array list A
				{
					intersect.add(Subset.get(j));                                           //Add the values to the intesect array list.
				}
			}
		}
		
		ArrayList<Integer> unique = new ArrayList<Integer>();                          //Creates a new array list called unique.

		for (int i = 0; i < intersect.size(); i++)                                     //Loops through the size of the array list intersect.
		{
			if (!unique.contains(intersect.get(i)))                                    //If the array of intersect does not contain values of the array list unique
			{
				unique.add(intersect.get(i));                                          //Add the values to the array list unique.
			}
		}
		
		return unique;
	} 

    public ArrayList<Integer> complement(ArrayList<Integer> A, ArrayList<Integer> Subset)
	{
		if (Subset.size() > A.size())                                                  
		{
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp = A;
			A = Subset;
			Subset = temp;
			
		}
		
		ArrayList<Integer> complement = new ArrayList<Integer>();
		for (int i = 0; i < A.size(); i++)
		{
			if (!Subset.contains(A.get(i)))
			{
				complement.add(A.get(i));
			}
		}
		return complement;
	}
}
