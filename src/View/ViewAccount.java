package View;

import Manager.AccountManager;
import Model.Account;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ViewAccount {
    Scanner scanner = new Scanner(System.in);
    public int menuLogin(){
        System.out.println("                   ♛ JAVA BILLIARDS MANAGER SYSTEM ♛");
        System.out.println("                  -----------☬SYSTEM☬--------------");
        System.out.println("                  ☟☟☟☟☟☟☟☟☟☟☟☟ ☣ LOGIN ☠ ☟☟☟☟☟☟☟☟☟☟☟☟");
        System.out.println("                  ☟     1. Sign in ⍥      ☟");
        System.out.println("                  ☟     2. Sign up ⍢      ☟");
        System.out.println("                  ☟                        ☟");
        System.out.println("                  ☟                        ☟");
        System.out.println("                   ♈♉♊♋♌♍♏♐♑♒♓ ");
        System.out.println("                  ☟                         ☟");
        System.out.println("                  ☝☝☝☝☝☝☝☝☝☝☝☝☝☝☝☝☝☝☝☝☝☝☝☝☝☝☝☝☝☝☝☝☝☝");
        System.out.println("                  ↝ Enter your choice ↜");
        return checkChoice();
    }

    public String getUser(){
        String userName = " ";
        while (true){
            System.out.println(" ⌛ Enter username: ");
            userName = scanner.nextLine();
            Pattern p = Pattern.compile("^[A-Z][a-z 0-9]{7,}$");
            if(p.matcher(userName).find()){
                System.out.println("Your username is: " +userName + "\n" + "---------------");
                break;
            }
            else {
                System.err.println("Username have at least 8 characters include 1 uppercase letter and 1 number ");
            }
        }
        return userName;
    }
    public String getPass(){
        String pass = " ";
        while (true){
            System.out.println("⌚ Enter password: ");
            pass = scanner.nextLine();
            Pattern p = Pattern.compile("^[a-z 0-9]{6,}$");
            if(p.matcher(pass).find()){
                System.out.println("\n" + "WELCOME TO JAVA BILLIARDS ");
                System.out.println("-------------------------");
                return pass;
            }
            else {
                System.err.println("Password have at least 6 characters, include number");
            }
        }
    }
    private int checkChoice(){
        boolean checkChoice;
        int choice = 0;
        do{
            checkChoice = true;
            try{
                choice = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e){
             checkChoice = false;
             System.err.println("--- Enter number in menu! ---");
                System.out.println("Enter any key to continue. Press Q to exit");
                String quit = scanner.nextLine();
                if(quit.equalsIgnoreCase("q")){
                    break;
                }
            }
        } while (!checkChoice);
            return choice;
    }
    public Account createAccount(){
        System.out.println();
        System.out.println("         Sign in ⍥        ");
        String user = getUser();
        String pass = getPass();
        return new Account(user,pass);
    }
    public Account editAccount(){
        System.out.println("Enter edit account");
        String name = scanner.nextLine();
        System.out.println("Enter new password");
        String pass = scanner.nextLine();
        for (Account account: AccountManager.accounts){
            if(account.getUserName().equals(name)){
                account.setPassword(pass);
                return account;
            }
        }
        System.out.println("Account doesn't exist");
           return null;

    }
    public Account deleteAccount(){
        System.out.println("Enter delete account: ");
        String name = scanner.nextLine();
        for (Account account : AccountManager.accounts){
            if(account.getUserName().equals(name)){
                return account;
            }
        }
        System.out.println("Account doesn't exist");
        return null;
    }

}
