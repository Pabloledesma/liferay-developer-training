package com.liferay.training.parts.portlet;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.training.parts.model.Manufacturer;
import com.liferay.training.parts.service.ManufacturerLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class ManufacturerPortlet
 */
public class ManufacturerPortlet extends MVCPortlet {
 	/**
	 * Adds a new manufacturer to the database
	 * 
	 */

	public void addManufacturer(ActionRequest request, ActionResponse response)
		throws Exception {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

		Manufacturer manufacturer = ManufacturerLocalServiceUtil.createManufacturer(0);

		manufacturer.setManufacturerId(ParamUtil.getLong(request, "manufacturerId"));
		manufacturer.setName(ParamUtil.getString(request, "name"));
		manufacturer.setEmailAddress(ParamUtil.getString(request, "emailAddress"));
		manufacturer.setWebsite(ParamUtil.getString(request, "website"));
		manufacturer.setPhoneNumber(ParamUtil.getString(request, "phoneNumber"));
		manufacturer.setCompanyId(themeDisplay.getCompanyId());
		manufacturer.setGroupId(themeDisplay.getScopeGroupId());
		manufacturer.setUserId(themeDisplay.getUserId());

		List<String> errors = new ArrayList<String>();

		if (ManufacturerValidator.validateManufacturer(manufacturer, errors)) {
			ManufacturerLocalServiceUtil.addManufacturer(manufacturer);

			SessionMessages.add(request, "manufacturer-added");

			sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter("mvcPath", "/html/manufacturer/edit_manufacturer.jsp");
		}
	}

		/**
	 * Updates the database record of an existing manufacturer.
	 *
	 */
	public void updateManufacturer(ActionRequest request, ActionResponse response)
		throws Exception {

		long manufacturerId = ParamUtil.getLong(request, "manufacturerId");
		Manufacturer manufacturer = null;
		
		try {
			manufacturer = ManufacturerLocalServiceUtil.fetchManufacturer(manufacturerId);
		} catch (SystemException se) {
			_log.error(se);
			return;
		}

		manufacturer.setName(ParamUtil.getString(request, "name"));
		manufacturer.setEmailAddress(ParamUtil.getString(request, "emailAddress"));
		manufacturer.setWebsite(ParamUtil.getString(request, "website"));
		manufacturer.setPhoneNumber(ParamUtil.getString(request, "phoneNumber"));

		List<String> errors = new ArrayList<String>();

		if (ManufacturerValidator.validateManufacturer(manufacturer, errors)) {
			ManufacturerLocalServiceUtil.updateManufacturer(manufacturer);

			SessionMessages.add(request, "manufacturer-updated");

			sendRedirect(request, response);
		}
		else {
			for (String error : errors) {
				SessionErrors.add(request, error);
			}

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter("mvcPath", "/html/manufacturer/edit_manufacturer.jsp");
		}
	}
	
		/**
	 * Deletes a manufacturer from the database.
	 * 
	 */
	public void deleteManufacturer(ActionRequest request,
			ActionResponse response) throws Exception {

		long manufacturerId = ParamUtil.getLong(request, "manufacturerId");

		if (Validator.isNotNull(manufacturerId)) {
				ManufacturerLocalServiceUtil.deleteManufacturer(manufacturerId);

				SessionMessages.add(request, "manufacturer-deleted");

				sendRedirect(request, response);
			}
			
		else {
			SessionErrors.add(request, "null-manufacturer-error");
			sendRedirect(request, response);
		}
	}
		
	private static Log _log = LogFactoryUtil.getLog(ManufacturerPortlet.class);

}
