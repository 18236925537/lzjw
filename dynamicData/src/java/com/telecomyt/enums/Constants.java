package com.telecomyt.enums;

import java.util.Properties;
import com.telecomyt.utils.PathUtil;
import com.telecomyt.utils.PropertiesUtil;

public class Constants {
	public static final Integer ADD_GROUP_SUCCESS_CODE = 1;
	public static final String ADD_GROUP_SUCCESS_MESSAGE = "添加组成功";
	
	public static final Integer ADD_GROUP_FAIL_CODE = 0;
	public static final String ADD_GROUP_FAIL_MESSAGE = "添加组失败";
	
	public static final String SERVICE_EXCEPTION_MESSAGE = "服务器出错";
	
	//系统设置配置文件操作相关
	public static final String PROPERTIES_PATH = PathUtil.getProjectPath(Constants.class, "lzjw", "/WEB-INF/classes/setting.properties");
	public static final Properties SETTING_PROPERTIES = PropertiesUtil.getProperties(Constants.PROPERTIES_PATH);
	
	//gzb工作宝 api相关
	public static final String GZB_REQUEST_URL = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"gzbUrl");
	public static final String GZB_APP_KEY = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"gzbAppKey");
	public static final String GZB_APP_IP = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"gzbIp");
	public static final String GZB_APP_PORT = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"gzbPort");
	public static final String GZB_APP_SECRET = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"gzbAppSecret");
	public static final String GZB_PUSH_PARAMETER_MSG_TYPE = "custom";
	public static final boolean GZB_PUSH_PARAMETER_TO_ALL = false;
	
	//服务器存储文件地址
	public static final String SERVER_IMAGE_PATH = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"server_image_path");
	public static final String SERVER_ATTACH_PATH = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"server_attach_path");
	
	//opensns服务器信息
	public static final String OPENSNS_SERVER_URL = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"opensns_server");
	public static final String OPENSNS_ACCESS_TOKEN = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"opensns_access_token");
	
	//数据同步
	public static final String SECOND_SERVER_ID = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"second_server_id");
	public static final String THIRD_SERVER_ID = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"third_server_id");
	public static final String APP_ID = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"app_id");
	public static final String APP_KEY = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"app_key");
	public static final String EXCHANGE_DATA_SERVER_URL = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"exchange_data_server_url");
	public static final String EXCHANGE_FILE_SERVER_URL = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"exchange_file_server_url");
	public static final String STAFF_CODE = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"staffCode");
	public static final String DEVICE_ID = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"devId");
	public static final String UID = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"uid");
	public static final String FTP_USER = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"sftpUser");
	public static final String SYNC_NEW_FIELD = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"sync_new_field");
	public static final String SYNC_FILE_FIELD = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"sync_file_field");
	public static final String CZRK_SERVER_URL = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"czrk_server_url");
	//同步新闻的启动文件路径
	public static final String SPRIDER_QIDON＿BAT_LOCATION = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"spider_news_bat_url");
	
	//app数据
	public static final String SERVER_REGION_URL = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"server_region_url");
	public static final String CAR_SERVER_URL = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"car_server_url");
	public static final String CHECK_IMAGE_URL = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"check_image_server_url");
	
	//静态页面html地址
	public static final String NEWS_HTML_URL = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"newsHtmlUrl");
	public static final String CROWD_HTML_URL = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"crowdHtmlUrl");
	public static final String LAW_HTML_URL = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"lawHtmlUrl");
	public static final String NOTICE_DYNAMIC_HTML_URL = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"noticeDynamicHtmlUrl");
	public static final String NOTICE_USER_HTML_URL = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"noticeUserHtmlUrl");
	public static final String CIRCLE_FAVORITE_HTML_URL = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"circleFavoriteHtmlUrl");
	public static final String CIRCLE_HOT_HTML_URL = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"circleHotHtmlUrl");
	public static final String CIRCLE_BASE_HTML_URL = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"circleBaseHtmlUrl");
	public static final String NOTICE_SYSTEM_HTML_URL = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"noticeSystemHtmlUrl");
	public static final String CHART_HTML_URL = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES,"chartHtmlUrls");
	
}
