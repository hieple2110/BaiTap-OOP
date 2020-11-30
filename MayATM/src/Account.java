public class Account {
    private String nameAccount;
    private int idAccount;
    private double amountMonney;

    public Account() {
    }

    public Account(String nameAccount, int idAccount, double amountMonney) {
        this.nameAccount = nameAccount;
        this.idAccount = idAccount;
        this.amountMonney = amountMonney;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public double getAmountMonney() {
        return amountMonney;
    }

    public void setAmountMonney(double amountMonney) {
        this.amountMonney = amountMonney;
    }
}
