package gui_elements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MyMainWindow extends JFrame {
	private JPanel content_pane;
	private JLabel label_equal_sign;
	private JLabel label_current_sign;
	private JLabel label_sect_description;
	private JLabel label_about_close_zone;
	private JButton button_plus;
	private JButton button_less;
	private JButton button_product;
	private JButton button_division;
	private JButton button_about;
	private JButton button_close;
	private ActionListener button_action_sum;
	private ActionListener button_action_less;
	private ActionListener button_action_product;
	private ActionListener button_action_division;
	private ActionListener button_action_about;
	private ActionListener button_action_close;
	private JTextField operando_1;
	private JTextField operando_2;
	private JTextField resultado;
	private JDialog my_about_dialog;
	

	public MyMainWindow() {
		initialize();
	}

	private void initialize() {
		this.setTitle("Calculadora");
		this.setBounds(100, 100, 510, 230);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.fillFrame();

		this.setVisible(true);

	}

	private void fillFrame() {
		this.content_pane = new JPanel();
		this.content_pane.setLayout(null);
		this.content_pane.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.setContentPane(this.content_pane);

		// Add radio buttons
		this.addInput();

		// Getting actions
		this.addButtonsActions();

		// Add the buttons
		this.addButtons();

		// add button and set action
		// this.addButton();

	}

	private void addInput() {
		// Result
		this.resultado = new JTextField();
		this.resultado.setBounds(280, 20, 209, 23);
		this.resultado.setEditable(false);
		this.content_pane.add(this.resultado);

		// Left
		this.operando_1 = new JTextField();
		this.operando_1.setBounds(20, 20, 110, 23);
		this.content_pane.add(this.operando_1);
		
		// Want to make sure the user writes a double
		this.operando_1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String input = operando_1.getText();
                Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
                if (!pattern.matcher(input).matches()) {
                    operando_1.setText("");
                    resultado.setText("Operando no es double");
                }
            }
        });

		// Label operation type
		this.label_current_sign = new JLabel("?");
		this.label_current_sign.setBounds(135, 20, 10, 23);
		this.content_pane.add(this.label_current_sign);

		// Right
		this.operando_2 = new JTextField();
		this.operando_2.setBounds(150, 20, 110, 23);
		this.content_pane.add(this.operando_2);
		
		// Want to make sure the user writes a double
		this.operando_2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String input = operando_2.getText();
                Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
                if (!pattern.matcher(input).matches()) {
                    operando_2.setText("");
                    resultado.setText("Operando no es double");
                }
            }
        });

		// Label Equal
		this.label_equal_sign = new JLabel("=");
		this.label_equal_sign.setBounds(265, 20, 10, 23);
		this.content_pane.add(this.label_equal_sign);

	}

	private void addButtons() {
		// Labels
		this.label_sect_description = new JLabel("Operaciones para realizar");
		this.label_sect_description.setBounds(20, 65, 200, 23);
		this.content_pane.add(this.label_sect_description);

		this.button_plus = new JButton("+");
		this.button_plus.setBounds(20, 90, 50, 23);
		this.button_plus.addActionListener(this.button_action_sum);
		this.content_pane.add(this.button_plus);

		this.button_less = new JButton("-");
		this.button_less.setBounds(80, 90, 50, 23);
		this.button_less.addActionListener(this.button_action_less);
		this.content_pane.add(this.button_less);

		this.button_product = new JButton("*");
		this.button_product.setBounds(140, 90, 50, 23);
		this.button_product.addActionListener(this.button_action_product);
		this.content_pane.add(this.button_product);

		this.button_division = new JButton("/");
		this.button_division.setBounds(200, 90, 50, 23);
		this.button_division.addActionListener(this.button_action_division);
		this.content_pane.add(this.button_division);

		// Zone for closing and About
		this.label_about_close_zone = new JLabel("Acerca de/Cerrar:");
		this.label_about_close_zone.setBounds(20, 130, 200, 23);
		this.content_pane.add(this.label_about_close_zone);

		this.button_about = new JButton("About");
		this.button_about.setBounds(20, 150, 100, 23);
		this.button_about.addActionListener(this.button_action_about);
		this.content_pane.add(this.button_about);

		this.button_close = new JButton("Cerrar");
		this.button_close.setBounds(150, 150, 100, 23);
		this.button_close.addActionListener(this.button_action_close);
		this.content_pane.add(this.button_close);
	}

	private void actionSum() {
		this.resultado.setText(
				Double.toString(Double.valueOf(this.operando_1.getText()) + Double.valueOf(this.operando_2.getText())));
		this.label_current_sign.setText("+");
	}

	private void actionLess() {
		this.resultado.setText(
				Double.toString(Double.valueOf(this.operando_1.getText()) - Double.valueOf(this.operando_2.getText())));
		this.label_current_sign.setText("-");
	}

	private void actionProduct() {
		this.resultado.setText(
				Double.toString(Double.valueOf(this.operando_1.getText()) * Double.valueOf(this.operando_2.getText())));
		this.label_current_sign.setText("*");
	}

	private void actionDivision() {
		this.resultado.setText(
				Double.toString(Double.valueOf(this.operando_1.getText()) / Double.valueOf(this.operando_2.getText())));
		this.label_current_sign.setText("/");
	}

	private void addButtonsActions() {
		this.button_action_sum = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					actionSum();
				} catch (NumberFormatException ex) {
					operando_1.dispatchEvent(new FocusEvent(operando_1, FocusEvent.FOCUS_LOST));
					operando_2.dispatchEvent(new FocusEvent(operando_2, FocusEvent.FOCUS_LOST));
				}
			}
		};

		this.button_action_less = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					actionLess();
				} catch (NumberFormatException ex) {
					operando_1.dispatchEvent(new FocusEvent(operando_1, FocusEvent.FOCUS_LOST));
					operando_2.dispatchEvent(new FocusEvent(operando_2, FocusEvent.FOCUS_LOST));
				}
			}
		};

		this.button_action_product = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					actionProduct();
				} catch (NumberFormatException ex) {
					operando_1.dispatchEvent(new FocusEvent(operando_1, FocusEvent.FOCUS_LOST));
					operando_2.dispatchEvent(new FocusEvent(operando_2, FocusEvent.FOCUS_LOST));
				}
			}
		};

		this.button_action_division = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					actionDivision();
				} catch (NumberFormatException ex) {
					operando_1.dispatchEvent(new FocusEvent(operando_1, FocusEvent.FOCUS_LOST));
					operando_2.dispatchEvent(new FocusEvent(operando_2, FocusEvent.FOCUS_LOST));
				}
			}
		};

		this.button_action_close = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};

		JFrame this_frame = this;
		this.button_action_about = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				my_about_dialog = new MyAbout(this_frame);
			}
		};
	}

}
