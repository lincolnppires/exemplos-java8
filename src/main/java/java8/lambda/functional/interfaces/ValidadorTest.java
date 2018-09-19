package java8.lambda.functional.interfaces;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class ValidadorTest {

	@Test
	public void testeValidadorCEP(){
		Validador<String> validadorCEP = 
				cep -> cep.matches("[0-9]{5}-[0-9]{3}");
				
		System.out.println(validadorCEP.getClass());		
		
		assertTrue(validadorCEP.valida("35400-000"));
		assertFalse(validadorCEP.valida("35400-00A"));
	}
}
