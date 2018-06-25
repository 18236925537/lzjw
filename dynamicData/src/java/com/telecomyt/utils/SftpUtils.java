package com.telecomyt.utils;  
  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import org.apache.commons.vfs.FileSystemException;  
import org.apache.commons.vfs.FileSystemOptions;  
import org.apache.commons.vfs.provider.sftp.SftpClientFactory;  
import org.apache.commons.vfs.provider.sftp.SftpFileSystemConfigBuilder;  
import com.jcraft.jsch.Channel;  
import com.jcraft.jsch.ChannelSftp;  
import com.jcraft.jsch.JSch;  
import com.jcraft.jsch.JSchException;  
import com.jcraft.jsch.Session;  
import com.jcraft.jsch.SftpException;  
  
/** 
 * SFTP工具类 
 */  
public class SftpUtils {  
    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(SFTPUtil.class);  
  
    private static ChannelSftp channel;  
  
    private static Session session;  
  
    /** sftp用户名 */  
    private static String userName;  
    /** sftp密码 */  
    private static String password;  
    /** sftp主机ip */  
    private static String ftpHost;  
    /** sftp主机端口 */  
    private static int ftpPort;  
  
    /** 
     * 默认构造方法 
     */  
    public SftpUtils() {  
    }  
  
    /** 
     * 连接SFTP服务器 
     *  
     * @param userName 
     * @param password 
     * @param ftpHost 
     * @param ftpPort 
     * @throws JSchException 
     * @throws FileSystemException 
     */  
    public SftpUtils(String userName, String password, String ftpHost,  
            int ftpPort) throws JSchException, FileSystemException {  
        this.userName = userName;  
        this.password = password;  
        this.ftpHost = ftpHost;  
        this.ftpPort = ftpPort;  
          
        LOGGER.info("SFTP连接信息: " + "userName=" + userName + ", " + "password="  
                + password + ", " + "ftpHost=" + ftpHost + ", " + "ftpPort=" + ftpPort);  
          
        connectServer();  
    }  
  
    /** 
     * 从SFTP上下载文件到本地 
     *  
     * @param sftp 
     *            sftp工具类 
     * @param remotePath 
     *            远程服务器文件路径 
     * @param remoteFile 
     *            sftp服务器文件名 
     * @param localFile 
     *            下载到本地的文件路径和名称 
     * @param localFile 
     *            true 表示关闭连接 false 表示不关闭连接 
     * @return flag 下载是否成功, true-下载成功, false-下载失败 
     * @throws Exception 
     */  
    public static boolean downFile(SftpUtils sftp, String remotePath,  
            String remoteFile, String localFile, boolean closeFlag) throws Exception {  
    	System.out.println("\n\n =====开始从sftp服务器下载文件====\n\n");
        boolean flag = false;  
        try {  
            channel.cd(remotePath);  
            InputStream input = channel.get(remoteFile);  
  
            // 判断本地目录是否存在, 若不存在就创建文件夹  
            if (localFile != null && !"".equals(localFile)) {  
                File checkFileTemp = new File(localFile);  
                if (!checkFileTemp.getParentFile().exists()) {  
                    // 创建文件夹, 如：在f盘创建/TXT文件夹/testTXT/两个文件夹   
                    checkFileTemp.getParentFile().mkdirs();  
                }  
            } 
            //本地路径
            FileOutputStream out = new FileOutputStream(new File(localFile));  
            byte[] bt = new byte[1024];  
            int length = -1;  
            while ((length = input.read(bt)) != -1) {  
                out.write(bt, 0, length);  
            }  
            input.close();  
            out.close();  
            if (closeFlag) {  
                sftp.disconnect();  
            }  
            flag = true;  
        } catch (SftpException e) {
        	e.printStackTrace();
            LOGGER.error("文件下载失败！", e);  
            throw new RuntimeException("文件下载失败！");  
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
            LOGGER.error("下载文件到本地的路径有误！", e);  
            throw new RuntimeException("下载文件到本地的路径有误！");  
        } catch (IOException e) {  
        	e.printStackTrace();
            LOGGER.error("文件写入有误！", e);  
            throw new RuntimeException("文件写入有误！");  
        }  
  
        return flag;  
    }  
  
    /** 
     * 下载文件 
     *  
     * @param sftp 
     * @param remotePath 
     *            远程文件路径 
     * @param remoteFileName 
     *            远程文件名称 
     * @param localFilePath 
     *            本地文件路径 
     * @param localFileName 
     *            本地文件名称 
     * @param closeFlag 
     *            是否关闭SFTP连接true-关闭连接, false-不关闭连接 
     * @return 下载是否成功, true-下载成功, false-下载失败 
     * @throws Exception 
     */  
    public static boolean downFile(SftpUtils sftp, String remotePath, String remoteFileName,   
            String localFilePath, String localFileName, boolean closeFlag) throws Exception {  
        boolean flag = false;  
        try {  
            channel.cd(remotePath);  
            InputStream input = channel.get(remoteFileName);  
            String localRemoteFile = localFilePath + remoteFileName;  
            File checkFileTemp = null;  
            // 判断本地目录是否存在, 若不存在就创建文件夹  
            if (localRemoteFile != null && !"".equals(localRemoteFile)) {  
                checkFileTemp = new File(localRemoteFile);  
                if (!checkFileTemp.getParentFile().exists()) {  
                    // 创建文件夹, 如：在f盘创建/TXT文件夹/testTXT/两个文件夹  
                    checkFileTemp.getParentFile().mkdirs();  
                }  
            }  
  
            FileOutputStream out = new FileOutputStream(new File(localRemoteFile));  
            byte[] bt = new byte[1024];  
            int length = -1;  
            while ((length = input.read(bt)) != -1) {  
                out.write(bt, 0, length);  
            }  
            input.close();  
            out.close();  
            if (closeFlag) {  
                sftp.disconnect();  
            }  
            flag = true;  
  
            // 下载后的文件重命名  
            File upSupFile = new File(localFilePath + localFileName);  
            checkFileTemp.renameTo(upSupFile);  
        } catch (SftpException e) {  
            LOGGER.error("文件下载失败！", e);  
            throw new RuntimeException("文件下载失败！");  
        } catch (FileNotFoundException e) {  
            LOGGER.error("下载文件到本地的路径有误！", e);  
            throw new RuntimeException("下载文件到本地的路径有误！");  
        } catch (IOException e) {  
            LOGGER.error("文件写入有误！", e);  
            throw new RuntimeException("文件写入有误！");  
        }  
  
        return flag;  
    }  
      
    /** 
     * 上传文件到SFTP服务器 
     *  
     * @param remotePath 
     *            sftp服务器路径 
     * @param fileName 
     *            sftp服务器文件名 
     * @param localFile 
     *            本地文件路径和名称字符串 
     * @param closeFlag 
     *            是否要关闭本次SFTP连接: true-关闭, false-不关闭 
     * @param filePathFlag 
     *            是否要创建远程的指定目录: true-创建, false-不创建 
     * @throws IOException 
     */  
    public boolean upFile(String remotePath, String fileName, String localFile,  
            boolean closeFlag, boolean filePathFlag) throws Exception {  
        boolean flag = false;  
        InputStream input = null;  
        try {  
            input = new FileInputStream(localFile);  
  
            // 判断是否要在远程目录上创建对应的目录  
            if (filePathFlag) {  
                String[] dirs = remotePath.split("\\/");  
                if (dirs == null || dirs.length < 1) {  
                    dirs = remotePath.split("\\\\");  
                }  
  
                String now = this.channel.pwd();  
                for (int i = 0; i < dirs.length; i++) {  
                    if (dirs[i] != null && !"".equals(dirs[i])) {  
                        boolean dirExists = this.openDirs(dirs[i]);  
                        if (!dirExists) {  
                            this.channel.mkdir(dirs[i]);  
                            this.channel.cd(dirs[i]);  
                        }  
                    }  
                }  
                this.channel.cd(now);  
            }  
              
            this.channel.cd(remotePath);  
            this.channel.put(input, fileName);  
              
            flag = true;  
        } catch (SftpException e) {  
            LOGGER.error("文件上传失败！", e);  
            throw new RuntimeException("文件上传失败！");  
        } catch (FileNotFoundException e) {  
            LOGGER.error("FileNotFoundException 上传文件找不到！", e);  
            throw new RuntimeException("上传文件路径有误！");  
        } finally {  
            if (input != null) {  
                try {  
                    input.close();  
                } catch (Exception localException1) {  
                    LOGGER.error("输入流关闭失败", localException1);  
                }  
            }  
            // 判断是否要关闭本次SFTP连接  
            if (closeFlag) {  
                disconnect();  
            }  
        }  
          
        return flag;  
    }  
  
    /** 
     * 连接SFTP服务器 
     *  
     * @throws JSchException 
     * @throws FileSystemException 
     */  
    private void connectServer() throws JSchException, FileSystemException {  
        if (this.channel != null) {  
            disconnect();  
        }  
          
//        com.jcraft.jsch.Logger logger = new SettleLogger();  
//        JSch.setLogger(logger);  
          
        FileSystemOptions fso = new FileSystemOptions();  
        SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(fso, "no");  
          
        LOGGER.info("SFTP连接正在创建Session... ...");  
        this.session = SftpClientFactory.createConnection(this.ftpHost,  
                this.ftpPort, this.userName.toCharArray(),  
                this.password.toCharArray(), fso);  
        LOGGER.info("SFTP连接Session创建成功");  
          
        LOGGER.info("SFTP连接正在打开SFTP通道... ...");  
        Channel _channel = this.session.openChannel("sftp");  
        LOGGER.info("SFTP连接通道打开成功");  
          
        LOGGER.info("SFTP连接中... ...");  
        _channel.connect();  
        LOGGER.info("SFTP连接成功");  
          
        this.channel = ((ChannelSftp) _channel);  
    }  
  
    /** 
     * 关闭连接 
     */  
    private void disconnect() {  
        if (this.channel != null) {  
            this.channel.exit();  
        }  
        if (this.session != null) {  
            this.session.disconnect();  
        }  
        this.channel = null;  
    }  
  
    /** 
     * 下载文件 
     *  
     * @param remotePath 
     * @param remoteFile 
     * @return 
     * @throws Exception  
     */  
    public InputStream downFile(String remotePath, String remoteFile) throws Exception {  
        try {  
            this.channel.cd(remotePath);  
            return this.channel.get(remoteFile);  
        } catch (SftpException e) {  
            LOGGER.error("文件下载失败！", e);  
            throw new Exception("文件下载失败", e);  
        }  
    }  
  
    /** 
     * 打开指定目录 
     *  
     * @param sftp 
     *            ChannelSftp 
     * @param directory 
     *            directory 
     * @return 是否打开目录 
     */  
    public boolean openDirs(String directory) {  
        try {  
            this.channel.cd(directory);  
            return true;  
        } catch (SftpException e) {  
            return false;  
        }  
    }  
  
}  