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

// Library to generate random numbers.
import java.util.Random;

// Person class.
public class Person implements Runnable
{
    /* Variable from the class machine group to use
    the methods in that class. */
    private Machine_Group machine_group;

    // Variables to control the time.
    private int arriving_time;
    private int machine_use_time;

    // Variable to identify the persons.
    private int person_id;

    // Variables to control the operation process.
    private int number_machines;
    private int average_operation_time;

    /* Constructor of the person, with the atributes person id, machine group, 
    number machines, average operation time.*/
    public Person (int person_id, Machine_Group machine_group, int number_machines, int average_operation_time)
    {
        // Atributes
        this.person_id = person_id;
        this.machine_group = machine_group;
        this.number_machines = number_machines;
        this.average_operation_time = average_operation_time;

        // Creates an object of the Random class to generate random numbers.
        Random random = new Random();

        // Generates random number for the operation time within the indicated time.
        machine_use_time = random.nextInt(average_operation_time * 1000);
        // Generates random number for the arriving time within 60 minutes.
        arriving_time = random.nextInt(60000);
    }

    // Method run, specific to specify the actions that the threads perform.
    @Override
    public void run()
    {
        try
        {
            // Person on his way to use the machine.
            System.out.println("Person " + person_id + " is on the way to use an ATM.");
            // Person arriving time.
            System.out.println("Person " + person_id + " arriving time: " + (arriving_time / 1000) + " minutes.");
            // Execution of the arriving time.
            Thread.sleep(arriving_time);
            
            // If there are machines available.
            if(machine_group.available_machines() < number_machines)
            {
                // Line Simulation
                machine_group.direct_person_line_entrance();
                machine_group.person_line_exit();

                // Use machine simulation.
                machine_group.use_machine();
                Thread.sleep(machine_use_time);
                machine_group.unuse_machine();
            }
            else
            {
                // Person gets in line waiting to use a machine.
                machine_group.person_line_entrance();
                
                // Person waits in line until a machine is available to use.
                while(machine_group.available_machines() > number_machines)
                {
                    Thread.sleep(1);
                }
                
                // Person leaves the line.
                machine_group.person_line_exit();
                
                // Use machine simulation.
                machine_group.use_machine();
                Thread.sleep(machine_use_time);
                machine_group.unuse_machine();                
            }
        }
        catch (Exception e)
        {
            // In case something goes wrong in the program.
            System.out.println("\n");
            System.out.println("The program has presented a problem!");
            System.out.println("Please, contact the IT department.");
        }   
    }
}