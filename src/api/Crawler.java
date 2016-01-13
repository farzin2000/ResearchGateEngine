package api;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Crawler {

	private static final int MAX_PAGE_TO_SEARCH = 5;
	private List<String> pageToVisit;
	private HashSet<String> visitedPages;
	
	public Crawler()
	{
		pageToVisit = new LinkedList<>();
		visitedPages = new HashSet<>();
	}
	
	
}
