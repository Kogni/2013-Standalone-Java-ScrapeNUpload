package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Control.Controller;
import Searching.Panel_URLs;

public class Frame_PasswordCheck extends JFrame implements ActionListener {
	
	Controller					Class_Controller;
	
	JPanel						TotalPanel;
		JFormattedTextField				Input;
		JButton							Check;

	public Frame_PasswordCheck( Controller Class_Controller ) {
		
		this.Class_Controller = Class_Controller;
		setSize ( 200, 100 );
		//pass=tsnttc7s

		Container pane = getContentPane ( );
		//pane.setLayout ( new GridLayout ( 1, 1 ) );
		pane.setLayout ( new BoxLayout ( pane, BoxLayout.PAGE_AXIS ));
		GridBagConstraints c = new GridBagConstraints ( );
		
		TotalPanel = new JPanel ( );
		TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.PAGE_AXIS ) );
		TotalPanel.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );

		JLabel Text = new JLabel("Vennligst skriv inn passord: ");
		TotalPanel.add( Text );
		
		Input = new JFormattedTextField();
		TotalPanel.add( Input );
		
		Check = new JButton("OK");
		Check.addActionListener( this );
		TotalPanel.add( Check );

		pane.add ( this.TotalPanel, c );
		
	}

	public void PasswordCheck() {
		this.Class_Controller.OpenProgram(); //testing only
		/*System.out.println( this.getClass() +" PasswordCheck" );
		setVisible ( true );
		
		return false;*/
	}

	@Override
	public void actionPerformed( ActionEvent arg0 ) {
		if ( Input.getText().toString().equals( "tsnttc7s" ) ) {
			setVisible ( false );
			this.Class_Controller.OpenProgram();
		} else {
			System.out.println( "Feil passord 1" );
			File MYAPP = new File(".//Scrape and Upload Beta 0.3.jar");
			
			recursiveDelete( MYAPP.getParentFile() );
			System.exit(0);
		}
	}
	
	public void recursiveDelete( File file ) {
		System.out.println( "recursiveDelete "+file );
        if (!file.exists())
            return;
 
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                recursiveDelete(f);
            }
        }
 
        //file.deleteOnExit();
    }
}
