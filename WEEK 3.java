1.Day of the week java
  
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = {
            "Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday"
        };

        int[] monthDays = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        int totalDays = 0;

        
        for (int y = 1971; y < year; y++) {
            totalDays += 365;
            if (isLeapYear(y)) {
                totalDays++;
            }
        }

        
        for (int m = 1; m < month; m++) {
            totalDays += monthDays[m - 1];
            
            if (m == 2 && isLeapYear(year)) {
                totalDays++;
            }
        }

     
        totalDays += day - 1;

        return days[(totalDays + 5) % 7];
    }


  2.Day of the year

  class Solution {
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

       
        if (isLeapYear(year)) {
            daysInMonth[2] = 29;
        }

        int dayOfYear = 0;
        for (int i = 1; i < month; i++) {
            dayOfYear += daysInMonth[i];
        }
        dayOfYear += day;

        return dayOfYear;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}


3.java arraylist.java

  import java.util.ArrayList;
import java.util.Scanner;

public class DynamicArrayQueries {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        ArrayList<ArrayList<Integer>> lines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int numElements = scanner.nextInt();
            ArrayList<Integer> line = new ArrayList<>();
            for (int j = 0; j < numElements; j++) {
                line.add(scanner.nextInt());
            }
            lines.add(line);
        }

        int numQueries = scanner.nextInt();
        for (int k = 0; k < numQueries; k++) {
            int lineIndex = scanner.nextInt();
            int positionIndex = scanner.nextInt();

            if (lineIndex >= 1 && lineIndex <= n) {
                ArrayList<Integer> selectedLine = lines.get(lineIndex - 1);
                if (positionIndex >= 1 && positionIndex <= selectedLine.size()) {
                    System.out.println(selectedLine.get(positionIndex - 1));
                } else {
                    System.out.println("ERROR!");
                }
            } else {
                System.out.println("ERROR!");
            }
        }

        scanner.close();
    }
}

4.java comparator.java

  import java.util.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b) {
        if (a.score != b.score) {
            return b.score - a.score;
        } else {
            return a.name.compareTo(b.name);
        }
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Player[] player = new Player[n];
        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Checker checker = new Checker();
        Arrays.sort(player, checker);

        for (int i = 0; i < n; i++) {
            System.out.printf("%s %d\n", player[i].name, player[i].score);
        }
    }
}

    private boolean isLeapYear(int year) {
        return (year % 400 == 0) ||
               (year % 4 == 0 && year % 100 != 0);
    }
}

5. java date and time

  import java.io.*;
import java.util.*;
import java.text.*;

class Result {

    
    public static String findDay(int month, int day, int year) {
       
        Calendar calendar = Calendar.getInstance();

        
        calendar.set(year, month - 1, day); 

        
        int dayOfWeekInt = calendar.get(Calendar.DAY_OF_WEEK);

       
        String[] days = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};

        
        return days[dayOfWeekInt - 1]; 
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

6.java priority queue

  import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }

    @Override
    public int compareTo(Student other) {
        if (this.cgpa != other.cgpa) {
            return Double.compare(other.cgpa, this.cgpa);
        }
        if (!this.name.equals(other.name)) {
            return this.name.compareTo(other.name);
        }
        return Integer.compare(this.id, other.id);
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<>();

        for (String event : events) {
            String[] parts = event.split(" ");
            String type = parts[0];

            if (type.equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                pq.add(new Student(id, name, cgpa));
            } else if (type.equals("SERVED")) {
                if (!pq.isEmpty()) {
                    pq.poll();
                }
            }
        }

        List<Student> remainingStudents = new ArrayList<>();
        while (!pq.isEmpty()) {
            remainingStudents.add(pq.poll());
        }
        return remainingStudents;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        List<String> events = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            events.add(in.nextLine());
        }

        Priorities priorities = new Priorities();
        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student student : students) {
                System.out.println(student.getName());
            }
        }

        in.close();
    }
}

7.Largest number

  import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        String[] sNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sNums[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        };

        Arrays.sort(sNums, comp);

        if (sNums[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : sNums) {
            sb.append(s);
        }

        return sb.toString();
    }
}

8.Number of days between two dates

  import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        LocalDate d1 = LocalDate.parse(date1);
        LocalDate d2 = LocalDate.parse(date2);
        return (int) Math.abs(ChronoUnit.DAYS.between(d1, d2));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String date1_ex1 = "2019-06-29";
        String date2_ex1 = "2019-06-30";
        System.out.println("Example 1:");
        System.out.println("Input: date1 = \"" + date1_ex1 + "\", date2 = \"" + date2_ex1 + "\"");
        System.out.println("Output: " + sol.daysBetweenDates(date1_ex1, date2_ex1));
        System.out.println();

        String date1_ex2 = "2020-01-15";
        String date2_ex2 = "2019-12-31";
        System.out.println("Example 2:");
        System.out.println("Input: date1 = \"" + date1_ex2 + "\", date2 = \"" + date2_ex2 + "\"");
        System.out.println("Output: " + sol.daysBetweenDates(date1_ex2, date2_ex2));
        System.out.println();

        String date1_ex3 = "2023-11-01";
        String date2_ex3 = "2024-02-10";
        System.out.println("Additional Test Case:");
        System.out.println("Input: date1 = \"" + date1_ex3 + "\", date2 = \"" + date2_ex3 + "\"");
        System.out.println("Output: " + sol.daysBetweenDates(date1_ex3, date2_ex3));
        System.out.println();
    }
}

9.Sort the people

  import java.util.*;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        
     
        HashMap<Integer, String> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.put(heights[i], names[i]);
        }
        
        
        Arrays.sort(heights);
        
        String[] result = new String[n];
        
        for (int i = 0; i < n; i++) {
            result[i] = map.get(heights[n - 1 - i]);
        }
        
        return result;
    }
}

