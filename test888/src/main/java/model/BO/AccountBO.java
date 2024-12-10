package model.BO;

import model.DAO.AccountDAO;

public class AccountBO {
    public static boolean checkLogin(String username, String password) {
        return AccountDAO.Instance().checkLogin(username, password);
    }
} 
