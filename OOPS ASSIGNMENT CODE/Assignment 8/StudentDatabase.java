import java.io.*;
import java.util.Scanner;

public class StudentDatabase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Create Database");
            System.out.println("2. Display Database");
            System.out.println("3. Delete Records");
            System.out.println("4. Update Record");
            System.out.println("5. Search Record");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createDatabase();
                    break;
                case 2:
                    displayDatabase();
                    break;
                case 3:
                    deleteRecords();
                    break;
                case 4:
                    updateRecord();
                    break;
                case 5:
                    searchRecord();
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 6);
    }

    private static void createDatabase() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("student_database.txt", true))) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Student ID: ");
            int studentId = scanner.nextInt();
            System.out.print("Enter Name: ");
            String name = scanner.next();
            System.out.print("Enter Roll Number: ");
            int rollNo = scanner.nextInt();
            System.out.print("Enter Class: ");
            String studentClass = scanner.next();
            System.out.print("Enter Marks: ");
            double marks = scanner.nextDouble();
            System.out.print("Enter Address: ");
            String address = scanner.next();

            writer.println(studentId + "," + name + "," + rollNo + "," + studentClass + "," + marks + "," + address);
            System.out.println("Record added successfully.");
        } catch (IOException e) {
            System.out.println("Error creating the database.");
        }
    }

    private static void displayDatabase() {
        try (BufferedReader reader = new BufferedReader(new FileReader("student_database.txt"))) {
            String line;
            System.out.println("Student Records:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error displaying the database.");
        }
    }

    private static void deleteRecords() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Student ID to delete record: ");
            int studentIdToDelete = scanner.nextInt();

            BufferedReader reader = new BufferedReader(new FileReader("student_database.txt"));
            String line;
            StringBuilder newDatabase = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int currentStudentId = Integer.parseInt(data[0]);

                if (currentStudentId != studentIdToDelete) {
                    newDatabase.append(line).append("\n");
                }
            }

            reader.close();

            PrintWriter writer = new PrintWriter(new FileWriter("student_database.txt"));
            writer.print(newDatabase);
            writer.close();

            System.out.println("Record deleted successfully.");
        } catch (IOException e) {
            System.out.println("Error deleting the record.");
        }
    }

    private static void updateRecord() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Student ID to update record: ");
            int studentIdToUpdate = scanner.nextInt();

            BufferedReader reader = new BufferedReader(new FileReader("student_database.txt"));
            String line;
            StringBuilder newDatabase = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int currentStudentId = Integer.parseInt(data[0]);

                if (currentStudentId == studentIdToUpdate) {
                    System.out.print("Enter new Marks: ");
                    double newMarks = scanner.nextDouble();
                    data[4] = String.valueOf(newMarks);
                    line = String.join(",", data);
                }

                newDatabase.append(line).append("\n");
            }

            reader.close();

            PrintWriter writer = new PrintWriter(new FileWriter("student_database.txt"));
            writer.print(newDatabase);
            writer.close();

            System.out.println("Record updated successfully.");
        } catch (IOException e) {
            System.out.println("Error updating the record.");
        }
    }

    private static void searchRecord() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Student ID to search record: ");
            int studentIdToSearch = scanner.nextInt();

            BufferedReader reader = new BufferedReader(new FileReader("student_database.txt"));
            String line;
            boolean recordFound = false;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int currentStudentId = Integer.parseInt(data[0]);

                if (currentStudentId == studentIdToSearch) {
                    System.out.println("Record Found:");
                    System.out.println(line);
                    recordFound = true;
                    break;
                }
            }

            reader.close();

            if (!recordFound) {
                System.out.println("Record not found.");
            }
        } catch (IOException e) {
            System.out.println("Error searching for the record.");
        }
    }
}
