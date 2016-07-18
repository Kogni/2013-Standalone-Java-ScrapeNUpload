package Searching;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import URLs.Object_URL;

import Control.Controller;

public class Brain_Searching {
	
	Controller Class_Controller;
	
	ConcurrentHashMap AllPages_hashmap = new ConcurrentHashMap();
	
	public Brain_Searching( Controller Class_Controller ) {
		this.Class_Controller = Class_Controller;
	}
	
	public void RunThreads() {
		
	}
	
	private Object_URL SearchHashmapForURL( Object_URL newpage ) {
		return (Object_URL) AllPages_hashmap.get( newpage.Get_Adresse().toString() );
	}
	
	private void SaveURLToHashmap( Object_URL NewPage ) {
		AllPages_hashmap.put( NewPage.Get_Adresse().toString(), NewPage );
	}
	
	public void UpdateURLGUI_Hashmap() {
		
	    for ( Iterator<String> keys = AllPages_hashmap.keySet().iterator(); keys.hasNext();) {
	    	String key = keys.next();
	    	Object_URL HentetSide = ((Object_URL) AllPages_hashmap.get(key));
	    	

	    }
	}

}
