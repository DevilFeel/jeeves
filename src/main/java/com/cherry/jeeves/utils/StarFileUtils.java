package com.cherry.jeeves.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

public class StarFileUtils {

    /**
     * 创建文件夹
     * @param filepath 文件夹
     * @return true 成功, false 失败
     */
    public static boolean mkdir(String filepath){
        filepath.replace("\\", "/");
        String[] items = filepath.split("/");
        String lastItem = null;
        if (filepath.startsWith("/")){
            // 绝对路径 /home/config
            lastItem = "/";
        }else{
            // 相对路径 ./test/config
            lastItem = items[0];
        }

        boolean result = true;
        for (int i = 1; i < items.length-1; i++) {
            if (StringUtils.isNotBlank(items[i])){
                lastItem = lastItem + "/" + items[i];
                File file = new File(lastItem);
                if (!file.exists()){
                    result = result && file.mkdir();
                }
            }
        }
        return true;
    }
    
    /**
     * 转存文件，包括图片等
     * @param b
     * @param filename
     * @return
     * @throws IOException
     */
    public static String buffer2File(byte[] b, String filename) throws IOException{
    	FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(filename);
			// 将字节写入文件
			fout.write(b);
		} catch (IOException e) {
			return null;
		}finally {
			if (fout != null) {
				fout.close();
			}
		}
		
		return filename;
    }

}
