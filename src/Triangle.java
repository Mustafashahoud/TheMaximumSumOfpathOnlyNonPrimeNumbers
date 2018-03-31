import java.nio.file.Paths;
import java.nio.file.*;
import static java.util.Arrays.stream;

public class Triangle {
	public static void main(String[] args) throws Exception {

		// Create 2 dimensional array with the input triangle
		int[][] data = Files.lines(Paths.get("triangle.txt"))
				.map(s -> stream(s.trim().split("\\s+")).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
		
	


		for (int i = data.length - 1 ; i > 0 ; i--)
			for (int j = 0; j < data[i].length - 1; j++) {
				System.out.println("---------------------");
				System.out.println("lenIndex is : " + i);
				
				if (!isPrimeNum(data[i - 1][j]) || (i ==1)) {
					
					if (i == data.length - 1) {
						
						System.out.println(" i : (14) = data.length-1 : (14)");
						
						data[i - 1][j] += Math.max(isPrimeNum(data[i][j]) ? 0 : data[i][j],
								isPrimeNum(data[i][j + 1]) ? 0 : data[i][j + 1]);

						System.out.println("data[i][j] : " + data[i][j] + " data[i][j + 1] :" + data[i][j + 1]);
						
						System.out.println("Selected Number is: " + Math.max(isPrimeNum(data[i][j]) ? 0 : data[i][j],
								isPrimeNum(data[i][j + 1]) ? 0 : data[i][j + 1]));
						
					}
					
					else {
						data[i - 1][j] += Math.max(data[i][j], data[i][j + 1]);
						System.out.println("data[i][j] : " + data[i][j] + " data[i][j + 1] :" + data[i][j + 1]);
						System.out.println("Selected Number is" + Math.max(data[i][j], data[i][j + 1]));
					}
					System.out.println("After Sum #" + data[i - 1][j]);
				} else {
					System.out.println("Prime Number - Skiping : " + data[i - 1][j]);
					data[i - 1][j] = 0;
				}
			}

		System.out.println("Maximum Sum Is : " + data[0][0]);

	}

	private static boolean isPrimeNum(int i) {
		int factors = 0;
		int j = 1;

		while (j <= i) {
			if (i % j == 0) {
				factors++;
			}
			j++;
		}
		return (factors == 2);

	}

}

