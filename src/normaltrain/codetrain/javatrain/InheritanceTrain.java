package normaltrain.codetrain.javatrain;

import java.util.Scanner;

public class InheritanceTrain {

    static class Person {
        protected String firstName;
        protected String lastName;
        protected int idNumber;

        // Constructor
        Person(String firstName, String lastName, int identification){
            this.firstName = firstName;
            this.lastName = lastName;
            this.idNumber = identification;
        }

        // Print person data
        public void printPerson(){
            System.out.println(
                    "Name: " + lastName + ", " + firstName
                            + 	"\nID: " + idNumber);
        }

    }

    static class Student extends Person {
        private int[] testScores;

        /*
         *   Class Constructor
         *
         *   @param firstName - A string denoting the Person's first name.
         *   @param lastName - A string denoting the Person's last name.
         *   @param id - An integer denoting the Person's ID number.
         *   @param scores - An array of integers denoting the Person's test scores.
         */
        // Write your constructor here
        public Student(String firstName,String lastName, int id, int[] scores){
            super(firstName,lastName,id);
            testScores = scores.clone();
        }


        /*
         *   Method Name: calculate
         *   @return A character denoting the grade.
         */
        // Write your method here
        public String calculate(){
            String value = "";
            value = scoreAvg() < 40 ? "T" :
                    scoreAvg() < 55 ? "D" :
                            scoreAvg() < 70 ? "P" :
                                    scoreAvg() < 80 ? "A" :
                                            scoreAvg() < 90 ? "E" : "O";
            return value;
        }
        private int scoreAvg(){
            int sumScores = 0;
            for(int i=0; i < testScores.length; i++){
                sumScores += testScores[i];
            }
            return sumScores / testScores.length;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstName = scan.next();
        String lastName = scan.next();
        int id = scan.nextInt();
        int numScores = scan.nextInt();
        int[] testScores = new int[numScores];
        for(int i = 0; i < numScores; i++){
            testScores[i] = scan.nextInt();
        }
        scan.close();

        Student s = new Student(firstName, lastName, id, testScores);
        s.printPerson();
        System.out.println("Grade: " + s.calculate() );
    }

}
