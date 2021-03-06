package basicClass;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login {
	private int loginId;
	private String username;
	private String password;
	private String output;
	
	public Login(String username,String password)
	{
		this.loginId++;
		Connect(username,password);
	}
	
	public int getLoginId() {
		return loginId;
	}

	public String getUsername()
	{
		
	return this.username;	
	
	}
	public void Connect(String username,String password) 
	{
		/*
		 * Mogelijkheid 1 voor hash password
		 * MessageDigest digest = MessageDigest.getInstance("SHA-256");
		 *byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
		 * Mogelijkheid 2 voor hash password
		 * String sha256hex = org.apache.commons.codec.digest.DigestUtils.sha256Hex(stringText); 
		 *Wat het eigenlijk moet doen: 
		 * password= sha256(password);
		  
	/* Mogelijkheid voor sha256 hash
	 * public static String sha256(String base) {
    try{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(base.getBytes("UTF-8"));
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    } catch(Exception ex){
       throw new RuntimeException(ex);
    }
}
*Andere mogelijkheden in de links in het Referenties document
*Hieronder een probeersel(dit zal enkel gaan mits connectie met de database
*/
	

		MessageDigest md;
			try {
				md = MessageDigest.getInstance("SHA-256");
			
		 
		md.update(password.getBytes());
		byte byteData[] = md.digest();
		StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        	
        System.out.println("Hex format : " + sb.toString());
		
		if(this.password==password && this.username==username)
		{
			this.output="Connected.";
			System.out.println(this.output);
		}
		else
		{
			this.output="Not Connected.";
			System.out.println(this.output);
			
		} 
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.output="Not Connected.";
			System.out.println(this.output);
		}
	}
	
	
}