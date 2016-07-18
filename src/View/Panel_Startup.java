package View;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import Control.Controller;

public class Panel_Startup extends JPanel {
	
	Controller Class_Controller;
	
	JToolBar MenuBar;
		JButton  StartSearch;
		JButton  StopSearch;

	public Panel_Startup( Controller Class_Controller ) {
		this.Class_Controller = Class_Controller;
		
		MenuBar = new JToolBar();
		this.add(MenuBar);
		
		StartSearch = new JButton ( "Start search" );
		StartSearch.getAccessibleContext().setAccessibleDescription( "Starts searching");
		StartSearch.setEnabled( false );
		MenuBar.add(StartSearch);
		
		StopSearch = new JButton ( "Stop search" );
		StopSearch.getAccessibleContext().setAccessibleDescription( "Stops searching.");
		StopSearch.setEnabled( false );
		MenuBar.add(StopSearch);
	}

	public void Startup() {
		// TODO Auto-generated method stub

	}

}
