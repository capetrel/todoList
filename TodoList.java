package todoList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Created by capetrel on 04/05/2016.
 */
public class TodoList {
    JFrame todolist = new JFrame();
    java.util.List<String> todoItem = new ArrayList<>();

    public TodoList () {


//------------------ initialisation panneau conteneur -----------------------

        JPanel conteneur = new JPanel();

//------------- initialisation des parties et éléments interacrifs ----------
        JPanel header = new JPanel();
        JPanel titre = new JPanel();
        JPanel corp = new JPanel();
        JPanel footer = new JPanel();

        JTextField champDescription = new JTextField(22);

        JList listeTodo = new JList();

        JButton ajouter = new JButton("Ajouter");
        ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //champDescription.getText();
                String recChampDescription = champDescription.getText(); //memoriser champ description dans une variable
                if (recChampDescription.length() != 0) {
                    todoItem.add(recChampDescription); //inserer la variable memoriser dans le tableau todoItem
                    champDescription.setText(""); //vider champdescription
                    listeTodo.setListData(todoItem.toArray());
                }else{
                    JOptionPane.showMessageDialog(null, "Le champ est vide", "Erreur", JOptionPane.ERROR_MESSAGE);// boite de dialogue message d'erreur
                }
            }
        });
        JButton supprimer = new JButton("Supprimer");
        supprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String recValeurChoisie = (String) listeTodo.getSelectedValue();
                todoItem.remove(recValeurChoisie);
                listeTodo.setListData(todoItem.toArray());
                /*
                Collection recMultiSelec = new Collection();
                recMultiSelec = listeTodo.getSelectedValuesList();
                todoItem.removeAll(recMultiSelec);
                listeTodo.setListData(todoItem.toArray());
                */
            }
        });

//-------------------- initialisation header -------------------------

        header.setLayout(new FlowLayout());
        header.add(new JLabel("Description"));
        header.add(champDescription);
        header.add(ajouter);

//------------------ Initialisation titre Jliste ______________________

        titre.add(new JLabel("Choses à faire :"));

//------------------ Initialisation Jliste ____________________________

        corp.add(listeTodo);


//------------------ Initialisation footer ____________________________

        footer.setLayout(new FlowLayout());
        footer.add(supprimer);


//----------- organisation et affichage conteneur et éléments _________

        conteneur.setLayout(new BorderLayout());
        conteneur.add(header, BorderLayout.BEFORE_FIRST_LINE);
        conteneur.add(titre, BorderLayout.BEFORE_LINE_BEGINS);
        conteneur.add(listeTodo, BorderLayout.CENTER);
        conteneur.add(footer, BorderLayout.SOUTH);

        todolist.setContentPane(conteneur);
        todolist.setTitle("Liste des choses à faire");
        todolist.setSize(500, 400);
        todolist.setLocation(400, 100);
        todolist.setResizable(false);
        todolist.setVisible(true);
        todolist.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



    }

}
