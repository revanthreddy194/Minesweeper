package Package1;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class InitialiseExp {
	
	private int row = 12;
	private int col = 12;
	private int mines = 10;
	public int flag = 0;
	
	int mat[][] = new int[row][col]; //Matrix which stores the skeleton system
	int unvealedMat[][] = new int[row-2][col-2];//This mat has only unvealed indexes
	//This Method initializes mines at random places
	private void intializeMines()
	{
		int min = 1; //random index values
		int occIndex = 0; //Variable which counts the no.of mines initialized
		
		//Initializing mines(*) in random positions
		while(occIndex < mines)
		{
			int x = ThreadLocalRandom.current().nextInt(min, (row - 2) + 1);
			int y = ThreadLocalRandom.current().nextInt(min,(col - 2) + 1);
			if(mat[x][y] == 0){ //if the generated random field has zero then 
				mat[x][y] = 9 ; // 9(mine) is initialized
			occIndex++;
			}
		}
		
		//Displays the matrix to test the initialization of mines at random position
		//showMat(); 
	}
	
	private void intializeNumbers() throws Exception
	{
		int i,j;
	    // Iterate over each row 
	    for(i=1; i<=row-2; i++)
	    {
	        // Iterate over each column 
	        for(j=1; j<=col-2; j++)
	        {
	        	// Logic for Top left corner 
	        	if(i==1 && j==1)
	            {
	               	if(mat[i][j] == 9)
	            	{
	            		
	            		if(mat[i][j+1] != 9) {mat[i][j+1] += 1;} 
	            		if(mat[i+1][j] !=9) {mat[i+1][j] += 1;} 
	            		if(mat[i+1][j+1] !=9) {mat[i+1][j+1] += 1;}
	            	}
	            }      
	            else if(i==1 && (j>=2 && j<=col-3))
	            {
	           	   //1st row inner fields
	            	if(mat[i][j] == 9)
	            	{
	            					           	 	
            		if(mat[i][j-1] !=9) {mat[i][j-1] += 1;} 
            		if(mat[i][j+1] != 9) {mat[i][j+1] += 1;} 
            		if(mat[i+1][j-1] != 9) { mat[i+1][j-1] += 1;} 
            		if(mat[i+1][j] !=9) {mat[i+1][j] += 1;} 
            		if(mat[i+1][j+1] !=9) {mat[i+1][j+1] += 1;}
	            	}
	            }
	            else if(i==1 && j==col-2)
		        {
		        // Logic for Top right corner 
	            	if(mat[i][j] == 9)
	            	{
		         	
	            		if(mat[i][j-1] !=9) {mat[i][j-1] += 1;} 
	            		if(mat[i+1][j-1] != 9) { mat[i+1][j-1] += 1;} 
	            		if(mat[i+1][j] !=9) {mat[i+1][j] += 1;} 
	            	
	            	}
		        }
	            else if(j==1 && (i>=2 && i<=row-3))
	            {
            	   //1st column inner fields
	            	if(mat[i][j] == 9)
	            	{
	            	
	            		if(mat[i-1][j] !=9) {mat[i-1][j] += 1;}
	            		if(mat[i-1][j+1] !=9) {mat[i-1][j+1] += 1;} 
	            		if(mat[i][j+1] != 9) {mat[i][j+1] += 1;} 
	            		if(mat[i+1][j] !=9) {mat[i+1][j] += 1;} 
	            		if(mat[i+1][j+1] !=9) {mat[i+1][j+1] += 1;}
	            	}	
	            }
	            
	            else if(i==row-2 && j==1)
	            {
	            //logic for bottom left corner
	            	if(mat[i][j] == 9)
	            	{
	            		 		
	            		if(mat[i-1][j] !=9) {mat[i-1][j] += 1;}
	            		if(mat[i-1][j+1] !=9) {mat[i-1][j+1] += 1;} 
	            		if(mat[i][j+1] != 9) {mat[i][j+1] += 1;} 
	            		
	            	}
	            }
	            else if(i==row-2 && (j>=2 && j<=col-3))
	            {
	           	   //5th row inner fields
	            	if(mat[i][j] == 9)
	            	{
	            		
	            		if(mat[i-1][j-1] !=9) {mat[i-1][j-1] += 1;} 
	            		if(mat[i-1][j] !=9) {mat[i-1][j] += 1;}
	            		if(mat[i-1][j+1] !=9) {mat[i-1][j+1] += 1;} 
	            		if(mat[i][j-1] !=9) {mat[i][j-1] += 1;} 
	            		if(mat[i][j+1] != 9) {mat[i][j+1] += 1;} 
	            		
	            	}
            	}
	            else if(i==row-2 && j==col-2)
	            {
	            //logic for bottom right corner
	            	if(mat[i][j] == 9)
	            	{
	            		if(mat[i-1][j-1] !=9) {mat[i-1][j-1] += 1;}  
	            		if(mat[i-1][j] !=9) {mat[i-1][j] += 1;}
	            		if(mat[i][j-1] !=9) {mat[i][j-1] += 1;} 
	            	}
	            }
	            
	            
	            else if(j==col-2 && (i>=2 && i<=row-3))
	            {
	           	   //5th column inner fields
	            	if(mat[i][j] == 9)
	            	{
	            		if(mat[i-1][j] !=9) {mat[i-1][j] += 1;}
	            		if(mat[i-1][j-1] !=9) {mat[i-1][j-1] += 1;} 
	            		if(mat[i][j-1] !=9) {mat[i][j-1] += 1;} 
	            		if(mat[i+1][j-1] != 9) { mat[i+1][j-1] += 1;} 
	            		if(mat[i+1][j] !=9) {mat[i+1][j] += 1;} 
	            	}
	            }
	                       
	            else 
	            {
	            	//Logic for inner fields
	            	if(mat[i][j] == 9)
	            	{
	            		
	            		if(mat[i-1][j-1] !=9) {mat[i-1][j-1] += 1;} 
	            		if(mat[i-1][j] !=9) {mat[i-1][j] += 1;}
	            		if(mat[i-1][j+1] !=9) {mat[i-1][j+1] += 1;} 
	            		if(mat[i][j-1] !=9) {mat[i][j-1] += 1;} 
	            		if(mat[i][j+1] != 9) {mat[i][j+1] += 1;} 
	            		if(mat[i+1][j-1] != 9) { mat[i+1][j-1] += 1;} 
	            		if(mat[i+1][j] !=9) {mat[i+1][j] += 1;} 
	            		if(mat[i+1][j+1] !=9) {mat[i+1][j+1] += 1;}
	            	}
	            }
	        }

	     }
	    //displays internal matric which shows mined and numbers
	    //Note: not to be shown to the players(testing purpose only)
	    //showMat();
	    //System.out.println("***********************");
		
	}
				
	private void showMat() {
		//to display matrix
		int i,j;
		for(i=1; i<=row-2; i++)
	    {
	        // Iterate over each column 
	        for(j=1; j<=col-2; j++)
	        {
	           System.out.print(mat[i][j] + " ");
	        }

	        // Move to the next line/row 
	        System.out.print("\n");
		} 

	}
	
	private void showUnvealedMat()
	{
		//to display only unvealed matrix
		int i,j;
		for(i=0; i<=row-3; i++)
	    {
	        // Iterate over each column 
	        for(j=0; j<=col-3; j++)
	        {
	           System.out.print(unvealedMat[i][j] + " ");
	        }

	        // Move to the next line/row 
	        System.out.print("\n");
		} 
	}
	private void unvealMain(int x, int y)
	{
		//Manually select fields by giving row and column value
		int i = x;//Change it for every selection for time being
		int j = y;//Both i and j must be between 1 and 5 inclusive
		
		//TO CHECK(AVOID) THE OUTER FIELDS
		if(i == 0 || j == 0 || i == row-1 || j == col-1)
		{
			System.out.println("Enter Valid Field Number");
		}
		else //Enters if the entered fields are not outer ones
		{   
			if(mat[i][j] == 0) //if it is zero then explore surroundings
			{
				unvealSurroundings(i,j);
			}
			else if(mat[i][j] == 9) //if it is mine, then game over
			{
				System.out.println("GAME OVER!! It's a mine. ");
				
				flag = 1;
				
				showMat();
				
				System.exit(0);
			}
			else //if it is count of surrounding mines, then reveal it
			{
				if(mat[i][j] != 8)
				{
					unvealedMat[i-1][j-1] = mat[i][j];
					mat[i][j] = 8;
				}
				else if(mat[i][j] == 8)
				{
					System.out.println("The selected field is already opened!");
				}
			}
			//CHECK if the user won or not
			checkWinOrNot();
		}
		//showMat();
		showUnvealedMat();
		
	}
	private void checkWinOrNot() 
	{
		int i,j;
		int countUnvealed = 0;
		for(i=1; i<=row-2; i++)
	    {
	        // Iterate over each column 
	        for(j=1; j<=col-2; j++)
	        {
	           if(mat[i][j] == 8)
	           {
	        	   countUnvealed ++; //counting the unvealed fields
	           }
	        }
		} 
		//count total no of Non-Mine positions excluding the outer hidden fields
		int totalNonMines = ((row-2)*(col-2)) - mines;
		
		//if count of unvealed fields and total non-mine fields are equal, WON!
		if(countUnvealed == totalNonMines)
		{
			System.out.println("Congratulations!! You Won!");
			//showMat();
			showUnvealedMat();
			System.exit(0);
		}
		
	}

	private void unvealSurroundings(int i, int j) 
	{	
		//Check for outer fields
		if(i == 0 || i == 11 || j == 0 || j == 11)
		{
			mat[i][j] = 0;
		}
		
		// ONE: Logic for Top left corner
		else if(i==1 && j==1)
		{
			if(mat[i][j] == 0) //if it is zero only then it has to enter
			{
				mat[i][j] = 8;
				unvealedMat[i-1][j-1] =8;
				unvealSurroundings(i,j+1);
				unvealSurroundings(i+1,j+1);
				unvealSurroundings(i+1,j);
			}
			//check for mines and unvealed(8) fields 
			else if(mat[i][j] == 9 || mat[i][j] == 8)
			{
					
			}
			else
			{
				unvealedMat[i-1][j-1] = mat[i][j];
				mat[i][j] = 8;
				
			}
		}
		
		
		//TWO: 1st row inner fields
		else if(i==1 && (j>=2 && j<=9))
		{
			if(mat[i][j] == 0) //if it is zero only then it has to enter
			{
				mat[i][j] = 8;
				unvealedMat[i-1][j-1] =8;
				unvealSurroundings(i,j+1);
				unvealSurroundings(i+1,j+1);
				unvealSurroundings(i+1,j);
				unvealSurroundings(i+1,j-1);
				unvealSurroundings(i,j-1);
			}
			//check for mines and unvealed(8) fields 
			else if(mat[i][j] == 9 || mat[i][j] == 8)
			{
					
			}
			else
			{
				unvealedMat[i-1][j-1] = mat[i][j];
				mat[i][j] = 8;
			}
		}
		
		
		//THREE: Logic for Top right corner 
		else if(i==1 && j==10)
		{
			if(mat[i][j] == 0) //if it is zero only then it has to enter
			{
				mat[i][j] = 8;
				unvealedMat[i-1][j-1] =8;
				unvealSurroundings(i,j-1);
				unvealSurroundings(i-1,j-1);
				unvealSurroundings(i-1,j);
			}
			//check for mines and unvealed(8) fields 
			else if(mat[i][j] == 9 || mat[i][j] == 8)
			{
					
			}
			else
			{
				unvealedMat[i-1][j-1] = mat[i][j];
				mat[i][j] = 8;
			}
		}
		
		//FOURTH: 1st column inner fields
		else if(j==1 && (i>=2 && i<=9))
		{
			if(mat[i][j] == 0) //if it is zero only then it has to enter
			{
				mat[i][j] = 8;
				unvealedMat[i-1][j-1] =8;
				unvealSurroundings(i,j+1);
				unvealSurroundings(i+1,j+1);
				unvealSurroundings(i+1,j);
				unvealSurroundings(i-1,j);
				unvealSurroundings(i-1,j+1);
			}
			//check for mines and unvealed(8) fields 
			else if(mat[i][j] == 9 || mat[i][j] == 8)
			{
					
			}
			else
			{
				unvealedMat[i-1][j-1] = mat[i][j];
				mat[i][j] = 8;
			}
			
		}
		
		//FIFTH: logic for bottom left corner
		else if(i==10 && j==1)
		{
			if(mat[i][j] == 0) //if it is zero only then it has to enter
			{
				mat[i][j] = 8;
				unvealedMat[i-1][j-1] =8;
				unvealSurroundings(i,j+1);
				unvealSurroundings(i-1,j);
				unvealSurroundings(i-1,j+1);
			}
			//check for mines and unvealed(8) fields 
			else if(mat[i][j] == 9 || mat[i][j] == 8)
			{
					
			}
			else
			{
				unvealedMat[i-1][j-1] = mat[i][j];
				mat[i][j] = 8;
			}
			
		}
		
		//SIXTH: 5th row inner fields
	 	else if(i==10 && (j>=2 && j<=9))
		{
	 		if(mat[i][j] == 0) //if it is zero only then it has to enter
			{
				mat[i][j] = 8;
				unvealedMat[i-1][j-1] =8;
				unvealSurroundings(i,j+1);
				unvealSurroundings(i,j-1);
				unvealSurroundings(i-1,j-1);
				unvealSurroundings(i-1,j);
				unvealSurroundings(i-1,j+1);
			}
			//check for mines and unvealed(8) fields 
			else if(mat[i][j] == 9 || mat[i][j] == 8)
			{
					
			}
			else
			{
				unvealedMat[i-1][j-1] = mat[i][j];
				mat[i][j] = 8;
			}
		}
		
		//SEVEN: logic for bottom right corner
		else if(i==10 && j==10)
		{
			if(mat[i][j] == 0) //if it is zero only then it has to enter
			{
				mat[i][j] = 8;
				unvealedMat[i-1][j-1] =8;
				unvealSurroundings(i,j-1);
				unvealSurroundings(i-1,j-1);
				unvealSurroundings(i-1,j);
			}
			//check for mines and unvealed(8) fields 
			else if(mat[i][j] == 9 || mat[i][j] == 8)
			{
					
			}
			else
			{
				unvealedMat[i-1][j-1] = mat[i][j];
				mat[i][j] = 8;
			}
		}
		
		//EIGHT: 5th column inner fields
		else if(j==10 && (i>=2 && i<=9))
		{
			if(mat[i][j] == 0) //if it is zero only then it has to enter
			{
				mat[i][j] = 8;
				unvealedMat[i-1][j-1] =8;
				unvealSurroundings(i+1,j);
				unvealSurroundings(i+1,j-1);
				unvealSurroundings(i,j-1);
				unvealSurroundings(i-1,j-1);
				unvealSurroundings(i-1,j);
			}
			//check for mines and unvealed(8) fields 
			else if(mat[i][j] == 9 || mat[i][j] == 8)
			{
					
			}
			else
			{
				unvealedMat[i-1][j-1] = mat[i][j];
				mat[i][j] = 8;
			}
		}
		
		//NINE: Logic for inner fields 
		else
		{
			if(mat[i][j] == 0) //if it is zero only then it has to enter
			{
				mat[i][j] = 8;
				unvealedMat[i-1][j-1] =8;
				unvealSurroundings(i,j+1);
				unvealSurroundings(i+1,j+1);
				unvealSurroundings(i+1,j);
				unvealSurroundings(i+1,j-1);
				unvealSurroundings(i,j-1);
				unvealSurroundings(i-1,j-1);
				unvealSurroundings(i-1,j);
				unvealSurroundings(i-1,j+1);
			}
			//check for mines and unvealed(8) fields 
			else if(mat[i][j] == 9 || mat[i][j] == 8)
			{
					
			}
			else
			{
				unvealedMat[i-1][j-1] = mat[i][j];
				mat[i][j] = 8;
			}
		}
		
	}
	
	private void playMines()
	{
		
		
		Scanner sc = new Scanner(System.in);
		
		try
		{
			//Accepts input(row,col) from user 	
			System.out.println("Enter the indexes(row,column) position to open: ");
			int row=sc.nextInt();
			int col=sc.nextInt();
			
			//this method opens the selected field
			unvealMain(row,col);
		}
		catch(Exception e)
		{
			System.out.println("Enter valid index numbers!");
		}
		if(flag == 0)
		{
			playMines();
		}
	}
	
	public void mainPlay() throws Exception
	{
		//On calling this method, the mines get initialized randomly 
		intializeMines();
		//On calling this method, the corresponding numbers get initialized
		intializeNumbers();
		
		//this method shows the game matrix
		showUnvealedMat();
		//this method starts the game
		playMines();
	}
}
