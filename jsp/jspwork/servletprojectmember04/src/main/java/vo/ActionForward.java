package vo;

public class ActionForward { // &500
	private boolean isRedirect=false; // true
	private String path=null; // -> ./memberLogin.me
	
	public boolean isRedirect(){
		return isRedirect;
	}
	
	public String getPath(){
		return path;
	}
	
	public void setRedirect(boolean b){ // true
		isRedirect=b;
	}
	
	public void setPath(String string){ // ./memberLogin.me
		path=string;
	}
}