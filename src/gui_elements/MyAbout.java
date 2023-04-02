package gui_elements;

import javax.swing.*;

public class MyAbout extends JDialog {
	
	private JPanel panel;
	private JLabel label_name;
	private JLabel lable_version;
	private JLabel label_author;
	private JLabel label_license;
    
    public MyAbout(JFrame parent) {
        super(parent, "About", true);
        this.setSize(300, 140);
        this.setLocationRelativeTo(parent);

        this.panel = new JPanel();
        this.panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        this.label_name = new JLabel("Calculadora");
        label_name.setAlignmentX(CENTER_ALIGNMENT);
        this.panel.add(this.label_name);

        this.lable_version = new JLabel("Version 1.0");
        this.lable_version.setAlignmentX(CENTER_ALIGNMENT);
        this.panel.add(this.lable_version);

        this.label_author = new JLabel("© 2023 Francisco Parra");
        this.label_author.setAlignmentX(CENTER_ALIGNMENT);
        this.panel.add(this.label_author);
        
        this.label_license = new JLabel("MIT License");
        this.label_license.setAlignmentX(CENTER_ALIGNMENT);
        this.panel.add(this.label_license);

        JButton closeButton = new JButton("Cerrar");
        closeButton.addActionListener(e -> setVisible(false));
        closeButton.setAlignmentX(CENTER_ALIGNMENT);
        this.panel.add(closeButton);

        getContentPane().add(panel);
        setVisible(true);
    }
}