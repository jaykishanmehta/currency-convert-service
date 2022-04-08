package com.nagarro.sb.repository;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nagarro.sb.entity.Currency;
import com.nagarro.sb.entity.CurrencyRates;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@RunWith(SpringRunner.class)
@DataJpaTest
public class CurrencyConversionRepositoryTest {

  @Autowired 
  private CurrencyRepository currencyRepository;

  @Autowired
  private CurrencyRatesRepository currencyRatesRepository;
  
  @Test
  public void validateCurrencyServiceIsWorkingAsExpected(){
	  
	  Currency c = new Currency();
	  c.setCode("usd");
	  c.setName("Dollar");
	  
	  currencyRepository.save(c);
	  Assert.assertNotNull(c.getId());
	  
  }
  
  @Test
  public void validateCurrencyRateServiceIsWorkingAsExpected(){
	  
	  Collection<CurrencyRates> rates = (Collection<CurrencyRates>) currencyRatesRepository.findAll();
	  Assert.assertEquals(8, rates.size());
	  
  }
}