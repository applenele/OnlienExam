package org.nele.utils;

import java.security.MessageDigest;
public class ToMd5 {
	
	/***
	 * 讲一个字符串转换成一个md5的形式
	 * @author 聂乐 2013-9-23 nele0716@163.com
	 * @param 要转换的字符串
	 * @return 转换成md5的字符
	 */
 public final static String getMD5(String s) {
  char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
    'a', 'b', 'c', 'd', 'e', 'f' };
   s="apple"+s+"nele";
  try {
   byte[] strTemp = s.getBytes();
   // 使用MD5创建MessageDigest对象
   MessageDigest mdTemp = MessageDigest.getInstance("MD5");
   mdTemp.update(strTemp);
   byte[] md = mdTemp.digest();
   int j = md.length;
   char str[] = new char[j * 2];
   int k = 0;
   for (int i = 0; i < j; i++) {
    byte b = md[i];
    // System.out.println((int)b);
    // 将没个数(int)b进行双字节加密
    str[k++] = hexDigits[b >> 4 & 0xf];
    str[k++] = hexDigits[b & 0xf];
   }
   return new String(str);
  } catch (Exception e) {
     return null;
  }
 }
}
