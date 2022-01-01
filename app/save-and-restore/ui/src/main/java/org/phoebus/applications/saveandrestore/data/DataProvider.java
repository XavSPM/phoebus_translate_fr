/**
 * Copyright (C) 2019 European Spallation Source ERIC.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package org.phoebus.applications.saveandrestore.data;

import java.util.List;

import org.phoebus.applications.saveandrestore.model.ConfigPv;
import org.phoebus.applications.saveandrestore.model.Node;
import org.phoebus.applications.saveandrestore.model.SnapshotItem;
import org.phoebus.applications.saveandrestore.model.Tag;

public interface DataProvider {

	Node getRootNode();

	Node getNode(String uniqueNodeId);

	List<Node> getChildNodes(Node node);

	Node updateNode(Node nodeToUpdate);

	Node updateNode(Node nodeToUpdate, boolean customTimeForMigration);

	Node createNode(String parentsUniqueId, Node node);

	@Deprecated
	boolean deleteNode(String uniqueNodeId);

	boolean deleteNodes(List<String> nodeIds);

	List<ConfigPv> getConfigPvs(String uniqueNodeId);

	Node getSaveSetForSnapshot(String uniqueNodeId);

	Node updateSaveSet(Node configToUpdate, List<ConfigPv> configPvList);

	String getServiceUrl();

	List<SnapshotItem> getSnapshotItems(String snapshotUniqueId);

	Node saveSnapshot(String configUniqueId, List<SnapshotItem> snapshotItems, String snapshotName, String comment);

	List<Tag> getAllTags();

	List<Node> getAllSnapshots();

	Node moveNodes(List<String> sourceNodeIds, String targetNodeId);
}
