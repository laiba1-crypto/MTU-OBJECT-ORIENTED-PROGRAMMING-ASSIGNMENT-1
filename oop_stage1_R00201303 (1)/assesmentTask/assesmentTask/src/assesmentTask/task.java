package assesmentTask;

import javax.swing.table.DefaultTableModel;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.Toolkit;

public class task {

	private JFrame MTU_Student_Records_System;
	private JTextField ID;
	private JTextField Name;
	// private JTextField Course;
	private JTextField DOB;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnClear;
	DefaultTableModel model;
	private JButton btnNewButton;
	private JTextArea txtrStudentsInThe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					task window = new task();
					window.MTU_Student_Records_System.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public task() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MTU_Student_Records_System = new JFrame();
		MTU_Student_Records_System.setIconImage(Toolkit.getDefaultToolkit().getImage(".\\MTU.png"));
		MTU_Student_Records_System.setTitle("MTU Student Record System");
		MTU_Student_Records_System.setBounds(100, 100, 701, 582);
		MTU_Student_Records_System.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MTU_Student_Records_System.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 64));
		panel.setBounds(10, 11, 667, 523);
		MTU_Student_Records_System.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter Your ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(55, 41, 120, 14);
		panel.add(lblNewLabel);

		JLabel lblEnterYourName = new JLabel("Enter Your Name :");
		lblEnterYourName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEnterYourName.setBounds(55, 66, 120, 14);
		panel.add(lblEnterYourName);

		JLabel lblEnterYourDob = new JLabel("Enter Your DOB :");
		lblEnterYourDob.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEnterYourDob.setBounds(55, 91, 120, 14);
		panel.add(lblEnterYourDob);

		ID = new JTextField();
		ID.setBounds(224, 39, 226, 20);
		panel.add(ID);
		ID.setColumns(10);

		Name = new JTextField();
		Name.setColumns(10);
		Name.setBounds(224, 64, 226, 20);
		panel.add(Name);

		DOB = new JTextField();
		DOB.setColumns(10);
		DOB.setBounds(224, 89, 226, 20);
		panel.add(DOB);
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 245, 577, 186);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setVisible(false);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				int i = table.getSelectedRow();
				ID.setText(model.getValueAt(i, 0).toString());
				Name.setText(model.getValueAt(i, 1).toString());
				DOB.setText(model.getValueAt(i, 2).toString());
			}
		});
		table.setBackground(new Color(255, 128, 64));
		table.setForeground(new Color(0, 0, 0));
		model = new DefaultTableModel();
		Object[] column = { "StudentID", "Name", "DOB" };
		final Object[] row = new Object[3];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);

		JTextArea textArea = new JTextArea();
		scrollPane.setColumnHeaderView(textArea);
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (ID.getText().equals("") || Name.getText().equals("") || DOB.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Fill the Complete Information");
				} else {

					String[] row = new String[3];
					row[0] = ID.getText();
					row[1] = Name.getText();
					row[2] = DOB.getText();
					model.addRow(row);

					ID.setText("");
					Name.setText("");
					DOB.setText("");
					table.setVisible(false);
					JOptionPane.showMessageDialog(null, "Student Information Saved Successfully");
				}

			}
		});
		btnAdd.setBounds(28, 168, 80, 23);
		panel.add(btnAdd);

		btnUpdate = new JButton("List");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ID.getText().equals("") || Name.getText().equals("") || DOB.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Select The Record First");
				} else {
					int i = table.getSelectedRow();
					model.setValueAt(ID.getText(), i, 0);
					model.setValueAt(Name.getText(), i, 1);
					model.setValueAt(DOB.getText(), i, 2);
					ID.setText("");
					Name.setText("");
					DOB.setText("");
					table.clearSelection();
					JOptionPane.showMessageDialog(null, "Student Information Updated  Successfully");

				}

			}
		});
		btnUpdate.setBounds(125, 168, 80, 23);
		panel.add(btnUpdate);
		btnDelete = new JButton("Remove");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ID.getText().equals("") || Name.getText().equals("") || DOB.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Select The Record First");
				} else {

					int i = table.getSelectedRow();
					if (i >= 0) {
						model.removeRow(i);
						ID.setText("");
						Name.setText("");
						DOB.setText("");
						JOptionPane.showMessageDialog(null, "Successfully Deleted Student Information ");
					} else {
						JOptionPane.showMessageDialog(null, "Please Select Student Information First");
					}
				}

			}
		});
		btnDelete.setBounds(224, 168, 95, 23);
		panel.add(btnDelete);
		btnClear = new JButton("Exist");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = JOptionPane.showInputDialog(
						"Are You sure You want to remove all records \n                               'Yes' or 'Not'");
				if (str != null && str.toLowerCase().equals("yes")) {
					int rowCount = model.getRowCount();
					if (rowCount >= 0) {
						for (int j = rowCount - 1; j >= 0; j--) {
							model.removeRow(j);
						}
					}
					MTU_Student_Records_System.dispose();
				} else {
				}
			}
		});
		btnClear.setBounds(577, 453, 80, 23);
		panel.add(btnClear);

		btnNewButton = new JButton("save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to save the data?",
						"Confirmation", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					try {
						FileWriter fileWriter = new FileWriter("data.txt");
						PrintWriter printWriter = new PrintWriter(fileWriter);
						int numRows = table.getRowCount();
						int numCols = table.getColumnCount();
						for (int row = 0; row < numRows; row++) {
							for (int col = 0; col < numCols; col++) {
								Object cellValue = table.getValueAt(row, col);
								printWriter.print(cellValue + "\t");
							}
							printWriter.println();
						}
						printWriter.close();
					} catch (IOException ea) {
						ea.printStackTrace();
					}

					JOptionPane.showMessageDialog(null, "Data has been saved successfully!");
				} else {
					JOptionPane.showMessageDialog(null, "Data not saved.");
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(465, 453, 89, 23);
		panel.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Load");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getRowCount() < 1) {
					JOptionPane.showMessageDialog(null, "No record Found");
				} else {
					txtrStudentsInThe.setVisible(false);
					scrollPane.setVisible(true);
					table.setVisible(true);

				}
			}
		});
		btnNewButton_1.setBounds(356, 453, 89, 23);
		panel.add(btnNewButton_1);

		txtrStudentsInThe = new JTextArea();
		txtrStudentsInThe.setFont(new Font("Arial", Font.BOLD, 14));
		txtrStudentsInThe.setText("Students in the applications.");
		txtrStudentsInThe.setBounds(48, 245, 577, 186);
		panel.add(txtrStudentsInThe);
	}
}
