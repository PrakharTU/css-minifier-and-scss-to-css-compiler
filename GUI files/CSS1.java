package minifierandpreprocessor;

import java.util.Scanner;
import java.util.*;
import java.io.FileReader;
/**
 *
 * @author Prakhar Gupta
 */
public class CSS1 extends javax.swing.JFrame {
static int selectedRadioBtn=1;
    public CSS1() {
        initComponents();
        minifyBtn.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        minifyBtn = new javax.swing.JRadioButton();
        compileBtn = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Serif", 2, 18)); // NOI18N
        jLabel1.setText("Select an option");

        minifyBtn.setText("Minify CSS");
        minifyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minifyBtnActionPerformed(evt);
            }
        });

        compileBtn.setText("Compile SASS");
        compileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compileBtnActionPerformed(evt);
            }
        });

        jButton1.setText("Continue");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(minifyBtn)
                        .addGap(54, 54, 54)
                        .addComponent(compileBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jButton1)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minifyBtn)
                    .addComponent(compileBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        
    
    private void minifyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minifyBtnActionPerformed
        compileBtn.setSelected(false);
        minifyBtn.setSelected(true);
        selectedRadioBtn=1;
    }//GEN-LAST:event_minifyBtnActionPerformed

    private void compileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compileBtnActionPerformed
        minifyBtn.setSelected(false);
        compileBtn.setSelected(true);
        selectedRadioBtn=2;
    }//GEN-LAST:event_compileBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new CSS().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CSS1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CSS1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CSS1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CSS1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CSS1 s1=new CSS1();
                s1.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton compileBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton minifyBtn;
    // End of variables declaration//GEN-END:variables
}
class className{
	String name;
	className next;
	className prev;
	className(String s)
	{
		name =s;
		next =null;
	}
	
}
class Node{
	String prop;
	char ch;
	Node next;
	
	Node(String s,char c)
	{
		prop =s;
		ch =c;
		next = null;
	}
}
class preProcessorfinal
{
	static Node Nodetop;
	static className classtop;
	static className classbottom;
	public static void pushclass(String s)
	{
		className temp = new className(s);
		if(classtop == null)
		{
			classtop = temp;
			classbottom = temp;
		}
		else
		{
			classtop.next = temp;
			temp.prev = classtop;
			classtop = temp;
		}
	}
	public static String variable(String str)
    {
		/*FileReader file=new FileReader(path);
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\\Z");
        String str = sc.next();
		*/
		int i=0;
		int state=1;
		/*
			if state ==1 then trim and add to hashmap;
			if state==2 then replace that string with corresponding value
		*/
		//System.out.println("Str is\n"+str);
		String part1="";
		String part2="";
		HashMap<String, String> map = new HashMap<>();
		while(i<str.length()){
			char ch=str.charAt(i);
			if(ch=='{'){
				state=2;
			}
			if(ch=='}'){
				state=1;
			}
			if(ch=='$'){
				if(state==1){
					part1="";
					while(i<str.length()&&ch!=';'){
						part1+=ch;
						ch=str.charAt(++i);
					}
					String [] arrOfStr = part1.split(":", 2);        
					map.put(arrOfStr[0].trim(),arrOfStr[1].trim());
				}
				if(state==2){
					part2="";
					int end3 = 0;
					int start3 = i;
					while(i<str.length()&&ch!=';'){
						part2+=ch;
						ch=str.charAt(++i);
						end3 = i;
					}
					part2=part2.trim();
					 if (map.containsKey(part2)) 
					{	String a = map.get(part2);
						
						String s1 = str.substring(0,start3);
						s1 = s1 + a;
						s1 = s1 + str.substring(end3);
						//System.out.println("\n S1 is \n"+s1);
						str = s1;
						
					}
				}
			}
			else
				i++;			
		}
        
         //System.out.println(str);
		// System.out.println("------------------------------------------------------------");
        // System.out.println("\nAnswer is");
		 str = str.replaceAll("\\$.*?;","");
		 //System.out.println(str);
		 return str;
    }
	public static void popclass()
	{
		if(classtop!=null)
		{
			System.out.println();
			className ptr = classbottom;
			while(ptr!=null)
			{
				System.out.print(ptr.name+" ");
				ptr = ptr.next;
			}
			classtop = classtop.prev;
			if(classtop!=null)
			classtop.next=null;
			
			//System.out.println();
			//System.out.println("\nCurrent top class is :"+classtop.name);
		}
		
	}
	public static void pushprop(String s,char c)
	{
		Node temp = new Node(s,c);
		if(Nodetop == null)
			Nodetop = temp;
		else
		{
			temp.next = Nodetop;
			Nodetop = temp;
		}
	}
	public static void popprop()
	{
		if(Nodetop == null)
			return ;
		else
		{
			Node ptr= Nodetop;
			System.out.print("\n"+ptr.prop+";");
			Nodetop = Nodetop.next;
			
		}
			
	}
	public static void nesting(String path) throws Exception
	{
		FileReader file=new FileReader(path);
		Scanner sc = new Scanner(file);
		sc.useDelimiter("\\Z");
		String s = sc.next();
		System.out.println("\n------------------------------------------------------\nInput File is : \n"+s);
		s = variable(s);
		//System.out.println("\nStep -1 : After variable preprocessing : \n"+s);
		s = s.replaceAll("\\/\\*.*?\\*\\/", "");  
		//System.out.println("\nStep -2 : After removing comments: \n"+s);
		s = s.replaceAll("\r\n", "").replaceAll("\t", "").trim().replaceAll(" +", " ").toLowerCase();
		//System.out.println("\nInput String is : \n"+s);
		
		//System.out.println("\nStep -3 : After preprocessing the nesting: \n");
		
		System.out.println("\n\n------------------------------------------------------\nPreprocessed  file is");
		int i=0;
		String Parentname = null;
		int start=0,end =0,end1=0,child1=0,count = 0,start1=0,flag = 0;
		//Nesting
		while(i<s.length())
		{
			//System.out.println("The character is "+s.charAt(i));
			if(s.charAt(i)=='{' && flag == 0)
				{
					pushprop(null,'{');
					end= i-1;
					Parentname = s.substring(start,end+1);
					Parentname = Parentname.trim();
					//System.out.println("Parent is "+Parentname);
					pushclass(Parentname);
					flag = 1;
					start1 = i+1;
					
				}
				else if(s.charAt(i) == ';')
				{
					end1=i-1;
					//System.out.println("Start1 is : "+ start1 +" End1 is : "+end1);
					//System.out.println(s.charAt(start1)+" "+s.charAt(end1));
					String prop = s.substring(start1,end1+1);
					prop = prop.trim();
					pushprop(prop,'\0');
					//System.out.println("Property is : "+prop);
					start1 = i+1;
				}
				else if(s.charAt(i)=='{' && flag == 1)
				{
					pushprop(null,'{');
					end1= i-1;
					String childname = s.substring(start1,end1+1);
					childname = childname.trim();
					childname = childname.replaceAll("\\{","");
					childname = childname.replaceAll("\r\n"," ").replaceAll("\t", "").trim().replaceAll(" +", " ");
					//childname = Parentname+" "+childname;
					//System.out.println("Child is "+childname);
					pushclass(childname);
					start1 = i+1;
					count++;
				}
				else if(s.charAt(i)=='}' &&count !=0)
				{
				
					start1 = i+1;
					count--;
					//System.out.print("\n\n cHILD Class is :");
					popclass();
					System.out.print("{");
					while(Nodetop.ch != '{')
						{
							popprop();
						}
					System.out.print("\n}");
						Nodetop = Nodetop.next;
						System.out.println();
				}
				else if(s.charAt(i)=='}' &&count ==0)
				{
					start = i+1;
					int check =0;
					//System.out.println("\n\nParent finished");
					if(Nodetop.next!=null)
					{	
						check =1;
						System.out.print("\n");
						popclass();
						System.out.print("{");
						while(Nodetop.ch != '{')
							{
								popprop();
							}
						System.out.println("\n}");
					}
						
						Nodetop = Nodetop.next;
						if(check == 0)//Class waala stack empty nahi hua as popclass run nahi karwaya...usme ek class reh gyi
						{
							classtop = classtop.prev;
							if(classtop!=null)
							classtop.next=null;
						}
						System.out.println();
					flag =0;
				}
			i++;
		}
		
		
		
	}
	/*public static void main( String args[]) throws Exception
	{
		
		String path = "C:/Users/HP/Desktop/abc2.txt";
		nesting(path);
		
		
	}
	*/
}


class BSTNode{
	String name;// this will be the name of class or id or simple tag
	StyleNode data; // data will contain the address of head of main linked list;
	BSTNode left,right;
	BSTNode(String name){
		this.name=name;
		//data=d;
		left=null;
		right=null;
	}
}
class StyleNode{
	String property;
	String value;
	boolean isimp;
	StyleNode next;
	//if value is important, then boolean must be set true;
	StyleNode(String property, String value, boolean isimp){
		this.property=property;
		this.value=value;
		this.isimp=isimp; 
		next=null;
	}
}
class importfiles{
	String filepath;
	importfiles next;
	
	importfiles(String fp)
	{
		filepath = fp;
		next = null;
	}
}
class combined{
	static BSTNode root;
	static importfiles importhead ;

	public static BSTNode insert(BSTNode root1, String name, StyleNode d)
	{
		name = name.toLowerCase();
		if(root1 == null)
		{
			
			root1 = new BSTNode(name);
			root1.data = d;
			//System.out.println("\nInsert in the LL "+" Standing Node "+root1.name);
			//displayLL(root1.data);	
		}
		else if(((root1.name).compareTo(name))==0)
		{
			//System.out.println("\nInsert in the LL "+" Standing Node "+root1.name);
			
			if(root1.data == null)
			root1.data = d;
			
			else
			{
				StyleNode ptr = root1.data;
				StyleNode prev = null;
				while(ptr!=null)
				{
					if(((ptr.property).compareTo(d.property))==0)
						break;
					
					prev = ptr;
					ptr= ptr.next;
				}
				
				if(ptr == null) //Node is not found. Insert it at the end.
					prev.next = d;
				else   //Node is found then update the value according to isimp
				{
					//if(d.isimp || (d.isimp && !ptr.isimp) ||(!d.isimp && !ptr.isimp))
					if(d.isimp || (!d.isimp && !ptr.isimp))
					{
						ptr.value = d.value;
						if(d.isimp)
							ptr.isimp = true;
					}
				}
					
			}
		//displayLL(root1.data);	
		}
		else if(((root1.name).compareTo(name))>0)
		{
			root1.left = insert(root1.left,name,d);
		}
		else
			root1.right = insert(root1.right,name,d);
		
		return root1;
	}
	public static void InorderTraversal(BSTNode root1)
	{
		
		if(root1!=null)
		{
			InorderTraversal(root1.left);
			System.out.println("\n"+root1.name+" {");
			displayLL(root1.data);
			System.out.println("  }");
			InorderTraversal(root1.right);
		}
	}
	public static void displayLL(StyleNode head)
	{
		while(head != null)
		{
			if(head.isimp)
			System.out.println("    "+head.property+":"+head.value+" !important"+";");
			else
			System.out.println("    "+head.property+":"+head.value+";");	
			
			head = head.next;
		}
	}
	public static void InorderTraversal1(BSTNode root1)
	{
		
		if(root1!=null)
		{
			InorderTraversal1(root1.left);
			System.out.print(root1.name+"{");
			displayLL1(root1.data);
			System.out.print("}");
			InorderTraversal1(root1.right);
		}
	}
	public static void displayLL1(StyleNode head)
	{
		while(head != null)
		{
			if(head.isimp)
			System.out.print(head.property+":"+head.value+"!important"+";");
			else
			System.out.print(head.property+":"+head.value+";");	
			
			head = head.next;
		}
	}
	
public static void push(String filepath)
{
	
 importfiles temp = new importfiles(filepath);
	if(importhead == null)
	{
		importhead = temp;
	}
	else
	{
		temp.next = importhead;
		importhead =temp;	
	}
	
}
public static void pop()
{
	
	while(importhead!=null)
	{
		System.out.print(importhead.filepath);
		importhead = importhead.next;
	}
}
	public static void minimizer(String path2) throws Exception
	{
		FileReader file=new FileReader(path2);
		Scanner sc = new Scanner(file);
		sc.useDelimiter("\\Z");
		String s = sc.next();
		System.out.println("\n------------------------------------------------------\nInput File is : \n"+s);
		
		s = s.replaceAll("\r\n", "").replaceAll("\t", "").trim().replaceAll(" +", " ").toLowerCase();
		//System.out.println("\nInput String is : \n"+s);
		s = s.replaceAll("\\/\\*.*?\\*\\/", "");  
		//System.out.println("\nInput String is after removing comments: \n"+s);
		
		char ch1 = '\0',ch2 = '\0';
		
		String s1 ="";
		int i = 0;
		while(i<s.length())
		{
			if(s.charAt(i)=='@')
			{
			  while(s.charAt(i)!=';' && i<s.length())
			  {
				s1 = s1+s.charAt(i);
				s =s.substring(0,i)+' '+s.substring((i+1));
				i++;
			  }
			s =s.substring(0,i)+' '+s.substring((i+1));
			
			push(s1);
			s1 = "";
			}
			i++;
		}
		
		s =s.replaceAll(" +"," ");
		i=0;
		int start=0,end =0;
		while(i<s.length()-1)
		{
			if(s.charAt(i)=='{')
				{
					end= i-1;
					String BSTnodename = s.substring(start,end+1);
					BSTnodename = BSTnodename.trim();
					while(s.charAt(i)!='}')
						{
							i++;
						}
						
					if(s.charAt(i)=='}')
							start = i+1;
					String prop = s.substring(end+2,i);
					String[] Parts = prop.split(";"); 
					for(String singleprop:Parts)
					{
						 
						singleprop = singleprop.replaceAll(" ","");
						String Propname[] = singleprop.split(":");
						Propname[0] = Propname[0].trim();
						String r= Propname[0]+":";
						String Propvalue = singleprop.replace(r,""); 
						
						CharSequence seq = "!important";
						boolean bool = Propvalue.contains(seq);
						
						String p[] = Propvalue.split("!");
						Propvalue = p[0];
						
						StyleNode st;
						if(bool)
						st = new StyleNode(Propname[0],Propvalue,true);
						else
						st = new StyleNode(Propname[0],Propvalue,false);
						if(Propname[0].trim().equals(""))
						{
							st = null;
						}
						root = insert(root,BSTnodename,st);
						//System.out.println("\n\nOur tree is");
						//InorderTraversal(root);
					}
				}
			
			
			i++;
		}
		System.out.println("\n\n------------------------------------------------------\nMinimized  file is \n\n");
		pop();
		//InorderTraversal(root);
		InorderTraversal1(root);
	}
	public static void placeHold()
	{
		System.out.println("\n\nPress Enter to continue......");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
	}

	
}
