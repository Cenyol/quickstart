package com.cenyol.demo.utils;

import com.cenyol.demo.encrypt.AES;

import java.io.*;

/**
 * @author Chenhanqun mail: chenhanqun1@corp.netease.com
 * @date 2019/5/13 14:25
 */
public class FileIO {

    public static void main(String[] args) {
        String password = "131415";
        String filePath = "/Users/cenyol/tmp/test-20190512.txt";
        encryptFile(filePath, password);

        System.out.println(decryptFile(filePath, password));
    }

    /**
     * 解密指定文件内容
     *
     * @param filePath
     * @return
     */
    public static String decryptFile(String filePath, String password) {
        AES.setKey(password);
        String strToDecrypt = readFile(filePath + ".encrypt");
        AES.decrypt(strToDecrypt.trim());
        return AES.getDecryptedString();
    }

    /**
     * 读取
     * 加密
     * 写入保存在新文件中
     * @param filePath
     */
    public static void encryptFile(String filePath, String password) {
        AES.setKey(password);
        String strToEncrypt = readFile(filePath);
        AES.encrypt(strToEncrypt);
        writeFile(
                filePath + ".encrypt",
                AES.getEncryptedString()
        );
    }

    // 可为文本相对路劲，可以文件夹绝对路径
    private static String readFile(String filePath) {
        StringBuilder buffer = new StringBuilder();
        try {
            InputStream is = new FileInputStream(filePath);
            String line; // 用来保存每行读取的内容
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            line = reader.readLine(); // 读取第一行
            while (line != null) { // 如果 line 为空说明读完了
                buffer.append(line); // 将读到的内容添加到 buffer 中
                buffer.append("\n"); // 添加换行符
                line = reader.readLine(); // 读取下一行
            }
            reader.close();
            is.close();
        } catch (IOException ignored) {
        }
        return buffer.toString();
    }

    /* 写入Txt文件 */
    private static void writeFile(String filePath, String fileContent) {
        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw

            File writename = new File(filePath); // 相对路径，如果没有则要建立一个新的output。txt文件
            writename.createNewFile();  // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            out.write(fileContent); // \r\n即为换行
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
