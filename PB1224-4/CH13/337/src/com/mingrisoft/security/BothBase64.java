/**
 * @jdk����:1.6
 * @�g�{���ɶ�:2010-3-20
 */
package com.mingrisoft.security;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author bwm
 * 
 */
public class BothBase64 {

	/**
	 * �[�K
	 * 
	 * @param data
	 * @return
	 */
	public static String encryptBASE64(byte[] data) {
		//�[�K���
		return (new BASE64Encoder()).encodeBuffer(data);
	}

	/**
	 * �ѱK
	 * 
	 * @param data
	 * @return
	 * @throws IOException
	 */
	public static byte[] decryptBASE64(String data) throws IOException {
		//�ѱK���
		return (new BASE64Decoder()).decodeBuffer(data);
	}

	public static void main(String[] avg) throws IOException {
		String data = "������";
		System.out.println("�[�K�e�G" + data);
		String data1 = BothBase64.encryptBASE64(data.getBytes());
		System.out.println("�[�K��G" + data1);
		byte[] data2 = BothBase64.decryptBASE64(data1);
		System.out.println("�ѱK��G" + new String(data2));
	}
}
