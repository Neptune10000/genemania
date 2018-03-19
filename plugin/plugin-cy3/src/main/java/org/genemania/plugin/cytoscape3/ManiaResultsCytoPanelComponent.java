/**
 * This file is part of GeneMANIA.
 * Copyright (C) 2008-2011 University of Toronto.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.genemania.plugin.cytoscape3;

import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static org.genemania.plugin.view.util.IconUtil.GENEMANIA_LOGO;
import static org.genemania.plugin.view.util.IconUtil.GENEMANIA_LOGO_COLOR;
import static org.genemania.plugin.view.util.IconUtil.getIconFont;

import java.awt.Component;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.JPanel;

import org.cytoscape.application.swing.CytoPanelComponent2;
import org.cytoscape.application.swing.CytoPanelName;
import org.genemania.plugin.GeneMania;
import org.genemania.plugin.NetworkUtils;
import org.genemania.plugin.Strings;
import org.genemania.plugin.controllers.ManiaResultsController;
import org.genemania.plugin.cytoscape.CytoscapeUtils;
import org.genemania.plugin.data.DataSetManager;
import org.genemania.plugin.view.ManiaResultsPanel;
import org.genemania.plugin.view.util.TextIcon;
import org.genemania.plugin.view.util.UiUtils;

public class ManiaResultsCytoPanelComponent extends JPanel implements CytoPanelComponent2 {

	private static final long serialVersionUID = 1L;
	
	ManiaResultsPanel panel;

	private final Icon compIcon = new TextIcon(GENEMANIA_LOGO, getIconFont(16.0f), GENEMANIA_LOGO_COLOR, 16, 16);
	
	public ManiaResultsCytoPanelComponent(
			DataSetManager dataSetManager,
			GeneMania plugin,
			CytoscapeUtils cytoscapeUtils,
			UiUtils uiUtils,
			NetworkUtils networkUtils
	) {
		ManiaResultsController controller = new ManiaResultsController(dataSetManager, cytoscapeUtils, uiUtils,
				networkUtils);
		this.panel = new ManiaResultsPanel(controller, plugin, cytoscapeUtils, networkUtils, uiUtils);
		
		setOpaque(!uiUtils.isAquaLAF());
		
		final GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
		layout.setAutoCreateGaps(false);
		layout.setAutoCreateContainerGaps(false);
		
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addComponent(panel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
		);
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addComponent(panel, DEFAULT_SIZE, DEFAULT_SIZE, Short.MAX_VALUE)
		);
	}

	public ManiaResultsPanel getPanel() {
		return panel;
	}
	
	@Override
	public Component getComponent() {
		return this;
	}

	@Override
	public CytoPanelName getCytoPanelName() {
		return CytoPanelName.EAST;
	}

	@Override
	public Icon getIcon() {
		return compIcon;
	}

	@Override
	public String getTitle() {
		return Strings.maniaResults_title;
	}

	@Override
	public String getIdentifier() {
		return "org.genemania.GeneMANIAResultsPanel";
	}
}
