package noobChain;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.GsonBuilder;

import block.Block;

public class NoobChain {
	
	public static List<Block> blockChain = new ArrayList<Block>();
	public static int difficulty = 5;

	public static void main(String[] args) {
				
		Block genesisBlock = new Block("0","Hi, I am the first block.");
		blockChain.add(genesisBlock);
		System.out.println("Hash for block 1 - "+genesisBlock.hash);
		blockChain.get(0).mineBlock(difficulty);
		
		Block secondBlock = new Block(genesisBlock.calculateHash(),"Hi, I am the second block.");
		blockChain.add(secondBlock);
		System.out.println("Hash for block 2 - "+secondBlock.hash);
		blockChain.get(1).mineBlock(difficulty);

		Block thirdBlock = new Block(secondBlock.calculateHash(),"Hi, I am the third block.");
		blockChain.add(thirdBlock);
		System.out.println("Hash for block 3 - "+thirdBlock.hash);
		blockChain.get(2).mineBlock(difficulty);
		

		String blockChainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
		
		System.out.println(blockChainJson);
		
		if(isValidChain(blockChain)) {
			System.out.println("Valid Chain");
		}
		else {
			System.out.println("Not a valid chain");
		}
		
	}
	
	public static boolean  isValidChain(List<Block> blockChain) {
		Block currentBlock;
		Block previousBlock;
		String hashTarget = new String(new char[difficulty]).replace('\0','0');
		
		for (int i=1 ; i < blockChain.size() ; i++) {
			currentBlock = blockChain.get(i);
			previousBlock = blockChain.get(i-1);
		
			if(!currentBlock.hash.equals(currentBlock.calculateHash())) {
				System.out.println("Current hash is not equal.");
				return false;
			}
			
			if(!previousBlock.hash.equals(currentBlock.previousHash)) {
				System.out.println("Previous hash is not equal.");
				return false;
			}
			
			if(!currentBlock.hash.substring(0,difficulty).equals(hashTarget)) {
				System.out.println("This block has not been mined.");
				return false;
			}
		}
		return true;
	}

}
