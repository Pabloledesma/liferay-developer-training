<%@include file="/html/init.jsp" %>

<%
	Manufacturer manufacturer = null;

	long manufacturerId = ParamUtil.getLong(request, "manufacturerId");

	if (manufacturerId > 0) {
		manufacturer = ManufacturerLocalServiceUtil.getManufacturer(manufacturerId);
	}

	String redirect = ParamUtil.getString(request, "redirect");
%>

<aui:model-context bean="<%= manufacturer %>" model="<%= Manufacturer.class %>" />
<portlet:renderURL var="viewManufacturerURL" />
<portlet:actionURL name='<%= manufacturer == null ? "addManufacturer" : "updateManufacturer" %>' var="editManufacturerURL" windowState="normal" />

<liferay-ui:header
	backURL="<%= viewManufacturerURL %>"
	title='<%= (manufacturer != null) ? manufacturer.getName() : "new-manufacturer" %>'
/>

<aui:form action="<%= editManufacturerURL %>" method="POST" name="fm">
	<aui:fieldset>
		
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="manufacturerId" value='<%= manufacturer == null ? "" : manufacturer.getManufacturerId() %>'/>

		<liferay-ui:error key="manufacturername-required" message="manufacturername-required" />
		<aui:input name="name" >
			<aui:validator name="required" errorMessage="You must enter a Manufacturer Name"/>
		</aui:input>

		<liferay-ui:error key="manufactureremail-required" message="manufactureremail-required" />
		<liferay-ui:error key="manufactureremail-format-error"	message="manufactureremail-format-error" />
		<aui:input name="emailAddress" >
			<aui:validator name="required" errorMessage="You must enter an Email Address"/>
		</aui:input>

		<aui:input name="website" >
			<aui:validator name="required" errorMessage="You must enter a URL"/>
		</aui:input>

		<liferay-ui:error key="manufacturerphonenumber-required" message="manufacturerphonenumber-required" />
		<liferay-ui:error key="manufacturerphonenumber-format-error" message="manufacturerphonenumber-format-error" />
		<aui:input name="phoneNumber" >
			<aui:validator name="required" errorMessage="You must enter a Phone Number"/>
		</aui:input>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="<%= viewManufacturerURL %>" />
	</aui:button-row>
</aui:form>