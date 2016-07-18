package Control;

import javax.swing.JFrame;

import View.Frame_MainWindow;
import View.Frame_PasswordCheck;
import Dropshippers.Brain_Dropshippers;
import Dropshippers.Object_Dropshipper;

public class Controller {
	
	Brain_Dropshippers Class_Brain_Dropshippers;
	
	Frame_PasswordCheck Class_Frame_PasswordCheck;
	Frame_MainWindow Class_Frame_MainWindow;
	
	public Controller() {
		System.out.println( this.getClass().toString() );
		Class_Brain_Dropshippers = new Brain_Dropshippers( this );
		
		Class_Frame_PasswordCheck = new Frame_PasswordCheck( this );
		Class_Frame_MainWindow = new Frame_MainWindow( this );
		Class_Frame_MainWindow.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
		
		Startup();
	}
	
	public void Startup() {
		System.out.println( this.getClass().toString()+" Startup" );
		Class_Brain_Dropshippers.Startup(  );
		
		Class_Frame_PasswordCheck.PasswordCheck();
	}

	public String[] Get_Searchtypes() {
		// TODO Auto-generated method stub
		return null;
	}

	public void Set_Setting_SaveType(String string) {
		// TODO Auto-generated method stub
		
	}

	public void UpdateSettings_GUI() {
		// TODO Auto-generated method stub
		
	}

	public void Set_Setting_Searchtype(String string) {
		// TODO Auto-generated method stub
		
	}

	public void OpenProgram() {
		Class_Frame_MainWindow.Startup();
	}

	public Object_Dropshipper Get_SelectedDropshipper() {
		return Class_Brain_Dropshippers.Get_SelectedDropshipper();
	}

	public void AddProgressMessage(String string) {
		// TODO Auto-generated method stub
		
	}

}
