package gradle.cliapp.with.lib.template.utilities;

import gradle.cliapp.with.lib.template.structures.MapData;

import java.io.*;

public class UtilsFile {

    /**
     * create a directory if not exist
     * @param directory
     */
    private static void createDirectory(String directory){
        File dir = new File(directory);
        if (!dir.exists()){
            dir.mkdirs();
        }
    }

    /**
     * delete a file
     * @param directory directory of the file
     * @param filename name of the file
     */
    public static void deleteFile(String directory, String filename) {
        File file = new File(directory+ "\\" + Hash.hashCode(filename) + ".txt");
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * read all files in a directory
     * @param directory directory of files
     * @return array of MapData
     */
    public static MapData[] readFiles(String directory) {
        UtilsFile.createDirectory(directory);
        MapData[] data = null;
        try {
            File dir = new File(directory);
            File[] filesList = dir.listFiles();
            data = new MapData[filesList.length];

            for (int i = 0; i < filesList.length; i++) {
                data[i] = Cipher.decryptFile(new File(directory + "\\"+ filesList[i].getName()));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    /**
     * write a file
     * @param data data to write
     * @param directory directory of file
     */
    public static void writeFile(MapData data, String directory) {
        try {
            UtilsFile.createDirectory(directory);
            File file = new File(directory + "\\" + Hash.hashCode(data.getKey()) + ".txt");
            file.createNewFile();
            Cipher.encryptFile(data, file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
