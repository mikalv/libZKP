package tutorial;

import java.math.BigInteger;
import param.Params;

/**
 * @file test.java
 * @brief Simple test for all libzerocoin functions
 * @date 
 * @version 1.0.0
 * @author jiaxyan
 *
 */
public class test {
	static String TUTORIAL_TEST_MODULUS = "a8852ebf7c49f01cd196e35394f3b74dd86283a07f57e0a262928e7493d4a3961d93d93c90ea3369719641d626d28b9cddc6d9307b9aabdbffc40b6d6da2e329d079b4187ff784b2893d9f53e9ab913a04ff02668114695b07d8ce877c4c8cac1b12b9beff3c51294ebe349eca41c24cd32a6d09dd1579d3947e5c4dcc30b2090b0454edb98c6336e7571db09e0fdafbd68d8f0470223836e90666a5b143b73b9cd71547c917bf24c0efc86af2eba046ed781d9acb05c80f007ef5a0a5dfca23236f37e698e8728def12554bc80f294f71c040a88eff144d130b24211016a97ce0f5fe520f477e555c9997683d762aff8bd1402ae6938dd5c994780b1bf6aa7239e9d8101630ecfeaa730d2bbc97d39beb057f016db2e28bf12fab4989c0170c2593383fd04660b5229adcd8486ba78f6cc1b558bcd92f344100dff239a8c00dbc4c2825277f24bdd04475bcc9a8c39fd895eff97c1967e434effcb9bd394e0577f4cf98c30d9e6b54cd47d6e447dcf34d67e48e4421691dbe4a7d9bd503abb9";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * What is it:		Parameter loading
		 * Who does it:		P & V
		 * What it does:		load a trusted Zerocoin modulus "N" and generates all associated params from it
		 */
		BigInteger testModulus;//
		testModulus = new BigInteger(TUTORIAL_TEST_MODULUS,16);//把十六进制数转化成大树
		//Set up the Params object
		Params params = new Params();
		
	}

}
