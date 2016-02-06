import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class photoAdd extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1829442444297167002L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					photoAdd frame = new photoAdd();
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
	public photoAdd(final photoAlbum allPhotos) {
		setTitle("Add New Photo");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 480);
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
		
		final Photo addPhoto = new Photo();
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.showDialog(null,"Add New Photo");
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				    "JPG & GIF Images", "jpg", "gif","png","jpeg","JPEG","JPG","PNG");
				chooser.setFileFilter(filter);
				try {
					addPhoto.photoFile = chooser.getSelectedFile();
					String fileName = addPhoto.photoFile.getAbsolutePath();
					textField.setText(fileName);
				} catch (Exception e) {
					//System.out.println("YI");
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
		});
		btnBrowse.setBounds(445, 96, 129, 25);
		contentPane.add(btnBrowse);
		
		JLabel lblAddANew = new JLabel("Add a New Photo");
		lblAddANew.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddANew.setBounds(182, 27, 255, 34);
		contentPane.add(lblAddANew);
		
		textField = new JTextField();
		textField.setBounds(25, 96, 370, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterTheTitle = new JLabel("<html>Enter the Title of the Photo<br>(20 characters Max)");
		lblEnterTheTitle.setBounds(25, 153, 224, 34);
		contentPane.add(lblEnterTheTitle);
		
		textField_1 = new JTextField();
		textField_1.setBounds(284, 153, 290, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lbladdAnnotationTo = new JLabel("<html>Add Annotation to the Photo<br>(100 characters Max.)");
		lbladdAnnotationTo.setBounds(25, 220, 224, 34);
		contentPane.add(lbladdAnnotationTo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(284, 220, 290, 117);
		contentPane.add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnAddPhoto = new JButton("Add Photo");
		btnAddPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean done = true;
				if(textField_1.getText().length()>20||textField_1.getText().length()==0){
					done = false;
					textField_1.setText("");
					JOptionPane.showMessageDialog(null, "Title length is Invalid!!");
				}
				if(textArea.getText().length()>100||textArea.getText().length()==0){
					done = false;
					textArea.setText("");
					JOptionPane.showMessageDialog(null, "Annotation length is Invalid!!");
				}
				if(done){
					addPhoto.photoTitle = textField_1.getText();
					addPhoto.photoAnnotation = textArea.getText();
					allPhotos.photoList.add(addPhoto);
					try
				      {
				         FileOutputStream fileOut = new FileOutputStream("PhotoAlbum");
				         ObjectOutputStream out = new ObjectOutputStream(fileOut);
				         out.writeObject(allPhotos);
				         //JOptionPane.showMessageDialog(null, "One New Photo Successfully Added !!!");
				         out.flush();
				         out.close();
				         fileOut.close();
				         //System.out.println("\nAll Changes have been Saved Succcessfully!!");
				         //System.out.println("Thank You");
				      }catch(IOException exe)
				      {
				    	  System.out.println("Cannot Add");
				          exe.printStackTrace();
				      }
					//System.out.println(allPhotos.photoList.size());
					JOptionPane.showMessageDialog(null, "One New Photo Successfully Added !!!");
					setVisible(false);
				}
			}
		});
		btnAddPhoto.setBounds(118, 384, 163, 25);
		try {
			image = ImageIO.read(getClass().getResource("/add.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnAddPhoto.setIcon(new ImageIcon(image));
		contentPane.add(btnAddPhoto);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setBounds(341, 384, 157, 25);
		try {
			image = ImageIO.read(getClass().getResource("/back.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnBack.setIcon(new ImageIcon(image));
		contentPane.add(btnBack);
	}
}
