package com.alexaitken.probability;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Probability {

	private final Double probability;

	public static Probability probabilityOf(String probability) {
		return new Probability(new Double(probability));
	}

	
	private Probability(Double probability) {
		if (outOfRange(probability) )
			throw new IllegalArgumentException("probabilities are between 1 and 0 inclusive");
		this.probability = probability;
		
	}
	

	private boolean outOfRange(Double probability) {
		return probability > 1 || probability < 0;
	}
	

	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof Probability) {
			Probability otherProbability = (Probability) arg0;
			return Math.abs(probability - otherProbability.probability) < 0.00001;
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
		return new Probability(1 - probability);
	}

	
	
	public Probability combinedWith(Probability otherProbability) {
		return new Probability(probability * otherProbability.probability);
	}

	public Probability either(Probability otherProbability) {
		return new Probability(probability + otherProbability.probability - combinedWith(otherProbability).probability);
	}
	
	
	

}
