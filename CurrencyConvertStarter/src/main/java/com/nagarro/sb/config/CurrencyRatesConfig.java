package com.nagarro.sb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nagarro.sb.adapters.CurrencyRatesJpaAdaptor;
import com.nagarro.sb.port.api.CurrencyRatesServicePort;
import com.nagarro.sb.port.spi.CurrencyRatesPersistencePort;
import com.nagarro.sb.service.impl.CurrencyRatesServiceImpl;

@Configuration
public class CurrencyRatesConfig {

    @Bean
    public CurrencyRatesPersistencePort currencyRatesPersistence(){
        return new CurrencyRatesJpaAdaptor();
    }

    @Bean
    public CurrencyRatesServicePort currencyRatesService(){
        return new CurrencyRatesServiceImpl(currencyRatesPersistence());
    }
}
