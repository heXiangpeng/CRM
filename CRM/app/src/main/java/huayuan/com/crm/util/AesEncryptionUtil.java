package huayuan.com.crm.util;


import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * Created by lenovo on 2017/5/19.
 */

/**
 * AES加密解密算法
 *
 * @author long
 */
public class AesEncryptionUtil {
    public static String encrypt() throws Exception {
        try {
            String data = "{\n" +
                    "    \"Id\": 1,\n" +
                    "    \"Uuid\": \"test\",\n" +
                    "    \"Passwd\": \"test\",\n" +
                    "    \"Username\": \"test\",\n" +
                    "    \"Position\": \"1\",\n" +
                    "    \"Level\": 1,\n" +
                    "    \"Status\": 1,\n" +
                    "    \"Creater\": \"1\",\n" +
                    "    \"UpdateTime\": \"2017-05-15 09:30:03\"\n" +
                    "}";
            String key = "1111111111111111";
            String iv = "0123456789abcdef";

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();

            byte[] dataBytes = data.getBytes();
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }

            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);

            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return Base64.encodeToString(encrypted, Base64.DEFAULT);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String desEncrypt(String data) throws Exception {
        try
        {
            String key = "1111111111111111";
            String iv = "0123456789abcdef";

            byte[] encrypted1 = Base64.decode(data,Base64.DEFAULT);

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}