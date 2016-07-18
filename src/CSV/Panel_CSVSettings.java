package CSV;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import Control.Controller;
import Itemtypes.Object_Itemtype;

public class Panel_CSVSettings extends JPanel implements ActionListener {

	Controller Class_Controller;
	
	JPanel						TotalPanel;
	
		JPanel						Panel_Collumn_SaveType;
			JComboBox					SaveTypes;
	
		JPanel						Panel_Collumn_DescriptionData;
			JPanel[]					Panel_Row_DescriptionData = new JPanel[11];
				JCheckBox[]					DescriptionData 			= new JCheckBox[10];
				
		JPanel						Panel_Collumn_MetaKeywords;
			JPanel[]					Panel_Row_MetaKeywordsData = new JPanel[11];
				JCheckBox[]					MetaKeywordData				= new JCheckBox[10];
				
		JPanel						Panel_Collumn_SKU;
			JPanel[]					Panel_Row_SKU = new JPanel[11];
				JCheckBox[]					SKUData				= new JCheckBox[10];
				
				
		JPanel						Panel_Collumn_UPC;
			JPanel[]					Panel_Row_UPC = new JPanel[11];
				JCheckBox[]					UPCData				= new JCheckBox[10];
				
				
		JPanel						Panel_Collumn_Location;
			JPanel[]					Panel_Row_Location = new JPanel[11];
				JCheckBox[]					LocationData				= new JCheckBox[10];
				
				
		JPanel						Panel_Collumn_Price;
			JPanel[]					Panel_Row_Price = new JPanel[11];
				JCheckBox[]					PriceData				= new JCheckBox[10];
				
				
		JPanel						Panel_Collumn_Quantity;
			JPanel[]					Panel_Row_Quantity = new JPanel[11];
				JCheckBox[]					QuantityData				= new JCheckBox[10];
				
		
			JTextField					ItemtypeTextfield;
	
	MouseListener mouseListener;

	public Panel_CSVSettings( Controller Class_Controller ) {
		
		this.Class_Controller = Class_Controller;
		
	}

	public void Startup() {
		setSize ( 1000, 660 );

		//pane.setLayout ( new GridLayout ( 1, 1 ) );
		this.setLayout ( new BoxLayout ( this, BoxLayout.PAGE_AXIS ));
		GridBagConstraints c = new GridBagConstraints ( );
		
		TotalPanel = new JPanel ( );
		TotalPanel.setLayout ( new BoxLayout ( this.TotalPanel, BoxLayout.LINE_AXIS ) );
		TotalPanel.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );
		
		//save type
		Panel_Collumn_SaveType = new JPanel ( );
		//Panel_Collumn_SaveType.setLayout ( new BoxLayout ( this.Panel_Collumn_SaveType, BoxLayout.LINE_AXIS ) );
		Panel_Collumn_SaveType.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );
		Panel_Collumn_SaveType.setPreferredSize( new Dimension( 200, 200 ) );
		Panel_Collumn_SaveType.setMaximumSize( new Dimension( 200, 200 ) );
		
		Panel_Collumn_SaveType.add ( new JLabel("Where to save datas:") );
		
		SaveTypes = new JComboBox();
		String[] Alltypes = this.Class_Controller.Get_Searchtypes();
		SaveTypes.addItem( "" );
		SaveTypes.addItem( "CSV-file" );
		SaveTypes.addItem( "Local folders" );
		SaveTypes.addActionListener( this );
		Panel_Collumn_SaveType.add(SaveTypes);
		TotalPanel.add ( this.Panel_Collumn_SaveType );
		
		/*
		//----Description
		Panel_Collumn_DescriptionData = new JPanel ( );
		//Panel_Collumn_DescriptionData.setLayout ( new BoxLayout ( this.Panel_Collumn_DescriptionData, BoxLayout.PAGE_AXIS ) );
		Panel_Collumn_DescriptionData.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );
		Panel_Collumn_DescriptionData.setPreferredSize( new Dimension( 200, 200 ) );
		Panel_Collumn_DescriptionData.setMaximumSize( new Dimension( 200, 200 ) );
		
		Panel_Row_DescriptionData[0] = new JPanel ( );
		Panel_Row_DescriptionData[0].setLayout ( new BoxLayout ( this.Panel_Row_DescriptionData[0], BoxLayout.LINE_AXIS ) );
		JLabel Text = new JLabel("Make product DESCRIPTION consist of:");
		Text.setAlignmentX( Text.LEFT_ALIGNMENT);
		Text.setAlignmentX(1);
		Panel_Row_DescriptionData[0].add ( Text );
		Panel_Collumn_DescriptionData.add ( Panel_Row_DescriptionData[0] );
		int X = 0;
		DescriptionData[X] = new JCheckBox ( "Images" );
		X++;
		DescriptionData[X] = new JCheckBox ( "Original Auction Description" );
		for ( int y = 0 ; y < this.DescriptionData.length ; y++ ) {
			if ( this.DescriptionData[y] != null ) {
				DescriptionData[y].addActionListener ( this );
				DescriptionData[y].setActionCommand ( DescriptionData[y].getLabel() );
				DescriptionData[y].setAlignmentX( DescriptionData[y].LEFT_ALIGNMENT);
				DescriptionData[y].setAlignmentX(1);
				Panel_Row_DescriptionData[y+1] = new JPanel ( );
				Panel_Row_DescriptionData[y+1].setLayout ( new BoxLayout ( this.Panel_Row_DescriptionData[y+1], BoxLayout.LINE_AXIS ) );
				Panel_Row_DescriptionData[y+1].add ( this.DescriptionData[y] );
				Panel_Collumn_DescriptionData.add ( this.Panel_Row_DescriptionData[y+1] );
				Panel_Collumn_DescriptionData.add ( DescriptionData[y] );
			}
		}
		TotalPanel.add ( this.Panel_Collumn_DescriptionData );
		
		//----MetaKeywords
		Panel_Collumn_MetaKeywords = new JPanel ( );
		//Panel_Collumn_MetaKeywords.setLayout ( new BoxLayout ( this.Panel_Collumn_MetaKeywords, BoxLayout.PAGE_AXIS ) );
		Panel_Collumn_MetaKeywords.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );
		Panel_Collumn_MetaKeywords.setPreferredSize( new Dimension( 200, 200 ) );
		Panel_Collumn_MetaKeywords.setMaximumSize( new Dimension( 200, 200 ) );
		
		Panel_Row_MetaKeywordsData[0] = new JPanel ( );
		Panel_Row_MetaKeywordsData[0].setLayout ( new BoxLayout ( this.Panel_Row_MetaKeywordsData[0], BoxLayout.LINE_AXIS ) );
		Panel_Row_MetaKeywordsData[0].add ( new JLabel("Make product META KEYWORDS consist of:") );
		Panel_Collumn_MetaKeywords.add ( Panel_Row_MetaKeywordsData[0] );
		X = 0;
		SKUData[X] = new JCheckBox ( "Seller" );
		X++;
		SKUData[X] = new JCheckBox ( "Item Type" );
		X++;
		SKUData[X] = new JCheckBox ( "Product ID" );
		X++;
		SKUData[X] = new JCheckBox ( "Dropshipper site" );
		for ( int y = 0 ; y < this.SKUData.length ; y++ ) {
			if ( this.SKUData[y] != null ) {
				SKUData[y].addActionListener ( this );
				SKUData[y].setActionCommand ( SKUData[y].getLabel() );
				SKUData[y].setAlignmentX( SKUData[y].LEFT_ALIGNMENT);
				SKUData[y].setAlignmentX(1);
				Panel_Row_MetaKeywordsData[y+1] = new JPanel ( );
				Panel_Row_MetaKeywordsData[y+1].setLayout ( new BoxLayout ( this.Panel_Row_MetaKeywordsData[y+1], BoxLayout.LINE_AXIS ) );
				Panel_Row_MetaKeywordsData[y+1].add ( this.SKUData[y] );
				Panel_Collumn_MetaKeywords.add ( this.Panel_Row_MetaKeywordsData[y+1] );
				Panel_Collumn_MetaKeywords.add ( SKUData[y] );
			}
		}
		TotalPanel.add ( this.Panel_Collumn_MetaKeywords );
		
		//----SKU
		Panel_Collumn_SKU = new JPanel ( );
		//Panel_Collumn_SKU.setLayout ( new BoxLayout ( this.Panel_Collumn_SKU, BoxLayout.PAGE_AXIS ) );
		Panel_Collumn_SKU.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );
		Panel_Collumn_SKU.setPreferredSize( new Dimension( 200, 200 ) );
		Panel_Collumn_SKU.setMaximumSize( new Dimension( 200, 200 ) );
		
		Panel_Row_SKU[0] = new JPanel ( );
		Panel_Row_SKU[0].setLayout ( new BoxLayout ( this.Panel_Row_SKU[0], BoxLayout.LINE_AXIS ) );
		Panel_Row_SKU[0].add ( new JLabel("Make product SKU consist of:") );
		Panel_Collumn_SKU.add ( Panel_Row_SKU[0] );
		X = 0;
		MetaKeywordData[X] = new JCheckBox ( "Seller" );
		X++;
		MetaKeywordData[X] = new JCheckBox ( "Item Type" );
		X++;
		MetaKeywordData[X] = new JCheckBox ( "Product ID" );
		X++;
		MetaKeywordData[X] = new JCheckBox ( "Dropshipper site" );
		for ( int y = 0 ; y < this.MetaKeywordData.length ; y++ ) {
			if ( this.MetaKeywordData[y] != null ) {
				MetaKeywordData[y].addActionListener ( this );
				MetaKeywordData[y].setActionCommand ( MetaKeywordData[y].getLabel() );
				MetaKeywordData[y].setAlignmentX( MetaKeywordData[y].LEFT_ALIGNMENT);
				MetaKeywordData[y].setAlignmentX(1);
				Panel_Row_SKU[y+1] = new JPanel ( );
				Panel_Row_SKU[y+1].setLayout ( new BoxLayout ( this.Panel_Row_SKU[y+1], BoxLayout.LINE_AXIS ) );
				Panel_Row_SKU[y+1].add ( this.MetaKeywordData[y] );
				Panel_Collumn_SKU.add ( this.Panel_Row_SKU[y+1] );
				Panel_Collumn_SKU.add ( MetaKeywordData[y] );
			}
		}
		TotalPanel.add ( this.Panel_Collumn_SKU );
		
		//----UPC
		Panel_Collumn_UPC = new JPanel ( );
		//Panel_Collumn_UPC.setLayout ( new BoxLayout ( this.Panel_Collumn_UPC, BoxLayout.PAGE_AXIS ) );
		Panel_Collumn_UPC.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );
		Panel_Collumn_UPC.setPreferredSize( new Dimension( 200, 200 ) );
		Panel_Collumn_UPC.setMaximumSize( new Dimension( 200, 200 ) );
		
		Panel_Row_UPC[0] = new JPanel ( );
		//Panel_Row_UPC[0].setLayout ( new BoxLayout ( this.Panel_Row_UPC[0], BoxLayout.LINE_AXIS ) );
		Panel_Row_UPC[0].add ( new JLabel("Make product UPC consist of:") );
		Panel_Collumn_UPC.add ( Panel_Row_UPC[0] );
		X = 0;
		UPCData[X] = new JCheckBox ( "Seller" );
		X++;
		UPCData[X] = new JCheckBox ( "Item Type" );
		X++;
		UPCData[X] = new JCheckBox ( "Product ID" );
		X++;
		UPCData[X] = new JCheckBox ( "Dropshipper site" );
		for ( int y = 0 ; y < this.UPCData.length ; y++ ) {
			if ( this.UPCData[y] != null ) {
				UPCData[y].addActionListener ( this );
				UPCData[y].setActionCommand ( UPCData[y].getLabel() );
				UPCData[y].setAlignmentX( UPCData[y].LEFT_ALIGNMENT);
				UPCData[y].setAlignmentX(1);
				Panel_Row_UPC[y+1] = new JPanel ( );
				Panel_Row_UPC[y+1].setLayout ( new BoxLayout ( this.Panel_Row_UPC[y+1], BoxLayout.LINE_AXIS ) );
				Panel_Row_UPC[y+1].add ( this.UPCData[y] );
				Panel_Collumn_UPC.add ( this.Panel_Row_UPC[y+1] );
				Panel_Collumn_UPC.add ( UPCData[y] );
			}
		}
		TotalPanel.add ( this.Panel_Collumn_UPC );
		
		//----Location
		Panel_Collumn_Location = new JPanel ( );
		//Panel_Collumn_Location.setLayout ( new BoxLayout ( this.Panel_Collumn_Location, BoxLayout.PAGE_AXIS ) );
		Panel_Collumn_Location.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );
		Panel_Collumn_Location.setPreferredSize( new Dimension( 200, 200 ) );
		Panel_Collumn_Location.setMaximumSize( new Dimension( 200, 200 ) );
		
		Panel_Row_Location[0] = new JPanel ( );
		Panel_Row_Location[0].setLayout ( new BoxLayout ( this.Panel_Row_Location[0], BoxLayout.LINE_AXIS ) );
		Panel_Row_Location[0].add ( new JLabel("Make product LOCATION consist of:") );
		Panel_Collumn_Location.add ( Panel_Row_Location[0] );
		X = 0;
		LocationData[X] = new JCheckBox ( "Seller" );
		X++;
		LocationData[X] = new JCheckBox ( "Item Type" );
		X++;
		LocationData[X] = new JCheckBox ( "Product ID" );
		X++;
		LocationData[X] = new JCheckBox ( "Dropshipper site" );
		for ( int y = 0 ; y < this.LocationData.length ; y++ ) {
			if ( this.LocationData[y] != null ) {
				LocationData[y].addActionListener ( this );
				LocationData[y].setActionCommand ( LocationData[y].getLabel() );
				LocationData[y].setAlignmentX( LocationData[y].LEFT_ALIGNMENT);
				LocationData[y].setAlignmentX(1);
				Panel_Row_Location[y+1] = new JPanel ( );
				Panel_Row_Location[y+1].setLayout ( new BoxLayout ( this.Panel_Row_Location[y+1], BoxLayout.LINE_AXIS ) );
				Panel_Row_Location[y+1].add ( this.LocationData[y] );
				Panel_Collumn_Location.add ( this.Panel_Row_Location[y+1] );
				Panel_Collumn_Location.add ( LocationData[y] );
			}
		}
		TotalPanel.add ( this.Panel_Collumn_Location );
		
		//----Price
		Panel_Collumn_Price = new JPanel ( );
		//Panel_Collumn_Price.setLayout ( new BoxLayout ( this.Panel_Collumn_Price, BoxLayout.PAGE_AXIS ) );
		Panel_Collumn_Price.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );
		Panel_Collumn_Price.setPreferredSize( new Dimension( 200, 200 ) );
		Panel_Collumn_Price.setMaximumSize( new Dimension( 200, 200 ) );
		
		Panel_Row_Price[0] = new JPanel ( );
		Panel_Row_Price[0].setLayout ( new BoxLayout ( this.Panel_Row_Price[0], BoxLayout.LINE_AXIS ) );
		Panel_Row_Price[0].add ( new JLabel("Make product PRICE consist of:") );
		Panel_Collumn_Price.add ( Panel_Row_Price[0] );
		X = 0;
		PriceData[X] = new JCheckBox ( "Original $ price" );
		X++;
		PriceData[X] = new JCheckBox ( "Original NOK price" );
		X++;
		PriceData[X] = new JCheckBox ( "2x original $ price" );
		X++;
		PriceData[X] = new JCheckBox ( "2x original NOK price" );
		for ( int y = 0 ; y < this.PriceData.length ; y++ ) {
			if ( this.PriceData[y] != null ) {
				PriceData[y].addActionListener ( this );
				PriceData[y].setActionCommand ( PriceData[y].getLabel() );
				PriceData[y].setAlignmentX( PriceData[y].LEFT_ALIGNMENT);
				PriceData[y].setAlignmentX(1);
				Panel_Row_Price[y+1] = new JPanel ( );
				Panel_Row_Price[y+1].setLayout ( new BoxLayout ( this.Panel_Row_Price[y+1], BoxLayout.LINE_AXIS ) );
				Panel_Row_Price[y+1].add ( this.PriceData[y] );
				Panel_Collumn_Price.add ( this.Panel_Row_Price[y+1] );
				Panel_Collumn_Price.add ( PriceData[y] );
			}
		}
		TotalPanel.add ( this.Panel_Collumn_Price );
		
		//----Quantity
		Panel_Collumn_Quantity = new JPanel ( );
		//Panel_Collumn_Quantity.setLayout ( new BoxLayout ( this.Panel_Collumn_Quantity, BoxLayout.PAGE_AXIS ) );
		Panel_Collumn_Quantity.setBackground ( new Color ( ( 210 ), ( 225 ), ( 240 ) ) );
		Panel_Collumn_Quantity.setPreferredSize( new Dimension( 200, 200 ) );
		Panel_Collumn_Quantity.setMaximumSize( new Dimension( 200, 200 ) );
		
		Panel_Row_Quantity[0] = new JPanel ( );
		//Panel_Row_Quantity[0].setLayout ( new BoxLayout ( this.Panel_Row_Quantity[0], BoxLayout.LINE_AXIS ) );
		Panel_Row_Quantity[0].add ( new JLabel("Make product QUANTITY consist of:") );
		Panel_Collumn_Quantity.add ( Panel_Row_Quantity[0] );
		X = 0;
		QuantityData[X] = new JCheckBox ( "Always 0" );
		for ( int y = 0 ; y < this.QuantityData.length ; y++ ) {
			if ( this.QuantityData[y] != null ) {
				QuantityData[y].addActionListener ( this );
				QuantityData[y].setActionCommand ( QuantityData[y].getLabel() );
				QuantityData[y].setAlignmentX( QuantityData[y].LEFT_ALIGNMENT);
				QuantityData[y].setAlignmentX(1);
				Panel_Row_Quantity[y+1] = new JPanel ( );
				Panel_Row_Quantity[y+1].setLayout ( new BoxLayout ( this.Panel_Row_Quantity[y+1], BoxLayout.LINE_AXIS ) );
				Panel_Row_Quantity[y+1].add ( this.QuantityData[y] );
				Panel_Collumn_Quantity.add ( this.Panel_Row_Quantity[y+1] );
				Panel_Collumn_Quantity.add ( QuantityData[y] );
			}
		}
		TotalPanel.add ( this.Panel_Collumn_Quantity );
		*/

		this.add ( this.TotalPanel, c );
		
		setVisible ( true );

	}

	@Override
	public void actionPerformed( ActionEvent arg0 ) {
		
		if ( arg0.getSource().toString().equals( SaveTypes.toString() ) ) {
			Class_Controller.Set_Setting_SaveType( SaveTypes.getSelectedItem().toString() );
			Class_Controller.UpdateSettings_GUI();
		}
		
	}

}
