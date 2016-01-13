package core.db;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


public abstract class BaseDAO<Pojo> {

	private MongoOperations mongoOperations = getMongoInstance();

	protected BaseDAO(){

	}

	protected synchronized MongoOperations getMongoInstance(){
		if(mongoOperations == null){
			ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
			mongoOperations = (MongoOperations)ctx.getBean(MongoTemplate.class);
		}
		return mongoOperations;
	}
	
	public void save(Pojo pojo) {
		this.getMongoInstance().insert(pojo);
	}
	
	public void save(List<Pojo> pojoList){
		this.getMongoInstance().insertAll(pojoList);
	}
	
	public void remove(Pojo pojo) {
		this.mongoOperations.remove(pojo);
	}
	
	public void saveOrUpdate(Pojo pojo){
		this.getMongoInstance().save(pojo);
	}
	
	public Pojo get(String id) {
		return this.getMongoInstance().findById(id , getRefferenceClass());
	}
	
	public List<Pojo> getBySingleField(String fieldName , Object fieldValue){
		Query query = createQuery();
		query.addCriteria(Criteria.where(fieldName).is(fieldValue));
		return this.getMongoInstance().find(query, getRefferenceClass());
	}
	
	public List<Pojo> getAll(){
		Query query = createQuery();
		return this.getMongoInstance().find(query, getRefferenceClass());
	}
	
	protected Query createQuery(){
		Query query = new Query();
	//	query.restrict(getRefferenceClass());
		return query;
	}
	
	protected abstract Class<Pojo> getRefferenceClass();

}
