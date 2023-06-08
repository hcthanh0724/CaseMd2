package Manager;

import Model.Order;
import Model.Table;
import rw.ReadAndWrite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BilliardManager {
    Scanner scanner = new Scanner(System.in);
    public static List<Table> table = new ArrayList<>();

//    private double totalMoney = 0;
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
        ReadAndWrite.writeTable(table);
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

//    Thanh toán bàn
    public void checkout(int number1){
        int moneys ;
        for (Table table1: table) {
                if(table1.getNumber() == number1){
                moneys = (int) ((double) getDateDiff(table1.getStartTime(),new Date(),TimeUnit.MINUTES) * 7 + table1.getMoney());
                table1.setAvailable(false);
                System.out.println("Money is" +moneys);
                break;
            }
        }


    }


    public void chooseOrder() {
//        int moneys = 0;
        System.out.println("Enter service number: ");
        int orderNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter table number: ");
        int tableNum = Integer.parseInt(scanner.nextLine());

        // Kiểm tra danh sách orders và table có rỗng không
        if (table.isEmpty()) {
            System.out.println("There are no tables available.");
        }

        for (Order o : Order.orders) {
            for (Table table1 : table) {
                if ( o.getId() == orderNumber && tableNum == table1.getNumber()) {
                    table1.setMoney(table1.getMoney()+o.getPrice());
                    System.out.println("Service " + o.getName() + " add successful.");
                }
            }
        }
    }
//    public void sum(int sum){
//        totalMoney += sum;
//    }
//    public double getMoney(){
//        return totalMoney;
//    }


}
