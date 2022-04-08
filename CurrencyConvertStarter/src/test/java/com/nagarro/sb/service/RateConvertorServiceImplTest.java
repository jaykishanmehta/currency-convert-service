package com.nagarro.sb.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nagarro.sb.data.ConversionPayload;
import com.nagarro.sb.data.CurrencyDto;
import com.nagarro.sb.data.CurrencyRatesDto;
import com.nagarro.sb.exception.RatesNotAvailableException;
import com.nagarro.sb.port.api.CacheManagerPort;
import com.nagarro.sb.service.impl.RateConvertorServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class RateConvertorServiceImplTest {

	//TODO: Need to validate
	
	@Mock
	private CacheManagerPort cacheManager;
	
	@Autowired
	@InjectMocks
	private RateConvertorServiceImpl convertorServiceImpl;
	
	@Test(expected = RatesNotAvailableException.class)
	void testConvert() throws RatesNotAvailableException {
		
//		cacheManagerPort = Mockito.mock(CacheManagerPort.class);
		Mockito.when(cacheManager.findRates(Mockito.any())).then(getCurrencyRatesDto());
		
		ConversionPayload payload = getPayload();
		convertorServiceImpl.convert(payload);
		
		assertEquals(10, payload.getConvertedToAmount());
		
	}

	private Answer<?> getCurrencyRatesDto() {
		
		return new Answer<CurrencyRatesDto>() {

			@Override
			public CurrencyRatesDto answer(InvocationOnMock invocation) throws Throwable {
				return new CurrencyRatesDto(1, new CurrencyDto(1, "USD", null), new CurrencyDto(2, "INR", null), 75);
			}
		};
	}

	private ConversionPayload getPayload() {
		return new ConversionPayload("USD", "INR", 10d, 0, null);
	}

}
