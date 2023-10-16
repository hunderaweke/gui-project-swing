import java.io.File;
import java.text.DecimalFormat;


import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class cart_items extends JFrame {
    private Jpanel mainPanel = new Jpanel;


    private Jpanel clothpanel = new Jpanel;
    private JPanel cartPanel = new Jpanel;
    private Jpanel controlPanel = new Jpanel;


  // code may contain some bugs 
  //********************************************/ */ 
    private String Jlist clothlist;
    private String Jlist Cartlist;
    private double ArrayList price = new ArrayList<>();
//***************************************************** */


    private JButton removeItem = new JButton("remove");
    private JButton exsitBtn = new JButton("Exit");
    private JButton clearall = new JButton("Clear");
    private JButton check = new JButton("check");

public cart_items(){
    Super("Shopping cart System");
    mainPanel.setLayout(new BoarderLayout());
    build_cloth_panel();
    build_cart_panel();
    setcontrolpanel();

    add(mainPanel.setLayout.NORTH);
    setSize(700, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

private void build_cart_panel(){
    cartPanel.setBorder(BorderFactory.createTitledBorder("Shopping cart"));
    DefaultListModel<String> model = new DefaultListModel<>();
    clothlist.addListSelectionListener(){
@Override
Public void valueChanged(ListSectionEvent e){
    If (!e.getValueIsDjusting()){
        String str = (String) clothlist.getSelectedValur();
        model.addElement(str);
    }
} 
    });
   cartList = new Jlist<String>(model);
   JscrollPane ScrollPane = new JScrollPane(cartlis);

   cartPanel.add(ScrollPane);
   mainPanel add(cartPanel, BoarderLayout.EAST);
}

Private Void build_cloth_panel(){
    mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

    ArrayList<String> Cloth = new ArrayList<>(null);
    try{
        Scanner sc = new Scanner(new File())

    }
}
    }
}
    
}
