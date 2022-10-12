package com.URPlus.EntryTrain.impl;

import java.util.Locale;

import com.ur.urcap.api.contribution.ViewAPIProvider;
import com.ur.urcap.api.contribution.program.ContributionConfiguration;
import com.ur.urcap.api.contribution.program.CreationContext;
import com.ur.urcap.api.contribution.program.ProgramAPIProvider;
import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeService;
import com.ur.urcap.api.domain.data.DataModel;


public class ETProgramNodeService implements SwingProgramNodeService<ETProgramNodeContribution, ETProgramNodeView> {

	@Override
	public String getId() {

		return "entrytrain";
	}

	@Override
	public void configureContribution(ContributionConfiguration configuration) {

		configuration.setChildrenAllowed(false);
	
	}

	@Override
	public String getTitle(Locale locale) {
	
		return "EntryTrain";
	}

	@Override
	public ETProgramNodeView createView(ViewAPIProvider apiProvider) {
		return new ETProgramNodeView();

	}

	@Override
	public ETProgramNodeContribution createNode(ProgramAPIProvider apiProvider, ETProgramNodeView view,
			DataModel model, CreationContext context) {

		return new ETProgramNodeContribution(apiProvider, view, model, context);
	}

}