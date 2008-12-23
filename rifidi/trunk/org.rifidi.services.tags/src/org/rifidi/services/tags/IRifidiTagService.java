/*
 *  IRifidiTagService.java
 *
 *  Project:		RiFidi Designer - A Virtualization tool for 3D RFID environments
 *  http://www.rifidi.org
 *  http://rifidi.sourceforge.net
 *  Copyright:	    Pramari LLC and the Rifidi Project
 *  License:		Lesser GNU Public License (LGPL)
 *  http://www.opensource.org/licenses/lgpl-license.html
 */
package org.rifidi.services.tags;

import java.util.ArrayList;
import java.util.List;

import org.rifidi.services.tags.exceptions.RifidiTagNotAvailableException;
import org.rifidi.services.tags.model.IRifidiTagContainer;
import org.rifidi.tags.factory.TagCreationPattern;
import org.rifidi.tags.impl.RifidiTag;

/**
 * Service for handling tags. Keeps track of newly created tags and who
 * currently holds a tag.
 * 
 * @author Jochen Mader - jochen@pramari.com - Dec 18, 2008
 * 
 */
public interface IRifidiTagService {
	/**
	 * Destroy all currently registered tags. Unregister all currently
	 * registered tag containers.
	 */
	void clear();

	/**
	 * Register tags to the service.
	 * 
	 * @param tags
	 */
	void registerTags(List<RifidiTag> tags);

	/**
	 * Add a tag container to the list of registered tag containers.
	 * 
	 * @param rifidiTagContainer
	 */
	void registerTagContainer(IRifidiTagContainer rifidiTagContainer);

	/**
	 * Remove a tag container from the list of registered tag containers.
	 * 
	 * @param rifidiTagContainer
	 */
	void unregisterTagContainer(IRifidiTagContainer rifidiTagContainer);

	/**
	 * This method creates a list of tags according to the tagCreationPattern
	 * and registers them to the service.
	 * 
	 * @param tagCreationPattern
	 * @return The list of tags that were created
	 */
	ArrayList<RifidiTag> createTags(TagCreationPattern tagCreationPattern);

	/**
	 * Returns a list of all tags registered to the service.
	 * 
	 * @return
	 */
	List<RifidiTag> getRegisteredTags();

	/**
	 * Returns a list of all available (not taken) tags.
	 * 
	 * @return
	 */
	List<RifidiTag> getAvailableTags();

	/**
	 * Get a single tag using the tagEntityID.
	 * 
	 * @param tagEntityID
	 * @return
	 */
	RifidiTag getTag(Long tagEntityID);

	/**
	 * Take a tag from the service. The tag is removed from the list of
	 * available tags. A taken take has to be returned using releaseRifidiTag!
	 * 
	 * @param tag
	 * @param taker
	 * @throws RifidiTagNotAvailableException
	 */
	void takeRifidiTag(RifidiTag tag, IRifidiTagContainer taker)
			throws RifidiTagNotAvailableException;

	/**
	 * Release the given tag and make it available again.
	 * 
	 * @param tag
	 * @param taker
	 * @throws RifidiTagNotAvailableException
	 */
	void releaseRifidiTag(RifidiTag tag, IRifidiTagContainer taker);

	/**
	 * Add a new listener to the list of listeners for changes to the set of
	 * available tags.
	 * 
	 * @param listener
	 */
	void addRifidiTagServiceChangeListener(
			RifidiTagServiceChangeListener listener);

	/**
	 * Remove a new listener from the list of listeners for changes to the set
	 * of available tags.
	 * 
	 * @param listener
	 */
	void removeRifidiTagServiceChangeListener(
			RifidiTagServiceChangeListener listener);
}
