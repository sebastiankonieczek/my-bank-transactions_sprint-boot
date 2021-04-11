package spring_course.my_bank_transactions.spring_boot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring_course.my_bank_transactions.spring_boot.model.Account;
import spring_course.my_bank_transactions.spring_boot.model.Transaction;
import spring_course.my_bank_transactions.spring_boot.repository.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class TransactionService
{
   private final String slogan_;
   private final TransactionRepository transactionRepository_;

   public TransactionService( @Value( "${bank.slogan}" ) final String slogan, final TransactionRepository transactionRepository )
   {
      slogan_ = slogan;
      transactionRepository_ = transactionRepository;
   }

   @Transactional
   public Transaction find( String id )
   {
      return transactionRepository_.findById( id ).orElse( null );
   }

   @Transactional
   public Transaction create( final Account account, final String reference, final BigDecimal amount )
   {
      return transactionRepository_.save( new Transaction( null,
                                                           LocalDateTime.now(),
                                                           amount,
                                                           reference,
                                                           slogan_,
                                                           account.getId() ) );
   }

   @Transactional
   public Iterable< Transaction > getAll()
   {
      return transactionRepository_.findAll();
   }
}
