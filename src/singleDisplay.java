import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;

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
		setBounds(100, 100, 600, 655);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 153));
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
		lblNewLabel.setBounds(26, 39, 535, 510);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setText(allPhotos.photoList.get(index).photoTitle);
		lblNewLabel_1.setBounds(26, 12, 535, 15);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 558, 535, 57);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setText(allPhotos.photoList.get(index).photoAnnotation);;
		scrollPane.setViewportView(textArea);
		
		if(0<=index&&index<allPhotos.photoList.size()){
			BufferedImage image = null;
			try {
				image = ImageIO.read(allPhotos.photoList.get(index).photoFile);
				//System.out.println("Not");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			lblNewLabel.setIcon(new ImageIcon(image.getScaledInstance(500, 500, Image.SCALE_DEFAULT)));
		}
		
	}
}
