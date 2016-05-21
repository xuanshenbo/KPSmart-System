package view.eventsView;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.KPSmartController.KeyAction;
import controller.KPSmartController.MouseAction;
import controller.KPSmartController.ViewActionListener;
import view.AbstractMainDisplayPanel;

@SuppressWarnings("serial")
public class TransportCostChangePanel extends AbstractMainDisplayPanel {

	private JTextField newPriceWeightTextField;
	private JTextField newPriceVolumeTextField;
	private JTextField frequencyTextField;
	private JTextField hoursToDeliverTextField;

	private JLabel lblOrigin;
	private JLabel lblDestination;
	private JLabel lblTransportCompany;
	private JLabel lblType;
	private JLabel lblNewWeightCostperGram;
	private JLabel lblNewVolumeCostperCm;
	private JLabel lblFrequency;
	private JLabel lblHoursToDeliver;
	private JLabel label;
	private JLabel label_1;

	private JButton submitButton;
	private JButton cancelButton;
	private JButton resetButton;

	private JComboBox<String> typeComboBox;
	private JComboBox<String> originComboBox;
	private JComboBox<String> destinationComboBox;
	private JComboBox<String> transportCompanyComboBox;

	public TransportCostChangePanel(KeyAction keyAction, MouseAction mouseAction,
			ViewActionListener viewActionListener) {
		super(keyAction, mouseAction, viewActionListener);

		lblOrigin = new JLabel("Origin:");
		lblOrigin.setFont(new Font("Dialog", Font.BOLD, 15));
		lblDestination = new JLabel("Destination:");
		lblDestination.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTransportCompany = new JLabel("Transport Company:");
		lblType = new JLabel("Type:");
		lblType.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewWeightCostperGram = new JLabel("New Weight Cost(per gram):");
		lblNewWeightCostperGram.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewVolumeCostperCm = new JLabel("<html>New Volume Cost(per cm<sup>3</sup>):</html>");
		lblNewVolumeCostperCm.setFont(new Font("Dialog", Font.BOLD, 11));
		lblFrequency = new JLabel("Frequency:");
		lblFrequency.setFont(new Font("Dialog", Font.BOLD, 15));
		lblHoursToDeliver = new JLabel("Hours to Deliver:");
		lblHoursToDeliver.setFont(new Font("Dialog", Font.BOLD, 15));
		label = new JLabel("$");
		label_1 = new JLabel("$");

		resetButton = new JButton("Reset");
		resetButton.addActionListener(viewActionListener);
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(viewActionListener);
		submitButton = new JButton("Submit");
		submitButton.addActionListener(viewActionListener);

		newPriceWeightTextField = new JTextField();
		newPriceWeightTextField.setColumns(10);
		newPriceVolumeTextField = new JTextField();
		newPriceVolumeTextField.setColumns(10);
		frequencyTextField = new JTextField();
		frequencyTextField.setColumns(10);
		hoursToDeliverTextField = new JTextField();
		hoursToDeliverTextField.setColumns(10);

		typeComboBox = new JComboBox<String>();
		originComboBox = new JComboBox<String>();
		destinationComboBox = new JComboBox<String>();
		transportCompanyComboBox = new JComboBox<String>();

		initialiseLayout();
	}

	@Override
	protected void initialiseLayout() {
		GroupLayout groupLayout = new GroupLayout(this);

		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap(174, Short.MAX_VALUE)
										.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 83,
												GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(resetButton)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()).addGroup(
										groupLayout.createSequentialGroup().addGap(57)
												.addGroup(groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout.createSequentialGroup()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(lblOrigin)
																						.addComponent(lblDestination)
																						.addComponent(
																								lblTransportCompany)
																.addComponent(lblType)
																.addComponent(lblNewVolumeCostperCm,
																		GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
										.addComponent(lblNewWeightCostperGram, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addComponent(label_1)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(newPriceVolumeTextField, 0, 0, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup().addComponent(label)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(newPriceWeightTextField, 0, 0, Short.MAX_VALUE))
										.addComponent(typeComboBox, 0, 112, Short.MAX_VALUE)
										.addComponent(transportCompanyComboBox, 0, 112, Short.MAX_VALUE)
										.addComponent(destinationComboBox, 0, 112, Short.MAX_VALUE)
										.addComponent(originComboBox, 0, 112, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING,
								groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblHoursToDeliver).addComponent(lblFrequency,
														GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(frequencyTextField).addComponent(hoursToDeliverTextField,
												GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))).addGap(88)));

		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(26)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblOrigin).addComponent(
						originComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblDestination).addComponent(
						destinationComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblTransportCompany)
						.addComponent(transportCompanyComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblType).addComponent(
						typeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewWeightCostperGram)
						.addComponent(label).addComponent(newPriceWeightTextField, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewVolumeCostperCm)
						.addComponent(label_1).addComponent(newPriceVolumeTextField, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblFrequency).addComponent(
						frequencyTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(19)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblHoursToDeliver)
						.addComponent(hoursToDeliverTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(submitButton)
						.addComponent(resetButton).addComponent(cancelButton))
				.addContainerGap()));

		setLayout(groupLayout);
	}

	@Override
	protected void redraw() {
		// TODO Auto-generated method stub

	}

	public JTextField getNewPriceWeightTextField() {
		return newPriceWeightTextField;
	}

	public JTextField getNewPriceVolumeTextField() {
		return newPriceVolumeTextField;
	}

	public JTextField getFrequencyTextField() {
		return frequencyTextField;
	}

	public JTextField getHoursToDeliverTextField() {
		return hoursToDeliverTextField;
	}

	public JComboBox<String> getTypeComboBox() {
		return typeComboBox;
	}

	public JComboBox<String> getOriginComboBox() {
		return originComboBox;
	}

	public JComboBox<String> getDestinationComboBox() {
		return destinationComboBox;
	}

	public JComboBox<String> getTransportCompanyComboBox() {
		return transportCompanyComboBox;
	}

}