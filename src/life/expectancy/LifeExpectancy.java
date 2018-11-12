/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package life.expectancy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.util.Scanner;

/**
 *
 * @author Reuben_2
 */
public class LifeExpectancy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int left = 0;
        System.out.println("What year were you born in?");
        int year = input.nextInt();
        System.out.println("What month were you born in?");
        String month = input.next();
        System.out.println("What date were you born in?");
        int date = input.nextInt();
        String[] Months = {"january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};
        int[] Monthsdaysly = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] Monthsdays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int i = 0;
        int monthnumber = 0;
        for (i = 0; i < 12; i++) {
            if (month.equalsIgnoreCase(Months[i])) {
                System.out.println(Months[i]);
                System.out.println(i);
                monthnumber = i + 1;
            }
        }

        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(year, monthnumber, date);

        Period p = Period.between(birthday, today);
        int yearalive = p.getYears();
        int monthalive = p.getMonths();
        int dayalive = p.getDays();

        System.out.println("You have been alive for " + p.getYears() + " Years, " + p.getMonths() + " months and " + p.getDays() + " days!");
        System.out.println("Would you like to find out how long, on average, you have to live?");
        String Decision = input.next();
        int yearleft = 0;
        int monthleft = 0;
        int dayleft = 0;
        int monthaliveaddition = 0;
        int yearaliveaddition = 0;
        int yearremainder = year % 4;
        int arraynumber=monthnumber-1;

        if (Decision.equalsIgnoreCase("yes")) {
            System.out.println("Are you male or female");
            String sex = input.next();

            if (sex.equalsIgnoreCase("Male")) {
                //If months user has been alive is less than 5
                if (monthalive < 5) {
                    monthaliveaddition = monthalive + 8;
                    yearaliveaddition = yearalive + 1;
                    yearleft = 79 - yearaliveaddition;
                    monthleft = monthaliveaddition - monthalive;
                    monthleft = monthleft - 4;
                    if (yearremainder != 0) {
                        dayleft = Monthsdays[arraynumber] - dayalive;
                    } else {
                        dayleft = Monthsdaysly[arraynumber] - dayalive;
                    }

                } else{
                    yearleft=78-yearalive;
                    monthleft=12-monthalive;
                    if (yearremainder != 0) {
                        dayleft = Monthsdays[arraynumber] - dayalive;
                    } else {
                        dayleft = Monthsdaysly[arraynumber] - dayalive;
                    }            
                }

            } else {
                //If months user has been alive is more than or equal 5
                if (monthalive < 1) {
                    System.out.println("If printed");
                    monthaliveaddition = monthalive;
 //                   yearaliveaddition = yearalive ;
                    yearleft = 83 - yearalive;
                    monthleft = monthaliveaddition - monthalive;
                    if (yearremainder != 0) {
                        dayleft = Monthsdays[arraynumber] - dayalive;
                    } else {
                        dayleft = Monthsdaysly[arraynumber] - dayalive;
                    }

                } else{
                    System.out.println("Else printed");
                    yearleft=82-yearalive;
                    monthleft=12-monthalive;
                    if (yearremainder != 0) {
                        dayleft = Monthsdays[arraynumber] - dayalive;
                    } else {
                        dayleft = Monthsdaysly[arraynumber] - dayalive;
                    }            
                }

            }
            System.out.println("The month number array is "+arraynumber);
            System.out.println("The number of days in your birthmonth is "+Monthsdaysly[arraynumber]);
            System.out.println("You have " + yearleft + " years, " + monthleft + " months and " + dayleft + " days left to live!");
        }

    }

}
