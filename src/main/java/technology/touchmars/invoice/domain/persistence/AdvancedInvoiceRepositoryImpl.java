package technology.touchmars.invoice.domain.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import technology.touchmars.invoice.domain.model.Invoice;

@Repository("advancedInvoiceRepository")
public class AdvancedInvoiceRepositoryImpl implements AdvancedInvoiceRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public Long findInvoiceMaxBusinessNumber() {
		Query query = new Query();
		query.with(new Sort(Direction.DESC, "invoiceBusinessNumber"));
		query.limit(1);
		
		Invoice invoice = mongoTemplate.findOne(query, Invoice.class);
		if(invoice!=null)
			return invoice.getInvoiceBusinessNumber();
			
		return null;
	}

	
}
