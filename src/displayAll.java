import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

@SuppressWarnings("unused")
public class displayAll extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4853124009231766111L;
	private JPanel contentPane;
	public int index = 0;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displayAll frame = new displayAll();
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
	public displayAll(final photoAlbum allPhotos) {
		setTitle("Photo Album");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1325, 733);
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
		
		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(-40, 0, 1301, 647);
		contentPane.add(lblNewLabel);
		try {
			image_1 = ImageIO.read(allPhotos.photoList.get(index).photoFile);
			//System.out.println("Not");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		lblNewLabel.setIcon(new ImageIcon(image_1));
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index--;
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
				else{
					index = 0;
					JOptionPane.showMessageDialog(null, "This is the first Photo!");
				}
			}
		});
		btnPrevious.setBounds(310, 664, 138, 25);
		try {
			image_1 = ImageIO.read(getClass().getResource("/prev.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnPrevious.setIcon(new ImageIcon(image_1));
		contentPane.add(btnPrevious);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index++;
				if(index<allPhotos.photoList.size()){
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
				else{
					index = allPhotos.photoList.size()-1;
					JOptionPane.showMessageDialog(null, "This is the last Photo!");
				}
			}
		});
		btnNext.setBounds(894, 664, 151, 25);
		try {
			image_1 = ImageIO.read(getClass().getResource("/next.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnNext.setIcon(new ImageIcon(image_1));
		contentPane.add(btnNext);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index = 0;
				setVisible(false);
			}
		});
		btnBack.setBounds(600, 664, 138, 25);
		try {
			image_1 = ImageIO.read(getClass().getResource("/back.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnBack.setIcon(new ImageIcon(image_1));
		contentPane.add(btnBack);
		
	}
}
