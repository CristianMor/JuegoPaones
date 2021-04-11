package com.juego;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Resultado extends JDialog implements ActionListener{

    private JButton btnOK;
    private JLabel resultadoTxt, suma;

    public Resultado(Form parent, boolean modal, boolean color, String ganador, int maquina, int persona){
        super(parent, modal);

        setLayout(null);
        setBounds(200, 280, 410, 210);
        setResizable(false);
        setUndecorated(true);
        getContentPane().setBackground(Color.BLACK);

        resultadoTxt= new JLabel(ganador);
        suma= new JLabel(maquina+" + "+persona+" = "+(maquina+persona));

        resultadoTxt.setBounds(20, 30, 390, 30);
        if(color == true){
            resultadoTxt.setForeground(Color.WHITE);
        }else{
            resultadoTxt.setForeground(Color.RED);
        }
        resultadoTxt.setFont(new Font("MONOSPACED", PLAIN, 26));

        suma.setBounds(145, 70, 110, 30);
        suma.setForeground(Color.WHITE);
        suma.setFont(new Font("MONOSPACED", PLAIN, 16));
        suma.setBorder(new LineBorder(Color.WHITE));
        suma.setHorizontalAlignment(SwingConstants.CENTER);
        

        add(resultadoTxt);
        add(suma);

        btnOK= new JButton("Esta bien");
        btnOK.setBounds(105, 115, 200, 40);
        btnOK.setBackground(Color.WHITE);
        btnOK.setForeground(Color.BLACK);
        btnOK.setFocusPainted(false);
        btnOK.setFont(new Font("MONOSPACED", PLAIN, 24));
        add(btnOK);

        btnOK.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnOK){
            setVisible(false);
        }
    }

}