/**
 * 
 */
package technology.touchmars.invoice.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import technology.touchmars.invoice.domain.model.Invoice;
import technology.touchmars.invoice.domain.service.InvoiceService;

/**
 * @author jhcao
 *
 */
@Controller
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;
	
	@RequestMapping(value="/create", method=RequestMethod.POST, consumes="application/*", produces="application/*")
	public String createInvoice(@ModelAttribute Invoice invoice, BindingResult result, Model model){
		
		invoiceService.createInvoice(invoice);
		System.out.println("successfully created invoice and redirected to /edit/: "+invoice.getId());
		return "redirect:/edit/"+invoice.getId();
		
	}
	@RequestMapping(value="/view/{invoiceId}", method=RequestMethod.GET)
	public String viewInvoice(@PathVariable("invoiceId") String invoiceId, Model model){
		System.out.println("accepting GET /view/"+invoiceId);
		Invoice invoice = invoiceService.findInvoiceBySomeId(invoiceId);
		if(invoice!=null){
			System.out.println("find invoice "+invoiceId + " biz#: "+invoice.getInvoiceBusinessNumber());
			model.addAttribute("invoice",invoice);
			return "view";
		}else{
			return "redirect:/create";
		}
	}
	@RequestMapping(value="/edit/{invoiceId}", method=RequestMethod.GET)
	public String editInvoice(@PathVariable("invoiceId") String invoiceId, Model model){
		System.out.println("accepting GET /edit/"+invoiceId);		
		Invoice invoice = invoiceService.findInvoiceBySomeId(invoiceId);
		if(invoice!=null){
			System.out.println("find invoice "+invoiceId + " biz#: "+invoice.getInvoiceBusinessNumber());
			model.addAttribute("invoice",invoice);
			return "edit";
		}else{
			return "redirect:/create";
		}
	}	
	@RequestMapping(value="/update", method={RequestMethod.POST, RequestMethod.PUT})
	public String updateInvoice(@ModelAttribute Invoice invoice, BindingResult result, Model model){
		String invoiceId = invoice.getId();
		Long bizNum = invoice.getInvoiceBusinessNumber();
		System.out.println("accepting PUT /edit/"+invoiceId);	
		if(invoiceId==null){
			System.out.println("this invoice has no id!");
			return "redirect:/edit/"+invoiceId;
		}else{			
			invoiceService.updateInvoice(invoice);
			System.out.println("successfully updated invoice:"+invoiceId+", biz#="+bizNum);
			model.addAttribute("invoice",invoice);
			return "view";
		}
	}
	
}
