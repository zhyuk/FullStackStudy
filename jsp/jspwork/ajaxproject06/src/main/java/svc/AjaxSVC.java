package svc;

import org.json.simple.JSONArray;
import dao.AjaxDao;

public class AjaxSVC {
	AjaxDao dao = new AjaxDao();
	
	public JSONArray getStudent() {
		return dao.getStudent();
	}
}
