package br.com.cast.tdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TDDApplication{


    public static void main(String[] args) {

       SpringApplication.run(TDDApplication.class, args);

//        SpringApplication application = new SpringApplication(br.com.cast.tdd.TDDApplication.class);
//
//        Properties properties = new Properties();
//        properties.put("spring.datasouce.url", "yehaeygaueg");
//        application.setDefaultProperties(properties);
//
//        ConfigurableApplicationContext run = application.run(args);
//
//        run.getBean(br.com.cast.tdd.TDDApplication.class).mostrarUrl();
    }


}
