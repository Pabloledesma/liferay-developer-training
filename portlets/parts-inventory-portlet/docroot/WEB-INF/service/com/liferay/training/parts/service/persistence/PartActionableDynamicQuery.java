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

package com.liferay.training.parts.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.liferay.training.parts.model.Part;
import com.liferay.training.parts.service.PartLocalServiceUtil;

/**
 * @author naguayo
 * @generated
 */
public abstract class PartActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public PartActionableDynamicQuery() throws SystemException {
		setBaseLocalService(PartLocalServiceUtil.getService());
		setClass(Part.class);

		setClassLoader(com.liferay.training.parts.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("partId");
	}
}