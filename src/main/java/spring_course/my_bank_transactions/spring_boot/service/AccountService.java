package spring_course.my_bank_transactions.spring_boot.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring_course.my_bank_transactions.spring_boot.model.Account;
import spring_course.my_bank_transactions.spring_boot.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.Collections;

@Component
public class AccountService
{
   private final AccountRepository accountRepository_;

   public AccountService( final AccountRepository accountRepository )
   {
      accountRepository_ = accountRepository;
   }

   @Transactional
   public Account supplyAccount( final String userId )
   {
      final var accounts = accountRepository_.findByUserId( userId );

      final var iterator = accounts.iterator();
      if( iterator.hasNext() ) {
         return iterator.next();
      }

      return accountRepository_.save( new Account( null, userId, BigDecimal.ZERO, Collections.emptyList() ) );
   }

   @Transactional
   public void updateBalance( final Account userAccount, final BigDecimal amount )
   {
      accountRepository_.updateBalance( amount, userAccount.getId() );
   }
}
