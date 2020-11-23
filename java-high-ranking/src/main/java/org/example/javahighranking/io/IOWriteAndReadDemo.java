package org.example.javahighranking.io;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

/**
 * IO 读写示例
 *
 * @author qiqiang
 * @date 2020-10-26 10:12 上午
 */
public class IOWriteAndReadDemo {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        // 拿到一段文本
        String content = getContent();
        // 写入文件
        File file = write2File(content, "content.txt");
        // 读取文件
        byte[] bytes = readFromFile(file);
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }

    private static String getContent() throws URISyntaxException, IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI("http://www.baidu.com")).GET().build();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
        return response.body();
    }

    private static byte[] readFromFile(File file) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        InputStream fis = new FileInputStream(file);
        int r;
        // 使用缓冲数组，避免大内容撑爆内存
        byte[] temp = new byte[1024];
        // 将数据读取到缓冲数组中，如果能读取到数据，游标 r 不等于-1
        while ((r = fis.read(temp)) != -1) {
            // 将数组中0-r的数据写入 OutputStream 中
            bos.write(temp, 0, r);
        }
        fis.close();
        byte[] bytes = bos.toByteArray();
        bos.close();
        return bytes;
    }

    private static File write2File(String content, String filePath) throws IOException {
        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
        // 写入文件
        File file = new File(filePath);
        OutputStream fos = new FileOutputStream(file);
        fos.write(bytes);
        fos.close();
        return file;
    }
}