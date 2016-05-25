/**
 * Created by norvag on 25.05.2016.
 * Система Платежи.
 * Клиент имеет Счет в банке и Кредитную Карту (КК).
 * Клиент может оплатить Заказ,
 * сделать платеж на другой Счет,
 * заблокировать КК и аннулировать Счет.
 * Администратор может заблокировать КК за превышение кредита.
 */
public class Payment {
    private int numAccount;
    private long amountAccount;
    private boolean cardStatus;

    public Payment(int numAccount, long amountAccount) {
        this.numAccount = numAccount;
        this.amountAccount = amountAccount;
    }

    public boolean isCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(boolean cardStatus) {
        this.cardStatus = cardStatus;
    }

    public long getAmountAccount() {
        return amountAccount;
    }

    public void setAmountAccount(long amountAccount) {
        this.amountAccount = amountAccount;
    }
}
