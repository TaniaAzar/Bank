import Account.*;
import Account.Client;
import Cells.Cells;
import Cells.Currency;

import java.util.*;

public class Bank {

    private Set<Client> clients;
    private Map<Long,Account> accountMap;
    private Map<Long,Cells> cellsMap;

    private Map<Client,Set<Long>> clientAccount;
    private Map<Client,Set<Long>> clientCells;

    private Map<Long,Long> serviceAccount;

    private long accountId = 1;
    private long cellsId = 1;

    public Bank(){
        clients = new HashSet<>();
        accountMap = new HashMap<>();
        cellsMap = new HashMap<>();

        clientAccount = new HashMap<>();
        clientCells = new HashMap<>();
    }

    //регистрация клиента
    public void registerClient(String name, String surname, String number_password){
        Client client = new Client(name,surname,number_password);
        clients.add(client);
        clientAccount.put(client,new HashSet<>());
        clientAccount.put(client,new HashSet<>());
    }

    //открытие дебетового счета
    public Long newDebitAccount(Client client, Currency currency){
        if (client == null){
            throw new IllegalArgumentException("Несуществующий клиент, нельзя создать счет");
        }
        DebitAccount debitAccount = new DebitAccount(currency);
        accountMap.put(accountId,debitAccount);
        clientAccount.get(client).add(accountId);
        long t = accountId;
        accountId++;
        return t;
    }

    //открытие процентного счета
    public Long newPercentAccount(Client client, Currency currency, int percent){
        if (client == null){
            throw new IllegalArgumentException("Несуществующий клиент, нельзя создать счет");
        }
        PercentAccount percentAccount = new PercentAccount(currency,percent);
        accountMap.put(accountId,percentAccount);
        clientAccount.get(client).add(accountId);
        long t = accountId;
        accountId++;
        return accountId;
    }

    //открытие кредитного счета
    public Long newCreditAccount(Client client, Currency currency, int percent){
        if (client == null){
            throw new IllegalArgumentException("Несуществующий клиент, нельзя создать счет");
        }
        CreditAccount creditAccount = new CreditAccount(currency,percent);
        accountMap.put(accountId,creditAccount);
        clientAccount.get(client).add(accountId);
        long t = accountId;
        accountId++;
        return accountId;
    }

    //пополнить счет
    public void depositAccount(Client client, long id, double sum){
        if (client == null || !clients.contains(client)){
            throw new IllegalArgumentException("Несуществующий клиент");
        }
        if (!accountMap.containsKey(accountId)){
            throw new IllegalArgumentException("Счета не существует");
        }
        if (!clientAccount.get(client).contains(id)){
            throw new IllegalArgumentException("Счет не пренадлежит клиенту");
        }
        accountMap.get(id).replenishmentMoney(sum);
    }

    //снятие денег со счета
    public void removalMoney(Client client,Long id,double sum){
        if (client == null || !clients.contains(client)){
            throw new IllegalArgumentException("Несуществующий клиент");
        }
        if (!accountMap.containsKey(accountId)){
            throw new IllegalArgumentException("Счета не существует");
        }
        if (!clientAccount.get(client).contains(id)){
            throw new IllegalArgumentException("Счет не пренадлежит клиенту");
        }
        accountMap.get(id).removalMoney(sum);
    }

    //узнать сколько денег на счету
    public void getAccount(Client client,Long id){
        if (client == null || !clients.contains(client)){
            throw new IllegalArgumentException("Несуществующий клиент");
        }
        if (!accountMap.containsKey(accountId)){
            throw new IllegalArgumentException("Счета не существует");
        }
        if (!clientAccount.get(client).contains(id)){
            throw new IllegalArgumentException("Счет не пренадлежит клиенту");
        }
        accountMap.get(id).getBalance();
    }

    //перевод со счета на счет
    public void transfer(Client client,Long source, Long distance, double sum){
        if (client == null || !clients.contains(client)){
            throw new IllegalArgumentException("Несуществующий клиент");
        }
        if (!accountMap.containsKey(source) || !accountMap.containsKey(distance)){
            throw new IllegalArgumentException("Счета не существует");
        }
        if (!clientAccount.get(client).contains(source)){
            throw new IllegalArgumentException("Счет не пренадлежит клиенту");
        }
        accountMap.get(source).transfer(accountMap.get(distance),sum);
    }

    //fake client
    public boolean searchClientByPassword(String password){
        Client fakeClient = new Client("_","_", password);
        return this.clients.contains(fakeClient);
    }

    //узнать порядковый номер счета
    public boolean searchClientById(long id){
        return this.accountMap.containsKey(id);
    }
}
