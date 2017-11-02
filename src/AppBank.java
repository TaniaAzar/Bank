import Account.*;
import Cells.Events;
import Cells.Metals;
import Cells.Metals;
import Commision.Currency;
import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

import java.util.*;

import static Commision.Currency.BYN;
import static java.lang.Enum.valueOf;

public class AppBank {
    public static void main(String[] args) {

        int choose;

        do{
            System.out.println("Меню:\n1.Ввести клиента\n2.Список клиентов\n3.Список счетов, опреции по счетам\n4.Удалить клиента\n5.Выход\n");
            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();

            Map<Client,List<Account>> clientListHashMap = new HashMap<>();

            switch (choose){
                case 1:{

                    System.out.println("Введите имя");
                    Scanner scanner2 = new Scanner(System.in);
                    String name = scanner2.nextLine();

                    System.out.println("Введите фамилию");
                    Scanner scanner3 = new Scanner(System.in);
                    String surname = scanner3.nextLine();

                    System.out.println("Введите номер паспорта");
                    Scanner scanner4 = new Scanner(System.in);
                    String numpas = scanner4.nextLine();

                    Client client1 = new Client(numpas,name,surname);

                    clientListHashMap.put(client1, new ArrayList<>());
                    System.out.println("Введите баланс дебетового счета");
                    Scanner scanner5 = new Scanner(System.in);
                    double bal = scanner5.nextInt();

                    clientListHashMap.get(client1).add(new DebitAccount(bal,BYN));

                    System.out.println(clientListHashMap.keySet());

                    break;
                }
                case 2:{

                    for (Client client :clientListHashMap.keySet()) {
                        System.out.println("Клиент " + client.toString());
                        for (Account debitAccount : clientListHashMap.get(client)) {
                            System.out.println(debitAccount.toString());
                        }
                    }
                    break;
                }
            }

        }while (choose != 4);


    }
}
