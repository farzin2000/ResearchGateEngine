package core.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;

@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration{
	
	private static final String MONGO_DB_NAME = "mir";
	private static final String MONGO_DB_HOST = "localhost";
	private static final int MONGO_DB_PORT = 27017;
	
	@Override
	public String getDatabaseName() {
		return MONGO_DB_NAME;
	}
	
	@Override
	@Bean
	public MongoClient mongo() throws Exception {
		return new MongoClient(MONGO_DB_HOST , 
				MONGO_DB_PORT);
	}
}
