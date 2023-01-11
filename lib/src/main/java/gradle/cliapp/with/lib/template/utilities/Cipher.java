package gradle.cliapp.with.lib.template.utilities;


import gradle.cliapp.with.lib.template.structures.MapData;

import java.io.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class Cipher {

    private static final String password = "ooVGNNjMOdblOfAIexMMGPFXwSPjQHKShqBpqiEtltOYyorahi" +
            "ooVGNNjMOdblOfAIexMMGPFXwSPjQHKShqBpqiEtltOYyorahiGPInRIwOShmCHYMZYtmUTZBMnRmF";

    /**
     * Encrypt a string
     * @param data data to Encrypt
     * @param outputFile the output File
     */
    public static void encryptFile(MapData data, File outputFile) {
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES");
            byte [] salt = {2,3,4,5,6,4,3};
                cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512").generateSecret(new PBEKeySpec(password.toCharArray(), salt, 2,128)).getEncoded(), "AES"));
            SealedObject so = new SealedObject(data, cipher);

            CipherOutputStream cos = new CipherOutputStream(new FileOutputStream(outputFile), cipher);
            ObjectOutputStream outputStream = new ObjectOutputStream(cos);
            outputStream.writeObject(so);
            outputStream.close();
            cos.close();
        } catch (IllegalBlockSizeException | InvalidKeySpecException | IOException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Decrypt the object
     * @param inputFile input stream
     * @return the decrypted mapData
     */
    public static MapData decryptFile(File inputFile)  {
        try {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES");
        byte [] salt = {2,3,4,5,6,4,3};
            cipher.init(javax.crypto.Cipher.DECRYPT_MODE, new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512").generateSecret(new PBEKeySpec(password.toCharArray(), salt, 2, 128)).getEncoded(), "AES"));

        CipherInputStream cis = new CipherInputStream(new FileInputStream(inputFile), cipher);
        ObjectInputStream ois = new ObjectInputStream(cis);
        SealedObject so;

            so = (SealedObject) ois.readObject();
            ois.close();
            cis.close();
            return (MapData) so.getObject(cipher);
        } catch (ClassNotFoundException | InvalidKeySpecException | IllegalBlockSizeException | BadPaddingException | IOException | NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
}