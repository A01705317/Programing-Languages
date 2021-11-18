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

// Class Machine Group
public class Machine_Group
{
    /* Variables that help simulate and control
    the waiting in line of persons to use the machines. */  
    private int persons_line;
    private int machines_in_use;
    
    // Constructor, with the atributes persons in line and machines in use.
    public Machine_Group()
    {
        // Persons in line counter.
        persons_line = 0;
        
        // Machines in use counter.
        machines_in_use = 0;
    }

    // Method to simulate the waiting in line of a person.
    public synchronized void person_line_entrance()
    {
        persons_line ++;
        System.out.println("Persons in line waiting to use an ATM: " + number_persons_in_line());
    }

    // Method to simulate passing the line without waiting, because its empty.
    public synchronized void direct_person_line_entrance()
    {
        persons_line ++;
    }
    
    // Method to simulate the exit of the line of a person.
    public synchronized void person_line_exit()
    {
        persons_line --;
        System.out.println("Persons in line waiting to use an ATM: " + number_persons_in_line());
    }
    
    // Method that returns the number of persons waiting in line to use a machine.
    public synchronized int number_persons_in_line()
    {
        return persons_line;
    }

    // Method to simulate the use of a machine.
    public synchronized void use_machine()
    {
        machines_in_use ++;
    }

    // Method to simulate the unuse of a machine.
    public synchronized void unuse_machine()
    {
        machines_in_use --;
    }

    // Method to obtain the machines in use.
    public synchronized int available_machines()
    {
        return machines_in_use;
    }
}