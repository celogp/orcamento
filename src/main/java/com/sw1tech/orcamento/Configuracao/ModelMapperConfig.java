package com.sw1tech.orcamento.Configuracao;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        final ModelMapper _modelMapper= new ModelMapper();
        return _modelMapper;
    };

}
