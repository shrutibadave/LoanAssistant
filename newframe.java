package opt1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class newframe  extends javax.swing.JFrame{
	Boolean  computPayment;

	
	public newframe()
	{
		 initComponents();
		 balanceField.requestFocusInWindow();
		 
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
	      
	        jLabel5 = new javax.swing.JLabel();
	        exitButton = new javax.swing.JButton();
	        printButton = new javax.swing.JButton();
	        newButton = new javax.swing.JButton();
	     
	        

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        setTitle("Loan Assistant");
	        setResizable(false);

	        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
	        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
	        jLabel1.setText("Monthly Payment:");
	      
	   
	        
	        
	        
	       
	       

	        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
	        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
	        jLabel2.setText("Loan Term: ");

	       

	        computButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
	        computButton.setText("Compute Monthly Payment");
	        computButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                computButtonActionPerformed(evt);
	            }

				private void computButtonActionPerformed(ActionEvent evt) {
					
					
					int r=check();
					if(r==0)
					{
					
					Float price=Float.parseFloat(balanceField.getText());
					
					analysisTextAria.append("\n" +"You can get loan="+price*10 );
					float pay=(price*3)/100;
			   		analysisTextAria.append("\n" + "Monthly Payment of: $" + new DecimalFormat("0.00").format(pay));
			   		int a=Integer.parseInt(intersetField.getText());
			   		int b=a*12;
			   		float c=pay*b;
			   		float d=c-price;
			   		System.out.println(c);
			   		analysisTextAria.append("\n" + " Total Interest Paid : $" + new DecimalFormat("0.00").format(d));
			   		
			   		float rate=d*100/(price*a);
			   		DecimalFormat a1=new DecimalFormat("0.0000");
			   		String formated=a1.format(rate);
			   		analysisTextAria.append("\n" + "Interest rate : $" + formated+"%");
			   		
			   		
					}
			   
					
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
	      
	        

	        balanceField.setFont(new java.awt.Font("Tahoma", 0, 18));
	        // NOI18N
	        
	       balanceField.addActionListener(new ActionListener()
	    		   {

					@Override
					public void actionPerformed(ActionEvent e) {
						balanceFieldActionPerformed();
						
					}
	    	   
	    		   });
	       
	        analysisTextAria.setColumns(20);
	        analysisTextAria.setRows(5);
	        jScrollPane1.setViewportView(analysisTextAria);

	      

	      

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
	      
	      

				
	        

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGap(133, 133, 133)
	               
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE). 
	              
	                
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
	                                   
	                                   )
	                                .addGap(47, 47, 47)
	                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                   
	                                    ))
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
	                           )
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
	                           
	                            
	                           )
	                        .addGap(18, 18, 18)
	                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            
	                            
	                            )
	                        .addGap(30, 30, 30)
	                        .addComponent(computButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)).
	                        
	                    addGroup(jPanel1Layout.createSequentialGroup()
	                        .addContainerGap(15, Short.MAX_VALUE)
	                        .addComponent(jLabel5)
	                        .addGap(18, 18, 18)
	                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).
	                    
	                  
	                    
	                    
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

	   
	   

	    protected void balanceFieldActionPerformed() {
		// TODO Auto-generated method stub
	    	balanceField.transferFocus();
	    	
		
	}

		protected void intersetFieldActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			//intersetField.transferFocus();
			
		
	}

		private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
	        System.exit(0);
	    }//GEN-LAST:event_exitButtonActionPerformed

	   
	    public int  check()
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
	    	return 0;
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
	    
	    
	    

		
		
	    public static void main(String args[]) {
	        
	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(newframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(newframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(newframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(newframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        

	        
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new newframe().setVisible(true);
	            }
	        });
	    }
	   // private javax.swing.JButton XmonthButton;
	    //private javax.swing.JButton XpaymentButton;
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
	



}