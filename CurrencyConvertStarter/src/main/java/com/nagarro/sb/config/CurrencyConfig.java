package com.nagarro.sb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nagarro.sb.adapters.CurrencyJpaAdaptor;
import com.nagarro.sb.port.api.CurrencyServicePort;
import com.nagarro.sb.port.spi.CurrencyPersistencePort;
import com.nagarro.sb.service.impl.CurrencyServiceImpl;

@Configuration
public class CurrencyConfig {

    @Bean
    public CurrencyPersistencePort currencyPersistence(){
        return new CurrencyJpaAdaptor();
    }

    @Bean
    public CurrencyServicePort currencyService(){
        return new CurrencyServiceImpl(currencyPersistence());
    }
}
