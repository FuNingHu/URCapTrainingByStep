package com.URPlus.EntryTrain.impl;


import com.ur.urcap.api.contribution.ContributionProvider;
import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeView;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class ETProgramNodeView implements SwingProgramNodeView<ETProgramNodeContribution> {

	private final Style style;
	private final ViewAPIProvider apiProvider;
	private Locale locale;
	private JComboBox<Integer> ioComboBox = new JComboBox<Integer>();
	private JSlider durationSlider = new JSlider();
	
	
	public ETProgramNodeView(ViewAPIProvider apiProvider, Style style, Locale locale) {
		this.apiProvider = apiProvider;
		this.style = style;
		this.locale = locale;

	}

	@Override
	public void buildUI(JPanel panel, ContributionProvider<ETProgramNodeContribution> provider) {
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(createDescription("Select which output to Light Up:"));
		panel.add(createVerticalSpacing());
		panel.add(createIOComboBox(ioComboBox, provider));
		
		panel.add(createSpacer(0, 100));
		
		panel.add(createDescription("Selection duration of Light Up"));
		panel.add(createVerticalSpacing());
		panel.add(createDurationSlider(durationSlider, 0, 10, provider));
	}
	private Box createDescription(String description) {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel label = new JLabel(description);
		box.add(label);
		return box;
	}
	private Box createIOComboBox(final JComboBox<Integer> combo, final ContributionProvider<ETProgramNodeContribution> provider) {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel label = new JLabel("  digital_output ");
		combo.setPreferredSize(new Dimension(100,30));
		combo.setMaximumSize(combo.getPreferredSize());
		combo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange() == ItemEvent.SELECTED) {
					System.out.println("IO selection: "+e.getItem());
					provider.get().onOutputSelection((Integer) e.getItem()); //E6 implementation
				}
			}
		});
		box.add(createHorizontalSpacing());
		box.add(label);
		box.add(createHorizontalSpacing());
		box.add(combo);
		return box;
	}
	public void setIOComBoxItems(Integer[] items) {
		ioComboBox.removeAllItems();
		ioComboBox.setModel(new DefaultComboBoxModel<Integer>(items));
	}
	
	public void setIOComBoxSelection(Integer item) {//E6 implementation
		ioComboBox.setSelectedItem(item);
	}
	public void setDurationSlider(int value) {//E6 implementation
		durationSlider.setValue(value);
	}

	
	private Box createDurationSlider(final JSlider slider, int min, int max,
			final ContributionProvider<ETProgramNodeContribution> provider) {
		Box box = Box.createHorizontalBox();
		box.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		slider.setMinimum(min);
		slider.setMaximum(max);
		slider.setOrientation(JSlider.HORIZONTAL);
		
		slider.setPreferredSize(new Dimension(280,30));
		slider.setMaximumSize(slider.getPreferredSize());
		final JLabel value = new JLabel();
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				value.setText(Integer.toString(slider.getValue())+" s");
				System.out.println("Duration set: "+slider.getValue());
				provider.get().onDurationSelection(slider.getValue()); // E6 implementation
			}
			
		});
		box.add(slider);
		box.add(value);
		return box;
	}
	
	private Component createHorizontalSpacing() {
		return Box.createRigidArea(new Dimension(style.getHorizontalSpacing(),0));
	}
	private Component createVerticalSpacing() {
		return Box.createRigidArea(new Dimension(0,style.getHorizontalSpacing()));
	}
	private Component createSpacer(int x, int y) {
		return Box.createRigidArea(new Dimension(x,y));
	}


}