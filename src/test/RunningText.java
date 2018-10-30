/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author abednego(11315020)
 */
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.Font;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class RunningText extends JFrame 
{

	JPanel contentPane;
	javax.swing.Timer waktu;
	JLabel lblText;
	/**
	 * Create the frame.
	 */
	public RunningText() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblText = new JLabel("Selamat datang di www.marisharingilmu.wordpress.com     ");
		lblText.setIcon(new ImageIcon("/home/resa/Aplikasi Java/SwingComponents/src/Gambar/firefox.png"));
		lblText.setFont(new Font("Liberation Sans", Font.BOLD, 16));
		lblText.setBounds(61, 49, 448, 34);
		contentPane.add(lblText);
		setLocationRelativeTo(null);
		
		waktu = new Timer(100,new LabelListener(lblText));
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon("/home/resa/Aplikasi Java/SwingComponents/src/Gambar/kereta.png"));
		lblIcon.setBounds(333, 129, 176, 123);
		contentPane.add(lblIcon);
		
		JLabel lblIcon_2 = new JLabel("");
		lblIcon_2.setIcon(new ImageIcon("/home/resa/Aplikasi Java/SwingComponents/src/Gambar/Bus.png"));
		lblIcon_2.setBounds(72, 129, 147, 109);
		contentPane.add(lblIcon_2);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("/home/resa/Aplikasi Java/SwingComponents/src/Gambar/biru.JPG"));
		lblBackground.setBounds(0, 0, 557, 264);
		contentPane.add(lblBackground);
		lblText.addMouseListener(new LabelMouseListener(waktu));
		waktu.start();
	}	//Akhir Konstruktor
	
	public static void main(String[] ar) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					RunningText frame = new RunningText();
					frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
}
