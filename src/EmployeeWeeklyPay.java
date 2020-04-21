/**
 * This program reads an employee’s number, pay rate and the number of hours worked in a week.
 * The program is then to validate the pay rate field and the hours worked field and,
 * if valid, compute the employee’s weekly pay and then print it and the input data.
 *
 * Validation: According to the company’s rules, the maximum hours an employee can work per week is 60 hours,
 * and the maximum hourly rate is $25.00 per hour. If the hours worked field or
 * the hourly rate field is out of range, the input data and an appropriate message are to be printed and
 * the employee’s weekly pay is not to be calculated.
 *
 * Weekly pay calculation: Weekly pay is calculated as hours worked times pay rate.
 * If more than 35 hours are worked, payment for the overtime hours worked is calculated at time-and-a-half.
 */

import java.text.DecimalFormat;
import java.util.Scanner;
import static java.lang.String.format;

public class EmployeeWeeklyPay {

    public static void main(String[] args) {
        Scanner keybd = new Scanner(System.in);

        String employee_id;
        double normal_pay_rate = 0;
        double hours_worked = 0;
        double overtime_hours_worked = 0;
        boolean cont1 =true;
        boolean cont2 = true;

        double overtime_pay_rate = 0;
        double total_weekly_pay;
        double normal_weekly_pay;
        double overtime_weekly_pay;

        //INPUT
            System.out.print("Enter Employee's ID: ");
            employee_id = keybd.nextLine();
        do {

            System.out.print("Enter Employee's Pay Rate: ");
            normal_pay_rate = keybd.nextDouble();
            keybd.nextLine();

            //validation
            if(normal_pay_rate < 10.10){                                //according to Maryland Minimum hourly pay
                System.out.println("Pay Rate can not be that less.");
            }
            else if(normal_pay_rate > 25){
                System.out.println("Pay Rate is out of Range: ");
            }
            else{
                cont1 = false;
            }

        } while(cont1 == true);

        do {

                System.out.print("Enter number of hours worked : ");
                hours_worked = keybd.nextDouble();
                keybd.nextLine();

                //validate normal hours worked
                if(hours_worked < 0){
                    System.out.println("Invalid input! ");
                }
                else if(hours_worked > 60){
                    System.out.println("Input is out the allowable range.");
                }
                else{
                    cont2=false;
                }

        } while(cont2 == true);

        //PROCESS
        if(hours_worked > 35){
            overtime_hours_worked = hours_worked - 35;
            overtime_pay_rate = 1.5 * normal_pay_rate;
            hours_worked = 35;
        }
        normal_weekly_pay = hours_worked * normal_pay_rate;
        overtime_weekly_pay = overtime_hours_worked * overtime_pay_rate;
        total_weekly_pay = normal_weekly_pay + overtime_weekly_pay;

        //OUTPUT
        System.out.println(format("\n%1s %s","|-------------------------------------------------------------------------------------------------------", "||"));
        System.out.println(format("%1s %-14s %-46s %40s %2s", "|", "Employee ID: " , employee_id , "from date mm/dd/yyyy to date mm/dd/yyyy", "||"));
        System.out.println(format("%1s %s","|-------------------------------------------------------------------------------------------------------", "||"));
        System.out.println(format("%1s %30s %10s %10s %30s %10s %10s", "|", "Normal hours worked = ", String.format("%.2f", hours_worked), "||", "Overtime hrs worked = ", String.format("%.2f", overtime_hours_worked), "||"));
        System.out.println(format("%1s %30s %10s %10s %30s %10s %10s", "|", "Normal hourly rate = ", String.format("%.2f", normal_pay_rate), "||", "Overtime hourly rate = ", String.format("%.2f", overtime_pay_rate), "||"));
        System.out.println(format("%1s %30s %10s %10s %30s %10s %10s", "|", "Normal weekly pay amount = ", "$" + String.format("%.2f", normal_weekly_pay), "||", "Overtime weekly pay amount= ", "$" + String.format("%.2f", overtime_weekly_pay), "||"));
        System.out.println(format("%1s %s","|-------------------------------------------------------------------------------------------------------", "||"));
        System.out.println(format("%1s %-35s %-66s %2s", "|", "Total this week payment amount = $", String.format("%.2f", normal_weekly_pay) + " + $" + String.format("%.2f", overtime_weekly_pay) + " = $" + String.format("%.2f", total_weekly_pay), "||"));
        System.out.println(format("%1s %s","|-------------------------------------------------------------------------------------------------------", "||"));

    }

}