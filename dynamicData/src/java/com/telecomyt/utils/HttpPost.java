package com.telecomyt.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.http.client.methods.HttpGet;

import net.sf.json.JSONObject;

public class HttpPost {
	public static String addJson(String uri, String obj, String charset) {
		StringBuffer sb = new StringBuffer("");
		try {
			// 创建连接
			URL url = new URL(uri);
			System.out.println("url="+GsonUtil.toJson(url));
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
//			connection.setRequestProperty("Content-Type","application/text/html;charset=UTF-8");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.connect();
			// POST请求
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			System.out.println("请求参数："+obj.toString());
			// out.writeBytes(obj.toString());//这个中文会乱码
			out.write(obj.getBytes(charset));// 这样可以处理中文乱码问题
			out.flush();
			// 读取响应
			int status = connection.getResponseCode();
			System.out.println("serveCode===="+status);
			BufferedInputStream in;
			if (status >= 400 ) {
			    in = new BufferedInputStream( connection.getErrorStream() );
//			    sb = null;
			} else {
			    in = new BufferedInputStream( connection.getInputStream() );
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String lines;
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(), "utf-8");
				sb.append(lines);
			}
			System.out.println("请求返回信息======="+sb);
			reader.close();
			// 断开连接
			out.close();
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static String post(String uri, JSONObject obj, String charset) {
		StringBuffer sb = new StringBuffer("");
		try {
			// 创建连接
			URL url = new URL(uri);
			System.out.println("url="+GsonUtil.toJson(url));
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
//			connection.setRequestProperty("Content-Type","application/text/html;charset=UTF-8");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.connect();
			// POST请求
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			System.out.println("请求参数："+obj.toString());
			// out.writeBytes(obj.toString());//这个中文会乱码
			out.write(obj.toString().getBytes(charset));// 这样可以处理中文乱码问题
			out.flush();
			// 读取响应
			int status = connection.getResponseCode();
			System.out.println("serveCode===="+status);
			BufferedInputStream in;
			if (status >= 400 ) {
			    in = new BufferedInputStream( connection.getErrorStream() );
//			    sb = null;
			} else {
			    in = new BufferedInputStream( connection.getInputStream() );
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String lines;
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(), "utf-8");
				sb.append(lines);
			}
			System.out.println("请求返回信息======="+sb);
			reader.close();
			// 断开连接
			out.close();
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static void connectionUrl(String username,String password){
        String url = "http://61.148.30.210:33892/api/authorization";
        String responseMessage = ""; 
        StringBuffer response = new StringBuffer(); 
        HttpURLConnection httpConnection = null; 
        OutputStreamWriter out = null; 
        BufferedReader reader = null; 
        try { 
          URL urlPost = new URL(url); 
          httpConnection = (HttpURLConnection) urlPost.openConnection(); 
          httpConnection.setDoOutput(true); 
          httpConnection.setDoInput(true); 
          // 参数长度太大，不能用get方式 
          httpConnection.setRequestMethod("POST"); 
          // 不使用缓存 
          httpConnection.setUseCaches(false); 
          // URLConnection.setInstanceFollowRedirects是成员函数，仅作用于当前函数 
          httpConnection.setInstanceFollowRedirects(true); 
          // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的 
          // 意思是正文是urlencoded编码过的form参数 
          httpConnection.setRequestProperty("Connection", "Keep-Alive");
          // 设置请求头信息
          httpConnection.setRequestProperty("Charset", "UTF-8");
          // 设置边界
          String BOUNDARY = "----------" + System.currentTimeMillis();
          httpConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
          //httpConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 

          // 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成， 
          // 要注意的是connection.getOutputStream会隐含的进行connect。 
          // 实际上只是建立了一个与服务器的tcp连接，并没有实际发送http请求。 

          httpConnection.connect(); 
          out = new OutputStreamWriter(httpConnection.getOutputStream(),"UTF-8"); 

          // 正文，正文内容其实跟get的URL中'?'后的参数字符串一致 

          /*JSONObject jsonObject=new JSONObject(); 
          try{
              jsonObject.put("username", username); 
              jsonObject.put("password", password); 
              jsonObject.put("captcha", captcha); 
          }catch(Exception e){
              e.printStackTrace();
          }*/
          Map parames = new HashMap<String, String>();  
            parames.put("username", username);  
            parames.put("password",password);  
            parames.put("access_token", "captcha");  
            parames.put("method", "POST");
          
          // 构建请求参数  
//            StringBuffer sb = new StringBuffer();  
//            sb.append("username="+username+"&password="+password);
          //写入参数,DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写道流里面 
          out.write(GsonUtil.toJson(parames)); 
          System.out.println("send_url:" + url);  
          System.out.println("send_data:" + GsonUtil.toJson(parames));  
          // flush and close 
          out.flush(); 

        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
             try { 
                if (null != out) { 
                  out.close(); 
                } 
                if (null != reader) { 
                  reader.close(); 
                } 
                if (null != httpConnection) { 
                  httpConnection.disconnect(); 
                } 
              } catch (Exception e2) { 
                  e2.printStackTrace();
              }
        }  

        try {
          reader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream(),"UTF-8")); 
          while ((responseMessage = reader.readLine()) != null) { 
              response.append(responseMessage); 
              response.append("\n"); 
          } 

          if (!"failure".equals(response.toString())) { 
              System.out.println("success");
          } else { 
              System.out.println("failue");
          } 
          // 将该url的配置信息缓存起来 
          System.out.println(response.toString()); 
          System.out.println(httpConnection.getResponseCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) throws IOException {
//		String loginUrl = "http://61.148.30.210:33892/api/authorization";
//		Map<String,String> obj = new HashMap<>();
//		obj.put("username", "450501196211030619@lzpolice.com");
//		obj.put("password", "000000");
//		obj.put("access_token", "db69fc039dcbd2962cb4d28f5891aae1");
//		obj.put("method", "POST");
//		String string = HttpPost.addJson(loginUrl,GsonUtil.toJson(obj),"utf-8");
		connectionUrl("11", "11");
	}


}
