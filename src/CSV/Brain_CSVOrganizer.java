package CSV;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.Date;

import javax.imageio.ImageIO;

import Control.Controller;
import Downloads.Object_Product_Offer;

public class Brain_CSVOrganizer {
	
	Controller Class_Controller;
	
	boolean SaveAsCSV = true;

	public Brain_CSVOrganizer(Controller Class_Controller ) {
		this.Class_Controller = Class_Controller;
	}
	
	public void Startup() {
		// TODO Auto-generated method stub
		
	}

	public void PrintOffer( Object_Product_Offer Offer ) {
		if ( SaveAsCSV == true ) {
			PrintToCSV( Offer );
		} else {
			PrintToFolder( Offer );
		}
	}
	
	private void PrintToCSV( Object_Product_Offer Offer ) {
		try {
			Date Idag = new Date();
			String ProductsFilename = this.Class_Controller.Get_SelectedDropshipper().DropshipperName+" "+(1900+Idag.getYear())+"."+(1+Idag.getMonth())+"."+Idag.getDate()+"."+(Idag.getHours())+".CSV";
			File ProductsFile = new File ( ProductsFilename );

			if ( !ProductsFile.exists() ) {
				ProductsFile.createNewFile();
			}
				
			PrintStream utfil;
			FileOutputStream appendFilen = new FileOutputStream ( ProductsFile, true );
			utfil = new PrintStream ( appendFilen );

			utfil.println( Offer.Get_Name()+"~"+Offer.Get_Description()+"~"+Offer.Get_MetaDescription()+"~"+Offer.Get_MetaKeywords()+"~"+Offer.Get_Model()+"~"+Offer.Get_SKU()+"~"+Offer.Get_UPC()+"~"+Offer.Get_Location()+"~"+Offer.Get_Price()+"~"+Offer.Get_Quantity()+"~"+Offer.Get_MinQuantity()+"~"+Offer.Get_SubstractStock()+"~"+Offer.Get_RequiresShipping()+"~"+Offer.Get_SEOKeywords()+"~"+Offer.Get_Image()+"~"+Offer.Get_Length()+"~"+Offer.Get_Height()+"~"+Offer.Get_Width()+"~"+Offer.Get_Weight()+"~"+Offer.Get_ProductStatus()+"~"+Offer.Get_SortOrder()+"~"+Offer.Get_Manufacturer()+"~"+Offer.Get_Category()+"~"+Offer.Get_SubCategory()+"~"+Offer.Get_Download()+"~"+Offer.Get_Attribute()+"~"+Offer.Get_Options()+"~"+Offer.Get_DiscountPrice()+"~"+Offer.Get_SpecialPrice()+"~"+Offer.Get_AdditionalImage()+"~"+Offer.Get_Points()+"~"+Offer.Get_RewardPoints() );
			//System.out.println( Offer.Produktnavn+"~"+Offer.SuggestedSEO+"~"+Offer.Itemtype.Name+"~"+Offer.Dollarpris+"~"+Offer.SKU+"~"+Offer.Beskrivelser+"~"+Offer.FrontBilde+"~"+Offer.Bilder );

			utfil.close ( );
			utfil = null;
	        System.gc();
	        	
			//this.Class_Controller.AddProgressMessage( "New product saved to searchlist file." );
	        this.Class_Controller.AddProgressMessage( "Saved offer: "+Offer.Get_Name()+" ("+Offer.Get_Category()+" "+Offer.Get_SubCategory()+")" );
	        //linkToCheck.CleanForMemory();
		} catch ( IOException T ) {
			Class_Controller.AddProgressMessage( "Could not save offer A: "+T.getMessage()+" "+T.getCause()+" "+T.getClass() );
			CastErrors( T );
			if ( T.getMessage ( ).equals("Access is denied")) {
				PrintOffer( Offer );
			} else {
				CastErrors( T );
			}
		} catch ( Exception T ) {
			Class_Controller.AddProgressMessage( "Could not save offer B: "+T.getMessage()+" "+T.getCause()+" "+T.getClass() );
			CastErrors( T );
		}
	}
	
	private void PrintToFolder( Object_Product_Offer Offer ) {
		//System.out.println( this.getClass().toString()+" PrintToFolder " );
        try {
        	String CategoryFolder = Offer.Itemtype.ItemtypeName;
        	String SKU = Offer.Get_Model();
        	
        	String TempData = Offer.Beskrivelser;
        	String URLtemp;
        	
        	int Teller = 0;
        	String ImageName;
        	
			File ProductInfo = new File ( CategoryFolder+"\\"+SKU+"\\"+SKU+".txt" );
			
			if (!ProductInfo.getParentFile().exists())
				ProductInfo.getParentFile().mkdirs();

			if ( !ProductInfo.exists() ) {
				ProductInfo.createNewFile();
			}	
			PrintStream utfil;
			FileOutputStream appendFilen = new FileOutputStream ( ProductInfo, true );
			utfil = new PrintStream ( appendFilen );
			utfil.println( "Produkt: "+Offer.Get_Name()+"\r\nDescription i HTML-kode: "+Offer.Get_Description()+"\r\nURL: "+Offer.Get_MetaDescription()+"\r\nSKU: "+Offer.Get_Model()+"\r\nInnpris uten frakt: "+Offer.Get_Price()+"\r\nAntall: "+Offer.Get_Quantity() );

 
        	while ( TempData.indexOf( ".jpg" ) > -1 ) {
        		//System.out.println( this.getClass().toString()+" PrintToFolder Prøver å lagre bilde" );
        		URLtemp = TempData.substring( 0, TempData.indexOf( ".jpg" )+".jpg".length() );
        		TempData = TempData.substring( TempData.indexOf( ".jpg" )+1 );
        		
        		if ( !new File( CategoryFolder).exists() ) {
	        		File dir = new File( CategoryFolder );
	        		dir.mkdir();
        		}
        		if ( !new File( CategoryFolder+"\\"+SKU ).exists() ) {
	        		File dir = new File( CategoryFolder+"\\"+SKU );
	        		dir.mkdir();
        		}
        		
        		URLtemp = URLtemp.substring( URLtemp.lastIndexOf( "http") );
        		Teller ++;
        		ImageName = "Bilde nr "+Teller;
        		
        		//SaveImage1( URLtemp, CategoryFolder, SKU, ImageName );
        		saveImage2( URLtemp, CategoryFolder+"\\"+SKU+"\\"+ImageName+".jpg" );
        	}
        	Class_Controller.AddProgressMessage( "Saved offer: "+Offer.Get_Name()+" ("+Offer.Get_Category()+" "+Offer.Get_SubCategory()+")" );
 
        } catch ( Exception T) {
        	CastErrors( T );
        }
	}
	
	private void SaveImage1( String URLtemp, String CategoryFolder, String SKU, String ImageName  ) {
		BufferedImage image = null;
		File dir = new File( CategoryFolder+"\\"+SKU+"\\"+ImageName+".jpg" );
		
		try {
			
			if ( !dir.exists() ) {
				dir.createNewFile();
			}
			
			URL url = new URL( URLtemp );
        
            image = ImageIO.read(url );
 
            ImageIO.write( image, "jpg",new File( CategoryFolder+"\\"+SKU+"\\"+ImageName+".jpg" ));
            ImageIO.write( image, "gif",new File( CategoryFolder+"\\"+SKU+"\\"+ImageName+".gif"));
            ImageIO.write( image, "png",new File( CategoryFolder+"\\"+SKU+"\\"+ImageName+".png"));
        } catch (IOException T) {
        	System.err.println( this.getClass().toString()+" SaveImage1 klarte ikke lagre bilde" );
        	//CastErrors( T );
        }
	}
	
	private void saveImage2(String imageUrl, String destinationFile) throws IOException {
		try {
			File dir = new File( destinationFile );
			if (!dir.getParentFile().exists())
				dir.getParentFile().mkdirs();
			
			if ( !dir.exists() ) {
				dir.createNewFile();
    		}
			
			/*String Filnavn = Dato+" "+Producer+" - "+OfficialName+".txt";
			File filen = new File ( Folder.getAbsolutePath()+"//"+Filnavn );

			if (!filen.getParentFile().exists())
				filen.getParentFile().mkdirs();

			if ( !filen.exists() ) {
				filen.createNewFile();
			}*/
			
			//System.out.println( this.getClass().toString()+" saveImage2 - dir.exists()="+dir.exists()+". filnavn="+dir );
			
			URL url = new URL(imageUrl);
			InputStream is = url.openStream();
			OutputStream os = new FileOutputStream(destinationFile);
	
			byte[] b = new byte[2048];
			int length;
			
			while ((length = is.read(b)) != -1) {
				os.write(b, 0, length);
			}
	
			is.close();
			os.close();
		 } catch (IOException T) {
	        	//System.err.println( this.getClass().toString()+" saveImage2 klarte ikke lagre bilde" );
	        	CastErrors( T );
	     }
	}
	
	public void Set_Setting_SaveType(String type) {
		if ( type.equals( "CSV-file" )) {
			this.SaveAsCSV = true;
		} else {
			SaveAsCSV = false;
		}
	}
	
	private void CastErrors( Exception T ) {
		System.err.println( this.getClass().toString() );
		System.err.println ( "Throwable message: " + T.getMessage ( ) );
		System.err.println ( "Throwable cause: " + T.getCause ( ) );
		System.err.println ( "Throwable class: " + T.getClass ( ) );
		
		System.err.println ( "Origin stack "+0+": ");
		System.err.println ( "Class: " + T.getStackTrace ( )[0].getClassName ( ) );
		System.err.println ( "Method: " + T.getStackTrace ( )[0].getMethodName ( ) );
		System.err.println ( "Line: " + T.getStackTrace ( )[0].getLineNumber ( ) );
		
		System.err.println ( "Origin stack "+1+": ");
		System.err.println ( "Class: " + T.getStackTrace ( )[1].getClassName ( ) );
		System.err.println ( "Method: " + T.getStackTrace ( )[1].getMethodName ( ) );
		System.err.println ( "Line: " + T.getStackTrace ( )[1].getLineNumber ( ) );
		
		System.err.println ( "Origin stack "+2+": ");
		System.err.println ( "Class: " + T.getStackTrace ( )[2].getClassName ( ) );
		System.err.println ( "Method: " + T.getStackTrace ( )[2].getMethodName ( ) );
		System.err.println ( "Line: " + T.getStackTrace ( )[2].getLineNumber ( ) );
		
		for ( int y = 2 ; y < T.getStackTrace().length ; y++ ) {
			System.err.println (" ");
			System.err.println ( "Origin stack "+y+": ");
			System.err.println ( "Class: " + T.getStackTrace ( )[y].getClassName ( ) );
			System.err.println ( "Method: " + T.getStackTrace ( )[y].getMethodName ( ) );
			System.err.println ( "Line: " + T.getStackTrace ( )[y].getLineNumber ( ) );
		}
	}

}
