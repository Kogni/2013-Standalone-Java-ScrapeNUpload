package Dropshippers;

import Control.Controller;

public class Brain_Dropshippers {

	Controller Class_Controller;
	
	Object_Dropshipper SelectedDropshipper;
	
	public Brain_Dropshippers( Controller Class_Controller ) {
		this.Class_Controller = Class_Controller;
		
	}
	
	public void Startup( ) {
		this.SelectedDropshipper = SelectedDropshipper;
	}

	public Object_Dropshipper Get_SelectedDropshipper() {
		return SelectedDropshipper;
	}

}
