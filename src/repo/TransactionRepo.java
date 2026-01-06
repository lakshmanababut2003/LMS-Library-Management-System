package repo;

import java.util.*;

import model.Transaction;

public class TransactionRepo implements RepoInterface<Transaction> {

    private static TransactionRepo instance;

    private TransactionRepo(){}

    public static TransactionRepo getTransactionRepo(){

        if(instance == null){
            instance = new TransactionRepo();
        }

        return instance;
    }

    private final Map<Integer , Transaction> transactions = new HashMap<>();

    @Override
    public Transaction add(Transaction transaction){

        transactions.put(transaction.getId(), transaction);
        return transactions.get(transaction.getId());
    }

    @Override
    public List<Transaction> getAll(){
        return new ArrayList<>(transactions.values());
    }

    @Override
    public Transaction update(Transaction transaction){
        return this.add(transaction);
    }

    @Override
    public Transaction getById(int id){
        return transactions.get(id);
    } 


    
}
