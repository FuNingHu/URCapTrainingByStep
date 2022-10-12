package com.URPlus.EntryTrain.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.ur.urcap.api.contribution.program.swing.SwingProgramNodeService;

/**
 * Hello world activator for the OSGi bundle URCAPS contribution
 *
 */
public class Activator implements BundleActivator {
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		bundleContext.registerService(SwingProgramNodeService.class, new ETProgramNodeService(), null);
		System.out.println("EntryTrain says Hello World!");
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("EntryTrain says Goodbye World!");
	}
}

