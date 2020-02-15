/**
 * @jdk����:1.6
 * @�g�{���ɶ�:2010-3-20
 */
package com.mingrisoft.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * @author bwm
 * 
 */
public class BothDESFile {

	String algorithm = "DES";
	// key�x�s���ɮצW��
	String keyFile = "keyData.dat";
	// ����x�s���ɮצW��
	String dataFile = "fileData.dat";

	public BothDESFile() {
		try {
			initKey();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ���ͱK�_���,�x�s���ɮפ�
	 * 
	 * @throws NoSuchAlgorithmException
	 */
	private void initKey() throws NoSuchAlgorithmException {
		// ���ͤ@���H���Ʒ�
		SecureRandom secureRandom = new SecureRandom();
		// ��DES��k���ͤ@��KeyGenerator
		KeyGenerator generator = KeyGenerator.getInstance(algorithm);
		generator.init(secureRandom);
		SecretKey key = generator.generateKey();
		//���ͱK�_���,�x�s���ɮפ�
		writeFile(key.getEncoded(), keyFile);

	}

	/**
	 * ��ƱK�_��Key�i��[�K�ѱK
	 * 
	 * @return
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	private Key toKey() throws InvalidKeyException, NoSuchAlgorithmException,
			InvalidKeySpecException {
		byte[] key = readFile(keyFile);
		DESKeySpec keySpec = new DESKeySpec(key);
		SecretKeyFactory factory = SecretKeyFactory.getInstance(algorithm);
		SecretKey secretKey = factory.generateSecret(keySpec);
		return secretKey;
	}

	/**
	 * �[�K�A��[�K����x�s�b�ɮפ�
	 * 
	 * @param data
	 * @param key
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public void encrypt(byte[] data) throws InvalidKeyException,
			NoSuchAlgorithmException, InvalidKeySpecException,
			NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException {
		Key key = toKey();
		// �ϥ�Cipher��ڧ����[�K�ާ@
		Cipher cipher = Cipher.getInstance(algorithm);
		// �ϥαK�_��l��Cipher
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] f = cipher.doFinal(data);
		writeFile(f, dataFile);
	}

	/**
	 * �ѱK���Ʊq�ɮפ����X�Ӧb�ѱK
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public String decrypt() throws InvalidKeyException,
			NoSuchAlgorithmException, InvalidKeySpecException,
			NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException {
		Key key = toKey();
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] f = readFile(dataFile);
		return new String(cipher.doFinal(f));
	}

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

	public static void main(String[] avg) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		BothDESFile bothDESFile = new BothDESFile();
		String data = "������";

		// ��ƥ[�K
		System.out.println("�[�K�e�G" + data);
		bothDESFile.encrypt(data.getBytes());

		// ��ƸѱK
		String b = bothDESFile.decrypt();
		System.out.println("�ѱK��G" + b);

	}
}
