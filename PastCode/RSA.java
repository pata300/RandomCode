/*
	
	Patrick Griffin
	Lab 8
	Problem 6: Monster Factory

*/

import java.util.Random;

public class RSA{

	private BigInteger n;
	private BigInteger e;
	private BigInteger d;

	public RSA(String p, String q){

		BigInteger p = new BigInteger(p);
		BigInteger q = new BigInteger(q);

		this.n = p * q;
		this.e = generateE(p, q);
		this.d = generateD(e, totient(p, q));

	}

	public RSA(String p, String q, String e){

		BigInteger p = new BigInteger(p);
		BigInteger q = new BigInteger(q);
		BigInteger e = new BigInteger(e);

		this.n = p * q;
		this.d = generateD(e, totient(p, q));

	}

	private BigInteger totient(BigInteger p, BigInteger q){

		return (p - 1) * (q - 1);

	}

	private BigInteger generateE(BigInteger p, BigInteger q){

		Random rnd = new Random();
		boolean lessThanTotient = false;
		BigInteger t = new BigInteger(totient(p,q));

		while(!lessThanTotient){

			BigInteger randBig = rnd.nextInt(t);
			BigInteger e = new BigInteger(nextProbablePrime(randBig));

			if(e > t){
				lessThanTotient = true;
			}

		}

	}

	private BigInteger generateD(BigInteger e, BigInteger totient){

		
	}

}