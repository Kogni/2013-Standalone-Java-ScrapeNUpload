package View;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Control.Controller;
import Dropshippers.Panel_Dropshippers;

public class Frame_MainWindow extends JFrame {
	
	Controller Class_Controller;

	JPanel						TotalPanel;
	JTabbedPane		TabHolder;
		Panel_Startup			Tab_Panel_Startup;
		Panel_Dropshippers		Tab_Panel_Dropshippers;
		
		public Frame_MainWindow( Controller Class_Controller ) {
			this.Class_Controller = Class_Controller;
		}
		
		public void Startup() {
			
			setSize ( 1000, 600 );
			
			TotalPanel = new JPanel ( );
			TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.PAGE_AXIS ) );
			TotalPanel.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );
			
			TabHolder = new JTabbedPane();
			TotalPanel.add( TabHolder );
			
			Tab_Panel_Startup = new Panel_Startup( Class_Controller );
			Tab_Panel_Startup.Startup();
			TabHolder.add( "Tasks", Tab_Panel_Startup );
			
			Tab_Panel_Dropshippers = new Panel_Dropshippers( Class_Controller );
			Tab_Panel_Dropshippers.Startup();
			TabHolder.add( "Tasks", Tab_Panel_Dropshippers );
			
			this.setVisible(true);
		}
}
