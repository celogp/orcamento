package com.sw1tech.orcamento;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrcamentoApplication {
	
    static {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
    
	public static void main(String[] args) {

		SpringApplication.run(OrcamentoApplication.class, args);

	}

}
