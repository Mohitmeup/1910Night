package com.cg.ibs.cardmanagement.dao;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

import com.cg.ibs.cardmanagement.bean.CaseIdBean;
import com.cg.ibs.cardmanagement.bean.CreditCardBean;
import com.cg.ibs.cardmanagement.bean.CreditCardTransaction;
import com.cg.ibs.cardmanagement.bean.DebitCardBean;
import com.cg.ibs.cardmanagement.bean.DebitCardTransaction;

public interface BankDao {

	List<CaseIdBean> viewAllQueries();

	List<CreditCardTransaction> getCreditTrans(int days, BigInteger creditCardNumber);

	List<DebitCardTransaction> getDebitTrans(int dys, BigInteger debitCardNumber);

	boolean verifyCreditCardNumber(BigInteger creditCardNumber);

	boolean verifyDebitCardNumber(BigInteger debitCardNumber);

	boolean verifyQueryId(String queryId);

	void setQueryStatus(String queryId, String newStatus);
	void actionBlockDC(String queryId, String status);
	void actionBlockCC(String queryId, String status);
	void actionUpgradeDC(String queryId);

	void actionUpgradeCC(String queryId);

	String getNewType(String queryId) throws SQLException, IOException;

	String getNewName(BigInteger uci) throws SQLException, IOException;

	boolean actionANCC(String queryId, CreditCardBean bean1) throws SQLException, IOException;

	boolean actionANDC(String queryId, DebitCardBean bean) throws SQLException, IOException;
	BigInteger getNewUCI(String queryId) throws SQLException, IOException; 
}
