package com.cjx.filecleaner.service.impl;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.nutz.log.Loggers;
import org.slf4j.Logger;

import com.cjx.filecleaner.entity.FileEntity;
import com.cjx.filecleaner.service.Querier;
/**
 * 任务查询器
 */
public class QuerierImpl implements Querier{
	
	Logger log=Loggers.get();
	BlockingQueue<FileEntity> queue;
	Dao dao;
	
	public void run() {
		while(true){
    	   	try {
				Thread.sleep(1000);
				if(queue.size()==0){
        	   			Pager pager = dao.createPager(1, 500);
                		List<FileEntity> files = dao.query(FileEntity.class, Cnd.where("status", "=", "0").asc("createdate"), pager);
                		if(files.size()==0){
                			log.warn("没有新的任务了");
                			queue.offer(new FileEntity("end"));
                			Thread.sleep(1000);
                			log.info(String.format("查询线程[%s]已结束!", Thread.currentThread().getName()));
                			break;
                		}
                		for (int i = 0; i < files.size(); i++) {
                			if(queue.offer(files.get(i))){
//                				Thread.sleep(1);
                				log.info(String.format("[%s]已经放了数据，队列目前有[%s]条数据", Thread.currentThread().getName(),queue.size()));
                			}else{
                				log.warn("队列已满");
                			}
                		}
    	   		}
			} catch (Exception e) {
				e.printStackTrace();
			}
       }
	}

}
