import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Frame extends JFrame{
	
	public Frame() {
			
		setTitle("Grade Horária");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
			
		//Description section
		JLabel lblQuestion = new JLabel("Montar grade com maior número de disciplinas");
		lblQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblQuestion);
			
		//separating label and first button
		contentPane.add(Box.createRigidArea(new Dimension(40,40)));
			
		JButton btnShow = new JButton("Gerar classes aleatórias");
		btnShow.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(btnShow);
	
		
		//separating button and first table
		contentPane.add(Box.createRigidArea(new Dimension(40,40)));
		
		//table modeling - with all elements
		JLabel table1Title = new JLabel("Tabela com todos os elementos");
		table1Title.setAlignmentX(Component.CENTER_ALIGNMENT);
		table1Title.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(table1Title);
		
		JTable tableNotSorted = new JTable();
		tableNotSorted.setModel(getTableModel());
		contentPane.add(tableNotSorted);
		
		//separating talbe1 and table2
		contentPane.add(Box.createRigidArea(new Dimension(40,40)));
		
		//table modeling - with only selected elements
		JLabel table2Title = new JLabel("Tabela com elementos do Interval Scheduling");
		table2Title.setAlignmentX(Component.CENTER_ALIGNMENT);
		table2Title.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(table2Title);
		
		JTable tableSorted = new JTable();;
		tableSorted.setModel(getTableModel());
		contentPane.add(tableSorted);
		
		//button listener
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				revertToModel(tableSorted, getTableModel());
				revertToModel(tableNotSorted, getTableModel());
				
				ArrayList<Class> randomClasses = Class.getRandomClasses();
				
				showRandomData(tableNotSorted, randomClasses);
				showRandomData(tableSorted, Class.getSortedClasses(randomClasses));
				
			}
		});

	}
	
	private DefaultTableModel getTableModel() {
		Vector<String> COLUMN_NAME_VECTOR = new Vector<String>(
				Arrays.asList(new String[] {"--","A", "B","C","D","E","F",})
		);
	
		return new DefaultTableModel(getTableBaseMatrix(), COLUMN_NAME_VECTOR);
	}
	
	private void revertToModel(JTable table, DefaultTableModel model) {
		
		for (int i = 0; i < model.getRowCount(); i++) {
			for (int j = 0; j < model.getColumnCount(); j++) {
				
				table.setValueAt(model.getValueAt(i, j), i, j);
			}
		}
	}
	
	private Vector<Vector<String>> getTableBaseMatrix() {
		
		Vector<Vector<String>> matrix = new Vector<Vector<String>>();
		
		for (int i = 0; i < 10 ; i++) {
			Vector<String> row = new Vector<String>();
			for (int j = 0; j < 7; j++) {

				String rowText = " ";
                if (i == 0 && j == 0) {
                	
                	rowText = " -- ";
                	
                } else if (i == 0) {
                	
                    if (j == 1) {
                    	rowText = " Segunda ";
                    } else if (j == 2) {
                    	rowText = " Terça ";
                    } else if (j == 3) {
                    	rowText = " Quarta ";
                    } else if (j == 4) {
                    	rowText = "  Quinta  ";
                    } else if (j == 5) {
                    	rowText = " Sexta ";
                    } else if (j == 6) {
                    	rowText = " Sábado ";
                    }
                  
                } else if( j == 0) {

                    if(i == 1){
                    	rowText = " 08h/09h ";
                    }else if (i == 2) {
                    	rowText = " 09h/10h ";
                    } else if (i == 3) {
                    	rowText = " 10h/11h " ;
                    } else if (i == 4) {
                    	rowText = " 11h/12h ";
                    } else if (i == 5) {
                    	rowText = "  12h/13h  ";
                    } else if (i == 6) {
                    	rowText = " 13h/14h ";
                    } else if (i == 7) {
                    	rowText = " 14h/15h ";
                    } else if (i == 8) {
                    	rowText = " 15h/16h ";
                    }else if (i == 9) {
                    	rowText = " 16h/17h ";
                    }else if (i == 10) {
                    	rowText = " 17h/18h ";
                    }
                   
                } 
  
                row.add(rowText);
			}
            matrix.add(row);
      
        }
		
		return matrix;

	}
	
	private void showRandomData(JTable table, ArrayList<Class> classes) {
		
		for(int i = 0; i < classes.size(); i++) {
			
			for(int j = 1; j <= classes.get(i).duration; j++) {
				
				int row = classes.get(i).startTime - 8 + j;
				int column = classes.get(i).dayOfTheWeek;
				
				String text = table.getValueAt(row, column).toString();
				
				if (text == " ") {
					text = classes.get(i).name;
				} else {
					text += " / " + classes.get(i).name;
				}
				
				table.setValueAt(text, row, column);
			}
		
		}
		
	}
	
					

}
