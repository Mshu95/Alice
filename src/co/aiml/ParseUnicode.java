package co.aiml;

/**
 * 
 * @author ypan 
 * unicode编码转换工具类
 * in 2009-11-02
 */

public class ParseUnicode {
 
 //将unicode编码转换成中文
 public static String decodeUnicode(final String dataStr){
    int start = 0;   
         int end = 0;   
         final StringBuffer buffer = new StringBuffer();   
         while (start > -1) {   
             end = dataStr.indexOf("\\u", start + 2);   
             String charStr = "";   
             if (end == -1) {   
                 charStr = dataStr.substring(start + 2, dataStr.length());   
             } else {   
                 charStr = dataStr.substring(start + 2, end);   
             }   
             char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。   
             buffer.append(new Character(letter).toString());   
             start = end;   
         }   
         //System.out.println(buffer.toString());
         return buffer.toString();   
 }
 
 //将中文转换成unicode编码
   public static String gbEncoding(final String gbString) {   
         char[] utfBytes = gbString.toCharArray();   
         String unicodeBytes = "";   
         for (int byteIndex = 0; byteIndex < utfBytes.length; byteIndex++) {   
             String hexB = Integer.toHexString(utfBytes[byteIndex]);   
             if (hexB.length() <= 2) {   
                 hexB = "00" + hexB;   
             }   
             unicodeBytes = unicodeBytes + "\\u" + hexB;   
         }   
         //System.out.println("unicodeBytes is: " + unicodeBytes);   
         return unicodeBytes;   
     } 
}