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

/**
 * @author bwm
 * 
 */
public class SingleDSAServerFile {

	static String algorithm = "DSA";

	static String signdataFile = "fileSignData.dat";
	static String privatekeyFile = "keyPrivateData.dat";
	static String publickeyFile = "keyPublicData.dat";

	/**
	 * ���ͱK�_��
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public void generatorKey() {
		KeyPairGenerator generator = null;
		try {
			generator = KeyPairGenerator.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		KeyPair keyPair = generator.generateKeyPair();
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();
		writeFile(publicKey.getEncoded(), publickeyFile);
		writeFile(privateKey.getEncoded(), privatekeyFile);
	}

	/**
	 * ����ñ�W
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 * @throws InvalidKeyException 
	 * @throws SignatureException 
	 */
	public void generatorSign(byte[] data) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {

		byte[] privateKey = readFile(privatekeyFile);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKey);

		// algorithm ���w���[�K��k
		KeyFactory keyFactory = null;
		PrivateKey priKey = null;
		keyFactory = KeyFactory.getInstance(algorithm);
		priKey = keyFactory.generatePrivate(pkcs8KeySpec);
		Signature signature = Signature.getInstance(keyFactory.getAlgorithm());
		signature.initSign(priKey);
		signature.update(data);
		writeFile(signature.sign(), signdataFile);
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

	public static void main(String[] avg) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, SignatureException {

		SingleDSAServerFile singleDSAServerFile = new SingleDSAServerFile();
		SingleDSAClientFile singleDSAClientFile = new SingleDSAClientFile();
		String data = "������";
		System.out.println("�ǿ��ơG" + data);
		boolean flag = false;

		singleDSAServerFile.generatorKey();
		singleDSAServerFile.generatorSign(data.getBytes());

		flag = singleDSAClientFile.verifySign(data.getBytes());

		if (flag) {
			System.out.println("���ҳz�L�A��ƶǿ�L�{�S���g�L�ק�");
		} else {
			System.out.println("���Ҥ��L�q�A��ƶǿ�L�{�g�L�ק�");
		}
	}
}
