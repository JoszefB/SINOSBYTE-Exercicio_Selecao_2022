package View;

import DAO.AlunoDAO;
import Model.Aluno;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends JDialog {
    private JPanel contentPane;
    private JTabbedPane tabbedPane1;
    private JTextField codAluno;
    private JTextField nomAluno;
    private JTextField nota1;
    private JTextField nota2;
    private JTextField pesquisaCod;
    private JButton salvarButton;
    private JButton pesquisarButton;
    private JLabel codAlP;
    private JPanel pesquisa;
    private JLabel nota1AlP;
    private JLabel nota2AlP;
    private JLabel mediaAlP;
    private JLabel aprovadoAlP;
    private JLabel nomeAlP;
    private JButton buttonOK;
    private JButton buttonCancel;

    public Main() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        /*buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });*/

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aluno al= new Aluno();
                AlunoDAO ad = new AlunoDAO();
                al.setCodAluno(Integer.parseInt(codAluno.getText()));
                al.setNomeAluno(nomAluno.getText());
                al.setNota1(Double.parseDouble(nota1.getText()));
                al.setNota2(Double.parseDouble(nota2.getText()));
                al.setMedia();
                ad.criarAluno(al);
            }
        });
        pesquisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Aluno> al =new ArrayList();
                AlunoDAO ad = new AlunoDAO();
                al=ad.pesquisaAluno(Integer.parseInt(pesquisaCod.getText()));
                codAlP.setText(""+al.get(0).getCodAluno());
                nomeAlP.setText(""+al.get(0).getNomeAluno());
                nota1AlP.setText(""+al.get(0).getNota1());
                nota2AlP.setText(""+al.get(0).getNota2());
                mediaAlP.setText(""+al.get(0).getMedia());
                aprovadoAlP.setText(""+al.get(0).getAprovado());
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Main dialog = new Main();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
