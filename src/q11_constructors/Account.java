package q11_constructors;

public class Account {
  private long accountID;
  private boolean vipAccount;
  private long accountAmount;
  private boolean childAccount;

  public Account(long accountID, boolean vipAccount, long accountAmount, boolean childAccount) {
    this.accountID = accountID;
    this.vipAccount = vipAccount;
    this.accountAmount = accountAmount;
    this.childAccount = childAccount;
  }

  public Account(long accountID) {
    new Account(accountID, false, 0L, false);
  }

  public Account(long accountID, boolean vipAccount, boolean childAccount) {
    new Account(accountID, vipAccount, 0L, childAccount);
  }

  public Account(long accountID, long accountAmount) {
    new Account(accountID, false, accountAmount, false);
  }

  public static void main(String[] args) {
    Account account = new Account(8345245L);
    Account kidsAccount = new Account(2493875249L, false, true);
    Account accountWithMoney = new Account(24897529L, 500);
  }
}
