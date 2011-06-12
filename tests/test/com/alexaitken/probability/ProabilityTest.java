package test.com.alexaitken.probability;

import static com.alexaitken.probability.Probability.*;
import static org.junit.Assert.*;


import org.junit.Test;

import com.alexaitken.probability.Probability;


public class ProabilityTest {

	
	@Test
	public void should_have_two_probabilities_with_the_same_value_equal_each_other() throws Exception {
		assertEquals(probabilityOf("0.1"), probabilityOf("0.1"));
	}

	@Test
	public void should_have_two_probabilities_with_different_values_are_not_equal_each_other() throws Exception {
		assertFalse(probabilityOf("0.6").equals(probabilityOf("0.4")));
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void should_not_allow_a_number_greater_than_one_as_a_probability() throws Exception {
		probabilityOf("1.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void should_not_allow_a_number_less_than_zero_as_a_probability() throws Exception {
		probabilityOf("-0.12");
	}
	
	@Test
	public void should_allow_a_number_zero_as_a_probability() throws Exception {
		assertNotNull(probabilityOf("0.0"));
	}
	@Test
	public void should_allow_a_number_one_as_a_probability() throws Exception {
		assertNotNull(probabilityOf("1.0"));
	}
	
	
	@Test
	public void should_create_the_inverse_of_a_given_probability() throws Exception {
		Probability sut = probabilityOf("0.9");
		assertEquals(probabilityOf("0.1"), sut.inverseOf());
	}
	
	
	@Test
	public void should_create_the_combined_probability_of_two_probabilities() throws Exception {
		Probability sut = probabilityOf("0.5");
		assertEquals(probabilityOf("0.125"), sut.combinedWith(probabilityOf("0.25")));
	}
	
	@Test
	public void should_find_the_probability_of_either_event_happening() throws Exception {
		Probability sut = probabilityOf("0.5");
		assertEquals(probabilityOf("0.625"), sut.either(probabilityOf("0.25")));
	}
	
	
	
	@Test(timeout=1000)
	public void should_complete_a_half_a_million_either_operations_in_a_second() throws Exception {
		Probability pA = probabilityOf("0.4");
		Probability pB = probabilityOf("0.3");
		
		for (int i = 0; i < 5000000; i++) {
			
			pA.either(pB);
		}
	}
	
}
