var service = {
		
	 querier: {
		 type: 'com.geor.filecleaner.service.impl.QuerierImpl',
		 singleton: false,
		 fields: {
			 queue: {refer: 'queue'},
			 dao: {refer: 'dao'}
		 }
	 },
	
	 cleaner: {
		 type: 'com.geor.filecleaner.service.impl.CleanerImpl',
		 singleton: false,
		 fields: {
			 queue: {refer: 'queue'},
			 dao: {refer: 'dao'}
		 }
	 }

}