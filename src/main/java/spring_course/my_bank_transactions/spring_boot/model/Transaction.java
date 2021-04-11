package spring_course.my_bank_transactions.spring_boot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table( "TRANSACTION" )
public class Transaction
{
   @Id
   private final String id;
   @Column( "TIMESTAMP" )
   private final LocalDateTime timeStamp;
   @Column( "AMOUNT" )
   private final BigDecimal amount;
   @Column( "REFERENCE" )
   private final String reference;
   @Column( "SLOGAN" )
   private final String slogan;
   @Column( "ACCOUNT_ID" )
   private final String accountId;

   public Transaction(
      final String id,
      final LocalDateTime timeStamp,
      final BigDecimal amount,
      final String reference,
      final String slogan,
      final String accountId )
   {
      this.id = id;
      this.timeStamp = timeStamp;
      this.amount = amount;
      this.reference = reference;
      this.slogan = slogan;
      this.accountId = accountId;
   }

   public String getId()
   {
      return id;
   }

   public LocalDateTime getTimeStamp()
   {
      return timeStamp;
   }

   public BigDecimal getAmount()
   {
      return amount;
   }

   public String getReference()
   {
      return reference;
   }

   public String getSlogan()
   {
      return slogan;
   }

   public String getAccountId()
   {
      return accountId;
   }
}
