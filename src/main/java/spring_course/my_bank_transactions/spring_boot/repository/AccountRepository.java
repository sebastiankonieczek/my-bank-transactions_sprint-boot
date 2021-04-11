package spring_course.my_bank_transactions.spring_boot.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import spring_course.my_bank_transactions.spring_boot.model.Account;

import java.math.BigDecimal;

public interface AccountRepository extends CrudRepository< Account, String >
{
   @Query( "select * from account where USER_ID = :userId" )
   Iterable< Account > findByUserId( @Param( "userId" ) final String userId );

   @Modifying
   @Query( "update ACCOUNT set BALANCE = :balance where ID = :id" )
   void updateBalance( @Param( "balance" ) final BigDecimal balance, @Param( "id" ) final String accountId );
}
