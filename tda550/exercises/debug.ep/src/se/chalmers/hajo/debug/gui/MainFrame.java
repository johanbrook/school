package se.chalmers.hajo.debug.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import se.chalmers.hajo.debug.ctrl.DoItCtrl;
import se.chalmers.hajo.debug.ctrl.OtherCtrl;

/**
 * Application main window.
 * 
 * NOTE: This i a monolithic (auto generated) GUI i.e. everything is in one
 * gigantic file. BAD! You should compose the GUI from separate panels.
 * 
 * @author hajo
 * 
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private JMenuBar jMnuBMain;
	private JMenu jMnuOptions;
	private JTextPane jTxtPaneMain;
	private JButton jBtnOther;
	private JCheckBoxMenuItem jCBMnuItemSilly;
	private JPanel jPnlNorth;
	private JButton jBtnSomething;
	private JPanel jPnlCenter;
	private JPanel jPnlWest;
	private JTextField jTxtFldInput;
	private JButton jBtnDoIt;
	private JMenuItem jMnuItemAbout;
	private JMenu jMnuAbout;
	private JMenuItem jMnuItemExit;
	private JMenu jMenu1;

	public MainFrame() {
		initGUI();  // Order matters
		initActions();
	}

	private void initActions() {
		ActionListener doit = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				StringBuilder out = new StringBuilder();
				String in = jTxtFldInput.getText();
				new DoItCtrl(in, out).execute();
				jTxtPaneMain.setText("");
				jTxtPaneMain.setText(out.toString());
			}

		};
		ActionListener other = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jTxtPaneMain.setBackground(new OtherCtrl().execute());
			}

		};
		jBtnDoIt.addActionListener(doit);
		jBtnOther.addActionListener(other);

	}

	private void initGUI() {
		try {
			{
				this.setTitle("Debug");
				this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				{
					jPnlNorth = new JPanel();
					getContentPane().add(jPnlNorth, BorderLayout.NORTH);
					jPnlNorth.setBorder(new LineBorder(new java.awt.Color(0, 0,
							0), 1, false));
					{
						jTxtFldInput = new JTextField();
						jPnlNorth.add(jTxtFldInput);
						jTxtFldInput.setPreferredSize(new java.awt.Dimension(6,
								21));
						jTxtFldInput.setColumns(20);
					}
					{
						jBtnDoIt = new JButton();
						jPnlNorth.add(jBtnDoIt);
						jBtnDoIt.setText("DoIt");
					}
				}
				{
					jPnlWest = new JPanel();
					GridLayout jPnlWestLayout = new GridLayout(6, 1);
					jPnlWestLayout.setHgap(10);
					jPnlWestLayout.setVgap(10);
					jPnlWestLayout.setColumns(1);
					jPnlWestLayout.setRows(6);
					jPnlWest.setLayout(jPnlWestLayout);
					getContentPane().add(jPnlWest, BorderLayout.WEST);
					jPnlWest.setBorder(new LineBorder(new java.awt.Color(0, 0,
							0), 1, false));
					{
						jBtnSomething = new JButton();
						jPnlWest.add(jBtnSomething);
						jBtnSomething.setText("Something");
					}
					{
						jBtnOther = new JButton();
						jPnlWest.add(jBtnOther);
						jBtnOther.setText("Other");
					}
				}
				{
					jPnlCenter = new JPanel();
					getContentPane().add(jPnlCenter, BorderLayout.CENTER);
					{
						jTxtPaneMain = new JTextPane();
						jPnlCenter.add(jTxtPaneMain);
						jTxtPaneMain.setPreferredSize(new java.awt.Dimension(
								250, 183));
					}
				}
			}
			{
				jMnuBMain = new JMenuBar();
				setJMenuBar(jMnuBMain);
				{
					jMenu1 = new JMenu();
					jMnuBMain.add(jMenu1);
					jMenu1.setText("File");
					{
						jMnuItemExit = new JMenuItem();
						jMenu1.add(jMnuItemExit);
						jMnuItemExit.setText("Exit");
						jMnuItemExit.setBounds(48, 19, 32, 19);
						jMnuItemExit
								.addComponentListener(new ComponentAdapter() {
								});
						jMnuItemExit.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								System.exit(0);
							}
						});
					}
				}
				{
					jMnuOptions = new JMenu();
					jMnuBMain.add(jMnuOptions);
					jMnuOptions.setText("Options");
					{
						jCBMnuItemSilly = new JCheckBoxMenuItem();
						jMnuOptions.add(jCBMnuItemSilly);
						jCBMnuItemSilly.setText("Silly");
						jCBMnuItemSilly.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jTxtFldInput.setText("");
								jTxtPaneMain.setText("");
								jTxtPaneMain.setBackground(Color.WHITE);
							}
						});

					}
				}
				{
					jMnuAbout = new JMenu();
					jMnuBMain.add(jMnuAbout);
					jMnuAbout.setText("About");
					{
						jMnuItemAbout = new JMenuItem();
						jMnuAbout.add(jMnuItemAbout);
						jMnuItemAbout.setText("About");
						jMnuItemAbout.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								JOptionPane.showConfirmDialog(MainFrame.this,
										"Ram tidelli didja dudi", "About",
										JOptionPane.OK_OPTION);
							}
						});

					}
				}
			}
			{
				this.setSize(351, 276);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
