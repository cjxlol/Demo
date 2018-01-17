var datasource = {
		
	dao: {
		type: 'org.nutz.dao.impl.NutDao',
		fields: {
			dataSource: {refer: 'defaultDs'}
		}
	},
	

	defaultDs : {
		type : "com.alibaba.druid.pool.DruidDataSource",
		events : {
			init : 'init',
			depose : "close"
		},
		fields : {
			driverClassName : {java : "$config-local.get('db.driver')"},
			url : {java : "$config-local.get('db.url')"},
			username : {java : "$config-local.get('db.user')"},
			password : {java : "$config-local.get('db.pwd')"},
			initialSize : 5,
			maxActive : 100,
			minIdle : 1,
			maxWait : 30000,
			timeBetweenEvictionRunsMillis : 60000,
			minEvictableIdleTimeMillis : 300000,
			testOnBorrow : false,
			testOnReturn : false,
			poolPreparedStatements : true,
			maxPoolPreparedStatementPerConnectionSize : 200
		}
	},
	config-local : {
		type : "org.nutz.ioc.impl.PropertiesProxy",
		fields : {
			paths: ["config/app.properties"]
		}
	}
	
	
}