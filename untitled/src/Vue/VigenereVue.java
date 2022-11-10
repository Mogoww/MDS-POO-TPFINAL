package Vue;

import Controller.Cesar2Controller;
import Controller.VigenereController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class VigenereVue {
    //-------------------------------------------ATTRIBUTES-------------------------------------------
    private VigenereController controller;
    private JFrame encryptJFrame = new JFrame("Vigenere Cipher");
    JTextField inputTextField = new JTextField("", 20);
    JTextField outputTextField = new JTextField("", 20);

    // swirch between encrypt and decrypt mode
    JRadioButton encryptRadioButton = new JRadioButton("Encrypt", true);
    JRadioButton decryptRadioButton = new JRadioButton("Decrypt");

    // Buttons vor valide
    JButton buttonEncrypt = new JButton("Encrypt/Decrypt");

    // add text field for key
    JTextField keyTextField = new JTextField("", 20);



    //-------------------------------------------CONSTRUCTOR-------------------------------------------
    public VigenereVue(VigenereController controller, int posX, int posY) {
        this.controller = controller;

        // display input text field and output text field


        encryptJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        encryptJFrame.setSize(400, 400);
        encryptJFrame.setLocation(posX, posY);
        encryptJFrame.setVisible(true);

        // add 2 columns
        JPanel panel = new JPanel(new GridLayout(0, 3));
        panel.add(inputTextField);
        panel.add(outputTextField);

        JPanel panelChoice = new JPanel(new GridLayout(2, 1));
        ButtonGroup group = new ButtonGroup();
        group.add(encryptRadioButton);
        group.add(decryptRadioButton);

        panelChoice.add(encryptRadioButton);
        panelChoice.add(decryptRadioButton);

        panel.add(panelChoice);

        // add key text field
        panel.add(keyTextField);

        encryptJFrame.add(buttonEncrypt, BorderLayout.SOUTH);
        encryptJFrame.add(panel);

        // add listeners to the radio buttons and switch mode
        encryptRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.encode(inputTextField.getText());
            }
        });

        decryptRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.decode(inputTextField.getText());
            }
        });

        buttonEncrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get the text from key text field
                String key = keyTextField.getText();
                // check if the key is valid
                if (key.matches("[a-zA-Z]+")) {
                    // check if the key is valid
                    if (encryptRadioButton.isSelected()) {
                        controller.setKey(key);
                        controller.encode(inputTextField.getText());
                        outputTextField.setText(controller.getCypher());
                    } else {
                        controller.setKey(key);
                        controller.decode(inputTextField.getText());
                        outputTextField.setText(controller.getPlain());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Key is not valid");
                }


            }
        });


    }

    //-------------------------------------------METHODS-------------------------------------------
    //update the output
    public void update(Observable o, Object arg) {
        if(this.decryptRadioButton.isSelected()){
            outputTextField.setText(controller.getCypher());
        }else{
            outputTextField.setText(controller.getPlain());
        }
    }


}
