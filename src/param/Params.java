package param;

import java.math.BigInteger;

public class Params {

	public Boolean initialized;
	
	public AccumulatorAndProofParams accumulatorParams;
	
	/**
	 * 对一个serial number形成commitment 需要用到的二次剩余群
	 * (the Quadratic Residue group from which we form a coin as a commitment  to a serial number.)
	 */
	public IntegerGroupParams coinCommitmentGroup;
	
	/**
	 * 用来生成承诺的第一个群（自己就是一个对serial number的的承诺）
	 * 这是在serial number proof中用到的一个
	 * 这个的阶一定要和coinCommitmentGroup的模数相同
	 */
	public IntegerGroupParams serialNumberSoKCommitmentGroup;
	
	/*
	 * The number of iterations to use in the serial number proof.
	 */
	public int zkp_iterations;
	
	/*
	 * The amount of the hash function we use for proofs.
	 */
	public int zkp_hash_len;
	
//	public int ZEROCOIN_DEFAULT_SECURITYLEVEL = 80;
	/**
	 * @param N					A trusted RSA modulus
	 * @param securityLevel		A security level expressed in symmetric bits (default 80)
	 * 							securityLevel is set to GlobalPara.ZEROCOIN_DEFAULT_SECURITYLEVEL as default
	 * @param ParamGeneration paramgeneration 用来生成参数的一个类
	 * 
	 * 从模数 N 构建一套Zerocoin的参数(不知道什么有用什么没用)
	 * 用一种可验证的，确定(verifiable, deterministic)的步骤，在N的基础上计算全部剩下的参数(group descriptions etc.)，
	 * 
	 * Note:
	 * 这个构造方法的假设基础是：
	 * "N" encodes a valid RSA-style modulus of the form "e1 * e2" where
	 * "e1" and "e2" are safe primes. The factors "e1", "e2" MUST NOT
	 * be known to any party, or the security of Zerocoin is
	 * compromised. The integer "N" must be a MINIMUM of 1024
	 * in length. 3072 bits is strongly recommended.
	 */
	public Params(BigInteger accumulatorModulus,int securityLevel, ParamGeneration paramgeneration) {
		this.zkp_hash_len = securityLevel;
		this.zkp_iterations = securityLevel;
		
		this.accumulatorParams.k_prime = GlobalPara.ACCPROOF_KPRIME;
		this.accumulatorParams.k_dprime = GlobalPara.ACCPROOF_KDPRIME;
//		ParamGeneration paramgeneration = new ParamGeneration();
		//产生参数
		paramgeneration.CalculateParams(this, accumulatorModulus, GlobalPara.ZEROCOIN_PROTOCOL_VERSION, securityLevel);
		
		this.accumulatorParams.initialized = true;
		this.initialized = true;
	}
}
