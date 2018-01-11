package param;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
	public static byte[] calculateHash(byte[] input) {
		MessageDigest digest;
		byte[] hash = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			//参数本来是text.getBytes(StandardCharsets.UTF_8)
			hash = digest.digest(input);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hash;
	}
	
	public static Boolean equals(byte[] a, byte[] b) {
		if(a.length != b.length)
			return false;
//		Boolean isEqual = true;
		for(int i = 0; i < a.length; i++) 
			if(a[i]!=b[i])
				return false;
		return true;
	}
}
