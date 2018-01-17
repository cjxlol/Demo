package file.test;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.nutz.dao.Dao;
import org.nutz.ioc.ObjectFactory;
import org.nutz.lang.Files;
import org.nutz.resource.NutResource;
import org.nutz.resource.Scans;

import com.cjx.filecleaner.entity.FileEntity;
import com.cjx.filecleaner.util.FileUtil;

public class FileTest {
	
	Dao dao;
	String homedir;
	
	@Before
	public void setUp() throws IOException {
		ObjectFactory.create("config/");
		dao = ObjectFactory.getObject(Dao.class);
		homedir=FileUtil.getValue("app.homedir");
	}
	
	@Test
	public void test2() throws Exception{
		System.out.println(homedir);
		Random random = new Random(); 
		byte[] nbyte = new byte[5];
		random.nextBytes(nbyte);
		for (byte b : nbyte) {
			System.out.println(b);
		}
	}
	
	@Test
	public void test3() throws Exception{
		List<FileEntity> files = new ArrayList<FileEntity>();
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 10; j++) {
				String path = homedir + "/" + i+"/"+j;
				FileUtil.creatFiledir(new File(path));
				for (int k = 0; k < 10; k++) {
					String filePath = path + "/" + k + ".txt";
					System.out.println(filePath);
					FileUtil.RandomFile(new File(filePath), 200);
					
					String id = UUID.randomUUID().toString();
					id = id.replace("-", "");
					files.add(new FileEntity(id, filePath, new File(filePath).length(), new Date(), "0"));
					//FileDao.addFile(filePath, 200);
				}
				
			}
		}
		dao.create(FileEntity.class, true);
		dao.fastInsert(files);
	}
	
	@Test
	public void test4() throws Exception{
		File file=new File("C:/filetest/9/0/1.txt");
		file.delete();
	}
	
	@Test
	public void file_test(){
		File oldFile=new File("C:/testpath/old/old.png");
		File newFile=new File("C:/testpath/new.jpg");
		try {
			System.out.println(com.cjx.filecleaner.util.Files.copyFile(oldFile, newFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
