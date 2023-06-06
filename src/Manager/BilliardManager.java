package Manager;

import Model.Order;
import Model.Table;
import View.ViewTable;
import rw.ReadAndWrite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BilliardManager {
    Scanner scanner = new Scanner(System.in);
    public static List<Table> table = new ArrayList<>();
    Order order = new Order();

    double money = 0;
    private double totalMoney = 0;
    public BilliardManager(){
        table = ReadAndWrite.readTable();
    }

    public void add(Table tables){
        table.add(tables);
        ReadAndWrite.writeTable(table);
    }
    public void edit(int index, Table tables){
        table.set(index,tables);
        ReadAndWrite.writeTable(table);
    }
    public void onTable(int number) {
        for (Table tables : table) {
            if (tables.getNumber() == number) {
                if (!tables.isAvailable()) {
                    System.out.println("Table: " +number + "turn on successful");
                    tables.setAvailable(true);
                    tables.setStartTime(new Date());
                } else {
                    System.out.println("Table " + number + " is already occupied.");
                }
                return;
            }
        }
    }
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit){
        long diffInMillis = date2.getTime() - date1.getTime();
        //trả về giá tri của diff.. , sd convert để chuyển giá trị về milliseconds
        return timeUnit.convert(diffInMillis,TimeUnit.MILLISECONDS);
    }
    public void deleteTable(int index){
        table.remove(index);
        ReadAndWrite.writeTable(table);
    }

    //Thanh toán bàn
    public double checkout(int number1){
        for (Table table1: table) {
            for (Order order1: Order.orders) {
                if(table1.getNumber() == number1){
                money = (double) getDateDiff(table1.getStartTime(),new Date(),TimeUnit.MINUTES) * 7 + order1.getPrice();
                table1.setAvailable(false);
            }
            }
        }
        System.out.println("Money is" +money);
        return money;
    }

    //Chọn order
//    public int chooseOrder(){
//        System.out.println("Enter service number: ");
//        int orderNumber = Integer.parseInt(scanner.nextLine());
//        System.out.println("Enter table number: ");
//        int tableNum = Integer.parseInt(scanner.nextLine());
//
//        for (Order o: Order.orders){
//            for (Table table1: table) {
//            if(table1.getNumber() == tableNum){
//                return tableNum;
//            }
//            if(o.getId() == orderNumber){
//                    System.out.println("Service " +o.getName() +"add successful. ");
//                    return o.getPrice();
//
//                }
//        }
//
//        }
//        System.out.println("Order with id: " +orderNumber + "is not available. ");
//        return 0;
//    }
    public double chooseOrder() {
        System.out.println("Enter service number: ");
        int orderNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter table number: ");
        int tableNum = Integer.parseInt(scanner.nextLine());
        boolean check = false;

        // Kiểm tra danh sách orders và table có rỗng không
        if (table.isEmpty()) {
            System.out.println("There are no tables available.");
            return 0;
        }

        for (Order o : Order.orders) {
            for (Table table1 : table) {
                if ( o.getId() == orderNumber) {
                    money += o.getPrice();
                    table1.setMoney(money);
                    System.out.println("Service " + o.getName() + " add successful.");
                    return money;
                }
            }
        }


            System.out.println("Order with id: " + orderNumber + " is not available.");
        return 0;
    }
    public void sum(int sum){
        totalMoney += sum;
    }
    public double getMoney(){
        return totalMoney;
    }


}
