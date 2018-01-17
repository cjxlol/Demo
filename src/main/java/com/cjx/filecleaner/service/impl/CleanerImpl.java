package com.cjx.filecleaner.service.impl;

import java.io.File;
import java.util.concurrent.BlockingQueue;

import org.nutz.dao.Dao;
import org.nutz.log.Loggers;
import org.slf4j.Logger;

import com.cjx.filecleaner.entity.FileEntity;
import com.cjx.filecleaner.service.Cleaner;
/**
 * 文件清理器
 */
public class CleanerImpl implements Cleaner {

	Logger log=Loggers.get();
	BlockingQueue<FileEntity> queue;
	Dao dao;

	public void run() {
		while (true) {
			try {
				FileEntity file = queue.take();
				if(file.getId().equals("end")){
					queue.offer(file);
					log.info(String.format("清理线程[%s]已结束!", Thread.currentThread().getName()));
					break;
				}
				File src = new File(file.getPath());
				log.info(String.format("[%s]准备删数据!%s", Thread.currentThread().getName(),file));
				src.delete();
				file.setStatus("1");
				dao.update(file);
				log.info(String.format("[%s]已经删除数据，队列目前有[%s]条数据", Thread.currentThread().getName(),queue.size()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
