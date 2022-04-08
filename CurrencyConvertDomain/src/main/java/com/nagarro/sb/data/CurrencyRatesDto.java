package com.nagarro.sb.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CurrencyRatesDto {

	private int id;
	
	private CurrencyDto fromCurrency;
	
	private CurrencyDto toCurrency;
	
	private double rate;
}
