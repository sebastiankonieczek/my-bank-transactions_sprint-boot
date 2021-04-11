package spring_course.my_bank_transactions.spring_boot.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@JacksonXmlRootElement( localName = "transaction" )
public class TransactionDto
{
   @NotBlank
   @NotNull
   private String reference;
   @Min( 100 )
   @Max( 500 )
   private BigDecimal amount;
   @NotBlank
   @NotNull
   private String receivingUserId;

   public TransactionDto()
   {
   }

   @JsonCreator
   public TransactionDto(
      @JsonProperty( "reference" ) final String reference,
      @JsonProperty( "amount" ) final BigDecimal amount,
      @JsonProperty( "userId" ) final String receivingUserId )
   {
      this.reference = reference;
      this.amount = amount;
      this.receivingUserId = receivingUserId;
   }

   @JsonProperty( "reference" )
   public String getReference()
   {
      return reference;
   }

   @JsonProperty( "amount" )
   public BigDecimal getAmount()
   {
      return amount;
   }

   @JsonProperty( "userId" )
   public String getReceivingUserId()
   {
      return receivingUserId;
   }

   public void setReference( String reference )
   {
      this.reference = reference;
   }

   public void setAmount( BigDecimal amount )
   {
      this.amount = amount;
   }

   public void setReceivingUserId( String receivingUserId )
   {
      this.receivingUserId = receivingUserId;
   }
}
