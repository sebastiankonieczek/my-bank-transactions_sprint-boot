package spring_course.my_bank_transactions.spring_boot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Table( "ACCOUNT" )
public class Account
{
   @Id
   private final String id;
   @Column( "USER_ID" )
   private final String userId;
   @Column( "BALANCE" )
   private BigDecimal balance;
   @MappedCollection( idColumn = "ACCOUNT_ID", keyColumn = "TIMESTAMP" )
   private final List< Transaction > transactions;

   public Account(
      final String id, final String userId, final BigDecimal balance, final List< Transaction > transactions )
   {
      this.id = id;
      this.userId = userId;
      this.balance = balance;
      this.transactions = transactions;
   }

   public List< Transaction > getTransactions()
   {
      return Collections.unmodifiableList( transactions );
   }

   public String getUserId()
   {
      return userId;
   }

   public BigDecimal getBalance()
   {
      return balance;
   }

   public void setBalance( BigDecimal balance )
   {
      this.balance = balance;
   }

   public String getId()
   {
      return id;
   }
}
