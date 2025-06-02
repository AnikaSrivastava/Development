import java.util.List;

public class Transaction {
    private String type;
    private Double amount;

    public Transaction(String type, Double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    static void addTransactions(List<Transaction> transaction){
        Transaction transaction1 = new Transaction("Debit", 120.12);
        Transaction transaction2 = new Transaction("Credit", 345.23);
        Transaction transaction3 = new Transaction("Debit", 165.67);
        Transaction transaction4 = new Transaction("Credit", 904.23);
        Transaction transaction5 = new Transaction("Debit", 102.23);

        transaction.add(transaction1);
        transaction.add(transaction2);
        transaction.add(transaction3);
        transaction.add(transaction4);
        transaction.add(transaction5);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}

