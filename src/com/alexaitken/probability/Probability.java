package com.alexaitken.probability;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Probability {

	private final BigDecimal probability;

	public static Probability probabilityOf(String probability) {
		return new Probability(new BigDecimal(probability));
	}

	
	
	private Probability(BigDecimal probability) {
		if (outOfRange(probability) )
			throw new IllegalArgumentException("probabilities are between 1 and 0 inclusive");
		this.probability = probability;
	}

	private boolean outOfRange(BigDecimal probability) {
		return probability.compareTo(BigDecimal.ONE) > 0 || probability.compareTo(BigDecimal.ZERO) < 0;
	}
	

	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof Probability) {
			Probability otherProbability = (Probability) arg0;
			return probability.equals(otherProbability.probability);
		}
		return false;
	}

	
	
	@Override
	public int hashCode() {
		return probability.hashCode();
	}

	
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}



	public Probability inverseOf() {
		return new Probability(BigDecimal.ONE.subtract(probability));
	}

	
	
	public Probability combinedWith(Probability otherProbability) {
		return new Probability(probability.multiply(otherProbability.probability));
	}

	public Probability either(Probability otherProbability) {
		return new Probability(probability.add(otherProbability.probability).subtract(combinedWith(otherProbability).probability));
	}
	
	
	

}
