var loader = {
		
	appMain: {
		type: 'com.geor.filecleaner.main.AppMain'
//		fields: {
//			querier: {refer: 'querier'},
//			cleaner: {refer: 'cleaner'}
//		}
	},

	queue:{
		 type: 'java.util.concurrent.ArrayBlockingQueue',
		 singleton: true,
		 args: [500]
	}	
}