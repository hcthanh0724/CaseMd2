package rw;

import Model.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteAccount {
    public static List<Account> readAccount() {
        try (FileInputStream fileInputStream = new FileInputStream("account.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Object object = objectInputStream.readObject();
            if (object instanceof List<?>) {
                return (List<Account>) object;
            } else {
                writeAccount(new ArrayList<>());
                return new ArrayList<>();
            }
        } catch (FileNotFoundException e) {
            // File not found is not an error, just return an empty list
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            // IO error or class not found occurred, print stack trace and return null
            e.printStackTrace();
            return null;
        }
    }

    public static void writeAccount(List<Account> accounts) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("account.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(accounts);
        } catch (IOException e) {
            // IO error occurred, print stack trace
            e.printStackTrace();
        }
    }
}