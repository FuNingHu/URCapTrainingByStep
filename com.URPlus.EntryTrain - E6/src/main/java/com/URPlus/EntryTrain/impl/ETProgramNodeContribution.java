package com.URPlus.EntryTrain.impl;


import com.ur.urcap.api.contribution.ProgramNodeContribution;
import com.ur.urcap.api.contribution.program.ProgramAPIProvider;
import com.ur.urcap.api.contribution.program.CreationContext;
import com.ur.urcap.api.domain.ProgramAPI;
import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.script.ScriptWriter;
import com.ur.urcap.api.domain.undoredo.UndoRedoManager;
import com.ur.urcap.api.domain.undoredo.UndoableChanges;


public class ETProgramNodeContribution implements ProgramNodeContribution {

	private final ProgramAPI programAPI;
	private final ETProgramNodeView view;
	private final DataModel model;
	private final UndoRedoManager undoRedoManager;//E6 implementation
	
	private static final String OUTPUT_KEY = "output";//E6 implementation
	private static final Integer OUTPUT_DEFAULT = 2;//E6 implementation
	private static final String DURATION_KEY = "duration";//E6 implementation
	private static final int DURATION_DEFAULT = 2;//E6 implementation


	public ETProgramNodeContribution(ProgramAPIProvider apiProvider, ETProgramNodeView view, DataModel model, CreationContext context) {

		this.programAPI = apiProvider.getProgramAPI();
		this.view = view;
		this.model = model;
		this.undoRedoManager = apiProvider.getProgramAPI().getUndoRedoManager();//E6 implementation

	}
	
	public void onOutputSelection(final Integer value) {//E6 implementation
		undoRedoManager.recordChanges(new UndoableChanges() {
			//all datamodel set movement should be in undoredo record change scope
			@Override
			public void executeChanges() {
				// TODO Auto-generated method stub
				model.set(OUTPUT_KEY, value);
			}
		});
	}

	public void onDurationSelection(final int value) {//E6 implementation
		undoRedoManager.recordChanges(new UndoableChanges() {
			//all datamodel set movement should be in undoredo recod change scope			
			@Override
			public void executeChanges() {
				// TODO Auto-generated method stub
				model.set(DURATION_KEY, value);
			}
		});
	}
	
	private Integer[] getOutputItems() {
		Integer[] items = new Integer[8];
		for(int i=0;i<8;i++) {
			items[i]=i;
		}
		return items;
	}
	private Integer getIOSelection() {//E6 implementation
		return model.get(OUTPUT_KEY, DURATION_DEFAULT);
	}
	private int getDuration() {//E6 implementation
		return model.get(DURATION_KEY, DURATION_DEFAULT);
	}

	@Override
	public void openView() {
		view.setIOComBoxItems(getOutputItems());

		view.setIOComBoxSelection(getIOSelection()); //E6 implementation
		view.setDurationSlider(getDuration()); //E6 implementation
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