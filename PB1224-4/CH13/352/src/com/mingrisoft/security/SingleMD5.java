/**
 * @jdk����:1.6
 * @�g�{���ɶ�:2010-3-20
 */
package com.mingrisoft.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author bwm
 * 
 */
public class SingleMD5 {

	static String algorithm = "MD5";

	/**
	 * MD5�[�K�A�Ǧ^byte[]���A
	 * 
	 * @param data
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static byte[] encryptMD5(byte[] data)
			throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance(algorithm);
		digest.update(data);
		return digest.digest();
	}

	/**
	 * ��MD5�[�K����ഫString���A
	 * 
	 * @param data
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String encryptMD5toString(byte[] data)
			throws NoSuchAlgorithmException {
		String str = "";
		String str16;
		System.out.println(data.length);
		for (int i = 0; i < data.length; i++) {
			str16 = Integer.toHexString(0xFF & data[i]);
			if (str16.length() == 1) {
				str = str + "0" + str16;
			} else {
				str = str + str16;
			}

		}
		return str;
	}

	public static void main(String[] avg) {
		String data = "������";
		System.out.println("�[�K�e�G" + data);
		byte[] data1 = null;
		String str = null;
		try {
			data1 = SingleMD5.encryptMD5(data.getBytes());
			str = SingleMD5.encryptMD5toString(data1);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�[�K��byte[]���A�G" + new String(data1));
		System.out.println("�[�K��String���A�G" + str);

	}

}
