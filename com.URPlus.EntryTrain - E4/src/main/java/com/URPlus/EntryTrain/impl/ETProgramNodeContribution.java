package com.URPlus.EntryTrain.impl;


import com.ur.urcap.api.contribution.ProgramNodeContribution;
import com.ur.urcap.api.contribution.program.ProgramAPIProvider;
import com.ur.urcap.api.contribution.program.CreationContext;
import com.ur.urcap.api.domain.ProgramAPI;
import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.script.ScriptWriter;


public class ETProgramNodeContribution implements ProgramNodeContribution {

	private final ProgramAPI programAPI;
	private final ETProgramNodeView view;
	private final DataModel model;


	public ETProgramNodeContribution(ProgramAPIProvider apiProvider, ETProgramNodeView view, DataModel model, CreationContext context) {

	
		this.programAPI = apiProvider.getProgramAPI();
		this.view = view;
		this.model = model;

	}

	@Override
	public void openView() {

	}


	@Override
	public void closeView() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "EntryTrain";
	}

	@Override
	public boolean isDefined() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void generateScript(ScriptWriter writer) {

	}

}