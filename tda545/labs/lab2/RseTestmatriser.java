/** 
*	Matrix tests.
*
*	Checks if the rows in a matrix are equal.
*
*	@author Johan Brook (900720-0216), Robin Andersson (900122-0574)
*	@group 0
*	@assignment Lab 2, del 2
*	@date 2011-09-12
*/

public class RseTestmatriser {
	
	// --- Our code --------
	
	
	/**
	*	Doing the checks to see if the elements in the rows
	*	in a matrix are equal.
	*
	*	@param m The matrix.
	*	@return Returns true if the rows are equal, otherwise false.
	*/
	static boolean allRowSumsEqual(int[][] m){
		int firstRowSum = 0;
		
		// If we're dealing with a null array, or an empty array:
		if(m == null || m.length == 0){
			return true;
		}
		
		// Get the sum from the first row, unless it's null:
		if(m[0] != null){
			firstRowSum = rowSum(m[0]);
		}
		
		// Start from the second index and loop through and compare:
		for(int row = 1; row < m.length; row++){
			
			if(m[row] != null && firstRowSum != rowSum( m[row] )){				
				return false;
			}
		}
		
		return true;
	}
	
	
	/**
	*	Calculates the sum of the elements in an integer array.
	*
	*	@param v An int array.
	*	@return The sum of all elements in the array.
	*/
	static int rowSum(int[] v){
		int sum = 0;
		
		// If the array is empty, return 0:
		if(v.length == 0){
			return 0;
		}
		
		// Loop through and add to the sum variable:
		for(int i = 0; i < v.length; i++){
			sum = sum + v[i];
		}
	
		return sum;
	}
	
	
	
	
	
    
	// --- Erland's code --------

    static void print(int[][] m) {
        if ( m==null ) {
            System.out.print("[ null ]");
        } else if ( m.length == 0 ) {
            System.out.print("[ - ]");
        } else {
            System.out.print("[ ");
            for ( int row=0; row<m.length; row++ ) {
                if ( m[row]==null ) {
                    System.out.print("null ");
                } else {
                    System.out.print("{ ");
                    if ( m[row].length == 0 ) {
                        System.out.print("- ");
                    } else {
                        for ( int col=0; col<m[row].length; col++ ) {	
                            System.out.print( m[row][col] + " " ) ;
                        }
                    }
                    System.out.print("} ");
                }
            }
            System.out.print("]");
        }
    }


    // ---------- ---------- ---------- ----------


    public static void main(String[] args) {

    // Viktors testmatriser
    // en "tom matris/rad" finns men innehÃ¥ller inga tal, 
    // m.lenght gÃ¥r att anropa och ger alltsÃ¥ 0
    // en null matris/rad finns inte ens, 
    // m.length fÃ¥r inte anropas (ger nullPointerException)
    // ska ge true
            int[][] a = {{1, 2, 1, 2, 1, 2},
                         {4, 0, 0, 2, 2, 1},
                         {1, 1, 1, 1, 1, 4}};
    // ska ge false
            int[][] b = {{1, 2, 3, 4},
                         {5, 6, 7, 8},
                         {1, 1, 1, 1}};
    // ska ge true
            int[][] c = {{1},{2,-1},{3,-1,-1}};
    // bÃ¶r ge true, men gÃ¥r att motivera annat svar
            int[][] d = null;			// en null matris
            int[][] e = {null, null, null}; // matris med 3 null rader 
            int[][] f = {};				// matris med tom rad
    // ska ge true
            int[][] g = {{}};			// en matris med tom kolumn
            int[][] h = {{1,2,3}};
    // ska ge false
            int[][] i = {{1},{2},{3}};
    // ska ge true
            int[][] j = {{0}};
    // ska ge false
            int[][] k = {{1,2,3}, {3,2,1},   {4,4,4}};
            int[][] l = {{1,2,3}, {3,-2,-1}, {4,4,4}};	
    // ska ge true
            int[][] m ={{0, 0, 0, 0}, null, {5, 5, -5, -5}};
    // ska ge true
            int[][] n ={{0, 0, 0, 0}, null, {}};
    // ska ge false
            int[][] o ={{0, 0, 3, 0}, null, {}};
// tester
        boolean tmp;
        System.out.println();
        
        System.out.print("a= "); 
        tmp = allRowSumsEqual(a); // ska ge true
        System.out.print(tmp?" correct (T) ":" WRONG (T) "); 
        print(a); System.out.println(); 
        
        System.out.print("b= "); 
        tmp = allRowSumsEqual(b); // ska ge false
        System.out.print(!tmp?" correct (F) ":" WRONG (F) "); 
        print(b); System.out.println(); 
        
        System.out.print("c= "); 
        tmp = allRowSumsEqual(c); // ska ge true
        System.out.print(tmp?" correct (T) ":" WRONG (T) ");
        print(c); System.out.println(); 
        
        System.out.print("d= "); 
        tmp = allRowSumsEqual(d); // true, men gÃ¥r att motivera annat svar
        System.out.print(tmp?" correct (T) ":" WRONG (T) ");
        print(d); System.out.println(); 
        
        System.out.print("e= "); 
        tmp = allRowSumsEqual(e); // true, men gÃ¥r att motivera annat svar
        System.out.print(tmp?" correct (T) ":" WRONG (T) ");
        print(e); System.out.println(); 
        
        System.out.print("f= "); 
        tmp = allRowSumsEqual(f); // true, men gÃ¥r att motivera annat svar
        System.out.print(tmp?" correct (T) ":" WRONG (T) ");
        print(f); System.out.println(); 
        
        System.out.print("g= "); 
        tmp = allRowSumsEqual(g); // ska ge true
        System.out.print(tmp?" correct (T) ":" WRONG (T) ");
        print(g); System.out.println(); 
        
        System.out.print("h= "); 
        tmp = allRowSumsEqual(h); // ska ge true
        System.out.print(tmp?" correct (T) ":" WRONG (T) ");
        print(h); System.out.println(); 
        
        System.out.print("i= "); 
        tmp = allRowSumsEqual(i); // ska ge false
        System.out.print(!tmp?" correct (F) ":" WRONG (F) ");
        print(i); System.out.println(); 
        
        System.out.print("j= "); 
        tmp = allRowSumsEqual(j); // ska ge true
        System.out.print(tmp?" correct (T) ":" WRONG (T) ");
        print(j); System.out.println(); 
        
        System.out.print("k= "); 
        tmp = allRowSumsEqual(k); // ska ge false
        System.out.print(!tmp?" correct (F) ":" WRONG (F) ");
        print(k); System.out.println(); 
        
        System.out.print("l= "); 
        tmp = allRowSumsEqual(l); // ska ge false
        System.out.print(!tmp?" correct (F) ":" WRONG (F) ");
        print(l); System.out.println(); 
        
        System.out.print("m= "); 
        tmp = allRowSumsEqual(m); // ska ge true
        System.out.print(tmp?" correct (T) ":" WRONG (T) ");
        print(m); System.out.println(); 
        
        System.out.print("n= "); 
        tmp = allRowSumsEqual(n); // ska ge true
        System.out.print(tmp?" correct (T) ":" WRONG (T) ");
        print(n); System.out.println();
        
        System.out.print("o= "); 
        tmp = allRowSumsEqual(o); // ska ge false
        System.out.print(!tmp?" correct (F) ":" WRONG (F) ");
        print(o); System.out.println();

	}
}