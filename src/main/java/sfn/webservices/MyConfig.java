package sfn.webservices;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import sfn.webservices.web.CompteRestJaxRS;

@Configuration
public class MyConfig {
    //@Bean
    public ResourceConfig resourceConfig(){
       ResourceConfig jerseyServlet = new ResourceConfig();
        jerseyServlet.register(CompteRestJaxRS.class );
        return jerseyServlet ;
    }

    @Bean
    SimpleJaxWsServiceExporter simpleJaxWsServiceExporter(){
        SimpleJaxWsServiceExporter serviceExporter = new SimpleJaxWsServiceExporter();
        serviceExporter.setBaseAddress("http://0.0.0.0:8888/");
        return serviceExporter;
    }
}
