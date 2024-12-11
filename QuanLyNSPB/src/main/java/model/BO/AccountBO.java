package model.BO;

import model.BEAN.Account;
import model.DAO.AccountDAO;

public class AccountBO {
	public static Account checkLogin(String username, String password) {
		return AccountDAO.Instance().checkLogin(username, password);
	}
}
