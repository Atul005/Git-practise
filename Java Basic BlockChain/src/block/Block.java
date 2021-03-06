package block;

import java.util.Date;

import utils.StringUtil;

public class Block {
	
	public String hash;
	public String previousHash;
	private String data;
	private long timeStamp;
	private int nonce;
	
	public Block(String previousHash, String data) {
		super();
		this.previousHash = previousHash;
		this.data = data;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();
	}
	
	public String calculateHash() {
		String calculatedHash = StringUtil.applySHA256String(previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + data ); 
		return calculatedHash;
	}
	
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0','0');
		while(!hash.substring(0,difficulty).equals(target)) {
			nonce++;
			hash = calculateHash();
		}
		System.out.println("Block mined!!! : " +hash);
	}
}
