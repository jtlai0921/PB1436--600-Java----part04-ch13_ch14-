/**
 *second 
 */
package com.mingrisoft.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyAgreement;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 * @author baiweiming
 * 
 */
public class BothDHServerFile {

	private String keyAlgorithm = "DH";
	private String secretAlgorithm = "DES";
	// �A�Ⱥݸ���ɮ�
	private String serverdataFile = "fileServerData.dat";
	// �Ȥ�ݸ���ɮ�
	private String clientdataFile = "fileClientData.dat";
	// �A�Ⱥݨp�_�ɮ�
	private String privateServerkeyFile = "keyServerPrivateData.dat";
	// �A�Ⱥݤ��_�ɮ�
	private String publicServerkeyFile = "keyServerPublicData.dat";
	// �Ȥ�ݤ��_�ɮ�
	private String publicClientkeyFile = "keyClientPublicData.dat";

	/**
	 * ���Ƽg����w���ɮפW
	 * 
	 * @param data
	 *            ���
	 * @param fileName
	 *            �ɮצW��
	 */
	public void writeFile(byte[] data, String fileName) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(fileName);
			fileOutputStream.write(data);
			fileOutputStream.close();
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * �ھ�fileNameŪ������ɮ�
	 * 
	 * @param fileName
	 * @return
	 */
	public byte[] readFile(String fileName) {

		// Ū��
		try {
			File file = new File(fileName);
			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fileInputStream.read(data);
			fileInputStream.close();
			return data;
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * ���ͪA�ȺݱK�_��
	 */
	public void generateServerKeyFile() {
		KeyPairGenerator keyPairGen = null;
		try {
			keyPairGen = KeyPairGenerator.getInstance(keyAlgorithm);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		KeyPair keyPair = keyPairGen.generateKeyPair();

		// ���_
		PublicKey publicKey = keyPair.getPublic();
		writeFile(publicKey.getEncoded(), publicServerkeyFile);

		// �p�_
		PrivateKey privateKey = keyPair.getPrivate();
		writeFile(privateKey.getEncoded(), privateServerkeyFile);
	}

	/**
	 * ���ͪA�Ⱥݾ��K�K�_
	 * 
	 * @return
	 */
	private SecretKey getServerSecretKey() {
		byte[] privateServerKey = readFile(privateServerkeyFile);
		byte[] publicClientKey = readFile(publicClientkeyFile);

		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicClientKey);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(
				privateServerKey);

		Key publicKey = null;
		KeyFactory keyFactory = null;
		Key privateKey = null;
		KeyAgreement keyAgree = null;

		try {
			keyFactory = KeyFactory.getInstance(keyAlgorithm);
			publicKey = keyFactory.generatePublic(x509KeySpec);
			privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
			// �إ߱K�_��w
			keyAgree = KeyAgreement.getInstance(keyFactory.getAlgorithm());
			//��l�ƱK�_
			keyAgree.init(privateKey);
			keyAgree.doPhase(publicKey, true);
			return keyAgree.generateSecret(secretAlgorithm);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * �A�Ⱥݸ�ƥ[�K
	 * 
	 * @param data
	 */
	public void encryptForServer(byte[] data) {

		SecretKey secretKey = getServerSecretKey();

		try {
			Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			writeFile(cipher.doFinal(data), serverdataFile);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * �A�Ⱥݸ�ƸѱK
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public byte[] decryptForServer() {
		SecretKey secretKey = getServerSecretKey();

		try {
			byte[] data = readFile(clientdataFile);
			Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return cipher.doFinal(data);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] arg) {
		String data = "�Ȥ�ݧA�n�A�ڬO�A�Ⱥ�";
		BothDHServerFile bothDHServerFile = new BothDHServerFile();
		BothDHClientFile bothDHClientFile = new BothDHClientFile();

		// ���ͪA�ȺݱK�_��
		bothDHServerFile.generateServerKeyFile();
		// ���ͫȤ�ݱK�_��
		bothDHClientFile.generateClientKeyFile();
		// �A�Ⱥݥ[�K
		bothDHServerFile.encryptForServer(data.getBytes());
		// �Ȥ�ݸѱK
		byte[] data1 = bothDHClientFile.decryptForClient();
		System.out.println("Servet��l��ơG" + data);
		System.out.println("Client�ѱK��ơG" + new String(data1));
	}

}
