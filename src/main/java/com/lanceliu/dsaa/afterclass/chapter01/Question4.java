package com.lanceliu.dsaa.afterclass.chapter01;

import java.io.*;
import java.util.Scanner;

/**
 * TODO: describe.
 *
 * @author lanceliu <liuyunfei@yuntujinfu.com>
 * @date 15/9/23
 */
public class Question4 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String inputPath = sc.nextLine();

        String outputPath = sc.nextLine();

        File outPut = new File(outputPath);
        BufferedWriter fw = null;
        try {
            fw = new BufferedWriter(new FileWriter(outPut));
            readAndWrite(inputPath, fw);
        } catch (Exception ex) {

        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e1) {
                }
            }
        }

    }

    private static void readAndWrite(String inputPath, BufferedWriter fw) {

        File file = new File(inputPath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader((new FileReader(file)));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                fw.write("line " + line + ": " + tempString);
                fw.newLine();

                if (tempString.startsWith("#include")) {
                    String inputPaths = ""; // TODO: 解析路径
                    readAndWrite(inputPaths, fw);
                }
                line++;
            }
            reader.close();
        } catch (Exception ex) {

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}
