package io.github.aggumati.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtil {
	public static BigDecimal ONE_HUNDRED = new BigDecimal(100);
	public static BigDecimal EIGHTY = new BigDecimal(80);
	public static BigDecimal FOUR = new BigDecimal(4);
	public static BigDecimal NINTY_NINE = new BigDecimal(99);
	public static BigDecimal NINTY_TWO = new BigDecimal(92);
	public static BigDecimal SIX_POINT_TWENTY_ONE = new BigDecimal(6.21);
	
	public static BigDecimal getPercent (BigDecimal numerator, BigDecimal denominator, Integer decimalPoint) {
		if ( CommonUtil.isNullOrEmpty(numerator) || 
				CommonUtil.isNullOrEmpty(denominator) || 
				BigDecimal.ZERO.compareTo(numerator) == 0 ||
				BigDecimal.ZERO.compareTo(denominator) == 0
				)
			return null;
		return numerator.multiply(ONE_HUNDRED).divide(denominator, decimalPoint, RoundingMode.HALF_UP);
	}
	
	public static BigDecimal getPercent (BigDecimal numerator, BigDecimal denominator) {
		return getPercent(numerator, denominator, 2);
	}
	
	public static BigDecimal getAverage (BigDecimal ... values) {
		BigDecimal total = BigDecimal.ZERO;
		for (BigDecimal bigDecimal : values) {
			if (bigDecimal != null)
				total = total.add(bigDecimal);
		}
		
		return total.divide(new BigDecimal(values.length), 2, RoundingMode.HALF_UP);
	}
}
