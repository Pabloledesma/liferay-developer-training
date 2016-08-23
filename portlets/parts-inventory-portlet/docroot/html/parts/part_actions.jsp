<%@include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Part part = (Part)row.getObject();

long groupId = part.getGroupId();
String name = Part.class.getName();
long partId = part.getPartId();

String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu >
	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/parts/edit_part.jsp" />
		<portlet:param name="partId" value="<%= String.valueOf(partId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>

	<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />

	<portlet:actionURL name="deletePart" var="deleteURL">
		<portlet:param name="partId" value="<%= String.valueOf(partId) %>" />
		<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(renderRequest) %>"/>
	</portlet:actionURL>
		
	<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
</liferay-ui:icon-menu>