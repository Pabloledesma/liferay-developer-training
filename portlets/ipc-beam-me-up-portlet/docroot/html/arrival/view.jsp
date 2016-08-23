<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

This is the <b>Arrival Portlet</b> portlet in View mode.
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
   <portlet:defineObjects />

   <%String beammeup = (String)renderRequest.getParameter("beammeup");%>
   <p>And the destination is....</p>
   <p>
   <% if (beammeup!=null) { %>
   <%=beammeup %>!
   <% } else { %>
   ... waiting for transporting.
   <% } %>