/** 
 *  项目名称:data 
 * 文件名称:ILiuZhouDao.java 
 * 包名:com.telecomyt.dao 
 * 创建日期:2018年5月7日下午4:01:15 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.telecomyt.entity.Data;
import com.telecomyt.entity.Law;
import com.telecomyt.entity.NewInfo;
import com.telecomyt.entity.NewList;
import com.telecomyt.entity.News;
import com.telecomyt.entity.SecondTitle;
import com.telecomyt.entity.ThirdTitle;
import com.telecomyt.entity.User;
import com.telecomyt.template.PersonInfoData;

/** 
 *  项目名称：data    
 * 类名称：ILiuZhouDao    
 * 类描述：    
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月7日 下午4:01:15    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月7日 下午4:01:15    
 * 修改备注：       
 * @version      
 */
public interface ILiuZhouDao {

	/**getUserList(获取用户集合)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月7日 下午4:02:19    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月7日 下午4:02:19    
	 * 修改备注： 
	 * @return     
	 */
	public List<User> getUserList();

	/**  update(更改用户信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月7日 下午9:39:18    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月7日 下午9:39:18    
	 * 修改备注： 
	 * @param user     
	 */
	public void update(User user);

	/**getSendTitle(获取二级标题信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月13日 下午3:37:30    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月13日 下午3:37:30    
	 * 修改备注： 
	 * @return     
	 */
	public List<SecondTitle> getSendTitle();

	/**getThirdTitle(获取三级标题信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月13日 下午3:56:32    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月13日 下午3:56:32    
	 * 修改备注： 
	 * @param secondName
	 * @return     
	 */
	public List<ThirdTitle> getThirdTitle(@Param("secondName")String secondName);

	/**getNewList(查询新闻列表分页信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月13日 下午4:51:31    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月13日 下午4:51:31    
	 * 修改备注： 
	 * @param name
	 * @param pageCount
	 * @param lastNewId
	 * @return     
	 */
	public List<Data> getNewList(@Param("name")String name,@Param("pageCount")int pageCount,@Param("startIndex")int startIndex);

	/**getNewInfo(查询新闻详情)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月13日 下午8:02:24    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月13日 下午8:02:24    
	 * 修改备注： 
	 * @param newId
	 * @return     
	 */
	public NewInfo getNewInfo(@Param("newId")String newId);

	/**getLawFirstTitle(获取法律一级目录)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月16日 下午7:28:03    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月16日 下午7:28:03    
	 * 修改备注： 
	 * @return     
	 */
	public List<Law> getLawFirstTitle(@Param("key")String key);

	/**getSecondTitle(获取法律的二级标题信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月16日 下午7:35:41    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月16日 下午7:35:41    
	 * 修改备注： 
	 * @param titleName
	 * @return     
	 */
	public List<Law> getLawSecondTitle(@Param("titleName")String titleName);

	/**getLawInfo(获取法律详情)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月16日 下午7:47:08    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月16日 下午7:47:08    
	 * 修改备注： 
	 * @param titleName
	 * @return     
	 */
	public Law getLawInfo(@Param("titleName")String titleName);

	/**findAllMember(查询所有的用户)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月16日 下午11:58:41    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月16日 下午11:58:41    
	 * 修改备注： 
	 * @return     
	 */
	public List<Integer> findAllMember();

	/**addFollow(添加关注)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月16日 下午11:59:22    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月16日 下午11:59:22    
	 * 修改备注： 
	 * @param follow
	 * @param followWho
	 * @param i     
	 */
	public void addFollow(@Param("follow")int follow,@Param("followWho")int followWho,@Param("time")int i);

	/**getSyncNewList(获取需要同步的新闻记录信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月17日 下午9:48:00    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月17日 下午9:48:00    
	 * 修改备注： 
	 * @return     
	 */
	public List<News> getSyncNewList();

	/**addSyncFileRecord(添加新闻同步记录)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月17日 下午9:48:30    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月17日 下午9:48:30    
	 * 修改备注： 
	 * @param id     
	 * @param i 
	 */
	public void addSyncFileRecord(@Param("id")int id,@Param("i")int i);

	/**getNewListCount(这里用一句话描述这个方法的作用)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月24日 下午10:45:27    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月24日 下午10:45:27    
	 * 修改备注： 
	 * @param name
	 * @return     
	 */
	public int getNewListCount(@Param("name")String name);

	/**  addNew(这里用一句话描述这个方法的作用)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月25日 下午9:36:54    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月25日 下午9:36:54    
	 * 修改备注： 
	 * @param news     
	 */
	public void addNew(News news);

	/**getLagestNewId(这里用一句话描述这个方法的作用)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月25日 下午9:45:15    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月25日 下午9:45:15    
	 * 修改备注： 
	 * @return     
	 */
	public String getLagestNewId();

	/**syncNewData(获取最新的新闻信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月25日 下午9:51:29    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月25日 下午9:51:29    
	 * 修改备注： 
	 * @param newId
	 * @return     
	 */
	public List<News> syncNewData(@Param("newId")String newId);

	/**getAllNews(查询所有的新闻)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月26日 下午3:19:56    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月26日 下午3:19:56    
	 * 修改备注： 
	 * @return     
	 */
	public List<News> getAllNews();

	/**updateNew(更新新闻时间)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月26日 下午3:20:13    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月26日 下午3:20:13    
	 * 修改备注： 
	 * @param id
	 * @param listTime     
	 */
	public void updateNew(@Param("id")int id,@Param("listTime")String listTime);

	/**getAcenterMemberIds(获取要加入圈子的人员信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月27日 下午10:25:52    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月27日 下午10:25:52    
	 * 修改备注： 
	 * @return     
	 */
	public List<String> getAcenterMemberIds();

	/**queryPersonInfo(根据编码查询常住人口的详细信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月29日 下午2:49:06    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月29日 下午2:49:06    
	 * 修改备注： 
	 * @param whcd 文化程度
	 * @param mz 民族
	 * @param hyzk 婚姻状况
	 * @param hkszd 户口所在地
	 * @param jgssk 户籍省市县
	 * @return     
	 */
	public PersonInfoData queryPersonInfo(@Param("whcd")String whcd, 
			@Param("mz")String mz,@Param("hyzk")String hyzk,
			@Param("hkszd")String hkszd,@Param("jgssx")String jgssk);

	
}
