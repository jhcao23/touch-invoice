/**
 * 
 */
package technology.touchmars.invoice.domain.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import technology.touchmars.invoice.domain.model.Invoice;
import technology.touchmars.invoice.domain.persistence.AdvancedInvoiceRepository;
import technology.touchmars.invoice.domain.persistence.InvoiceRepository;

/**
 * @author jhcao
 *
 */
@Service("invoiceService")
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	@Autowired
	private AdvancedInvoiceRepository advancedInvoiceRepository;
	
	private AtomicLong counter;
	
	@PostConstruct
	private void initCounter(){
		counter = new AtomicLong(getInitLong());
	}
	
	private long getInitLong(){
		Long bizNum = advancedInvoiceRepository.findInvoiceMaxBusinessNumber();
		if(bizNum!=null)
			return bizNum;
		else
			return 0L;
	}
	
	/* (non-Javadoc)
	 * @see technology.touchmars.invoice.domain.service.InvoiceService#createInvoice(technology.touchmars.invoice.domain.model.Invoice)
	 */
	@Override
	public void createInvoice(Invoice invoice) {
		while(true){		
			invoice.setInvoiceBusinessNumber(counter.incrementAndGet());
			try{
				invoiceRepository.save(invoice);
				return ;
			}catch(DuplicateKeyException e){
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
				return ;
			}
		}
	}

	/* (non-Javadoc)
	 * @see technology.touchmars.invoice.domain.service.InvoiceService#updateInvoice(technology.touchmars.invoice.domain.model.Invoice)
	 */
	@Override
	public void updateInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);
	}

	/* (non-Javadoc)
	 * @see technology.touchmars.invoice.domain.service.InvoiceService#deleteInvoice(technology.touchmars.invoice.domain.model.Invoice)
	 */
	@Override
	public void deleteInvoice(Invoice invoice) {
		invoiceRepository.delete(invoice);
	}

	/* (non-Javadoc)
	 * @see technology.touchmars.invoice.domain.service.InvoiceService#findInvoice(java.lang.String)
	 */
	@Override
	public Invoice findInvoice(String invoiceId) {
		return invoiceRepository.findOne(invoiceId);
	}

	@Override
	public Invoice findInvoiceByBusinessNumber(Long bizNum) {
		List<Invoice> invoices = invoiceRepository.findByInvoiceBusinessNumber(bizNum);
		if(invoices!=null && invoices.size()==1)
			return invoices.get(0);
		else
			return null;
	}

	@Override
	public Invoice findInvoiceBySomeId(String someId) {
		Invoice invoice = null;
		if(someId!=null){
			try{
				Long bizNum = Long.parseLong(someId);
				invoice = findInvoiceByBusinessNumber(bizNum);
			}catch(Exception e){
				invoice = findInvoice(someId);
			}
		}
		return invoice;
	}

}
