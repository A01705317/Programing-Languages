/*
Final Project - Concurrency - Machines Use Simulator - Java
Miguel Angel Marines Olvera
A01705317
*/

// Library to scan inputs from the user.
import java.util.Scanner;

// Class Main
public class Main
{
    // Main to run the program.
    public static void main(String[] args)
    {
        // Creates object from the class machine group.
        Machine_Group machine_group = new Machine_Group();
        
        // Prints header of the program.
        System.out.println("\n ________________________________________________________________________");
        System.out.println("|                                                                        |");
        System.out.println("|                         Machines Use Simulation                        |");
        System.out.println("|                             Machines - ATMs                            |");
        System.out.println("|________________________________________________________________________|");

        // Creates scanner object to get the inputs from the user.
        Scanner input = new Scanner(System.in);

        // Variables to store the number of visitors, number of machines and average operation time.
        int number_visitors;
        int number_machines;
        int average_operation_time;

        // Number of visitors in a specific hour provided by the user with an input.
        System.out.print("\nNumber of ATM users for the hour: ");
        number_visitors = input.nextInt();

        // Number of machines working in a specific hour provided by the user with an input.
        System.out.print("\nNumber of ATMs working for the hour: ");
        number_machines = input.nextInt();

        // Average operation time provided by the user with an input.
        System.out.print("\nAverage operation time in minutes: ");
        average_operation_time = input.nextInt();
        System.out.print("\n");

        // Close inputs by the user.
        input.close();

        // Creates an array of the type person from the class Person, according to the number of visitors.
        Person persons[] = new Person[number_visitors];
        
        // Creates an array of threads from the class Thread, according to the number of visitors.
        Thread threads[] = new Thread[number_visitors];
        
        // The for loop:
        // 1. Creates person objects from the class Person and stores them in the persons array.
        // 2. Creates threads objects from the class Thread and stores them in the threads array.
        // 3. Starts the threads.
        for(int i = 0; i < number_visitors; i++)
        {
            persons[i] = new Person(i, machine_group, number_machines, average_operation_time);
            threads[i] = new Thread(persons[i]);
            threads[i].start();
        }
    }
}