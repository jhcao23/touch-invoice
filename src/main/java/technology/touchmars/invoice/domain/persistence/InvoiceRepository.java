/**
 * 
 */
package technology.touchmars.invoice.domain.persistence;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import technology.touchmars.invoice.domain.model.Invoice;

/**
 * @author jhcao
 *
 */
public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, String> {

	public List<Invoice> findByInvoiceBusinessNumber(Long invoiceBusinessNumber);
}
