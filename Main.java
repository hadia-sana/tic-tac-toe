import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   static JFrame frame;
    static JPanel panel;
    static JButton []btn;
    static JButton cross;
    static JButton O;
    static JLabel lbl;
    static boolean iscross=true;
    public static void main(String[] args) {
frame=new JFrame();
frame.setBounds(150,150,400,550);
frame.setLayout(null);
frame.setVisible(true);
panel=new JPanel();
panel.setBounds(35,25,300,450);
panel.setLayout(new GridLayout(3,3));
panel.setVisible(true);
btn=new JButton[9];
for(int i=0;i<9;i++){
    btn[i]=new JButton();
    btn[i].setBackground(Color.cyan);
    btn[i].setBorder(new LineBorder(Color.BLACK,2));
    btn[i].setLayout(null);
    btn[i].setVisible(true);

}
        //ImageIcon img1 = new ImageIcon(new ImageIcon("C:\\Users\\Hp\\IdeaProjects\\tictactoe\\img_1.png").getImage().getScaledInstance(btn[0].getWidth(), btn[0].getHeight(), Image.SCALE_SMOOTH));

        ImageIcon img1=new ImageIcon("img_3.png");
        ImageIcon img2=new ImageIcon("img_2.png");
        int [][] combin={
                {0,1,2},
                {3,4,5},
                {6,7,8},
                {0,3,6},
                {1,4,7},
                {2,5,8},
                {0,4,8},
                {2,4,6}

        };

        for(int i=0;i<9;i++){
            int finali=i;

        btn[i].addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                boolean isdraw=true;
                if(iscross){
                btn[finali].setIcon(img1);
                iscross=false;
                btn[finali].setEnabled(false);}
                else{
                    btn[finali].setIcon(img2);
                    iscross=true;
                    btn[finali].setEnabled(false);
                }
                for(int[]arr:combin){
                    if(btn[arr[0]].getIcon()!=null && btn[arr[0]].getIcon().equals(btn[arr[1]].getIcon())&& btn[arr[1]].getIcon().equals(btn[arr[2]].getIcon())){
                        String win=iscross?"0":"X";
                        JOptionPane.showMessageDialog(frame,win+"is winner");
                        for(JButton jj:btn){
                            jj.setIcon(null);
                            iscross=true;
                            jj.setEnabled(true);
                        }
                       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


                    }
                    for(JButton j:btn){
                        if(j.getIcon()==null){
                            isdraw=false;
                        }
                    }
                    if(isdraw){
                        JOptionPane.showMessageDialog(null,"The match is draw");
                        for(JButton jj:btn){
                            jj.setIcon(null);
                            iscross=true;
                            jj.setEnabled(true);
                        }
                    }
                   // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                }
            }
        });}
        for(int i=0;i<9;i++){
           panel.add(btn[i]);
        }




       // ImageIcon img2=new ImageIcon("C:\Users\Hp\IdeaProjects\tictactoe\img.png");


//panel.add(btn[0]);
//btn[0].add(lbl);

frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}