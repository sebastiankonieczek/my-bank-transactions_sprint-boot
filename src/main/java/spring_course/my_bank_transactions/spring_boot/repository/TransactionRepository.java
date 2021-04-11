package spring_course.my_bank_transactions.spring_boot.repository;

import org.springframework.data.repository.CrudRepository;
import spring_course.my_bank_transactions.spring_boot.model.Transaction;

public interface TransactionRepository extends CrudRepository< Transaction, String >
{
}
