package org.nele.utils;

import java.security.MessageDigest;
public class ToMd5 {
	
	/***
	 * ��һ���ַ���ת����һ��md5����ʽ
	 * @author ���� 2013-9-23 nele0716@163.com
	 * @param Ҫת�����ַ���
	 * @return ת����md5���ַ�
	 */
 public final static String getMD5(String s) {
  char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
    'a', 'b', 'c', 'd', 'e', 'f' };
   s="apple"+s+"nele";
  try {
   byte[] strTemp = s.getBytes();
   // ʹ��MD5����MessageDigest����
   MessageDigest mdTemp = MessageDigest.getInstance("MD5");
   mdTemp.update(strTemp);
   byte[] md = mdTemp.digest();
   int j = md.length;
   char str[] = new char[j * 2];
   int k = 0;
   for (int i = 0; i < j; i++) {
    byte b = md[i];
    // System.out.println((int)b);
    // ��û����(int)b����˫�ֽڼ���
    str[k++] = hexDigits[b >> 4 & 0xf];
    str[k++] = hexDigits[b & 0xf];
   }
   return new String(str);
  } catch (Exception e) {
     return null;
  }
 }
}
