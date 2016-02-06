import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("unused")
public class singleDisplay extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5179639829508974442L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					singleDisplay frame = new singleDisplay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public singleDisplay(photoAlbum allPhotos,int index) {
		setTitle("Photo Display");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1089, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		BufferedImage image_1 = null;
		try {
			image_1 = ImageIO.read(getClass().getResource("/photo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setIconImage(image_1);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 0, 1065, 614);
		contentPane.add(lblNewLabel);
		
		if(0<=index&&index<allPhotos.photoList.size()){
			BufferedImage image = null;
			try {
				image = ImageIO.read(allPhotos.photoList.get(index).photoFile);
				//System.out.println("Not");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			lblNewLabel.setIcon(new ImageIcon(image));
		}
		
	}
}
