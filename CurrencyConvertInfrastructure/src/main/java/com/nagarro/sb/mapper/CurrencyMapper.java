package com.nagarro.sb.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.nagarro.sb.data.CurrencyDto;
import com.nagarro.sb.entity.Currency;

@Mapper
public interface CurrencyMapper {

    CurrencyMapper INSTANCE = Mappers.getMapper(CurrencyMapper.class);

    CurrencyDto currencyToCurrencyDto(Currency Currency);

    Currency currencyDtoToCurrency(CurrencyDto CurrencyDto);

    List<CurrencyDto> currencyListToCurrencyDtoList(List<Currency> CurrencyList);

    List<Currency> currencyDtoListToCurrencyList(List<CurrencyDto> CurrencyDtoList);
}