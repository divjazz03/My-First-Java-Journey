public class SavingsAccount implements BankAccount, Comparable<BankAccount> {
    private int acctNum;

    private int balance = 0;
    private double rate = 0.01;
    private boolean isForeign = false;

    public SavingsAccount(int a){
        acctNum = a;
    }

    public int getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(int acctNum) {
        this.acctNum = acctNum;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isForeign() {
        return isForeign;
    }

    public void setForeign(boolean foreign) {
        isForeign = foreign;
    }

    public void deposit(int amt) {
        balance += amt;
    }

    public boolean hasEnoughCollateral(int loanAmt) {
        return balance >= loanAmt / 2;
    }

    public void addInterest() {
        balance += (int) (balance*rate);
    }
    @Override
    public String toString(){
        return "Savings account " + acctNum + ": balance="
                + balance + ", is "
                + (isForeign ? "foreign" : "domestic");
    }

    @Override
    public int compareTo(BankAccount ba) {
        int bal1 = this.getBalance();
        int bal2 = ba.getBalance();
        if (bal1 == bal2)
            return getAcctNum() - ba.getAcctNum();
        else
            return bal1 - bal2;

    }
}
