package com.example.effective.chapter2.clauses9;

import java.io.*;

import static org.springframework.util.StreamUtils.BUFFER_SIZE;

/**
 * jdk 1.7之后支持TryWithResource
 *
 * @Author: zhenglongze
 * @Date 2019/11/18 17:55
 */
public class TryWithResource {

    //单资源的时候
    public String firstLineOfFile(String path) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            return br.readLine();
        }
    }

    //不仅更简洁，也容易进行诊断
    public void copy(String str,String dst) throws IOException {
        try(InputStream in = new FileInputStream(str)){
            try(OutputStream out = new FileOutputStream(dst)){
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n=in.read(buf))>=0){
                    out.write(buf,0,n);
                }
            }
        }
    }

}
