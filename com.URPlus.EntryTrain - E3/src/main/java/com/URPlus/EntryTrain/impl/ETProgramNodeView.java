package com.URPlus.EntryTrain.impl;


import com.ur.urcap.api.contribution.ContributionProvider;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeView;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class ETProgramNodeView implements SwingProgramNodeView<ETProgramNodeContribution> {

	public ETProgramNodeView() {

	}

	@Override
	public void buildUI(JPanel panel, ContributionProvider<ETProgramNodeContribution> provider) {
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

	}


}