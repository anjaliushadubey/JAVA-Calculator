import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class Calculator 
{
    private Image icon;
    private JFrame frame;
    private Dialog message; 
    private JTextField label;
    private JTextField text;
    private ButtonGroup bGroup; 
    private JRadioButton Button_on;
    private JRadioButton Button_off;
    private JButton Button_0;
    private JButton Button_b;
    private JButton btnClr;
    private JButton Button_1;
    private JButton Button_2;
    private JButton Button_3;
    private JButton Button_4;
    private JButton Button_5;
    private JButton Button_6;
    private JButton Button_7;
    private JButton Button_8;
    private JButton Button_9;
    private JButton Button_de;
    private JButton Button_e;
    private JButton Button_p;
    private JButton Button_m;
    private JButton Button_mu;
    private JButton Button_d;
    private char[]symbols={'/','*','-','+'};
    private String number="";
    private double[]arr_numbers;
    private char[]arr_symbols;
    private int l;
    public static void main(String[] args) 
    {        
        Calculator window=new Calculator();
        window.frame.setVisible(true);
    }

    public Calculator() 
    {
        frameInitialize();
        iconInitialize();
        textInitialize();
        buttonInitialize();
    }

    private void iconInitialize()
    {        
        icon=Toolkit.getDefaultToolkit().getImage("Icon.PNG");
        MediaTracker track=new MediaTracker(frame);    
        track.addImage(icon,0);
        try
        {
            track.waitForID(0);
        }
        catch(Exception ex)
        {
        }
        frame.setIconImage(icon);
    }

    private void frameInitialize() 
    {
        frame = new JFrame("Calculator-Ankit Bhagat");
        frame.setAlwaysOnTop(true);
        frame.getContentPane().setBackground(SystemColor.scrollbar);
        frame.setResizable(false);
        frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 20));
        frame.setBounds(500, 140, 316, 380);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);        
    }

    private void textInitialize()
    {
        text  = new JTextField();
        text.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        text.setBounds(10, 22, 280, 48);
        text.setBackground(Color.WHITE);
        text.setHorizontalAlignment(SwingConstants.RIGHT);
        text.setFont(new Font("Arial", Font.BOLD, 20));
        frame.getContentPane().add(text);
        text.setColumns(10);               

        label=new JTextField();
        label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        label.setBorder(new EmptyBorder(0, 0, 0, 0));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setBackground(SystemColor.scrollbar);
        label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
        label.setBounds(10,4,280,16);
        label.setEnabled(false);
        frame.getContentPane().add(label);    
    }

    private void buttonInitialize()
    {        
        //Button Group
        bGroup=new ButtonGroup();

        //Radio Buttons        
        Button_on = new JRadioButton("ON",true);
        Button_on.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_on.setBackground(SystemColor.scrollbar);
        Button_on.setBounds(20, 80, 50, 20);
        bGroup.add(Button_on);        
        Button_on.setEnabled(false);
        frame.getContentPane().add(Button_on);

        Button_off = new JRadioButton("OFF",false);
        Button_off.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_off.setBackground(SystemColor.scrollbar);
        Button_off.setBounds(20, 100, 50, 20);
        bGroup.add(Button_off);
        frame.getContentPane().add(Button_off);

        Button_on.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ie)
                {
                    Button_on.setEnabled(false);
                    Button_off.setEnabled(true);
                    Button_0.setEnabled(true);
                    Button_1.setEnabled(true);
                    Button_2.setEnabled(true);
                    Button_3.setEnabled(true);
                    Button_4.setEnabled(true);
                    Button_5.setEnabled(true);
                    Button_6.setEnabled(true);
                    Button_7.setEnabled(true);
                    Button_8.setEnabled(true);
                    Button_9.setEnabled(true);
                    Button_p.setEnabled(true);
                    Button_m.setEnabled(true);
                    Button_mu.setEnabled(true);
                    Button_d.setEnabled(true);
                    Button_de.setEnabled(true);
                    Button_e.setEnabled(true);
                    Button_b.setEnabled(true);
                    btnClr.setEnabled(true);
                    text.setEnabled(true);
                    label.setEnabled(true);
                }
            });
        Button_off.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ie)
                {
                    Button_on.setEnabled(true);
                    Button_off.setEnabled(false);
                    Button_0.setEnabled(false);
                    Button_1.setEnabled(false);
                    Button_2.setEnabled(false);
                    Button_3.setEnabled(false);
                    Button_4.setEnabled(false);
                    Button_5.setEnabled(false);
                    Button_6.setEnabled(false);
                    Button_7.setEnabled(false);
                    Button_8.setEnabled(false);
                    Button_9.setEnabled(false);
                    Button_p.setEnabled(false);
                    Button_m.setEnabled(false);
                    Button_mu.setEnabled(false);
                    Button_d.setEnabled(false);
                    Button_de.setEnabled(false);
                    Button_e.setEnabled(false);
                    Button_b.setEnabled(false);
                    btnClr.setEnabled(false);
                    text.setEnabled(false);
                    label.setEnabled(false);
                }
            });

        //Push Buttons

        Button_0 = new JButton("0");
        Button_0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_0.setBorder(UIManager.getBorder("Button.border"));
        Button_0.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    number=text.getText()+"0";
                    text.setText(number.trim());
                }
            });
        Button_0.setBounds(20, 280, 50, 40);
        Button_0.setBackground(SystemColor.scrollbar);
        Button_0.setFont(new Font("Tahoma", Font.BOLD, 20));
        frame.getContentPane().add(Button_0);

        Button_1= new JButton("1");
        Button_1.setBorder(UIManager.getBorder("Button.border"));
        Button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_1.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    number=text.getText()+"1";
                    text.setText(number.trim());
                }
            });
        Button_1.setBounds(20, 230, 50, 40);
        Button_1.setBackground(SystemColor.scrollbar);
        Button_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        frame.getContentPane().add(Button_1);

        Button_2 = new JButton("2");
        Button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_2.setBorder(UIManager.getBorder("Button.border"));
        Button_2.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    number=text.getText()+"2";
                    text.setText(number.trim());
                }
            });
        Button_2.setBounds(90, 230, 50, 40);
        Button_2.setBackground(SystemColor.scrollbar);
        Button_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        frame.getContentPane().add(Button_2);

        Button_3 = new JButton("3");
        Button_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_3.setBorder(UIManager.getBorder("Button.border"));
        Button_3.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    number=text.getText()+"3";
                    text.setText(number.trim());
                }
            });
        Button_3.setBounds(160, 230, 50, 40);
        Button_3.setBackground(SystemColor.scrollbar);
        Button_3.setFont(new Font("Tahoma", Font.BOLD, 20));
        frame.getContentPane().add(Button_3);

        Button_4 = new JButton("4");
        Button_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_4.setBorder(UIManager.getBorder("Button.border"));
        Button_4.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) 
                {
                    number=text.getText()+"4";
                    text.setText(number.trim());
                }
            });
        Button_4.setBounds(20, 180, 50, 40);
        Button_4.setBackground(SystemColor.scrollbar);
        Button_4.setFont(new Font("Tahoma", Font.BOLD, 20));
        frame.getContentPane().add(Button_4);

        Button_5 = new JButton("5");
        Button_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_5.setBorder(UIManager.getBorder("Button.border"));
        Button_5.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    number=text.getText()+"5";
                    text.setText(number.trim());
                }
            });
        Button_5.setBounds(90, 180, 50, 40);
        Button_5.setBackground(SystemColor.scrollbar);
        Button_5.setFont(new Font("Tahoma", Font.BOLD, 20));
        frame.getContentPane().add(Button_5);

        Button_6 = new JButton("6");
        Button_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_6.setBorder(UIManager.getBorder("Button.border"));
        Button_6.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    number=text.getText()+"6";
                    text.setText(number.trim());
                }
            });
        Button_6.setBounds(160, 180, 50, 40);
        Button_6.setBackground(SystemColor.scrollbar);
        Button_6.setFont(new Font("Tahoma", Font.BOLD, 20));
        frame.getContentPane().add(Button_6);

        Button_7 = new JButton("7");
        Button_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_7.setBorder(UIManager.getBorder("Button.border"));
        Button_7.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    number=text.getText()+"7";
                    text.setText(number.trim());
                }
            });
        Button_7.setBounds(20, 130, 50, 40);
        Button_7.setBackground(SystemColor.scrollbar);
        Button_7.setFont(new Font("Tahoma", Font.BOLD, 20));
        frame.getContentPane().add(Button_7);

        Button_8 = new JButton("8");
        Button_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_8.setBorder(UIManager.getBorder("Button.border"));
        Button_8.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    number=text.getText()+"8";
                    text.setText(number.trim());
                }
            });
        Button_8.setBounds(90, 130, 50, 40);
        Button_8.setBackground(SystemColor.scrollbar);
        Button_8.setFont(new Font("Tahoma", Font.BOLD, 20));
        frame.getContentPane().add(Button_8);

        Button_9 = new JButton("9");
        Button_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_9.setBorder(UIManager.getBorder("Button.border"));
        Button_9.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    number=text.getText()+"9";
                    text.setText(number.trim());
                }
            });
        Button_9.setBounds(160, 130, 50, 40);
        Button_9.setBackground(SystemColor.scrollbar);
        Button_9.setFont(new Font("Tahoma", Font.BOLD, 20));
        frame.getContentPane().add(Button_9);

        Button_de = new JButton(".");
        Button_de.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_de.setBorder(UIManager.getBorder("Button.border"));
        Button_de.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    number=text.getText()+".";
                    text.setText(number.trim());
                }
            });
        Button_de.setBounds(90, 280, 50, 40);
        Button_de.setBackground(SystemColor.scrollbar);
        Button_de.setFont(new Font("Tahoma", Font.BOLD, 20));
        frame.getContentPane().add(Button_de);

        Button_e = new JButton("=");
        Button_e.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_e.setBorder(UIManager.getBorder("Button.border"));
        Button_e.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {   
                    label.setEnabled(true);
                    number=text.getText();
                    label.setText(number.trim());
                    number+=" ";
                    try
                    {
                        text.setText(Double.toString(calculate())); 
                    }
                    catch(Exception ex)
                    {
                    	message=new Dialog(frame,"Error",true);
                    	message.add(new Label("Error in the expression!"));
                    	message.setLayout(new FlowLayout());
                    	message.setBounds(533,280,250,100);
                    	message.addWindowListener(new WindowAdapter()
                    	{
                    		public void windowClosing(WindowEvent we)
                    		{
                    			message.setVisible(false);
                    		}
                    	});
                    	message.setVisible(true);
                    }
                }
            });
        Button_e.setBounds(160, 280, 120, 40);
        Button_e.setBackground(SystemColor.scrollbar);
        Button_e.setFont(new Font("Tahoma", Font.BOLD, 20));
        frame.getContentPane().add(Button_e);

        Button_p = new JButton("+");
        Button_p.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_p.setBorder(UIManager.getBorder("Button.border"));
        Button_p.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    number=text.getText()+"+";
                    text.setText(number.trim());
                }
            });
        Button_p.setBounds(230, 80, 50, 40);
        Button_p.setBackground(SystemColor.scrollbar);
        Button_p.setFont(new Font("Tahoma", Font.BOLD, 20));
        frame.getContentPane().add(Button_p);

        Button_m = new JButton("-");
        Button_m.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_m.setBorder(UIManager.getBorder("Button.border"));
        Button_m.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    number=text.getText()+"-";
                    text.setText(number.trim());
                }
            });
        Button_m.setBounds(230, 130, 50, 40);
        Button_m.setBackground(SystemColor.scrollbar);
        Button_m.setFont(new Font("Tahoma", Font.BOLD, 20));
        frame.getContentPane().add(Button_m);

        Button_mu = new JButton("*");
        Button_mu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_mu.setBorder(UIManager.getBorder("Button.border"));
        Button_mu.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    number=text.getText()+"*";
                    text.setText(number.trim());
                }
            });
        Button_mu.setBounds(230, 180, 50, 40);
        Button_mu.setBackground(SystemColor.scrollbar);
        Button_mu.setFont(new Font("Tahoma", Font.BOLD, 20));
        frame.getContentPane().add(Button_mu);

        Button_d = new JButton("/");
        Button_d.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_d.setBorder(UIManager.getBorder("Button.border"));
        Button_d.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    number=text.getText()+"/";
                    text.setText(number.trim());
                }
            });
        Button_d.setBounds(230, 230, 50, 40);
        Button_d.setBackground(SystemColor.scrollbar);
        Button_d.setFont(new Font("Tahoma", Font.BOLD, 20));
        frame.getContentPane().add(Button_d);

        Button_b = new JButton("<--");
        Button_b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_b.setBorder(UIManager.getBorder("Button.border"));
        Button_b.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    try
                    {
                        number=text.getText().substring(0,text.getText().length()-1);
                        text.setText(number.trim());
                    }
                    catch(Exception ex)
                    {
                    	message=new Dialog(frame,"Error",true);
                    	message.add(new Label("What exactally do you want to erase?"));
                    	message.setLayout(new FlowLayout());
                    	message.setBounds(533,280,250,100);
                    	message.addWindowListener(new WindowAdapter()
                    	{
                    		public void windowClosing(WindowEvent we)
                    		{
                    			message.setVisible(false);
                    		}
                    	});
                    	message.setVisible(true);
                    }
                }
            });
        Button_b.setBounds(90, 80, 50, 40);
        Button_b.setBackground(SystemColor.scrollbar);
        Button_b.setFont(new Font("Tahoma", Font.BOLD, 10));
        frame.getContentPane().add(Button_b);

        btnClr = new JButton("clr");
        btnClr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnClr.setBorder(UIManager.getBorder("Button.border"));
        btnClr.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    number="";
                    text.setText(number.trim());
                }
            });
        btnClr.setBounds(160, 80, 50, 40);
        btnClr.setBackground(SystemColor.scrollbar);
        btnClr.setFont(new Font("Tahoma", Font.BOLD, 10));
        frame.getContentPane().add(btnClr);
    }

    public int getNumberOfSymbols()
    {
        int count=0;
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<number.length();j++)
            {
                if(number.charAt(j)==symbols[i])
                    count++;
            }
        }
        return count;
    }    

    public double calculate()
    {        
        arr_symbols=new char[getNumberOfSymbols()];
        arr_numbers=new double[getNumberOfSymbols()+1];
        String num="0";
        double ans=0;
        try
        {
            ans=Double.parseDouble(number);
        }
        catch(Exception e)
        {
        }    
        int a=0;
        for(int i=0;i<number.length();i++)
        {
            if(!checkSymbol(number.charAt(i))&&number.charAt(i)!=' ')
                num+=number.charAt(i);
            else 
            {
                arr_numbers[a]=Double.parseDouble(num);
                num="";
                if(a<arr_symbols.length)
                    arr_symbols[a++]=number.charAt(i);
            }
        }  
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<arr_symbols.length;j++)
            {                
                if(arr_symbols[j]==symbols[i])
                {
                    switch(arr_symbols[j])
                    {
                        case '/':
                        ans=arr_numbers[j]/arr_numbers[j+1];
                        break;
                        case '*':
                        ans=arr_numbers[j]*arr_numbers[j+1];
                        break;
                        case '+':
                        ans=arr_numbers[j]+arr_numbers[j+1];
                        break;
                        case '-':
                        ans=arr_numbers[j]-arr_numbers[j+1];
                    }
                    update(ans,j); 
                    j=-1;
                }
            }
        }
        return ans;
    }

    public boolean checkSymbol(char c)
    {
        for(int i=0;i<4;i++)
        {
            if(symbols[i]==c)
                return true;
        }
        return false;
    }

    public void update(double ans,int j)
    {
        int a=0;
        for(int i=0;i<arr_symbols.length;i++)
        {
            if(i!=j)
                arr_symbols[a++]=arr_symbols[i];
        }
        arr_symbols[a]='.';
        a=0;
        for(int i=0;i<arr_numbers.length;i++)
        {
            if(i==j)
                arr_numbers[a++]=ans;
            if(i!=j&&i!=j+1)
                arr_numbers[a++]=arr_numbers[i];
        }
    }
}