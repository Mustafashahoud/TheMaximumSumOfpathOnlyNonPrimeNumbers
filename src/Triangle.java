import java.nio.file.Paths;
import java.nio.file.*;
import static java.util.Arrays.stream;

		
public class Triangle {
public static void main(String[] args)throws Exception{
	
//Create 2 dimensional array with the input triangle
	int[][] data = Files.lines(Paths.get("triangle.txt"))
            .map(s -> stream(s.trim().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray())
            .toArray(int[][]::new);
	
//Print the Array
//	try {
//		for(int i = 0; i < data.length; i++) 
//			for(int j = 0; j < data[i].length; j++) {
//				System.out.println(data[i][j]);
//			}
//		
//    } catch(ArrayIndexOutOfBoundsException e) {e.printStackTrace(); }

for (int i = data.length - 1; i >= 0; i--)	
 for (int j = 0; j < data[i].length - 1; j++)
  {
     
     if(!checkPrime(data[i - 1][j])) {
    	 
         System.out.println("öAdd the max to The top element");
         
         data[i - 1][j] += Math.max(
                 data[i][j],data[i][j + 1]);
         System.out.println("-->"+data[i - 1][j]);
     }
     else {
         data[i - 1][j] = 0;
     }
 }

System.out.println("Maximum Sum Is : "+data[0][0]);

}

private static boolean checkPrime(int i) {
	int factors = 0;
    int j = 1;

    while(j <= i)
    {
        if(i % j == 0)
        {
            factors++;
        }
        j++;
    }
    return (factors == 2);

}

}