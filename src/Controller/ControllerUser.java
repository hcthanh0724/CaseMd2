package Controller;

import Manager.AccountManager;
import Manager.BilliardManager;
import Model.Order;
import Model.Table;
import View.ViewAccount;
import View.ViewTable;

public class ControllerUser {
    public static void menuManagerUser(){
        ViewTable viewTable = new ViewTable();
        BilliardManager billiardManager = new BilliardManager();
        while (true){
            int choice = viewTable.menuUser();
            switch (choice){
                case 1:
                    billiardManager.add(viewTable.createTable());
                    break;
                case 2:
                    billiardManager.edit(viewTable.enterId(),viewTable.createTable());
                    break;
                case 3:
                    billiardManager.deleteTable(viewTable.enterId());
                    break;
                case 4:
                    viewTable.showTable();
                    break;
                case 5:
                    return;
                case 6:
                    billiardManager.onTable(viewTable.chooseTable());
                    break;
                case 7:
                    viewTable.showOrder();
                    billiardManager.chooseOrder();
                    break;
                case 8:
                    billiardManager.checkout(viewTable.payMoney());
                    break;
            }
        }
    }
    public static void menuManagerAdmin(){
        ViewTable viewTable = new ViewTable();
        ViewAccount viewAccount = new ViewAccount();
        AccountManager accountManager = new AccountManager();
        while (true){
            int choice = viewTable.menuAdmin();
            switch (choice){
                case 1:
                    accountManager.addAccount(viewAccount.createAccount());
                    break;
                case 2:
                    viewAccount.editAccount();
                    break;
                case 3:
                    accountManager.deleteAccount(viewAccount.deleteAccount());
                    break;
                case 4:
                    accountManager.showAccount();
                    break;
                case 5:
                    menuManagerUser();
                    break;
            }
        }
    }
}
