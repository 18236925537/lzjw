package com.telecomyt.task;

import java.util.List;
import java.util.concurrent.RecursiveAction;

import com.telecomyt.dao.ILiuZhouDao;

/** 
* @author zpb
* @date 2018年3月9日 上午10:58:17 
* 类说明 
*/
public class AddFollowTask extends RecursiveAction{
	
	//执行的对象
	private static final int MAX = 1000;
	
	private List<Integer>list;
	private Integer id;
	
	//构造方法注入personDao
	private ILiuZhouDao liuZhouDao;
	
	public AddFollowTask(List<Integer>list,ILiuZhouDao liuZhouDao,Integer id){
		this.list = list;
		this.liuZhouDao = liuZhouDao;
		this.id = id;
	}
	
	@Override
	protected void compute() {
		int num = list.size();
		if(num > MAX){
			//超过MAX就分割任务
			List<Integer>list1 = list.subList(0, num / 2);
			List<Integer>list2 = list.subList(num / 2 + 1, num);
			AddFollowTask task1 = new AddFollowTask(list1,liuZhouDao,id);
			AddFollowTask task2 = new AddFollowTask(list2,liuZhouDao,id);
			//分别执行这两个任务
			task1.fork();
			task2.fork();
		}else{
			for (Integer integer : list) {
				addFollow(integer,id);
			}
		}
	}
	
	public void addFollow(Integer followWho,Integer follow){
		liuZhouDao.addFollow(follow, followWho,1526115218);
	}
	
}
