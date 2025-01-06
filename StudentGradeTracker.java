import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentGradeTracker {

  
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/student_grades_db?serverTimezone=UTC";
    static final String JDBC_USER = "USER";  
    static final String JDBC_PASS = "1234567890";  

    public static void main(String[] args) {

     
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

       
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Enter the total number of Students: ");
        int totalStudent = sc.nextInt();
        sc.nextLine();  

       
        String[] studentNames = new String[totalStudent];
        int[] studentMarks = new int[totalStudent];

       
        int totalMarks = 0;
        int maxMarks = Integer.MIN_VALUE;
        int minMarks = Integer.MAX_VALUE;

      
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS)) {

            
            String insertSQL = "INSERT INTO student_grades (student_name, marks) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

              
                for (int i = 0; i < totalStudent; i++) {
                    System.out.println("Enter the name of Student " + (i + 1) + ": ");
                    studentNames[i] = sc.nextLine();

                    System.out.println("Enter marks obtained by " + studentNames[i] + " (Out of 100):");
                    studentMarks[i] = sc.nextInt();
                    sc.nextLine();  

                   
                    while (studentMarks[i] < 0 || studentMarks[i] > 100) {
                        System.out.println("Invalid Marks. Please enter valid marks for " + studentNames[i] + " (out of 100):");
                        studentMarks[i] = sc.nextInt();
                        sc.nextLine();  // Consume newline
                    }

                  
                    pstmt.setString(1, studentNames[i]);
                    pstmt.setInt(2, studentMarks[i]);
                    pstmt.executeUpdate();

                    totalMarks += studentMarks[i];
                    if (studentMarks[i] > maxMarks) maxMarks = studentMarks[i];
                    if (studentMarks[i] < minMarks) minMarks = studentMarks[i];
                }

               
                double averageScore = (double) totalMarks / totalStudent;
                System.out.println("Student's Average Score: " + averageScore);
                System.out.println("Maximum Marks obtained by student: " + maxMarks);
                System.out.println("Minimum Marks obtained by student: " + minMarks);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            
            sc.close();
        }
    }
}
