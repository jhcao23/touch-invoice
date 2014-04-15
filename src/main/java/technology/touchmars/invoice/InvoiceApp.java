package technology.touchmars.invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

/**
 * Created by jhcao on 14-4-1.
 */
@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
@EnableAutoConfiguration
@EnableMongoAuditing
@EnableMongoRepositories("technology.touchmars.invoice.domain.persistence")
@ComponentScan
public class InvoiceApp {

	@Bean(name="pdfReportView")
	public JasperReportsPdfView getJasperReportsPdfView(){
		JasperReportsPdfView pdfView = new JasperReportsPdfView();
		pdfView.setUrl("classpath:invoices.jrxml");
		pdfView.setReportDataKey("dataSource");
		return pdfView;
	}
	
	@Bean
	public AuditorAware<String> auditorProvider(){
		return new SpringSecurityAuditorAware();
	}
	
    public static void main(String[] args) {
        SpringApplication.run(InvoiceApp.class, args);
    }
    
}
