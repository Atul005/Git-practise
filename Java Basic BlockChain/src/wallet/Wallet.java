package wallet;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;

public class Wallet {
	private PrivateKey privateKey;// This private key could be used as our signature
	private PublicKey publicKey; // Public Key will act as out wallet address
	
	public Wallet() {
		generateKeyPair();
	}
	
	public void generateKeyPair() {
		try {
			KeyPairGenerator generator = KeyPairGenerator.getInstance("ECDSA","BC");//Elliptic Curve Digital Signature Algorithm, BouncyCastle
			SecureRandom  securerandom = SecureRandom.getInstance("SHA1PRNG");//Pseudo Random Number Generator
			ECGenParameterSpec spec = new ECGenParameterSpec("prime192v1");//This immutable class specifies the set of parameters used for generating elliptic curve (EC) domain parameters.
			generator.initialize(spec,securerandom);
			KeyPair keyPair = generator.generateKeyPair();
		    privateKey = keyPair.getPrivate();
			publicKey = keyPair.getPublic();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	
	
}
