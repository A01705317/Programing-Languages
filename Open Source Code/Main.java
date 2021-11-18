/* 
The purpose of this project is to implement the programming paradigm of concurrency
to simulate the use of machines or cash counters. The idea is to provide companies
with a tool that helps calculate, at a specific day and hour, the ideal amount of
machines or cash counters that need to be working in order to maintain short lines,
but also keeping the operating costs low.

Copyright (C) 2021  Miguel Angel Marines Olvera

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see https://www.gnu.org/licenses
*/

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

        // License especifications
        System.out.println("\nMachine Simulator  Copyright (C) 2021  Miguel Angel Marines Olvera");
        System.out.println("\nThis program comes with ABSOLUTELY NO WARRANTY");
        System.out.println("\nThis is free software, and you are welcome to redistribute it under certain conditions");


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