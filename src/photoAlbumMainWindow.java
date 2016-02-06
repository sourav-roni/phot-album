import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class photoAlbumMainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -586501023258284875L;
	private JPanel contentPane;
	static photoAlbum allPhotos = new photoAlbum();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					photoAlbumMainWindow frame = new photoAlbumMainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				try
			      {
			         FileInputStream fileIn = new FileInputStream("PhotoAlbum");
			         ObjectInputStream input = null;
					try {
						input = new ObjectInputStream(fileIn);
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						//e2.printStackTrace();
					}
			         try {
			        	 allPhotos = (photoAlbum) input.readObject();
			        	 //System.out.println(allPhotos.photoList.size());
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						//e2.printStackTrace();
					}
			         try {
						input.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}
			         try {
						fileIn.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
			      }catch(FileNotFoundException a)
			      {
			         //System.out.println("OOPs!! File Not Found");
			      }catch(ClassNotFoundException c)
			      {
			         //System.out.println("Acquaintances class not found");
			         //c.printStackTrace();
			         return;
			      }
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public photoAlbumMainWindow() {
		setResizable(false);
		setTitle("Photo Album");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 444);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResource("/photo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setIconImage(image);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setBounds(280, 34, 70, 15);
		contentPane.add(lblWelcome);
		
		JLabel lblPhotoAlbum = new JLabel("Photo Album");
		lblPhotoAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhotoAlbum.setBounds(215, 62, 192, 15);
		contentPane.add(lblPhotoAlbum);
		
		JButton btnAddNewPhoto = new JButton("Add New Photo");
		btnAddNewPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(allPhotos.photoList.size()<10){
					photoAdd newAdd = new photoAdd(allPhotos);
					newAdd.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null,"There are already 10 Photographs. Please Delete First.");
				}
			}
		});
		btnAddNewPhoto.setBounds(120, 106, 399, 42);
		try {
			image = ImageIO.read(getClass().getResource("/add.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnAddNewPhoto.setIcon(new ImageIcon(image));
		contentPane.add(btnAddNewPhoto);
		
		JButton btnDisplayAllPhotos = new JButton("Display All Photos one by one");
		btnDisplayAllPhotos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayAll allDisplay = new displayAll(allPhotos);
				allDisplay.setVisible(true);
			}
		});
		btnDisplayAllPhotos.setBounds(120, 177, 399, 52);
		try {
			image = ImageIO.read(getClass().getResource("/display.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnDisplayAllPhotos.setIcon(new ImageIcon(image));
		contentPane.add(btnDisplayAllPhotos);
		
		JButton btnChooseAndDispaly = new JButton("Choose and Display Photos");
		btnChooseAndDispaly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listDisplay listed = new listDisplay(allPhotos);
				listed.setVisible(true);
			}
		});
		btnChooseAndDispaly.setBounds(120, 257, 399, 52);
		try {
			image = ImageIO.read(getClass().getResource("/display.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnChooseAndDispaly.setIcon(new ImageIcon(image));
		contentPane.add(btnChooseAndDispaly);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(260, 353, 117, 35);
		try {
			image = ImageIO.read(getClass().getResource("/exit.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnExit.setIcon(new ImageIcon(image));
		contentPane.add(btnExit);
	}
}
