package com.nagarro.sb.adapters;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.sb.data.CurrencyRatesDto;
import com.nagarro.sb.entity.CurrencyRates;
import com.nagarro.sb.mapper.CurrencyRatesMapper;
import com.nagarro.sb.port.spi.CurrencyRatesPersistencePort;
import com.nagarro.sb.repository.CurrencyRatesRepository;

@Service
public class CurrencyRatesJpaAdaptor implements CurrencyRatesPersistencePort {

	@Autowired
	private CurrencyRatesRepository currencyRatesRepository;
	
	@Override
	public Collection<CurrencyRatesDto> findAll() {
		 List<CurrencyRates> currencyRatesList = (List<CurrencyRates>) currencyRatesRepository.findAll();

	     return CurrencyRatesMapper.INSTANCE.currencyRatesListToCurrencyRatesDtoList(currencyRatesList);
	}

}
