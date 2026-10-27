package University_Exam_Regestration_System;

import java.util.Scanner;

class invalidException extends Exception{
    public invalidException(String message){
        super(message);
    }
}

public class Exam_registration {

        String student_id;
        String name;
        int age;
        double examination_mark;
        int number_of_subject;

        Exam_registration(){
            Scanner input = new Scanner(System.in);

            System.out.print("Enter Student ID: ");
            this.student_id = input.nextLine();

            System.out.print("Enter Student Name: ");
            this.name = input.nextLine();

            System.out.print("Enter Age: ");
            this.age = input.nextInt();

            System.out.print("Enter Exam Mark: ");
            this.examination_mark = input.nextDouble();

            System.out.print("Enter Number of Subjects: ");
            this.number_of_subject = input.nextInt();
        }

    public void register() throws invalidException {

        if (age < 18){
            throw new invalidException("Student age must be at least 18");
        }

        if (examination_mark < 0 || examination_mark > 100){
            throw new invalidException("Exam marks must be between 0 and 100");
        }

        if (number_of_subject < 1 || number_of_subject > 5){
            throw new invalidException("Number of subjects must be between 1 - 5");
        }

        if (student_id == ""){
            throw new invalidException("Student id can not be negative");
        }

        System.out.println();
        System.out.println("Registration Successfully ");
        System.out.println("Student name: " + name);
        System.out.println("Registered Subjects: " + number_of_subject);

    }


}

class ExamRegistrationSystem {
    static void main() {

        try{
            Exam_registration student = new Exam_registration();
            student.register();
            System.out.println();
        } catch (invalidException e) {
            System.out.println("Registration Failed!");
            System.out.println("Error: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Registration Failed!");
            System.out.println("Error: Invalid input.");

        } finally {
            System.out.println("Registration attempt completed.");
        }
    }
}