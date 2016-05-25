import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by norvag on 25.05.2016.
 * Система Платежи.
 * Клиент имеет Счет в банке и Кредитную Карту (КК).
 * Клиент может оплатить Заказ,
 * сделать платеж на другой Счет,
 * заблокировать КК и аннулировать Счет.
 * Администратор может заблокировать КК за превышение кредита.
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ваш номер счета в банке: ");
        int numAccount = Integer.parseInt(reader.readLine());
        System.out.print("Сумма денег на вашем счете: ");
        long amountAccount = Long.parseLong(reader.readLine());

        Payment payment = new Payment(numAccount, amountAccount);

        while (!payment.isCardStatus() && payment.getAmountAccount() >= 0) {
            long sumOffer = (int) (Math.random() * 400000);
            System.out.println("Необходимо оплатить заказ на " + sumOffer + " тыс.рублей.");
            Thread.sleep(2000);
            System.out.println("С вашего счёта списано " + sumOffer + " тыс.рублей.");
            payment.setAmountAccount(payment.getAmountAccount() - sumOffer);
            System.out.println("Остаток на балансе: " + payment.getAmountAccount() + " тыс.рублей.");
            Thread.sleep(2000);

            System.out.println("\nПеревести деньги на счет.");
            Thread.sleep(2000);
            System.out.print("Введите счет для перевода средств: ");
            long anotherAccount = Long.parseLong(reader.readLine());
            System.out.print("Введите количество денег, которые необходимо перевести: ");
            sumOffer = Long.parseLong(reader.readLine());
            Thread.sleep(2000);
            System.out.println("Средства успешно переведены ✓");
            payment.setAmountAccount(payment.getAmountAccount() - sumOffer);
            System.out.println("Остаток на балансе: " + payment.getAmountAccount() + " тыс.рублей.");
            Thread.sleep(2000);

            System.out.println("Желаете заблокировать карту? (Y/N)");
            String status = reader.readLine();
            if (status.equals("Y")) {
                payment.setCardStatus(true);
                System.out.println("Карта успешно заблокирована!");
            }

            System.out.println("Желаете аннулировать счет? (Y/N)");
            status = reader.readLine();
            if (status.equals("Y")) {
                payment.setAmountAccount(0);
                System.out.println("Счет успешно аннулирован!");
            }
        }
    }
}
