package core.db;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoConnector {

	private static final String DB_NAME = "mir";
	
	public static DBCollection connect(String collName)
	{
		MongoClient client = new MongoClient("localhost", 27017);
		DB db = client.getDB(DB_NAME);
		return  db.getCollection(collName);
	}
	
	
}
