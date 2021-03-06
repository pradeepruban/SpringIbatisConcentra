<%/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/%>
<%
/********************************************************************
 Author 				: Syntel
 Version 				: 1.0
 Purpose				: This is for User Application Queue SOP Exclusion List of SyntBotsITOps Application
 ********************************************************************/
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Application Queue SOP Exclusion</title>
<script>
/**
 *This is method is called during jsp is loaded
 */
$(document).ready(function() {
	fnInitializeUsrApplnQueSopExclsnDataTable();
	fnGetUsrApplnQueSopExclsnDetails();
})
/**
 *This function is used to get data table properties of user application queue SOP exclusion data table
 */
var varUsrApplnQueSopExclsnDataTable;
function fnInitializeUsrApplnQueSopExclsnDataTable(){
	//alert("Inside Dtable")
	varUsrApplnQueSopExclsnDataTable = $('#usrApplnQueSopExclsnDataTableId').dataTable({
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
														 // "sAjaxSource": 'usrApplnQueSopExclsnDetails',
														   "aoColumns" : [{
																"data" : "usrApplnQueSopExclsnUsrId"
															},{
																"data" : "usrApplnQueSopExclsnApplicationId"
															},{
																"data" : "usrApplnQueSopExclsnQueueId"
															}, {
																"data" : "usrApplnQueSopExclsnSopId"
															},{
																"data" : "strUsrApplnQueSopExclsnUsrName"
															}, {
																"data" : "strUsrApplnQueSopExclsnApplicationName"
															},{
																"data" : "strUsrApplnQueSopExclsnQueueName"
															}, {
																"data" : "strUsrApplnQueSopExclsnSopName"
															}, {
																"data" : "usrApplnQueSopExclsnDeleteFlag",
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
																"data" : "strUsrApplnQueSopExclsnCreatedByShortUserName"
															},
															{
																"data" : "strUsrApplnQueSopExclsnModifiedByShortUserName"
															},
															{
																"data" : "strUsrApplnQueSopExclsnCreatedDate"
															},
															{
																"data" : "strUsrApplnQueSopExclsnModifiedDate"
															} 
														 ]
														});
	varUsrApplnQueSopExclsnDataTable.fnSetColumnVis( 0, false );
	varUsrApplnQueSopExclsnDataTable.fnSetColumnVis( 1, false );
	varUsrApplnQueSopExclsnDataTable.fnSetColumnVis( 2, false );
	varUsrApplnQueSopExclsnDataTable.fnSetColumnVis( 3, false );
	/*varRgstTlDataTable.fnSetColumnVis( 5, false );
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
 *This method is used to intiate an ajax call to get User Application Queue SOP Exclusion Details list
 * @return success function/ error function
 */
function fnGetUsrApplnQueSopExclsnDetails()
{
	  var getGetUsrApplnQueSopExclsnDetailsJsonObj = {};
	  var strJSON = JSON.stringify(getGetUsrApplnQueSopExclsnDetailsJsonObj);
	  fnCommonDoAjaxForGet("<%=request.getContextPath()%>/pages/usrApplnQueSopExclsnDetails", strJSON,  "fnSucAfterGetUsrApplnQueSopExclsnDetails", "fnErrAfterGetUsrApplnQueSopExclsnDetails");
	
}
/**This method is called on success of fnCommonDoAjaxForGet util method with action get User Application Queue SOP Exclusion Details list
* @param Queue details
*/
function fnSucAfterGetUsrApplnQueSopExclsnDetails(UsrApplnQueSopExclsnDtls)
{
	fnLoadDataTable(varUsrApplnQueSopExclsnDataTable, UsrApplnQueSopExclsnDtls);
	varUsrApplnQueSopExclsnDataTable.find('tbody tr:first').addClass('row_selected');
}
/**This method is called on failure of fnCommonDoAjaxForGet util method with action get User Application Queue SOP Exclusion Details list
*/
function fnErrAfterGetUsrApplnQueSopExclsnDetails()
{
	alert("User Application Queue SOP Exclusion Details error");
} 
/**This method is called on clicking of row in User Application Queue SOP Exclusion Details data table
*/
$("#usrApplnQueSopExclsnDataTableId tbody").on('click', 'tr', function() {
	
	$("#usrApplnQueSopExclsnDataTableId tbody tr").removeClass('row_selected');	
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
								<h2>User Application Queue SOP Exclusion </h2>
							</header>
							<!-- widget div-->
							<div>
								<!-- widget content -->
								<div class="widget-body no-padding">
									<table id="usrApplnQueSopExclsnDataTableId" class="table table-striped table-bordered table-hover" width="100%">
										<thead>
											<tr>
												<th>User Id</th>
												<th>Application Id</th>
												<th>Queue Id</th>
												<th>SOP Id</th>
												<th>User Name</th>
												<th>Application Name</th>
												<th>Queue Name</th>
												<th>SOP Name</th>
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
</body>
</html>