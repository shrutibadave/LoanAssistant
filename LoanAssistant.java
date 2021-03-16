package opt1;


import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Date;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;




public class LoanAssistant extends javax.swing.JFrame {

    Boolean computPayment;
   // private Object computePayment;
    double loan,s,fp,lb;
    double interest;
   double month;
    int payment;
    double MonthlyPayment;
    double result;
    int   r[]=new int[3];
    String paid;
    int count=0;

   
    public LoanAssistant() {
        initComponents();
        XmonthButton.doClick();
        newLoanButton.setEnabled(false);
       
    }

    
    
    
    
    private void computButtonActionPerformed(ActionEvent evt) {
    	
    	
    	int a=0,b=0;
    	
    	if(computPayment)
    	{
    		a=validity1();
    		if(a!=1) {
    		//System.out.println("hello");
    			
    			loan=Float.parseFloat(balanceField.getText());
        		interest=Float.parseFloat( intersetField.getText());
        		 s =Double.valueOf(monthField.getText()).doubleValue();
        		 double mus=interest/1200;
        		
        		
        		if(interest==0.0)
        		{
        			month=(int)loan/s;
        			paymentField.setText(String.valueOf((int)month));
        			
        		}
        		else
        		{
        			 
    		
    			if(s<=(loan*mus+1.0))
    			{
    				if (JOptionPane.showConfirmDialog(null, "Minimum payment must be $" +
    						new DecimalFormat("0.00").format((int)(loan * mus + 1.0)) + "\n" + "Do you want to use the minimum payment?", "Input Error", JOptionPane.YES_NO_OPTION,
    						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
    				{
    					monthField.setText(new DecimalFormat("0.00").format((int)
    							(loan * mus + 1.0)));
    					s=Double.valueOf(monthField.getText()).doubleValue();
    					nop();
    					
    				}
    				else
    				{
    					monthField.requestFocus();
    					return;
    					
    					
    				}
    				
    			}
    			
    			else
    			{
    				nop();
    			}
					
					
    		
        		}
    	
    	}
    	}
    	else
    	{
    		b=validity2();
    		
    		if(b!=1)
    		{
    			loan=Float.parseFloat(balanceField.getText());
        		interest=Float.parseFloat( intersetField.getText());
        		payment=Integer.parseInt( paymentField.getText());
        		
        		if(interest==0.0)
        		{
        			result=loan/payment;
        			monthField.setText(new DecimalFormat("0.00").format(result));
        			
        		}
        		
        		else
        		{
        			
        			double i1=interest/1200;
            		
            		
            		
            		
            		month=Math.pow((1+i1), payment);
            		 result=loan*i1*month/(month-1);
            		 
            		
            		monthField.setText(new DecimalFormat("0.00").format(result));
            		 
            		 result=Float.parseFloat(monthField.getText());
            		
            	    
            		   lb=loan;
        				result=Float.parseFloat(monthField.getText());
        	    		for(int i=1;i<=payment-1;i++)
        	    		{
        	    			lb+=lb*i1-result;
        	    		}
        	    		
        	    		
        	    		 fp=lb;
        	    		if(fp>result)
        	    		{
        	    			lb+=lb*i1-result;
        	    		fp=lb;
        	    			
        	    			payment++;
        	    		}
        			
        		}
        		
        		analysisTextAria.setText("Loan Balance: $" + new DecimalFormat("0.00").format(loan));
          		 analysisTextAria.append("\n" + "Interest Rate: " + new DecimalFormat("0.00").format(interest) + "%");
           		 
           		
           		
          		 month=payment;
          		 s=result;
          		 
    		}
    		
    		
    	}
    	//System.out.println(a+" "+b);
    	if(a==0 && b==0)
    	{
    		checkdate();
    	newLoanButton.setEnabled(true);
		computButton.setEnabled(false);
		analysisTextAria.setText("Loan Balance: $" + new
				 DecimalFormat("0.00").format(loan));
				 analysisTextAria.append("\n" + "Interest Rate: " + new DecimalFormat("0.00").format(interest) + "%");
   		analysisTextAria.append("\n\n" + String.valueOf(month - 1) + " Payments of $" + new DecimalFormat("0.00").format(s));
   		analysisTextAria.append("\n" + "Final Payment of: $" + new DecimalFormat("0.00").format(fp));
   		analysisTextAria.append("\n" + "Total Payments: $" + new DecimalFormat("0.00").format((month - 1) * result + fp));
   		
   		
   		analysisTextAria.append("\n" + "Loan Paid off on: " +" "+paid);
   		
   		double monthly=(interest/1200)*100;
   		DecimalFormat a1=new DecimalFormat("0.0000");
   		String formated=a1.format(monthly);
   		analysisTextAria.append("\n" + "Monthly Interst: " +formated +"%");
   		if(interest!=0)
   	   		analysisTextAria.append("\n" + "Interest Paid $" + new DecimalFormat("0.00").format((month - 1) * result + fp - loan));
   	   		}
    	float pay=(float) ((month - 1) * result + fp);
			float pay1=Float.parseFloat(monthField.getText());
   		for(int i=0;i<month-1;i++)
   		{
   		
   			
   		analysisTextAria.append("\n\n" + "Balance decreases in "+(i+1)+" month:"+(pay-pay1) );
   		pay=pay-pay1;
   		
  
   		}
   		
   		
   		
    	
    	
    	
    	
		
		
	}
    
    
    public int validity1()
    {
    	if(balanceField.getText().equals(""))
		{
			
			
				JOptionPane.showConfirmDialog(null, "Invalid credentials.", "Payment Input Error", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
				balanceField.setText("");
				intersetField.setText("");
				monthField.setText("");
				return 1;

				
		}
		else if(!isNumber(balanceField.getText()))
		{
			JOptionPane.showConfirmDialog(null, "Enter valid input.", "Payment Input Error", JOptionPane.DEFAULT_OPTION,
    				JOptionPane.INFORMATION_MESSAGE);
			balanceField.setText("");
			intersetField.setText("");
			monthField.setText("");
			return 1;
			
		}
		else if(intersetField.getText().equals(""))
		{
			JOptionPane.showConfirmDialog(null, "Invalid credentials.", "Payment Input Error", JOptionPane.DEFAULT_OPTION,
    				JOptionPane.INFORMATION_MESSAGE);
			balanceField.setText("");
			intersetField.setText("");
			monthField.setText("");
			return 1;
		}
		else if(!isNumber(intersetField.getText()))
		{
			JOptionPane.showConfirmDialog(null, "Enter valid input.", "Payment Input Error", JOptionPane.DEFAULT_OPTION,
    				JOptionPane.INFORMATION_MESSAGE);
			balanceField.setText("");
			intersetField.setText("");
			monthField.setText("");
			return 1;
		}
		else if(monthField.getText().equals(""))
		{
			JOptionPane.showConfirmDialog(null, "Invalid credentials.", "Payment Input Error", JOptionPane.DEFAULT_OPTION,
    				JOptionPane.INFORMATION_MESSAGE);
			
			balanceField.setText("");
			intersetField.setText("");
			monthField.setText("");
			return 1;
		}
		else if(!isNumber(monthField.getText()))
		{
			JOptionPane.showConfirmDialog(null, "Enter valid input.", "Payment Input Error", JOptionPane.DEFAULT_OPTION,
    				JOptionPane.INFORMATION_MESSAGE);
			paymentField.setText("");
			balanceField.setText("");
			monthField.setText("");
			return 1;
			
			
		}
    	return 0;
		
    }
    
    public int validity2()
    {
    	if(balanceField.getText().equals(""))
		{
			
			
				JOptionPane.showConfirmDialog(null, "Invalid credentials.", "Payment Input Error", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
				balanceField.setText("");
				intersetField.setText("");
    			paymentField.setText("");
    			return 1;
				

				
		}
		else if(!isNumber(balanceField.getText()))
		{
			JOptionPane.showConfirmDialog(null, "Enter valid input.", "Payment Input Error", JOptionPane.DEFAULT_OPTION,
    				JOptionPane.INFORMATION_MESSAGE);
			balanceField.setText("");
			intersetField.setText("");
			paymentField.setText("");
			return 1;
			
			
		}
		else if(intersetField.getText().equals(""))
		{
			JOptionPane.showConfirmDialog(null, "Invalid credentials.", "Payment Input Error", JOptionPane.DEFAULT_OPTION,
    				JOptionPane.INFORMATION_MESSAGE);
			balanceField.setText("");
			intersetField.setText("");
			paymentField.setText("");
			return 1;
		}
		else if(!isNumber(intersetField.getText()))
		{
			JOptionPane.showConfirmDialog(null, "Enter valid input.", "Payment Input Error", JOptionPane.DEFAULT_OPTION,
    				JOptionPane.INFORMATION_MESSAGE);
			balanceField.setText("");
			intersetField.setText("");
			paymentField.setText("");
			return 1;
		}
		else if(paymentField.getText().equals(""))
		{
			JOptionPane.showConfirmDialog(null, "Invalid credentials.", "Payment Input Error", JOptionPane.DEFAULT_OPTION,
    				JOptionPane.INFORMATION_MESSAGE);
			
			balanceField.setText("");
			
			intersetField.setText("");
			paymentField.setText("");
			return 1;
		}
		else if(!isNumber(paymentField.getText()))
		{
			JOptionPane.showConfirmDialog(null, "Enter valid input.", "Payment Input Error", JOptionPane.DEFAULT_OPTION,
    				JOptionPane.INFORMATION_MESSAGE);
			paymentField.setText("");
			balanceField.setText("");
			intersetField.setText("");
			return 1;
			
			
		}
    	return 0;
		
		
    }
    
    
    public void nop()
    {
    	
    	loan=Float.parseFloat(balanceField.getText());
		interest=Float.parseFloat( intersetField.getText());
		 s =Double.valueOf(monthField.getText()).doubleValue();
		 System.out.println(loan);
		 double mus=interest/1200;
		
    	month = (int)((Math.log(s) - Math.log(s - loan * mus)) /
				Math.log(1 + mus));
			
				paymentField.setText(String.valueOf((int)month));
				
	
		 
	
	
	double  lb=loan;
	result=Float.parseFloat(monthField.getText());
	//System.out.println(result);
	for(int i=1;i<=month-1;i++)
	{
		lb+=lb*mus-result;
	}
	
	 fp=lb;
	if(fp>s)
	{
		lb+=lb*mus-s;
	fp=lb;
		
		month++;
		paymentField.setText(String.valueOf((int)month));
	}	
    	
    }
    
    public int checkdays()
    {
    	
    	LocalDate date1 =LocalDate.now();
		String date=date1.toString();
		
		String []c=date.split("-");
	int r[]=new int[3];
		for(int i=0;i<c.length;i++){
			r[i]=Integer.parseInt(c[i]);}
		YearMonth yearMonthObject = YearMonth.of(r[0], r[1]);
		int daysInMonth = yearMonthObject.lengthOfMonth(); 
		
		int dr=daysInMonth-r[2];
		int k=dr;
	
		r[1]++;
		for(int i=0;i<month;i++)
		{
			//System.out.println(r[0]+" "+r[1]);
			if(r[1]>12)
			{
				r[1]=1;
				r[0]++;
			}
			
			YearMonth yearMonthObject1 = YearMonth.of(r[0], r[1]);
			int daysInMonth1 = yearMonthObject1.lengthOfMonth(); 
			//System.out.println( daysInMonth1);
			
			k+=daysInMonth1;
			//System.out.println(k);
			
			r[1]++;
			
		}
	//	System.out.println(k);
    	return k;
    	
    }
    
    public void  checkdate()
    {
    	
    	
Date a=new Date();
int day1=checkdays();
System.out.println(day1);
		
		LocalDate date1 =LocalDate.now();
		String date=date1.toString();
		int  days=day1;
		String []c=date.split("-");
	 int   r[]=new int[3];
		for(int i=0;i<c.length;i++){
			r[i]=Integer.parseInt(c[i]);
			
			
		}
		
		for(int i=1;i<=days;i++)
		{
			//System.out.println(r[2]+"  "+r[1]);
		YearMonth yearMonthObject = YearMonth.of(r[0], r[1]);
		int daysInMonth = yearMonthObject.lengthOfMonth(); //28
		r[2]++;
		if(r[2]>daysInMonth)
		{
			r[2]=1;
			r[1]++;
		}
		if(r[1]>12)
		{
			r[0]++;
			r[1]=1;
			r[2]=1;
		}
		
		
		
		}
		paid=r[2]+"/"+r[1]+"/"+r[0];
		//System.out.println(r[2]+"/"+r[1]+"/"+r[0]);
		
    }
    
    
    public boolean isNumber(String s)
    {
    	int m=0;
    	
    	if(s.contains(".")) {
    	s=s.replace(".", "0");}
        for (int i = 0; i < s.length(); i++)
        {
       
            if (Character.isDigit(s.charAt(i)) == true)
            {
            	m++;
            }
           
        
            
        }
       
        if(m==s.length())
        {
        	return true;
        	
        }
        else
        {
        	return false;
        }
    }
    
    
    
    private void  newLoanButtonActionPerformed(java.awt.event.ActionEvent evt)
    {
    // clear computed value and analysis
    if (computPayment)
    {
   
    	monthField.setText("");
    	paymentField.setText("");
    	
    
    }
    else
    {
    	
    	monthField.setText("");
    }
    analysisTextAria.setText("");
    computButton.setEnabled(true);
    newLoanButton.setEnabled(false);
    balanceField.requestFocus();
    count++;
	System.out.println(count);
	if(count>=6)
	{
		JOptionPane.showConfirmDialog(null, "You have crossed your limits.", "Payment Input Error", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		
		counttime();
		System.out.println(count);
	}
    
    
    }
    
    private void monthFieldActionPerformed(ActionEvent evt)
    {
    	monthField.transferFocus();
    }
    
    
    
    private void  intersetFieldActionPerformed(ActionEvent e)
    {
    	 intersetField.transferFocus();
    }
    
    private void balanceFieldActionPerformed(ActionEvent e)
    {
    	balanceField.transferFocus();
    }
    private void  paymentFieldActionPerformed(ActionEvent e)
    {
    	 paymentField.transferFocus();
    }
 
   
    public void  printButtonActionPerformed(ActionEvent   e) {
    	
    	 String printData = analysisTextAria.getText();
    	    PrinterJob job = PrinterJob.getPrinterJob();
    	    job.setPrintable(new OutputPrinter(printData));
    	    boolean doPrint = job.printDialog();
    	    if (doPrint)
    	    { 
    	        try 
    	        {
    	            job.print();
    	        }
    	        catch (PrinterException e1)
    	        {
    	        e1.printStackTrace();
    	        }
    	    }
    	
    	
    	
    }
    
    
    
  public void  newButtonActionPerformed( ActionEvent evt)
  {
	 
	  paymentField.setText("");
	 
		balanceField.setText("");
		intersetField.setText("");
		 analysisTextAria.setText("");
		 monthField.setText("");
		 paymentField.setText("");
		 newLoanButton.setEnabled(false);
			computButton.setEnabled(true);
			count++;
			System.out.println(count);
			if(count>=6)
			{
				counttime();
			}
		
  }
  
  public void counttime()
  {
	  newLoanButton.setEnabled(false);
		computButton.setEnabled(false); 
		printButton.setEnabled(false);
		newButton.setEnabled(false);
		
		balanceField.setEnabled(false);
		intersetField.setEnabled(false);
		monthField.setEnabled(false);
		paymentField.setEnabled(false);
		analysisTextAria.setEnabled(false);
	
		
  }
  public void  afforActionPerformed( ActionEvent e) {
	  java.awt.EventQueue.invokeLater(new Runnable() {
          public void run() {
              new newframe().setVisible(true);
          }
      });
	 
	 
	  
	  
}
  
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        computButton = new javax.swing.JButton();
        affoButton = new javax.swing.JButton();
        
        newLoanButton = new javax.swing.JButton();
        intersetField = new javax.swing.JTextField();
        balanceField = new javax.swing.JTextField();
        monthField = new javax.swing.JTextField();
        paymentField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        analysisTextAria = new javax.swing.JTextArea();
        XmonthButton = new javax.swing.JButton();
        XpaymentButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
     
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loan Assistant");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Loan Balance:");
      
   
        
        
        
       
       

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Interest Rate: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Number of Payment:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Monthly Payment:");

        computButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        computButton.setText("Compute Monthly Payment");
        computButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                computButtonActionPerformed(evt);
            }

			
        });
       

        newLoanButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        newLoanButton.setText("New Loan Analysis");
        newLoanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newLoanButtonActionPerformed(evt);
            }

			
			
        });

        intersetField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        
        intersetField.addActionListener(new ActionListener ()
        {
        public void actionPerformed(ActionEvent e)
        {
        	 intersetFieldActionPerformed(e);
        }
        });
       

        balanceField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        balanceField.addActionListener(new ActionListener ()
        {
        public void actionPerformed(ActionEvent e)
        {
        	 balanceFieldActionPerformed(e);
        }
        });

        monthField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        monthField.addActionListener(new ActionListener ()
        {
        public void actionPerformed(ActionEvent e)
        {
        	 monthFieldActionPerformed(e);
        }
        });

        paymentField.setBackground(new java.awt.Color(255, 255, 153));
        
        paymentField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        paymentField.addActionListener(new ActionListener ()
        {
        public void actionPerformed(ActionEvent e)
        {
        	 paymentFieldActionPerformed(e);
        }
        });

        analysisTextAria.setColumns(20);
        analysisTextAria.setRows(5);
        jScrollPane1.setViewportView(analysisTextAria);

        XmonthButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        XmonthButton.setText("X");
        XmonthButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XmonthButtonActionPerformed(evt);
            }
        });

        XpaymentButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        XpaymentButton.setText("X");
        XpaymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XpaymentButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Loan Analysis");
        
      

        exitButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        printButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        printButton.setText("print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });
        newButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        newButton.setText("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });
        affoButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        affoButton.setText("Affortablity");
        affoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
            	 afforActionPerformed(evt);
            }

			
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(133, 133, 133)
               
                .addComponent(newLoanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
               
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE). 
                addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE).
                addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE).
                addComponent(affoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE).
                
                addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                . 
               
              
                addGap(134, 134, 134))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(paymentField, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(monthField, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(102, 102, 102)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(balanceField, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(intersetField,javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(XmonthButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(XpaymentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(computButton, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                       
                        .addGap(16, 16, 16)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(balanceField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(intersetField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(paymentField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(XpaymentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(monthField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(XmonthButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(computButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)).
                        
                    addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(15, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(newLoanButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE).
                 
                    addComponent(newButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).
                    addComponent(printButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).
                    addComponent(affoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).
                    
                    addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   
    private void XpaymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XpaymentButtonActionPerformed
       computPayment=true;
       XpaymentButton.setVisible(false);
       XmonthButton.setVisible(true);
       monthField.setEditable(true);
       monthField.setBackground(Color.WHITE);
       monthField.setFocusable(true);
       paymentField.setEditable(false);
       paymentField.setBackground(Color.YELLOW);
      paymentField.setFocusable(false);
      balanceField.requestFocus();
    	
       
    }//GEN-LAST:event_XpaymentButtonActionPerformed

    private void XmonthButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XmonthButtonActionPerformed
     computPayment = false;
      XpaymentButton.setVisible(true);
      XmonthButton.setVisible(false);
      monthField.setEditable(false);
      monthField.setBackground(Color.YELLOW);
      monthField.setFocusable(false);
      paymentField.setEditable(true);
      paymentField.setBackground(Color.WHITE);
      paymentField.setFocusable(true);
      balanceField.requestFocus();
      computButton.setVisible(true);
    	
    
     
    }//GEN-LAST:event_XmonthButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

   
       
        
        
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoanAssistant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoanAssistant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoanAssistant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoanAssistant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoanAssistant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton XmonthButton;
    private javax.swing.JButton XpaymentButton;
    private javax.swing.JTextArea analysisTextAria;
    private javax.swing.JTextField balanceField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton computButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JTextField intersetField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
   
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField monthField;
    private javax.swing.JButton newLoanButton;
    private javax.swing.JButton affoButton;
    private javax.swing.JTextField paymentField;
    private javax.swing.JButton printButton;
    private javax.swing.JButton newButton;
   
    // End of variables declaration//GEN-END:variables
}

