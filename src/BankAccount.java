public interface BankAccount extends Comparable<BankAccount>{
   public int getAcctNum();
   public int getBalance();
   public boolean isForeign();
   public void setForeign(boolean isForeign);
   public void deposit(int amt);
   public boolean hasEnoughCollateral(int loanAmt);
   public String toString();
   public void addInterest();
}
