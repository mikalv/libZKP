package param;

import java.math.BigInteger;

import Exception.libzkpException;

public class ParamGeneration {
	
	public String STRING_COMMIT_GROUP = "COIN_COMMITMENT_GROUP";
	public String STRING_AVC_GROUP = "ACCUMULATED_VALUE_COMMITMENT_GROUP";
	public String STRING_AVC_ORDER = "ACCUMULATED_VALUE_COMMITMENT_ORDER";
	public String STRING_AIC_GROUP = "ACCUMULATOR_INTERNAL_COMMITMENT_GROUP";
	public String STRING_QRNCOMMIT_GROUPG = "ACCUMULATOR_QRN_COMMITMENT_GROUPG";
	public String STRING_QRNCOMMIT_GROUPH = "ACCUMULATOR_QRN_COMMITMENT_GROUPH";
	public int ACCUMULATOR_BASE_CONSTANT= 31;
	public int MAX_PRIMEGEN_ATTEMPTS = 10000;
	public int MAX_ACCUMGEN_ATTEMPTS = 10000;
	public int MAX_GENERATOR_ATTEMPTS = 10000;
	public int NUM_SCHNORRGEN_ATTEMPTS = 10000;
	
	public void CalculateParams(Params params, BigInteger N, String aux, int securityLevel) {
		params.initialized = false;
		params.accumulatorParams.initialized = false;
		
		//验证Verify |N| > 1023 bits 
		int Nlen = N.bitLength();
		if(Nlen < 1023) {
			throw new libzkpException("N < 1023 bits----in ParamGeneration.java");
		}
		
		//验证Verify securityLevel大于等于 80 bits
		if(securityLevel < 80) {
			throw new libzkpException("SecurityLevel must be at least 80 bits----in ParamGeneration.java");
		}
		
		//设置累加器的模数为N  Set the accumulator modulus to "N"
		params.accumulatorParams.accumulatorModulus = N;
		
		//计算“F_p”需要的大小
		//
		//
		int pLen = 0;
		int qLen = 0;
		calculateGroupParamLengths(Nlen - 2, securityLevel, pLen, qLen);
		
		//
		//
		//
//		params.coinCommitmentGroup = deriveIntegerGroupParams(calculateSeed(N, aux, securityLevel, STRING_COMMIT_GROUP),
//                pLen, qLen);
	}
	

	public byte[] calculateGroupParamLengths(int maxPLen, int securityLevel,int pLen, int qLen) {return null;};
	
	public byte[] calculateSeed(BigInteger modulus, String auxString, int securityLevel, String groupName){return null;}
	
	
	public byte[] calculateHash(byte[] input) {
		return Hash.calculateHash(input);
	}
	
	
	
	//								uint32_t primeBitLen, uint256 in_seed, uint256 *out_seed,uint32_t *prime_gen_counter
	public BigInteger generateRandomPrime(int primeBitLen, byte[] in_seed, byte[] out_seed, int prime_gen_counter) {
		//检查
		return null;
	}
	
	
	BigInteger generateIntegerFromSeed(int numBits, byte[] seed, int numIterations) {
		BigInteger result = BigInteger.valueOf(0);
		int iterations = (int) Math.ceil((double)numBits / (double)GlobalPara.HASH_OUTPUT_BITS);
		
		//This uint is self defined, and is not compatibal with java 
		// So this way is much time-comsuming as well as space-comsuming
		for(int count = 0; count < iterations; count++) {
			result = result.add(
					(
							new BigInteger(
								calculateHash( 
											( new BigInteger(seed)).multiply( 
														BigInteger.valueOf(count)
													).toByteArray() 
										) 
							)
					).multiply(
							(BigInteger.valueOf(2).pow(count*GlobalPara.HASH_OUTPUT_BITS))
							)
				);
			
			result = BigInteger.valueOf(2).pow(numBits-1).add(
					result.mod(  (BigInteger.valueOf(2).pow(numBits-1)) )
					);
//			result = ( new BigInteger(calculateHash(seed*count)) ).multiply(
//					(BigInteger.valueOf(2)).pow(count * HASH_OUTPUT_BITS) 
//					);
		}
		
		numIterations = iterations;
		return result;
	}
	
	/*
	 * 查看参数是否为素数
	 */
	public Boolean primalityTestByTrialDivision(int candidate) {
		BigInteger canBigNum = BigInteger.valueOf(candidate);
		//当前数字为素数的可能性超过 (1 - (1/2)^certainty)
		return canBigNum.isProbablePrime(9);
	}
}
