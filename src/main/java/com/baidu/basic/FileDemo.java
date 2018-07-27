package com.baidu.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDemo {
    public static void main(String[] args) throws Exception {

        String src = "/Users/wuqingxin/AppDev/workspace/test.zip";
        String dest = "/Users/wuqingxin/AppDev/workspace/test2.zip";
        //copyWithStream(src, dest);
        // copyWith(src, dest);
        copyWithFileChannel(src, dest);
    }

    /**
     *
     *
     * @param src
     * @param dest
     */
    public static void copyWithFileChannel(String src, String dest){
        try {
            Path path1 = Paths.get(src);
            Path path2 = Paths.get(dest);
            System.out.println(path1.getFileSystem());

            FileChannel f1 = FileChannel.open(path1);
            FileChannel f2 = FileChannel.open(path2);
            f1.transferTo(9,0, f2);

            long copyBegin = System.currentTimeMillis();

            //Files.copy(path1,path2);
            System.out.println("time:" + (System.currentTimeMillis() - copyBegin) + "ms.");

            //destFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
    }

    /**
     * 9443ms
     *
     * @param src
     * @param dest
     */
    public static void copyWith(String src, String dest){
        try {
            Path path1 = Paths.get(src);
            Path path2 = Paths.get(dest);

            long copyBegin = System.currentTimeMillis();

            Files.copy(path1,path2);
            System.out.println("time:" + (System.currentTimeMillis() - copyBegin) + "ms.");

            //destFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
    }
    /**
     * time:22097ms.
     *
     * @param src
     * @param dest
     */
    public static void copyWithStream(String src, String dest) {
        try {
            InputStream input = new FileInputStream(new File(src));
            OutputStream output = new FileOutputStream(new File(dest));
            long copyBegin = System.currentTimeMillis();
            byte[] buf = new byte[1024];
            int size;
            while ((size = input.read(buf)) > 0) {
                output.write(buf, 0, size);
            }
            output.flush();
            input.close();
            output.close();

            System.out.println("time:" + (System.currentTimeMillis() - copyBegin) + "ms.");

            //destFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
