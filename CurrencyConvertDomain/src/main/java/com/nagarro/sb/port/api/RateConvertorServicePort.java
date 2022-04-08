package com.nagarro.sb.port.api;

import com.nagarro.sb.data.ConversionPayload;
import com.nagarro.sb.exception.RatesNotAvailableException;

public interface RateConvertorServicePort {

	void convert(ConversionPayload data) throws RatesNotAvailableException;
}
