package com.telecomyt.service;

import java.util.List;

import com.telecomyt.entity.News;

/** 
* @author zpb
* @date 2018年3月13日 下午3:08:52 
* 类说明   处理数据的逻辑层
*/
public interface IDataService {
	
	/**  initLiuZhouData(初始化柳州数据)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月7日 下午3:46:14    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月7日 下午3:46:14    
	 * 修改备注： 
	 * @return     
	 */
	public String initLiuZhouData();

	/**getNewsList(获取新闻列表)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月13日 上午11:29:46    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月13日 上午11:29:46    
	 * 修改备注： 
	 * @param name 标题名称
	 * @param pageNum 页码
	 * @param pageCount 每页大小
	 * @param lastNewId 上次查询新闻id
	 * @return     
	 */
	public String getNewsList(String name, int pageCount, int pageNum, int lastNewId);

	/**getSecondTitle(获取二级)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月13日 下午3:28:05    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月13日 下午3:28:05    
	 * 修改备注： 
	 * @return     
	 */
	public String getSecondTitle();

	/**getThirdTitle(获取三级标题)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月13日 下午3:55:28    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月13日 下午3:55:28    
	 * 修改备注： 
	 * @param secondName
	 * @return     
	 */
	public String getThirdTitle(String secondName);

	/**getNewInfo(获取新闻详情)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月13日 下午6:10:21    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月13日 下午6:10:21    
	 * 修改备注： 
	 * @param newId
	 * @return     
	 */
	public String getNewInfo(String newId);

	/**syncFileData(定时抓取同步文件)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月16日 下午5:32:37    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月16日 下午5:32:37    
	 * 修改备注：      
	 * @return 
	 */
	public String syncFileData();
	
	/**syncFileData(定时抓取同步文件)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月16日 下午5:32:37    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月16日 下午5:32:37    
	 * 修改备注：      
	 * @return 
	 */
	public String syncNewFileData();

	/**getLawFirstTitle(获取法律法规一级目录)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月16日 下午7:09:29    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月16日 下午7:09:29    
	 * 修改备注： 
	 * @param key 
	 * @return     
	 */
	public String getLawFirstTitle(String key);

	/**getSecondTitle(根据法律一级标题获取二级标题)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月16日 下午7:34:51    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月16日 下午7:34:51    
	 * 修改备注： 
	 * @param titleName
	 * @return     
	 */
	public String getSecondTitle(String titleName);

	/**getLawInfo(getLawInfo)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月16日 下午7:46:12    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月16日 下午7:46:12    
	 * 修改备注： 
	 * @param titleName
	 * @return     
	 */
	public String getLawInfo(String titleName);

	/**  addFollow(这里用一句话描述这个方法的作用)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月16日 下午11:51:27    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月16日 下午11:51:27    
	 * 修改备注： 
	 * @return     
	 */
	public String addFollow();
	
	/**
	 * saveSyncRecord(保存同步记录)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月25日 下午1:36:48    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月25日 下午1:36:48    
	 * 修改备注： 
	 * @param newId
	 * @param isSuccess
	 * @return
	 */
	String saveSyncRecord(String newId,int isSuccess);

	/**addNew(添加新闻)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月25日 下午9:34:50    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月25日 下午9:34:50    
	 * 修改备注： 
	 * @param data     
	 */
	public void addNew(List<News> data);

	/**getLagestNewId(获取最大的新闻id)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月25日 下午9:44:19    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月25日 下午9:44:19    
	 * 修改备注： 
	 * @return     
	 */
	public String getLagestNewId();

	/**syncNewData(获取最新的新闻信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月25日 下午9:49:09    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月25日 下午9:49:09    
	 * 修改备注： 
	 * @param newId
	 * @return     
	 */
	public String syncNewData(String newId);

	/**correctTitleTime(格式化标题时间)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月26日 下午3:05:53    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月26日 下午3:05:53    
	 * 修改备注： 
	 * @return     
	 */
	public String correctTitleTime();

	/**joinCrowd(这里用一句话描述这个方法的作用)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月27日 下午10:22:10    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月27日 下午10:22:10    
	 * 修改备注： 
	 * @return     
	 */
	public String joinCrowd();

}
