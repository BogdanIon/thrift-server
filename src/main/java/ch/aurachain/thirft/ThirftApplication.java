package ch.aurachain.thirft;

import ch.aurachain.thirft.generated.CrossPlatformRepository;
import ch.aurachain.thirft.generated.CrossPlatformResource;
import ch.aurachain.thirft.generated.CrossPlatformService;
import ch.aurachain.thirft.generated.UserType;
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
import java.util.*;

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
        ServletRegistrationBean servlet = new ServletRegistrationBean(tServlet, "/cross");
        servlet.setLoadOnStartup(1);
        return servlet;
    }

    @Bean
    public CrossPlatformRepository createCrossPlatform() {
        Map<Integer, CrossPlatformResource> crossPlatformResourceMap = new HashMap<>();

        List<String> emails = Arrays.asList("bogdan.gherla@aurachain.ch", "bogdan.gherla@hq.aurachain.ch");
        Set<String> emailsSet = new HashSet<>(emails);

        Map<String, String> idAndUsername = new HashMap<>();
        idAndUsername.put("1", "bogdan");
        idAndUsername.put("2", "ionut");

        CrossPlatformResource crossPlatform1 = new CrossPlatformResource();
        crossPlatform1.setName("Cross1");
        crossPlatform1.setId(1);
        crossPlatform1.setEmails(emails);
        crossPlatform1.setIdAndUserName(idAndUsername);
        crossPlatform1.setUserSet(emailsSet);
        crossPlatform1.setIsAdmin(true);
        crossPlatform1.setUserType(UserType.ADMIN);
        crossPlatform1.setSalutation("Mr");

        CrossPlatformResource crossPlatform2 = new CrossPlatformResource();
        crossPlatform2.setId(2);
        crossPlatform2.setEmails(emails);

        crossPlatformResourceMap.put(1, crossPlatform1);
        crossPlatformResourceMap.put(2, crossPlatform2);
        return new CrossPlatformRepository(crossPlatformResourceMap);
    }

}
