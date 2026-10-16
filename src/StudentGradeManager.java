import java.util.*;

public class StudentGradeManager {
    
    public ArrayList students = new ArrayList();
    public int count = 0;
    
    public void doStuff(String n, int a, double g1, double g2, double g3, String e) {
        double avg = (g1 + g2 + g3) / 3;
        
        if (avg >= 0) {
            if (avg >= 60) {
                if (avg >= 70) {
                    if (avg >= 80) {
                        if (avg >= 90) {
                            System.out.println(n + " gets an A");
                        } else {
                            System.out.println(n + " gets a B");
                        }
                    } else {
                        System.out.println(n + " gets a C");
                    }
                } else {
                    System.out.println(n + " gets a D");
                }
            } else {
                System.out.println(n + " gets an F");
            }
        }
        
        String info = "";
        info = info + "Name: " + n + ", ";
        info = info + "Age: " + a + ", ";
        info = info + "Email: " + e + ", ";
        info = info + "Average: " + avg;
        
        students.add(info);
        count++;
        
        System.out.println("Student added. Total students: " + count);
        
        String sql = "INSERT INTO students VALUES ('" + n + "', " + a + ", " + avg + ", '" + e + "')";
        System.out.println("Executing: " + sql);
    }
    
    public String getLetterGrade(double g1, double g2, double g3) {
        double avg = (g1 + g2 + g3) / 3;
        
        if (avg >= 90) {
            return "A";
        } else if (avg >= 80) {
            return "B";
        } else if (avg >= 70) {
            return "C";
        } else if (avg >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
    
    public void printAll() {
        for (int i = 0; i < students.size(); i++) {
            Object s = students.get(i);
            System.out.println(s);
        }
    }
    
    public void calculateClassAverage() {
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += Double.parseDouble((String)students.get(i));
        }
        double classAvg = sum / count;
        System.out.println("================================");
        System.out.println("Class Average: " + classAvg);
        System.out.println("================================");
    }
}