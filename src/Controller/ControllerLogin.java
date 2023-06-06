package Controller;

import Manager.AccountManager;
import Manager.BilliardManager;
import Model.Account;
import View.ViewAccount;
import View.ViewTable;

public class ControllerLogin {
    public static void menuLogin(){
        ViewAccount viewAccount = new ViewAccount();
        AccountManager accountManager = new AccountManager();
        while (true){
            int choice = viewAccount.menuLogin();
            switch (choice){
                case 1:
                    Account account = viewAccount.createAccount();
                    if(accountManager.loginAdmin(account)){
                        ControllerUser.menuManagerAdmin();
                        break;
                    }
                    if(accountManager.login(account)){
                        ControllerUser.menuManagerUser();
                        break;
                    }
                case 2:
                    accountManager.addAccount(viewAccount.createAccount());
                    break;
            }
        }
    }
}
