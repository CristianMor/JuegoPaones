/* 1.- Tú serás pares y debes poder elegir del 1 al 5 en cada tirada
   2.- La máquina será nones y elegirá un número del 1 al 5 en cada tirada
   3.- Un texto debe mostrar, en otra ventana, el número que tú elegiste, el que eligió la 
        máquina y quién ha ganado.
   4.- Esta última ventana permitirá volver a la ventana anterior. */

package com.juego;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JOptionPane;

public class Form extends JFrame{

    JButton btnSalir;
    JButton btnUno;
    JButton btnDos;
    JButton btnTres;
    JButton btnCuatro;
    JButton btnCinco;
    JButton btnJugar;
    JButton btnPar; 
    JButton btnNon;
    JLabel valor;
    JLabel paonesTxt;
    JLabel tituloTxt;
    JLabel score;
    private int cont=0;
    private int cpu=0;
    private int person=0;

    public Form(){
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);

        display();
        initBotones();
        accionesBotones();
    }

    private void accionesBotones(){
        btnUno.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                valor.setText("1");
                valor.requestFocus();
            }
        });

        btnDos.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                valor.setText("2");
                valor.requestFocus();
            }
        });

        btnTres.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                valor.setText("3");
                valor.requestFocus();
            }
        });

        btnCuatro.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                valor.setText("4");
                valor.requestFocus();
            }
        });

        btnCinco.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                valor.setText("5");
                valor.requestFocus();
            }
        });

        btnPar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                paonesTxt.setText("PAR");
                btnPar.setEnabled(false);
                btnNon.setEnabled(false);
                valor.requestFocus();
            }
        });

        btnNon.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                paonesTxt.setText("NONES");
                btnNon.setEnabled(false);
                btnPar.setEnabled(false);
                valor.requestFocus();
            }
        });

        btnJugar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                valor.requestFocus();
                String ganador;
                boolean gano;
                if(valor.getText() == "" || paonesTxt.getText() == ""){
                    JOptionPane.showMessageDialog(null, "Debe ingresar un numero y seleccionar una opcion. PAR O NONES", "Error", JOptionPane.WARNING_MESSAGE);
                }else{
                    int maquina= (int) (Math.random()*5+1);
                    cont++;
                    if((maquina+Integer.parseInt(valor.getText()))% 2 == 0){
                        if(paonesTxt.getText() == "PAR"){
                            ganador= "Felicidades haz ganado!";
                            gano= true;
                            person++;
                        }else{
                            ganador= "Lo sentimos haz perdido!";
                            cpu++;
                            gano= false;
                        }
                    }else{
                        if(paonesTxt.getText() == "NONES"){
                            ganador= "Felicidades haz ganado!";
                            person++;
                            gano= true;
                        }else{
                            ganador= "Lo sentimos haz perdido!";
                            cpu++;
                            gano= false;
                        }
                    }
                    score.setText("Juegos: "+cont+" CPU Ganados: "+cpu+" Haz Ganado: "+person);
                    Resultado dialogResult = new Resultado(new Form(), true, gano, ganador, maquina, Integer.parseInt(valor.getText()));
                    dialogResult.setVisible(true);
                }
                
            }
        });

        btnSalir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){ 
                System.exit(0);
            }
        });
    }

    private void display(){
        valor= new JLabel("");
        paonesTxt= new JLabel("");
        tituloTxt= new JLabel("JUGUEMOS PARES Y NONES");
        score= new JLabel();
        
        score.setOpaque(true);
        score.setBackground(Color.WHITE);
        score.setForeground(Color.BLACK);
        score.setFont(new Font("MONOSPACED", PLAIN, 12));
        score.setHorizontalAlignment(SwingConstants.LEFT);
        score.setBounds(5, 270, 390, 30);

        tituloTxt.setOpaque(true);
        tituloTxt.setBackground(Color.WHITE);
        tituloTxt.setForeground(Color.BLACK);
        tituloTxt.setFont(new Font("MONOSPACED", PLAIN, 24));
        tituloTxt.setHorizontalAlignment(SwingConstants.CENTER);
        tituloTxt.setBounds(10, 10, 390, 30);

        paonesTxt.setOpaque(true);
        paonesTxt.setBackground(Color.WHITE);
        paonesTxt.setForeground(Color.BLACK);
        paonesTxt.setFont(new Font("MONOSPACED", PLAIN, 24));
        paonesTxt.setHorizontalAlignment(SwingConstants.CENTER);
        paonesTxt.setBounds(270, 180, 100, 30);

        valor.setOpaque(true);
        valor.setBackground(Color.WHITE);
        valor.setForeground(Color.BLACK);
        valor.setBorder(new LineBorder(Color.BLACK));
        valor.setFont(new Font("MONOSPACED", PLAIN,  24));
        valor.setHorizontalAlignment(SwingConstants.CENTER);
        valor.setFocusable(true);
        valor.setBounds(50, 50, 200, 30);

        add(score);
        add(tituloTxt);
        add(valor);
        add(paonesTxt);

        valor.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e){

            }

            @Override
            public void keyPressed(KeyEvent e){
                String teclado = String.valueOf(e.getKeyChar());

                if("1".equals(teclado) || "2".equals(teclado) || "3".equals(teclado) || "4".equals(teclado) || "5".equals(teclado)){
                    valor.setText(teclado);
                }

                if("1".equals(teclado)){
                    btnUno.setBackground(Color.CYAN);
                    btnUno.setForeground(Color.BLACK);
                    btnUno.setBorder(new LineBorder(Color.BLACK));
                }

                if("2".equals(teclado)){
                    btnDos.setBackground(Color.CYAN);
                    btnDos.setForeground(Color.BLACK);
                    btnDos.setBorder(new LineBorder(Color.BLACK));
                }

                if("3".equals(teclado)){
                    btnTres.setBackground(Color.CYAN);
                    btnTres.setForeground(Color.BLACK);
                    btnTres.setBorder(new LineBorder(Color.BLACK));
                }

                if("4".equals(teclado)){
                    btnCuatro.setBackground(Color.CYAN);
                    btnCuatro.setForeground(Color.BLACK);
                    btnCuatro.setBorder(new LineBorder(Color.BLACK));
                }

                if("5".equals(teclado)){
                    btnCinco.setBackground(Color.CYAN);
                    btnCinco.setForeground(Color.BLACK);
                    btnCinco.setBorder(new LineBorder(Color.BLACK));
                }

                if("n".equals(teclado)){
                    btnPar.setEnabled(true);
                    btnNon.setEnabled(true);
                    paonesTxt.setText("");
                }

            }

            @Override
            public void keyReleased(KeyEvent e){
                btnUno.setBackground(Color.WHITE);
                btnUno.setForeground(Color.BLACK);
                btnUno.setBorder(new LineBorder(Color.BLACK));

                btnDos.setBackground(Color.WHITE);
                btnDos.setForeground(Color.BLACK);
                btnDos.setBorder(new LineBorder(Color.BLACK));

                btnTres.setBackground(Color.WHITE);
                btnTres.setForeground(Color.BLACK);
                btnTres.setBorder(new LineBorder(Color.BLACK));

                btnCuatro.setBackground(Color.WHITE);
                btnCuatro.setForeground(Color.BLACK);
                btnCuatro.setBorder(new LineBorder(Color.BLACK));

                btnCinco.setBackground(Color.WHITE);
                btnCinco.setForeground(Color.BLACK);
                btnCinco.setBorder(new LineBorder(Color.BLACK));
            }
        });
    }

    private void initBotones(){
        btnSalir= new JButton("Salir");
        btnUno= new JButton("1");
        btnDos= new JButton("2");
        btnTres= new JButton("3");
        btnCuatro= new JButton("4");
        btnCinco= new JButton("5");
        btnJugar=new JButton("Jugar");
        btnPar=new JButton("Par");
        btnNon=new JButton("Non");

        btnUno.setFont(new Font("MONOSPACED", PLAIN, 24));
        btnDos.setFont(new Font("MONOSPACED", PLAIN, 24));
        btnTres.setFont(new Font("MONOSPACED", PLAIN, 24));
        btnCuatro.setFont(new Font("MONOSPACED", PLAIN, 24));
        btnCinco.setFont(new Font("MONOSPACED", PLAIN, 24));
        btnSalir.setFont(new Font("MONOSPACED", PLAIN, 16));
        btnJugar.setFont(new Font("MONOSPACED", PLAIN, 20));
        btnPar.setFont(new Font("MONOSPACED", PLAIN, 20));
        btnNon.setFont(new Font("MONOSPACED", PLAIN, 20));

        btnNon.setBounds(270, 145, 100, 30);
        btnPar.setBounds(270, 105, 100, 30);
        btnSalir.setBounds(270, 235, 100, 30);
        btnUno.setBounds(70, 90, 50, 50);
        btnDos.setBounds(125, 90, 50, 50);
        btnTres.setBounds(180, 90, 50, 50);
        btnCuatro.setBounds(70, 145, 50, 50);
        btnCinco.setBounds(180, 145, 50, 50);
        btnJugar.setBounds(50, 205, 200, 30);
        
        btnUno.setOpaque(true);
        btnDos.setOpaque(true);
        btnTres.setOpaque(true);
        btnCuatro.setOpaque(true);
        btnCinco.setOpaque(true);
        btnPar.setOpaque(true);
        btnNon.setOpaque(true);
        btnSalir.setOpaque(true);
        btnJugar.setOpaque(true);

        btnUno.setFocusPainted(false);
        btnDos.setFocusPainted(false);
        btnTres.setFocusPainted(false);
        btnCuatro.setFocusPainted(false);
        btnCinco.setFocusPainted(false);
        btnPar.setFocusPainted(false);
        btnNon.setFocusPainted(false);
        btnSalir.setFocusPainted(false);
        btnJugar.setFocusPainted(false);

        btnUno.setBackground(Color.WHITE);
        btnDos.setBackground(Color.WHITE);
        btnTres.setBackground(Color.WHITE);
        btnCuatro.setBackground(Color.WHITE);
        btnCinco.setBackground(Color.WHITE);
        btnPar.setBackground(Color.WHITE);
        btnNon.setBackground(Color.WHITE);
        btnSalir.setBackground(Color.WHITE);
        btnJugar.setBackground(Color.WHITE);

        btnUno.setBorder(new LineBorder(Color.BLACK));
        btnDos.setBorder(new LineBorder(Color.BLACK));
        btnTres.setBorder(new LineBorder(Color.BLACK));
        btnCuatro.setBorder(new LineBorder(Color.BLACK));
        btnCinco.setBorder(new LineBorder(Color.BLACK));
        btnPar.setBorder(new LineBorder(Color.BLACK));
        btnNon.setBorder(new LineBorder(Color.BLACK));
        btnSalir.setBorder(new LineBorder(Color.BLACK));
        btnJugar.setBorder(new LineBorder(Color.BLACK));

        btnUno.setForeground(Color.BLACK);
        btnDos.setForeground(Color.BLACK);
        btnTres.setForeground(Color.BLACK);
        btnCuatro.setForeground(Color.BLACK);
        btnCinco.setForeground(Color.BLACK);
        btnPar.setForeground(Color.BLACK);
        btnNon.setForeground(Color.BLACK);
        btnSalir.setForeground(Color.BLACK);
        btnJugar.setForeground(Color.BLACK);
        
        add(btnNon);
        add(btnPar);
        add(btnJugar);
        add(btnCinco);
        add(btnCuatro);
        add(btnTres);
        add(btnDos);
        add(btnUno);
        add(btnSalir);
    }

    public static void main(String[] args) {
        Form form = new Form();
        form.setBounds(40, 40, 400, 300);
        form.setVisible(true);
    }
}
