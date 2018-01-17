package com.cjx.filecleaner.main;

import org.nutz.ioc.ObjectFactory;

import com.cjx.filecleaner.service.Cleaner;
import com.cjx.filecleaner.service.Querier;
import com.cjx.filecleaner.util.FileUtil;

public class AppMain {
	
	int threads=Integer.parseInt(FileUtil.getValue("app.threads"));
    
	public static void main(String[] args) {
		ObjectFactory.create("config/");
		ObjectFactory.getObject(AppMain.class).launch();
	}
	
	public void launch() {
		
		Querier querier = ObjectFactory.getObject(Querier.class);
        new Thread(querier).start();
        for(int i=0;i<threads;i++){
        	new Thread(ObjectFactory.getObject(Cleaner.class)).start();
        }
	}
}
