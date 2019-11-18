package com.example.effective.chapter2.clauses9;

import java.io.*;

import static org.springframework.util.StreamUtils.BUFFER_SIZE;

/**
 * try-catch-finally方法
 *
 * @Author: zhenglongze
 * @Date 2019/11/18 15:38
 */
public class TryCatchFinally {

    //单资源的时候，不算太坏
    public String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        }finally {
            br.close();
        }
    }

    //层次深，代码可读性差
    public void copy(String str,String dst) throws IOException {
        InputStream in = new FileInputStream(str);
        try{
            OutputStream out = new FileOutputStream(dst);
            try{
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n=in.read(buf))>=0){
                    out.write(buf,0,n);
                }
            }finally {
                out.close();
            }
        }finally {
            in.close();
        }
    }
}
