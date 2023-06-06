package Model;

import java.util.Scanner;

public class Order {
    private int id = 1;
    private String name;
    private double price;
    public Order(){

    }

    public Order(int id,String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order: " + "id: " +id +
                "name='" + name + '\'' +
                ", price=" + price +
                ' ';
    }
    public static final Order[] orders = {
            new Order(1,"Mojito",25),
            new Order(2,"Coke",10),
            new Order(3,"Cbd",20),
            new Order(4,"Methamphetamine",99),
            new Order(5,"Ketamine",80),
            new Order(6,"Laughing Gas Ballons",40),
            new Order(7,"Jagermeister",125),
            new Order(8,"Latina chicks",200),
            new Order(9,"Hiring cue",13),
            new Order(10,"Gambling fee",30),
            new Order(11,"Cigarette",10),

    };
//    public int getOrderPrice(){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nhập id order: ");
//        int choice = Integer.parseInt(scanner.nextLine());
//        if(choice < 0 || choice > orders.length){
//            System.out.println("Can't find id.");
//        }
//        Order order = orders[choice];
//        int price = order.getPrice();
//        return price;
//    }

}
