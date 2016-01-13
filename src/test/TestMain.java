package test;

import model.Link;
import model.dao.LinkDAO;

public class TestMain {

	public static void main(String[] args) {
		
		Link l = new Link();
		l.setName("test.com");
		LinkDAO.getInstance().save(l);
	}
}
