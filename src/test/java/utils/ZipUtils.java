package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils {

    private static final ClassLoader CLASS_LOADER = ZipUtils.class.getClassLoader();


    public static void addZip(String zipName, String... fileName) throws IOException {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zipName))) {
            for (String file : fileName) {
                InputStream inputStream = CLASS_LOADER.getResourceAsStream(file);
                ZipEntry entry = new ZipEntry(file);
                zout.putNextEntry(entry);
                byte[] buffer = new byte[inputStream.available()];
                inputStream.read(buffer);
                zout.write(buffer);
            }
            zout.closeEntry();
        }
    }

    public static void moveFile(String src, String dest) {
        Path result = null;
        try {
            result = Files.move(Paths.get(src), Paths.get(dest));
        } catch (IOException e) {
            System.out.println("Exception while moving file: " + e.getMessage());
        }
        if (result != null) {
            System.out.println("File moved successfully.");
        } else {
            System.out.println("File movement failed.");
        }
    }

    public static void removeZip(String path) throws IOException {
        Files.delete(Paths.get(path));
    }
}
