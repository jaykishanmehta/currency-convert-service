package com.nagarro.sb.data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
public class ConversionPayload {

	@Pattern(regexp = "^[a-zA-Z]*$", message = "From currency is invalid")
	@NotBlank(message = "From currency is not defined")
	@NonNull
	private String from;
	
	@Pattern(regexp = "^[a-zA-Z]*$", message = "To currency is invalid")
	@NotBlank(message = "To currency is not defined")
	@NonNull
	private String to;
	
	@PositiveOrZero
	private double amount;
	
	@Setter
	private double convertedToAmount;
	
	@Setter
	private String message;
	
}
