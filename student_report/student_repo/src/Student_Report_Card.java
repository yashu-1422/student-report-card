import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    int[] marks;
    int obtainedMarks = 0;
    float percentage;
    char grade;
    int subjects;
    int marksOutOff;
    int totalMarks;

    Student(int rollNo, String name, int subjects, int marksOutOff) {
        this.name = name;
        this.rollNo = rollNo;
        this.subjects = subjects;
        this.marks = new int[subjects];
        this.marksOutOff = marksOutOff;
    }

    void inputMarks(Scanner sc) {
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter your marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
            obtainedMarks += marks[i];
        }
        percentage = percentageCalculate(obtainedMarks, subjects, marksOutOff);
        grade = calculateGrade(percentage);
    }

    float percentageCalculate(int obtainedMarks, int subjects, int marksOutOff) {
        totalMarks = subjects * marksOutOff;
        percentage = ((float) obtainedMarks / totalMarks) * 100;
        return percentage;
    }

    char calculateGrade(float percentage) {
        if (percentage >= 90) return 'A';
        else if (percentage >= 80) return 'B';
        else if (percentage >= 70) return 'C';
        else if (percentage >= 60) return 'D';
        else return 'F';
    }

    void displayReportCard() {
        System.out.println("\n==== STUDENT REPORT CARD ====");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Obtained Marks: " + obtainedMarks + "/" + totalMarks);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("=============================");
    }
}

public class Student_Report_Card {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Roll Number: ");
        int rollNo = sc.nextInt();
        System.out.print("Enter Number of Subjects: ");
        int subjects = sc.nextInt();
        System.out.print("Enter Marks Out Of Per Subject: ");
        int marksOutOff = sc.nextInt();

        Student student1 = new Student(rollNo, name, subjects, marksOutOff);
        student1.inputMarks(sc);
        student1.displayReportCard();

        sc.close(); // Close the scanner
    }
}
