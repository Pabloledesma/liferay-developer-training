/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.training.parts.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.training.parts.model.Part;
import com.liferay.training.parts.service.base.PartLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the part local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.training.parts.service.PartLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author naguayo
 * @see com.liferay.training.parts.service.base.PartLocalServiceBaseImpl
 * @see com.liferay.training.parts.service.PartLocalServiceUtil
 */
public class PartLocalServiceImpl extends PartLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.training.parts.service.PartLocalServiceUtil} to access the part local service.
	 */
		/**
	 * Adds the Part to the database incrementing the primary key
	 *
	 */
	public Part addPart(Part part) throws SystemException {

		long partId = counterLocalService.increment(Part.class.getName());

		part.setPartId(partId);

		return super.addPart(part);
	}

	/**
	 * Gets a list with all the Parts in a group
	 *
	 */
	public List<Part> getPartsByGroupId(long groupId) throws SystemException {

		return partPersistence.findByGroupId(groupId);
	}

	/**
	 * Gets a list with a range of Parts from a group
	 *
	 */
	public List<Part> getPartsByGroupId(long groupId, int start, int end) throws SystemException {

		return partPersistence.findByGroupId(groupId, start, end);
	}

	/**
	 * Gets the number of Parts in a group
	 *
	 */
	public int getPartsCountByGroupId(long groupId) throws SystemException {

		return partPersistence.countByGroupId(groupId);
	}

	/**
	 * Gets a list of Parts from a Manufacturer
	 *
	 */
	public List<Part> getPartsByManufacturer(long manufacturerId, long groupId) throws SystemException {

		return partPersistence.findByManufacturer(manufacturerId, groupId);
	}
}