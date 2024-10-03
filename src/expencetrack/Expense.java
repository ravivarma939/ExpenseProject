package expencetrack;

import java.util.Date;

public class Expense {
	private double amount;//250
	private String spentfor;
	private Date date;//10-02-2024
    private double checkamount;
    
	public double getCheckamount() {
		return checkamount;
	}

	public void setCheckamount(double checkamount) {
		this.checkamount = checkamount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSpentfor() {
		return spentfor;
	}

	public void setSpentfor(String spentfor) {
		this.spentfor = spentfor;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date string) {
		this.date = string;
	}

}
