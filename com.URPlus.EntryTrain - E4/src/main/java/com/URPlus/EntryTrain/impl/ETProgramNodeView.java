package com.URPlus.EntryTrain.impl;


import com.ur.urcap.api.contribution.ContributionProvider;
import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeView;
import javax.swing.JPanel;

import java.util.Locale;

import javax.swing.BoxLayout;

public class ETProgramNodeView implements SwingProgramNodeView<ETProgramNodeContribution> {

	private final Style style;
	private final ViewAPIProvider apiProvider;
	private Locale locale;
	
	public ETProgramNodeView(ViewAPIProvider apiProvider, Style style, Locale locale) {
		this.apiProvider = apiProvider;
		this.style = style;
		this.locale = locale;

	}

	@Override
	public void buildUI(JPanel panel, ContributionProvider<ETProgramNodeContribution> provider) {
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

	}


}