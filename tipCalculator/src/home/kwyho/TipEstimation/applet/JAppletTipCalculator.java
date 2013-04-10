package home.kwyho.TipEstimation.applet;

import home.kwyho.TipEstimation.SplitPaymentCalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JAppletTipCalculator extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4132480876461956892L;

	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JButton jCalculateButton;
	private JFormattedTextField jFormattedTextFieldSplitPayment;
	private JFormattedTextField jFormattedTextFieldTotalPayment;
	private JLabel jLabel7;
	private JFormattedTextField jFormattedTextFieldTax;
	private JLabel jLabel6;
	private JFormattedTextField jFormattedTextFieldTip;
	private JFormattedTextField jFormattedTextFieldNumPeople;
	private JFormattedTextField jFormattedTextFieldSubTotal;
	private JComboBox jComboBoxState;
	private JCheckBox jCheckSmallGroup;
	
	private NumberFormat amountFormat;
	private NumberFormat integerFormat;
	
	private SplitPaymentCalculator calculator;
	
	public void init() {
		calculator = new SplitPaymentCalculator();
		initGUI();
	}
	
	private void initGUI() {
		amountFormat = NumberFormat.getCurrencyInstance();
		integerFormat = NumberFormat.getIntegerInstance();
		
		try {
			//setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("SubTotal");
				jLabel1.setBounds(32, 31, 82, 15);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("State");
				jLabel2.setBounds(32, 59, 68, 15);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Tax");
				jLabel3.setBounds(32, 153, 68, 15);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Tip");
				jLabel4.setBounds(32, 179, 82, 15);
			}
			{
				jCheckSmallGroup = new JCheckBox();
				getContentPane().add(jCheckSmallGroup);
				jCheckSmallGroup.setText("Small Group");
				jCheckSmallGroup.setSelected(true);
				jCheckSmallGroup.setBounds(149, 122, 109, 19);
			}
			{
				ComboBoxModel jComboBoxStateModel = 
						new DefaultComboBoxModel(
								new String[] { "MD", "VA", "DC" });
				jComboBoxState = new JComboBox();
				getContentPane().add(jComboBoxState);
				jComboBoxState.setModel(jComboBoxStateModel);
				jComboBoxState.setBounds(149, 55, 88, 22);
			}
			{
				jFormattedTextFieldSubTotal = new JFormattedTextField(amountFormat);
				getContentPane().add(jFormattedTextFieldSubTotal);
				//jFormattedTextFieldSubTotal.setText("jFormattedTextFieldSubTotal");
				jFormattedTextFieldSubTotal.setValue(1000.0);
				jFormattedTextFieldSubTotal.setBounds(149, 28, 96, 22);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("Number of People");
				jLabel5.setBounds(32, 93, 105, 15);
			}
			{
				jFormattedTextFieldNumPeople = new JFormattedTextField(integerFormat);
				getContentPane().add(jFormattedTextFieldNumPeople);
				//jFormattedTextFieldNumPeople.setText("1");
				jFormattedTextFieldNumPeople.setValue(1);
				jFormattedTextFieldNumPeople.setBounds(149, 90, 47, 22);
			}
			{
				jFormattedTextFieldTax = new JFormattedTextField(amountFormat);
				getContentPane().add(jFormattedTextFieldTax);
				//jFormattedTextFieldTax.setText("10.00");
				jFormattedTextFieldTax.setValue(10.0);
				jFormattedTextFieldTax.setBounds(149, 150, 70, 22);
				jFormattedTextFieldTax.setEditable(false);
			}
			{
				jFormattedTextFieldTip = new JFormattedTextField(amountFormat);
				getContentPane().add(jFormattedTextFieldTip);
				//jFormattedTextFieldTip.setText("5.00");
				jFormattedTextFieldTip.setValue(5.0);
				jFormattedTextFieldTip.setBounds(149, 176, 70, 22);
				jFormattedTextFieldTip.setEditable(false);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("Total Payment");
				jLabel6.setBounds(32, 211, 105, 15);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("Split Payment");
				jLabel7.setBounds(32, 238, 99, 15);
			}
			{
				jFormattedTextFieldTotalPayment = new JFormattedTextField(amountFormat);
				getContentPane().add(jFormattedTextFieldTotalPayment);
				//jFormattedTextFieldTotalPayment.setText("jFormattedTextFieldTotalPayment");
				jFormattedTextFieldTotalPayment.setValue(1200.0);
				jFormattedTextFieldTotalPayment.setBounds(149, 208, 88, 22);
				jFormattedTextFieldTotalPayment.setEditable(false);
			}
			{
				jFormattedTextFieldSplitPayment = new JFormattedTextField(amountFormat);
				getContentPane().add(jFormattedTextFieldSplitPayment);
				//jFormattedTextFieldSplitPayment.setText("jFormattedTextFieldSplitPayment");
				jFormattedTextFieldSplitPayment.setValue(1200.0);
				jFormattedTextFieldSplitPayment.setBounds(149, 235, 88, 22);
				jFormattedTextFieldSplitPayment.setEditable(false);
			}
			{
				jCalculateButton = new JButton();
				getContentPane().add(jCalculateButton);
				jCalculateButton.setText("Calculate");
				jCalculateButton.setBounds(302, 28, 73, 22);
				jCalculateButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						//System.out.println("jCalculateButton.actionPerformed, event="+evt);
						
						try {
							jFormattedTextFieldSubTotal.commitEdit();
						} catch (ParseException e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(jFormattedTextFieldSubTotal,
								    "Invalid numeric input.",
								    "Input Error",
								    JOptionPane.ERROR_MESSAGE);
						}
						try {
							jFormattedTextFieldNumPeople.commitEdit();
						} catch (ParseException e) {
							e.printStackTrace();
							JOptionPane.showMessageDialog(jFormattedTextFieldNumPeople,
								    "Invalid numeric input.",
								    "Input Error",
								    JOptionPane.ERROR_MESSAGE);
						}

						
						double subTotal = getSubTotal();
						String state = getSelectedState();
						int numPeople = getNumPeople();
						boolean smallGroup = isSmallGroup();
						calculator.setState(state);
						calculator.setSmallGroup(smallGroup);
						
						double tax = calculator.getTax(subTotal);
						double tip = calculator.getTip(subTotal);
						double total = calculator.getTotalPayment(subTotal);
						double splitPayment = calculator.getSplitPayment(subTotal, numPeople);
						
						jFormattedTextFieldTax.setValue(tax);
						jFormattedTextFieldTip.setValue(tip);
						jFormattedTextFieldTotalPayment.setValue(total);
						jFormattedTextFieldSplitPayment.setValue(splitPayment);
					}
				});
			}
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public double getSubTotal() {
		Number subTotalN = (Number)jFormattedTextFieldSubTotal.getValue();
		return subTotalN.doubleValue();
	}

	public String getSelectedState() {
		return (String)jComboBoxState.getSelectedItem();
	}
	
	public int getNumPeople() {
		Number numPeopleN = (Number)jFormattedTextFieldNumPeople.getValue();
		return numPeopleN.intValue();
	}
	
	public boolean isSmallGroup() {
		return jCheckSmallGroup.isSelected();
	}
}
