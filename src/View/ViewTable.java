package View;

import Manager.BilliardManager;
import Model.Order;
import Model.Table;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewTable {
    Scanner scanner = new Scanner(System.in);

    public int checkChoice(){
        boolean checkChoice;
        int choice = 0;
        do {
            checkChoice = true;
            try{
                choice = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e){
                checkChoice = false;
                System.err.println("-----Enter number in menu-----");
                System.err.println("-----Press Q to exit-----");
                String quit = scanner.nextLine();
                if(quit.equalsIgnoreCase("q")){

                    break;
                }
            }
        } while (!checkChoice);
        return choice;
    }
    public void showOrder(){
        for (Order o : Order.orders){
            System.out.println(o);
        }
    }
    public int payMoney(){
        System.out.println("Enter pay table: ");
        return Integer.parseInt(scanner.nextLine());
    }
    public int chooseTable(){
        System.out.println("Enter chosen table: ");
        return Integer.parseInt(scanner.nextLine());
    }
    public int enterId(){
        System.out.println("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }
    public void showTable(){
        for (Table table1: BilliardManager.table){
            System.out.println(table1);
        }
    }
    public Table createTable(){
        System.out.println("Enter table number:");
        int tableNum ;
        while (true){
            try{
                tableNum = Integer.parseInt(scanner.nextLine());
                boolean exist = false;
                for (Table t: BilliardManager.table){
                    if(t.getNumber() == tableNum){
                        exist = true;
                        break;
                    }
                }
                if(exist){
                    System.out.println("Table id is exist");
                }
                else {
                    break;
                }
            } catch (NumberFormatException e){
                System.err.println("Wrong format number. Please enter again");
                System.err.println("Press Q to exit");
                String quit = scanner.nextLine();
                if(quit.equalsIgnoreCase("q")){
                    return null;
                }
            }
        }
        return new Table(tableNum);
    }

    public int menuAdmin(){
        System.out.println("-------WELCOME, SUMMONER.-------");
        System.out.println("        1. Add account        ");
        System.out.println("        2. Edit password        ");
        System.out.println("        3. Delete account        ");
        System.out.println("        4. Show all account        ");
        System.out.println("        5. Menu user        ");
        return checkChoice();
    }
    public int menuUser(){
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t☣☣♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡ MENU ♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡☣☣");
        System.out.println("\t\t\t\t\t\t\t☣☣      1, Add table ☠                                                            ☣☣");
        System.out.println("\t\t\t\t\t\t\t☣☣      2, Edit table ☠                                                   ☣☣");
        System.out.println("\t\t\t\t\t\t\t☣☣      3, Delete table ☠                                                             ☣☣");
        System.out.println("\t\t\t\t\t\t\t☣☣      4, Show all table ☠                                             ☣☣");
        System.out.println("\t\t\t\t\t\t\t☣☣      5, Sign out ☠                                                           ☣☣");
        System.out.println("\t\t\t\t\t\t\t☣☣      6, Turn table on ☠                                                             ☣☣");
        System.out.println("\t\t\t\t\t\t\t☣☣      7, Service ☠                                                             ☣☣");
        System.out.println("\t\t\t\t\t\t\t☣☣      8, Pay ☠                                                           ☣☣");
        System.out.println("\t\t\t\t\t\t\t☣☣♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡♡☣☣");
        System.out.println();
        System.out.print("\t\t\t\t\t\t\t-------------->Your choice ✎ •: ");
        return checkChoice();
    }
}
