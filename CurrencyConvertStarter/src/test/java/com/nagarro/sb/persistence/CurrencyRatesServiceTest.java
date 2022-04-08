package com.nagarro.sb.persistence;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nagarro.sb.data.CurrencyRatesDto;
import com.nagarro.sb.port.spi.CurrencyRatesPersistencePort;
import com.nagarro.sb.service.impl.CurrencyRatesServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class CurrencyRatesServiceTest {

	@Mock
	private CurrencyRatesPersistencePort currencyRatesPersistancePort;
	
	@Autowired
    @InjectMocks
    private CurrencyRatesServiceImpl currencyRatesService;
	
	@Test
	void testGetAvailableConversionRates() {
		Mockito.when(currencyRatesPersistancePort.findAll()).thenReturn(getCurrencyRateList());
		assertTrue(currencyRatesService.getAvailableConversionRates().size() > 0);
	}

	private Collection<CurrencyRatesDto> getCurrencyRateList() {
		Collection<CurrencyRatesDto> list = new ArrayList<>();
		list.add(new CurrencyRatesDto());
		return list;
	}

}
