package it.uniroma1.restserver;

import com.fasterxml.jackson.jaxrs.json.*;

import java.util.*;

import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.jaxrs.*;
import org.apache.cxf.jaxrs.lifecycle.*;

public class Server {
    public static void main(String[] args) {
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(VaccinationRepository.class);
        VaccinationRepository fr = new VaccinationRepository();
        fr.setConnection(args[0]); // path of database
        factoryBean.setResourceProvider(new SingletonResourceProvider(fr));
        factoryBean.setAddress("http://localhost:8080/");

        List<Object> providers = new ArrayList<>();
        providers.add(new JacksonJaxbJsonProvider());
        factoryBean.setProviders(providers);

        BindingFactoryManager manager = factoryBean.getBus().getExtension(BindingFactoryManager.class);
        JAXRSBindingFactory restFactory = new JAXRSBindingFactory();
        restFactory.setBus(factoryBean.getBus());
        manager.registerBindingFactory(JAXRSBindingFactory.JAXRS_BINDING_ID, restFactory);

        factoryBean.create();

        System.out.println("REST Server ready...");

    }
}
