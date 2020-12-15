package ch.aurachain.thirft;

import ch.aurachain.thirft.generated.CrossPlatformService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.apache.thrift.transport.TTransportException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.servlet.Servlet;

@SpringBootApplication
public class ThirftApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirftApplication.class, args);
	}

	@Bean
	public TProtocolFactory tProtocolFactory() {
		return new TBinaryProtocol.Factory();
	}

	@Bean
	public ServletRegistrationBean cross(TProtocolFactory protocolFactory, CrossPlatformServiceImpl crossPlatformService) throws TTransportException {
		TServlet tServlet = new TServlet(new CrossPlatformService.Processor<CrossPlatformServiceImpl>(crossPlatformService), protocolFactory);
		ServletRegistrationBean servlet =  new ServletRegistrationBean(tServlet, "/cross");
		servlet.setLoadOnStartup(1);
		return servlet;
	}


}
