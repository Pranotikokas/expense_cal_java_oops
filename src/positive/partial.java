package positive;

import java.util.Arrays;

public class partial {
	a = '100';
	s = 'Snacks'
	String[][] temp = { {'A', a , s , 'A', 'B', 'C', 'D'}, {'B', a , s , 'C', 'D'}, 
			{'D', a , s , 'A', 'B'} };
	 String[][] a = new String[2][];
	    for (int i = 1, j = 0; i < 3; i++, j++) {
	        a[j] = Arrays.copyOfRange(temp[i], 1, 3);
	    }
    System.out.println(Arrays.deepToString(a));

}
}
