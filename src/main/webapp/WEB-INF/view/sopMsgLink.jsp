<%/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/%>
<%
/********************************************************************
 Author 				: Syntel
 Version 				: 1.0
 Purpose				: This is for SOP message link details List of SyntBotsITOps Application
 ********************************************************************/
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SOP Message Link</title>
<script>
/**
 *This is method is called during jsp is loaded
 */
$(document).ready(function() {
	fnInitializeSopMsgLnkDataTable();
	fnGetSopMskLnkDetails();
})
/**
 *This function is used to get data table properties of SOP message link data table
 */
var varSopMsgLnkDataTable;
function fnInitializeSopMsgLnkDataTable(){
	//alert("Inside Dtable")
	varSopMsgLnkDataTable = $('#sopMsgLnkDataTableId').dataTable({
															"processing" : true,
															"scrollY" : "195px",
															"autoWidth" : true,
															"iDisplayLength" : 5,
															"sDom" : "<'dt-toolbar'<'col-xs-6 col-sm-6'f>r>"
																+ "t"
																+ "<'dt-toolbar-footer'<'col-sm-6 col-xs-6 hidden-xs'i><'col-sm-6 col-xs-12'p>>",
											"oTableTools" : {
															"aButtons" : [
																	"copy",
																	"csv",
																	"xls",
																	{
																		"sExtends" : "pdf",
																		"sTitle" : "SyntBots_PDF",
																		"sPdfMessage" : "SyntBots PDF Export",
																		"sPdfSize" : "letter"
																	},
																	{
																		"sExtends" : "print",
																		"sMessage" : "Generated by SyntBots <i>(press Esc to close)</i>"
																	} ],
															"sSwfPath" : "<%=request.getContextPath()%>/smartadmin/js/plugin/datatables/swf/copy_csv_xls_pdf.swf"
														}, 
														  // "sAjaxSource": 'listSopMskLnkDetails',
														   "aoColumns" : [ {
																"data" : "sopId"
															},  {
																"data" : "sopName"
															},{
																"data" : "msgKeyword"
															},
															{
																"data" : "deleteFlag",
																"mRender": function (data, type, row) {
																	if( (typeof(data) !="undefined")  && (data != 'undefined') && (data != null) ){
																		 if (data == '0') {
																			 return ' <span class="badge bg-color-green">No</span>';
																          } else if(data == '1') {
																        	   return ' <span class="badge bg-color-orange">Yes</span>';
																          }
															          		else{
																	   		return data;
																	  		}
																	 }else{
																			data = '';
																			return data;
																		}
																	  
																}
															}, 
															{
																"data" : "strCreatedByShortUserName"
															},
															{
																"data" : "strModifiedByShortUserName"
															},
															{
																"data" : "strSopMsgLnkCreatedDate"
															},
															{
																"data" : "strSopMsgLnkModifiedDate"
															}]
														
														
														});
	varSopMsgLnkDataTable.fnSetColumnVis( 0, false );
	/* varRgstTlDataTable.fnSetColumnVis( 3, false );
	varRgstTlDataTable.fnSetColumnVis( 4, false );
	varRgstTlDataTable.fnSetColumnVis( 5, false );
	varRgstTlDataTable.fnSetColumnVis( 8, false );
	varRgstTlDataTable.fnSetColumnVis( 9, false );
	varRgstTlDataTable.fnSetColumnVis( 10, false );
	varRgstTlDataTable.fnSetColumnVis( 11, false );
	varRgstTlDataTable.fnSetColumnVis( 12, false );
	varRgstTlDataTable.fnSetColumnVis( 13, false );
	varRgstTlDataTable.fnSetColumnVis( 14, false );
	varRgstTlDataTable.fnSetColumnVis( 15, false );
	varRgstTlDataTable.fnSetColumnVis( 16, false ); */
	
	
	  
}
/**
 *This method is used to intiate an ajax call to get SOP message link details list
 * @return success function/ error function
*/
function fnGetSopMskLnkDetails()
{
	  var getGetSopMskLnkDetailsJsonObj = {};
	  var strJSON = JSON.stringify(getGetSopMskLnkDetailsJsonObj);
	  fnCommonDoAjaxForGet("<%=request.getContextPath()%>/pages/listSopMskLnkDetails", strJSON,  "fnSucAfterGetSopMskLnkDetails", "fnErrAfterGetSopMskLnkDetails");
	
}
/**This method is called on success of fnCommonDoAjaxForGet util method with action get SOP message link details list
* @param Queue details
*/
function fnSucAfterGetSopMskLnkDetails(SOPMessageLinkDtls)
{
	fnLoadDataTable(varSopMsgLnkDataTable, SOPMessageLinkDtls);
	varSopMsgLnkDataTable.find('tbody tr:first').addClass('row_selected');
}
/**This method is called on failure of fnCommonDoAjaxForGet util method with action get get SOP workflow link details list
*/
function fnErrAfterGetSopMskLnkDetails()
{
	alert("SOP message link Details error");
} 
/**This method is called on clicking of row in SOP workflow link details data table
*/
$("#sopMsgLnkDataTableId tbody").on('click', 'tr', function() {
	
	$("#sopMsgLnkDataTableId tbody tr").removeClass('row_selected');	
    $(this).addClass('row_selected');
	
});


</script>
</head>
<body>
	<!-- MAIN CONTENT -->
	<div id="content">
		<!-- widget grid -->
		<section id="widget-grid" class="">
			<!-- row -->
			<div class="row">
				<!-- NEW WIDGET START -->
				<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<!-- Widget ID (each widget will need unique ID)-->
					<div class="jarviswidget jarviswidget-color-darken" id="wid-id-0" data-widget-editbutton="false">
						<!-- widget options:
						usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">
								data-widget-colorbutton="false"
								data-widget-editbutton="false"
								data-widget-togglebutton="false"
								data-widget-deletebutton="false"
								data-widget-fullscreenbutton="false"
								data-widget-custombutton="false"
								data-widget-collapsed="true"
								data-widget-sortable="false"
						-->
							<header>
								<h2>SOP Message Link </h2>
							</header>
							<!-- widget div-->
							<div>
								<!-- widget content -->
								<div class="widget-body no-padding">
									<table id="sopMsgLnkDataTableId" class="table table-striped table-bordered table-hover" width="100%">
										<thead>
											<tr>
												<th>SOP Id</th>
												<th>SOP Name</th>	
												<th>Message Keyword</th>	
												<th>Deleted&nbsp;<i class="fa fa-question"></i></th>
												<th>Created By</th>	
												<th>Modified By</th>
												<th style="width:15%;">Created Date</th>	
												<th style="width:15%;">Modified Date</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
								</div>
								<!-- end widget content -->
							</div>
							<!-- end widget div -->
						</div>
						<!-- end widget -->
					</article>
					<!-- NEW WIDGET END -->
				</div>
				<!-- end row -->
			</section>
			<!-- end widget grid -->
		</div>
		<!-- END MAIN CONTENT -->
	
SOP Message Link
</body>
</html>