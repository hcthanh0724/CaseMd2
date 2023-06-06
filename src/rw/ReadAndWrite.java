package rw;

import Model.Table;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static List <Table> readTable (){
        try {
        File file = new File("table.txt");
        if(!file.isFile()){
                file.createNewFile();
            }
        //Nếu file tồn tại, tạo đối tượng fileInputStream để đọc dữ liệu
            FileInputStream fileInputStream = new FileInputStream("table.txt");
        //Kiểm tra xem txt có dữ liệu hay không, nếu có trả về danh sách, nếu k trả về list rỗng
        if(fileInputStream.available() != 0){
            ObjectInputStream  objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<Table>) objectInputStream.readObject();
        }
        return new ArrayList<>();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public static void writeTable(List<Table> list){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("table.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            fileOutputStream.close();
            objectOutputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
