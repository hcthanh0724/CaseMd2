package Manager;

import Model.Account;
import rw.ReadAndWriteAccount;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    public static List <Account> accounts = new ArrayList<>();
    public AccountManager(){
        accounts = ReadAndWriteAccount.readAccount();
    }
    public void addAccount(Account account){
        //Duyệt qua danh sách các tài khoản đã tồn tại và gán vào biến acc
        for (Account acc: accounts) {
            //Tài khoản được thêm vào lưu trữ trong biến account
            //Nếu tài khoản đã tồn tại,kết thúc bằng ccaau lệnh return
            if( acc.getUserName().equals(account.getUserName())){
                return;
            }
        }
        //Nếu tài khoản chưa tồn tại, thêm mới vào list
        accounts.add(account);
        ReadAndWriteAccount.writeAccount(accounts);
    }


    //Trả về tất cả các tài khoản có trong list
//    public List <Account> findAll(){
//        return accounts;
//    }
    public boolean login (Account account){
        for (Account acc: accounts) {
            if(acc.getUserName().equals(account.getUserName()) &&
            acc.getPassword().equals(account.getPassword())){
                return true;
            }
        }
        return false;
    }
    public boolean loginAdmin(Account account){
        if("Admin1234".equals(account.getUserName()) && "admin123456".equals(account.getPassword())){
            return true;
        }
        return false;
    }

    public void deleteAccount(Account account){
        for (Account account1: accounts) {
            if(account1.getUserName().equals(account.getUserName())){
                accounts.remove(account1);
                break;
            }
        }
        ReadAndWriteAccount.writeAccount(accounts);
    }
    public void showAccount(){
        for (Account acc: accounts) {
            System.out.println(acc.getUserName() + " " +acc.getPassword());
        }
    }
}
