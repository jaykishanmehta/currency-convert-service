package com.nagarro.sb.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.nagarro.sb.data.CurrencyRatesDto;
import com.nagarro.sb.entity.CurrencyRates;

@Mapper
public interface CurrencyRatesMapper {

    CurrencyRatesMapper INSTANCE = Mappers.getMapper(CurrencyRatesMapper.class);

    CurrencyRatesDto currencyRatesToCurrencyRatesDto(CurrencyRates CurrencyRates);

    CurrencyRates currencyRatesDtoToCurrencyRates(CurrencyRatesDto CurrencyRatesDto);

    List<CurrencyRatesDto> currencyRatesListToCurrencyRatesDtoList(List<CurrencyRates> CurrencyRatesList);

    List<CurrencyRates> currencyRatesDtoListToCurrencyRatesList(List<CurrencyRatesDto> CurrencyRatesDtoList);
}