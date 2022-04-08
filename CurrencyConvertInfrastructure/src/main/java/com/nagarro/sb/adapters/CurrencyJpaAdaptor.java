package com.nagarro.sb.adapters;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.sb.data.CurrencyDto;
import com.nagarro.sb.entity.Currency;
import com.nagarro.sb.mapper.CurrencyMapper;
import com.nagarro.sb.port.spi.CurrencyPersistencePort;
import com.nagarro.sb.repository.CurrencyRepository;

@Service
public class CurrencyJpaAdaptor implements CurrencyPersistencePort{

	@Autowired
	private CurrencyRepository currencyRepository;
	
	@Override
	public Collection<CurrencyDto> findAll() {
		 List<Currency> currencyList = (List<Currency>) currencyRepository.findAll();

	     return CurrencyMapper.INSTANCE.currencyListToCurrencyDtoList(currencyList);
	}

}
