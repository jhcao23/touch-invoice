package technology.touchmars.invoice.domain.model;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Document(collection="invoice")
public class Invoice {
	
	@Id
	private String id;
	
	@Indexed(unique=true)
	@Field
	private Long invoiceBusinessNumber;
	@Field
	@NumberFormat(style=Style.CURRENCY)
	private BigDecimal invoiceAmount;
	@Field
	@NumberFormat(style=Style.CURRENCY)
	private BigDecimal receivedAmount;
	@Field
	private String paymentMethod;
	@Field
	private String lastDigits4;
	@Field
	private List<InvoiceItem> items;
	@Field
	private Customer customer;
	
	
	@Field
	@CreatedBy
	private String createdBy;
	
	
	@Field
	@LastModifiedBy
	private String updatedBy;

	
	@Field
	@CreatedDate
	private LocalDateTime createdDt;
	
	
	@Field
	@LastModifiedDate
	private LocalDateTime updatedDt;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getInvoiceBusinessNumber() {
		return invoiceBusinessNumber;
	}
	public void setInvoiceBusinessNumber(Long invoiceBusinessNumber) {
		this.invoiceBusinessNumber = invoiceBusinessNumber;
	}
	public BigDecimal getInvoiceAmount() {
		return invoiceAmount;
	}
	public void setInvoiceAmount(BigDecimal invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
	public BigDecimal getReceivedAmount() {
		return receivedAmount;
	}
	public void setReceivedAmount(BigDecimal receivedAmount) {
		this.receivedAmount = receivedAmount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getLastDigits4() {
		return lastDigits4;
	}
	public void setLastDigits4(String lastDigits4) {
		this.lastDigits4 = lastDigits4;
	}
	public List<InvoiceItem> getItems() {
		return items;
	}
	public void setItems(List<InvoiceItem> items) {
		this.items = items;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public LocalDateTime getCreatedDt() {
		return createdDt;
	}
	public void setCreatedDt(LocalDateTime createdDt) {
		this.createdDt = createdDt;
	}
	public LocalDateTime getUpdatedDt() {
		return updatedDt;
	}
	public void setUpdatedDt(LocalDateTime updatedDt) {
		this.updatedDt = updatedDt;
	}
	
}
