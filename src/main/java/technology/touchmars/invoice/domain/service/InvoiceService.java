/**
 * 
 */
package technology.touchmars.invoice.domain.service;

import technology.touchmars.invoice.domain.model.Invoice;

/**
 * @author jhcao
 *
 */
public interface InvoiceService {

	public void createInvoice(Invoice invoice);
	public void updateInvoice(Invoice invoice);
	public void deleteInvoice(Invoice invoice);
	public Invoice findInvoice(String invoiceId);
	public Invoice findInvoiceByBusinessNumber(Long bizNum);
	
	public Invoice findInvoiceBySomeId(String someId);
	
}
