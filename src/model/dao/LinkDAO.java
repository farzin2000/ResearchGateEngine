package model.dao;

import core.db.BaseDAO;
import model.Link;

public class LinkDAO extends BaseDAO<Link>{

	private static LinkDAO instance;
	
	private LinkDAO() {
		
	}
	
	public static LinkDAO getInstance()
	{
		if(instance == null)
		{
			instance = new LinkDAO();
			return instance;
		}
		else
			return instance;
	}
	
	@Override
	protected Class<Link> getRefferenceClass() {
		return Link.class;
	}
}
