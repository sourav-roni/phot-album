import java.io.File;
import java.util.ArrayList;

public class photoAlbum implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4344489482617338783L;
	public ArrayList<Photo> photoList = new ArrayList<Photo>(10);
}

class Photo implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4491312495108456460L;
	String photoTitle;
	String photoAnnotation;
	File photoFile;
}