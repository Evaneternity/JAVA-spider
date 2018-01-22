package hahaha;

import java.awt.*; 
import java.awt.event.*;
import java.io.*;
import javax.swing.*; 
	
public class JSQ { 
    private JFrame frame; 
    private JTextArea textArea; 
    private JMenuBar menuBar; 
    private JMenu file,format,search,help; 
    private JMenuItem open,exit; 
    private JMenuItem font,color,background,speed; 
    private JMenuItem find,changeto;  
    private JMenuItem helps,about;
    private Boolean autoLineWrap=true;
    private String fileName = "未命名";//文件名
    //private File currentFile ;
    private JScrollPane jsp;
   	private JScrollBar jsb;
   	private Speed sped;
   	private font font1;
   	int delay = 10;
    Timer timer = new Timer(delay,new ActionListener() {
	      public void actionPerformed(ActionEvent evt) {
	    	jsb.setValue(jsb.getValue()+jsb.getUnitIncrement());
	      }
	} );

    
    public JSQ(){ 
        frame = new JFrame(); 
        frame.setTitle("未命名"); 
        frame.setLayout(new BorderLayout()); 
        textArea = new JTextArea(); 
        textArea.setFont(new Font("宋体",Font.PLAIN,18));//设置默认字体样式字号 
        //set input textArea 设置编辑区 
        
        textArea.setText(""); 
        textArea.setEditable(false); 
        textArea.setLineWrap(autoLineWrap);//设置自动换行 
        jsp = new JScrollPane(textArea);//set Scroll  
      	jsb = jsp.getVerticalScrollBar();
        jsb.addAdjustmentListener(new AdjustmentListener(){
    			public void adjustmentValueChanged(AdjustmentEvent e) {
    				int i;
    				i = jsb.getUnitIncrement();
    				System.out.println(i);
    	}});
        frame.add(jsp,BorderLayout.CENTER); 
        //菜单 
        menuBar = new JMenuBar(); 
        file = new JMenu("文件"); 
        file.setMnemonic('F');  
        format = new JMenu("格式"); 
        search = new JMenu("搜索"); 
        help = new JMenu("帮助"); 
        menuBar.add(file); 
        menuBar.add(format); 
        menuBar.add(search);  
        menuBar.add(help);
        //文件菜单项  
        open = new JMenuItem("打开...",KeyEvent.VK_O); 
        exit = new JMenuItem("退出"); 
        file.add(open); 
        file.add(exit);
        //格式菜单项 
      //  autoLine = new JCheckBoxMenuItem("自动换行"); 
        font = new JMenuItem("字体..."); 
        color = new JMenuItem("颜色..."); 
        background = new JMenuItem("背景颜色...");
        speed = new JMenuItem("滚屏速度...");
//        format.add(autoLine); 
        format.add(font); 
        format.add(color); 
        format.add(background); 
        format.add(speed); 
        //搜索菜单项 
        find = new JMenuItem("查找..."); 
        changeto = new JMenuItem("转到...");
        search.add(find); 
        search.add(changeto);
        //帮助菜单项 
        helps = new JMenuItem("帮助"); 
        about = new JMenuItem("关于");
        help.add(helps); 
        help.add(about);
        //设置菜单条 
        menuBar.add(file); 
        menuBar.add(format); 
        menuBar.add(search); 
        menuBar.add(help);
        frame.setJMenuBar(menuBar); 
        //sped///
        sped = new Speed(jsb,timer);
        font1 = new font(textArea);
        //调用监听方法
        addEventHandler();
        //////
        textArea.addMouseListener(new MouseListener(){

    		public void mouseClicked(MouseEvent e) {	 
    		if(e.getClickCount()==2){
    			timer.start();
    		} 
    		if(e.getClickCount()==1){
    			timer.stop();
    		}
    		
    		}
    		public void mouseEntered(MouseEvent arg0) {
    		}
    		public void mouseExited(MouseEvent arg0) {
    		}
    		public void mousePressed(MouseEvent arg0) {	
    		}
    		public void mouseReleased(MouseEvent arg0) {
    		}});
        //监听上下键//
        textArea.addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()== KeyEvent.VK_UP){
					jsb.setValue(jsb.getValue()-jsb.getUnitIncrement());
				}
				if(arg0.getKeyCode()== KeyEvent.VK_DOWN){
					jsb.setValue(jsb.getValue()+jsb.getUnitIncrement());
				}			
			}
			public void keyReleased(KeyEvent arg0) {}
			public void keyTyped(KeyEvent arg0) {
			}});
        //
        textArea.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {	 
			if(e.getClickCount()==2){
				timer.start();
			} 
			if(e.getClickCount()==1){
				timer.stop();
			}
			
			}
			public void mouseEntered(MouseEvent arg0) {
			}
			public void mouseExited(MouseEvent arg0) {
			}
			public void mousePressed(MouseEvent arg0) {	
			}
			public void mouseReleased(MouseEvent arg0) {
			}});

    }   
    ///////////初始化frame////////////////
    protected  void frameInit() {
    	Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); 
        frame.setSize(d.width,d.height); 
        frame.setVisible(true); 
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            frame.dispose();
        }
        });
        Dimension b = frame.getSize();
    }
    
    private void addEventHandler(){ 
        //文件项的监听
    	open.addActionListener(new ActionListener() 
        {public void actionPerformed(ActionEvent e){fileOpen(null);jsb.setValue(0);} } 
        ); 
        exit.addActionListener(new ActionListener() 
        {public void actionPerformed(ActionEvent e){fileExit();} } 
        ); 
        //格式菜单的监听
        font.addActionListener(new ActionListener() 
        {public void actionPerformed(ActionEvent e){font1.addEventHandler();} } 
        ); 
        color.addActionListener(new ActionListener() 
        {public void actionPerformed(ActionEvent e){formatColor();} } 
        ); 
        background.addActionListener(new ActionListener() 
        {public void actionPerformed(ActionEvent e){formatBackground();} } 
        ); 
        
        speed.addActionListener(new ActionListener() 
       {public void actionPerformed(ActionEvent e){ sped.liser();} } 
       ); 
    }

    //////////文件项的方法/////////////////////////
    private void fileOpen(String bookname){ 
    	
    	File file;
    	if (bookname==null){
    		textArea.setText(""); 
            JFileChooser fileChooser=new JFileChooser(); 
            fileChooser.showOpenDialog(frame); 
            file=fileChooser.getSelectedFile(); 
    	}
    	else{
    		file=new File(bookname);
    	}
        
        if(file==null) return; 
        fileName = file.getName();//获得文件名 
        frame.setTitle(file.getAbsolutePath()); 
        FileInputStream fis=null; 
        BufferedReader br=null; 
        try { 
            fis=new FileInputStream(file); 
            br=new BufferedReader(new InputStreamReader(fis)); 
            String str=null; 
            while((str=br.readLine())!=null){ 
                textArea.append(str+"\n"); 
            } 
            System.out.println("打开成功");
            textArea.setCaretPosition(0);
        } catch (IOException e1) { 
            JOptionPane.showMessageDialog(frame,"文件不存在或已被损坏"); 
        }finally{ 
            if(br!=null)try{br.close();}catch(IOException e){} 
            if(fis!=null)try{fis.close();}catch(IOException e){} 
        } 
    } 
    private void fileExit(){ 
        int option = -1; 
        Object options[] = {"Yes","No"}; 
        option = JOptionPane.showOptionDialog(frame,"是否退出阅读？","exit",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]); 
        switch(option) { 
            case JOptionPane.YES_OPTION: 
              frame.dispose(); 
            case JOptionPane.NO_OPTION: 
              return; 
            default: 
              frame.dispose();
      } 
  } 
////////////////////////////////////////////////////////////
/////////////////格式项的方法/////////////////////////////////
    private void formatColor(){ 
        //弹出颜色色选择器对话框 
        Color color=JColorChooser.showDialog(textArea, "选择颜色", Color.BLACK); 
        textArea.setForeground(color); 
    } 
    private void formatBackground(){ 
        //弹出颜色色选择器对话框 
        Color color=JColorChooser.showDialog(textArea, "选择颜色", Color.BLACK); 
        textArea.setBackground(color); 
    } 
  //////////////////////////////////////////////////////////////
   
    public static void main(String s){
    	JSQ nt = new JSQ();
    	nt.frameInit();
    	nt.fileOpen(s);
    	
    	
    }
    
}

class font{ 
    private JTextArea textArea; 
    private JButton ok,cancel; 
    private JComboBox fontName,fontSize,fontStyle; 
    GraphicsEnvironment ge;//定义系统字体对象 
    String[]    size = {"8","10","12","14","16","18","20","22","24","26","28","32","36","48","72","96"}; 
    String[]    style= {"PLAIN","BOLD","ITALIC"}; 
    JFrame jf = new JFrame("字体设置"); 
    public font(JTextArea textArea){ 
        this.textArea=textArea; 
        JLabel label1=new JLabel("    字体                                         "); 
        JLabel label2=new JLabel(" 字号        "); 
        JLabel label3=new JLabel(" 样式        "); 
        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();//获取系统字体 
        String[] fontname = ge.getAvailableFontFamilyNames(); 
        fontName = new JComboBox(fontname); 
        fontSize = new JComboBox(size); 
        fontStyle = new JComboBox(style); 
        ok = new JButton("确定"); 
        cancel = new JButton("取消"); 
        jf.setLayout(new BorderLayout()); 
        JPanel p1 = new JPanel(); 
        JPanel p2 = new JPanel(); 
        JPanel p3 = new JPanel(); 
        p1.add(label1); 
        p1.add(label2); 
        p1.add(label3); 
        p2.add(fontName); 
        p2.add(fontSize); 
        p2.add(fontStyle); 
        p3.add(ok); 
        p3.add(cancel); 
        jf.add(p1,BorderLayout.NORTH); 
        jf.add(p2,BorderLayout.CENTER); 
        jf.add(p3,BorderLayout.SOUTH); 
        jf.setSize(360,200); 
        jf.setLocation(300,200); 
        jf.setVisible(false); 
        jf.setResizable(false); 
        //addEventHandler(); 
    } 
    void addEventHandler(){ 
    	jf.setVisible(true);
        ok.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e){ 
                String n1 = (String)fontName.getSelectedItem(); 
                int  n2 = fontStyle.getSelectedIndex(); 
                String n3 = (String)fontSize.getSelectedItem(); 
                textArea.setFont(new Font(n1,n2,Integer.parseInt(n3))); 
                jf.setVisible(false);
            } 
        }); 
        cancel.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e){ 
                jf.setVisible(false);// 
            } 
        }         
        ); 
    } 
}

class Speed implements ItemListener{
	private JScrollBar jsb; 
	private JFrame jfrm;
	private JLabel jlb1;
	//JLabel jlb2;
	private JButton jbt;
	//private JCheckBox jcheckbox;
	private JComboBox jcbb;
	Integer sudu;
	Timer timer;
	private Integer msg[] = {1,10,18,36,48,66,80,90};
	public Speed(final JScrollBar jsb,final Timer timer){
		this.jsb= jsb;
		this.timer=timer;
    	jfrm = new JFrame();
    	jlb1 = new JLabel("滚屏速度");
    	jbt = new JButton("确定");
    	//jcheckbox = new JCheckBox("自动滚屏");
    	jcbb = new JComboBox(msg);
    	jfrm.setLayout(new FlowLayout());
    	jfrm.add(jlb1);
    	jfrm.add(jcbb);
    	//jfrm.add(jcheckbox);
    	jfrm.add(jbt);
    	jfrm.setVisible(false);
    	jcbb.setEditable(true);
    	jfrm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    	jfrm.pack();
	}
	void liser(){
		jfrm.setVisible(true);
///////监听复选框///////////////////////////
    	jcbb.addItemListener(this);
    /*	jcbb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				jcbb.setSelectedIndex(jcbb.getSelectedIndex());
			}});*/
/////////监听按钮//////////////////////////
    	jbt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				jfrm.setVisible(false);
			}});
   //////////////////////////////////////

    /*	jcheckbox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(jcheckbox.isSelected()==false){
					System.out.println("false");
					timer.stop();
				}
				if(jcheckbox.isSelected()==true){
					timer.start();
				}
                 }} );*/
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		sudu =(Integer) jcbb.getSelectedItem();
		//jcbb.setSelectedItem(msg);
		//jcbb.updateUI() ;
		jsb.setUnitIncrement(sudu.intValue());
	}
}



