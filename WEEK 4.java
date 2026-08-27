1.Constraint-Driven Solution Design

  class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        String a = s.substring(0, n / 2);
        String b = s.substring(n / 2);

        return countVowels(a) == countVowels(b);
    }

    private int countVowels(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (isVowel(c)) {
                count++;
            }
        }
        return count;
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}

2.Constraint-Driven Solution Design

  import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            int n = s.length();
            int[] count1 = new int[26];
            int[] count2 = new int[26];

            
            for (int i = 0; i < n / 2; i++) {
                count1[s.charAt(i) - 'a']++;
            }

           
            for (int i = (n + 1) / 2; i < n; i++) {
                count2[s.charAt(i) - 'a']++;
            }

            boolean isLapindrome = true;

           
            for (int i = 0; i < 26; i++) {
                if (count1[i] != count2[i]) {
                    isLapindrome = false;
                    break;
                }
            }

            System.out.println(isLapindrome ? "YES" : "NO");
        }

        sc.close();
    }
}

3.Competitive Problem Patterns

  import java.io.*;
import java.util.*;

public class Solution {

    
    static int[] compareTriplets(int[] a, int[] b) {
        int aliceScore = 0;
        int bobScore = 0;

        for (int i = 0; i < 3; i++) {
            if (a[i] > b[i]) {
                aliceScore++;
            } else if (a[i] < b[i]) {
                bobScore++;
            }
        }

        return new int[]{aliceScore, bobScore};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int[] a = new int[3];

        for (int i = 0; i < 3; i++) {
            int aItem = Integer.parseInt(aTemp[i]);
            a[i] = aItem;
        }

        String[] bTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int[] b = new int[3];

        for (int i = 0; i < 3; i++) {
            int bItem = Integer.parseInt(bTemp[i]);
            b[i] = bItem;
        }

        int[] result = compareTriplets(a, b);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

4.Competitive Problem Patterns

  import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}

5.Writing Efficient Code

  import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

class Result {

    public static String timeConversion(String s) {
        String period = s.substring(8, 10);
        String timePart = s.substring(0, 8);
        String[] timeComponents = timePart.split(":");
        int hour = Integer.parseInt(timeComponents[0]);
        String minute = timeComponents[1];
        String second = timeComponents[2];

        if (period.equals("AM")) {
            if (hour == 12) {
                hour = 0;
            }
        } else { // PM
            if (hour != 12) {
                hour += 12;
            }
        }

        return String.format("%02d:%s:%s", hour, minute, second);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

6. Writing Efficient Code

  class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[nonZeroIndex];
                nums[nonZeroIndex] = temp;
                nonZeroIndex++;
            }
        }
    }
}

7.Matrix Basics

  import java.util.Scanner;

class Solution {

    public static int diagonalDifference(int[][] arr) {
        int n = arr.length;
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int i = 0; i < n; i++) {
            primaryDiagonalSum += arr[i][i];
            secondaryDiagonalSum += arr[i][n - 1 - i];
        }

        return Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int result = diagonalDifference(arr);
        System.out.println(result);
        scanner.close();
    }
}

8. Matrix Basics

  class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] transposedMatrix = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }
}

9.Strassen’s Matrix Multiplication

  class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] answer = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int r = Math.max(0, i - k); r <= Math.min(m - 1, i + k); r++) {
                    for (int c = Math.max(0, j - k); c <= Math.min(n - 1, j + k); c++) {
                        sum += mat[r][c];
                    }
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}
10.Strassen’s Matrix Multiplication
  import java.util.*;

public class MatrixRotation {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();

       

        int numLayers = Math.min(m, n) / 2;

        for (int layer = 0; layer < numLayers; layer++) {
          
            List<Integer> currentLayer = new ArrayList<>();

            
            for (int j = layer; j < n - 1 - layer; j++) {
                currentLayer.add(matrix.get(layer).get(j));
            }

            
            for (int i = layer; i < m - 1 - layer; i++) {
                currentLayer.add(matrix.get(i).get(n - 1 - layer));
            }

            
            for (int j = n - 1 - layer; j > layer; j--) {
                currentLayer.add(matrix.get(m - 1 - layer).get(j));
            }

            
            for (int i = m - 1 - layer; i > layer; i--) {
                currentLayer.add(matrix.get(i).get(layer));
            }

            
            int layerWidth = n - 2 * layer;
            int layerHeight = m - 2 * layer;
            int elementsInLayer = currentLayer.size();
            int effectiveRotations = r % elementsInLayer;

            
            if (effectiveRotations > 0) {
                List<Integer> rotatedLayer = new ArrayList<>();
                for (int i = 0; i < elementsInLayer; i++) {
                    rotatedLayer.add(currentLayer.get((i + effectiveRotations) % elementsInLayer));
                }
                currentLayer = rotatedLayer;
            }

           
            int currentIndex = 0;

            
            for (int j = layer; j < n - 1 - layer; j++) {
                matrix.get(layer).set(j, currentLayer.get(currentIndex++));
            }

            
            for (int i = layer; i < m - 1 - layer; i++) {
                matrix.get(i).set(n - 1 - layer, currentLayer.get(currentIndex++));
            }

            
            for (int j = n - 1 - layer; j > layer; j--) {
                matrix.get(m - 1 - layer).set(j, currentLayer.get(currentIndex++));
            }

            
            for (int i = m - 1 - layer; i > layer; i--) {
                matrix.get(i).set(layer, currentLayer.get(currentIndex++));
            }
        }

        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix.get(i).get(j) + (j == n - 1 ? "" : " "));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int r = scanner.nextInt();

        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(scanner.nextInt());
            }
            matrix.add(row);
        }

        matrixRotation(matrix, r);

        scanner.close();
    }
}

Strassen’s Matrix Multiplication
  
class Solution {
    public ArrayList<ArrayList<Integer>> multiply(int[][] mat1, int[][] mat2) {
        int n = mat1.length;

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int sum = 0;

                for (int k = 0; k < n; k++) {
                    sum += mat1[i][k] * mat2[k][j];
                }

                row.add(sum);
            }

            result.add(row);
        }

        return result;
    }
}
