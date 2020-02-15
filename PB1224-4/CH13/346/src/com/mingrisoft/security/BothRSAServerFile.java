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
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * @author baiweiming
 * 
 */
public class BothRSAServerFile {

	private String keyAlgorithm = "RSA";
	private String singAlgorithm = "MD5withRSA";
	// �A�Ⱥݸ���ɮ�
	private String serverdataFile = "fileServerData.dat";
	// �Ȥ�ݸ���ɮ�
	private String clientdataFile = "fileClientData.dat";
	// ñ�W�ɮ�
	private String signdataFile = "fileSignData.dat";
	// �p�_�ɮ�
	private String privatekeyFile = "keyPrivateData.dat";
	// ���_�ɮ�
	private String publickeyFile = "keyPublicData.dat";

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
	 * ���ͱK�_��
	 */
	public void generateKeyFile() {
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
		writeFile(publicKey.getEncoded(), publickeyFile);

		// �p�_
		PrivateKey privateKey = keyPair.getPrivate();
		writeFile(privateKey.getEncoded(), privatekeyFile);
	}

	/**
	 * �Ψp�_�[�K
	 * 
	 * @param data
	 * @return
	 */
	public void encryptByPrivateKey(byte[] data) {

		// ���o�p�_
		byte[] key = readFile(privatekeyFile);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);
		KeyFactory keyFactory = null;
		Key privateKey = null;
		try {
			keyFactory = KeyFactory.getInstance(keyAlgorithm);
			privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ���ƥ[�K
		try {
			Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
			cipher.init(Cipher.ENCRYPT_MODE, privateKey);
			writeFile(cipher.doFinal(data), serverdataFile);
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * �Ψp�_���T���ͼƦrñ�W
	 * 
	 * @param data
	 *            �[�K���
	 * @param privateKey
	 *            �p�_
	 * 
	 * @return
	 * @throws Exception
	 */
	public void generateSign() {

		byte[] privateKey = readFile(privatekeyFile);
		byte[] serverData = readFile(serverdataFile);
		// �غcPKCS8EncodedKeySpec�ﹳ
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKey);

		// KEY_ALGORITHM ���w���[�K��k
		KeyFactory keyFactory = null;
		PrivateKey priKey = null;
		try {
			//���ͨp�_
			keyFactory = KeyFactory.getInstance(keyAlgorithm);
			priKey = keyFactory.generatePrivate(pkcs8KeySpec);
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			//���ͼƦrñ�W
			Signature signature = Signature.getInstance(singAlgorithm);
			signature.initSign(priKey);
			signature.update(serverData);
			writeFile(signature.sign(), signdataFile);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * �Ψp�_�ѱK
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public byte[] decryptByPrivateKey() {
		byte[] data = readFile(clientdataFile);
		byte[] key = readFile(privatekeyFile);
		// ���o�p�_
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(key);
		KeyFactory keyFactory = null;
		Key privateKey = null;
		try {
			keyFactory = KeyFactory.getInstance(keyAlgorithm);
			privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			return cipher.doFinal(data);
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] arg) {
		String data = "�Ȥ�ݧA�n�A�ڬO�A�Ⱥ�";
		// �A�Ⱥݾާ@
		BothRSAServerFile bothRSAServerFile = new BothRSAServerFile();
		// ���ͱK�_��
		bothRSAServerFile.generateKeyFile();
		// �[�K����
		bothRSAServerFile.encryptByPrivateKey(data.getBytes());
		// ����ñ�W
		bothRSAServerFile.generateSign();

		// �Ȥ�ݾާ@
		BothRSAClientFile bothRSAClientFile = new BothRSAClientFile();

		byte[]  data1 =null;
		if(bothRSAClientFile.verifySign()){
			data1= bothRSAClientFile.decryptByPublicKey();
		}
		System.out.println("Servet��l��ơG"+data);
		System.out.println("Client�ѱK��ơG"+new String (data1));
		
	}

}
