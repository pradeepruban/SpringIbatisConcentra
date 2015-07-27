<%/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/%>
<%
/********************************************************************
 Author 				: Syntel
 Version 				: 1.0
 Purpose				: This is for Queue details List of SyntBotsITOps Application
 ********************************************************************/
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Queue Details List</title>
<script>
/**
 *This is method is called during jsp is loaded
 */
$(document).ready(function() {
	fnQueueDtlsDataTable();
	fnGetQueueDtls();		  
}); 
/**
 *This function is used to get data table properties of Queue details data table
 */
var varQueueDtlsDataTable;

function fnQueueDtlsDataTable(){
	//alert("Inside Dtable")
	varQueueDtlsDataTable = $('#queueDtlsDataTable').dataTable({
															"processing" : true,
															"destroy" : true,
															"autoWidth" : true,
															"iDisplayLength" :4,
																								 
														//"sAjaxSource": 'getQueueDtls',
														   "aoColumns" : [
														                  {
																"data" : "queId"
															}, {
																"data" : "queName"
															},
															{
																"data" : "queDesc"
															}, 
															
															{
																"data" : "createdUser"
															}, 
															{
																"data" : "strCreatedDate"
															}, {
																"data" : "modifiedUser"
															},{
																"data" : "strModifiedDate"
															},
															
															{
																"data" : "deleteFlag",
																"mRender": function (data, type, row) {
																	 if (data == '0') {
																		  return ' <span class="badge bg-color-green">No</span>';
															          } else if(data == '1') {
															        	   return ' <span class="badge bg-color-orange">Yes</span>';
															          }
															          else{
																	   return data;
																	  }
																	  
														      }	
															},
															{
																"data" : "queueAction"
															},],
															
	});
	}
/**
 *This method is used to intiate an ajax call to get Queue details list
 * @return success function/ error function
*/
function fnGetQueueDtls()
{
	  var getGetQueueDtlsJsonObj = {};
	  var strJSON = JSON.stringify(getGetQueueDtlsJsonObj);
	  fnCommonDoAjaxForGet("<%=request.getContextPath()%>/pages/getQueueDtls", strJSON,  "fnAfterGetQueueDetails", "fnErrAfterGetQueueDetails");
	
}
/**This method is called on success of fnCommonDoAjaxForGet util method with action get Queue details list
* @param Queue details
*/
function fnAfterGetQueueDetails(queuedtls)
{
	fnLoadDataTable(varQueueDtlsDataTable, queuedtls);
	varQueueDtlsDataTable.find('tbody tr:first').addClass('row_selected');
}
/**This method is called on failure of fnCommonDoAjaxForGet util method with action get Queue details list
*/
function fnErrAfterGetQueueDetails()
{
	alert("Queue Details error");
} 
/**This method is called on clicking of row in queue details data table
*/
$("#queueDtlsDataTable tbody").on('click', 'tr', function() {
	
	$("#queueDtlsDataTable tbody tr").removeClass('row_selected');	
    $(this).addClass('row_selected');
	
});
/**This method is called on clicking of EDIT  in queue details data table To get Popup
*/
function fnPopulateQueueDtls(varQueId){

			//alert("varQueId:  " +varQueId);
			var allQueueData = $('#queueDtlsDataTable').DataTable().rows().data();
			for(var i=0;i<allQueueData.length;i++)
			{
			var tempQueueData = allQueueData [i];
			//alert("inside fnPopulateQueueDtls fn., tempQueueData is:"+tempQueueData +':tempQueueData [queId]:'+tempQueueData ['queId']+':');
			var tempQueueId = tempQueueData ['queId'];
			if(tempQueueId == varQueId)
				{
			//	alert('the queue is matched');
					$("#queId").val(tempQueueId);
					$("#queName").val(tempQueueData ['queName']);
					$("#queDesc").val(tempQueueData ['queDesc']);
					if(tempQueueData ['deleteFlag']==1){
						document.getElementById("checkbox").checked = true;
					}
					else{
					document.getElementById("checkbox").checked = false;
					}
					document.getElementById("deletecheckbox").style.display = 'block';
					$('#itopsAddeditPopUp').modal('show');
					document.getElementById("queName").disabled = true; 
					
					break;
				}
		    
	}
	
	}
/**This method is called on clicking of save button  in queue details data table To validate Qname
*/
	

function fnItOpsValidateQueueDetails(){
	var varItOpsQueueDtlsValidationErrMsg = '';
	 var queName = document.getElementById('queName').value;
	 var queDesc = document.getElementById('queDesc').value;
	 
    if(queName == null || queName == "") {
    	varItOpsQueueDtlsValidationErrMsg = "Queue Name";
    	setInvalidInputFieldBorderRed('queName');
    }
	if(queDesc == null || queDesc == ""){
			if(varItOpsQueueDtlsValidationErrMsg.length > 0)
			{
				varItOpsQueueDtlsValidationErrMsg += ", ";
			}
			varItOpsQueueDtlsValidationErrMsg += "Queue Description";
			setInvalidInputFieldBorderRed('queDesc');
	}
	if(varItOpsQueueDtlsValidationErrMsg.length > 0)
	{
	varItOpsQueueDtlsValidationErrMsg += " are mandatory fields. ";
	}
	if(varItOpsQueueDtlsValidationErrMsg == null || varItOpsQueueDtlsValidationErrMsg == ''){
		var varQueID=getValuesFromInputField("queId");
		if(varQueID==0)
		{
			itOpsGetQueNameCount();
		}
		else{
			fnItopsSaveQueDtls();
		}
	}else{
		//alert(varValidationDetailsErrMsg+" Fields are Required:");
		fnShowItOpsValidationDialog(varItOpsQueueDtlsValidationErrMsg);
	}	
}



/**This method is called on clicking of save button  in queue details data table To get Qname
*/
function itOpsGetQueNameCount(){
	 var varGetQueCountJsonObj = {};
	 varGetQueCountJsonObj['queName'] = getValuesFromInputField("queName");
	 var strJSON = JSON.stringify(varGetQueCountJsonObj);
	 fnCommonDoAjaxForGet("<%=request.getContextPath()%>/pages/itOpsValQueDtls", strJSON,  "fnSucAfterGetQueNameCount", "fnErrAfterGetQueNameCount");
}
/**This method is called on clicking on success of fnCommonDoAjaxForGet util method with action itOpsValQueDtls
* @param Queue details
*/
function fnSucAfterGetQueNameCount(data){
	
	if(data==0){
	fnItopsSaveQueDtls();
	}
	else{
		var QExstmsg = "Queue Name Already  exists";
		fnShowItOpsValidationDialog(QExstmsg);
		//alert("Queue Name Already  exists");
	}
}
/**This method is called on failure of fnCommonDoAjaxForGet util method with action itOpsValQueDtls
*/
function fnErrAfterGetQueNameCount(){
	alert("Failure");
}
/**This method is called on clicking of save button  in queue details data table To Save Quedetails
*/
function fnItopsSaveQueDtls(){
	var itopsSaveQueueJsonObj = {};
	itopsSaveQueueJsonObj['queId'] = getValuesFromInputField("queId");
	var checkboxvalue=document.getElementById("checkbox").checked;
   	if(checkboxvalue==true){
		itopsSaveQueueJsonObj['deleteFlag'] = 1;
	}
	else{
		itopsSaveQueueJsonObj['deleteFlag'] = 0;
	}
	itopsSaveQueueJsonObj['queName'] = getValuesFromInputField("queName");
	itopsSaveQueueJsonObj['queDesc'] = getValuesFromInputField("queDesc");
	var strJSON = JSON.stringify(itopsSaveQueueJsonObj);
	//alert('strJSON is:'+strJSON+':');		
	fnCommonDoAjaxForSave("<%=request.getContextPath()%>/pages/itopsEditQueuedtls", strJSON,  "fnItopsSaveQueDtlsAfterSaveQue", "fnItopsSaveQueDtlsErrAfterSaveQue");

}

function fnItopsSaveQueDtlsAfterSaveQue(){
	$('#itopsAddeditPopUp').modal('hide');
	document.getElementById("deletecheckbox").style.display ='block' ;
	fnGetQueueDtls();
}

function fnItopsSaveQueDtlsErrAfterSaveQue()
{
	alert("After Err server");
	$('#itopsErrorPopUp').modal('show');
}
function fnItopsSaveQueueclearData()
{
	document.getElementById("queId").value = "";
	document.getElementById("queName").value = "";
	document.getElementById("queDesc").value = "";
	
}

function fnItopsAddQueDtls() {
	
	$('#queName').removeAttr('disabled');
	document.getElementById("queId").value = "";
	document.getElementById("queName").value = "";
	document.getElementById("queDesc").value = "";
	document.getElementById("deletecheckbox").style.display = 'none';
	$('#itopsAddeditPopUp').modal('show');
	
}
function fnItopsClearForm()
{
	$('#itopsErrorPopUp').hide;
	fnItopsSaveQueueclearData();
}
</script>
</head>
<body>
			<!-- MAIN CONTENT -->
			<div id="content">

				<!-- widget grid -->
				<section id="widget-grid" class="">
				<!--BUTTONS START -->
			<div class="pull-right" style="padding-right: 2%;" >
				<a data-toggle="modal" onclick="fnItopsAddQueDtls()" class="btn btn-success txt-color-white pull-left  ">
					<i class="fa fa-circle-arrow-up fa-lg">
					</i>
					Add Queue
				</a>   
				<br>
				<br>
			</div>
			<!--BUTTONS END -->
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
								
									<h2>Queue Details List </h2>
				
								</header>
				
								<!-- widget div-->
								<div>
				
									<!-- widget edit box -->
									<div class="jarviswidget-editbox">
										<!-- This area used as dropdown edit box -->
				
									</div>
									<!-- end widget edit box -->
				
									<!-- widget content -->
									<div class="widget-body no-padding">
				
										<table id="queueDtlsDataTable" class="table table-striped table-bordered table-hover" width="100%">
											<thead>
												<tr>
													<th>Queue ID</th>	
													<th>Queue Name</th>	
													<th>Queue Desc</th>
													<th>Created User</th>
													<th style="width:15%;">Created Date</th>	
													<th>Modified User </th>	
													<th style="width:15%;">Modified Date</th>
													<th>Deleted ?</th>
													<th>Actions</th>
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
							</article></div></section>
							
			
		</div>
				<form name="queueDetailsForm"  id="formvalidation" method="post" action="">
							<div class="row">
		<div class="modal fade" id="itopsAddeditPopUp" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title">
							<b> Queue Details</b>
						</h4>
					</div>
					<input type="hidden" name="queId" id="queId" class="form-control"/>
					
					<div class="modal-body">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="category"></label> Queue Name <sup class="reqdField">*</sup> <input type="text"
										name="queName" id="queName"  class="form-control" disabled/>
										<span id="editQname"></span>
								</div>
							</div>
							
							</div>


                         <div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="category"></label> Queue Description <sup class="reqdField">*</sup>  <input type="text"
										name="queDesc" id="queDesc" class="form-control"  required />
								</div>
							</div>
							
						</div>
						 <div class="row" >
						<div class="col-md-6"  id="deletecheckbox" style="display:none">
							<div class="inline-group" >
									<label class="checkbox">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" id="checkbox" name="checkbox-inline" >
									<i></i>Deleted ?</label>
									</div>
							</div>
                            </div>
						<div class="modal-footer">
							<footer>
							
								<button type="button" id="save"class="btn btn-primary" onclick="javascript:fnItOpsValidateQueueDetails();">Save</button>
								<button type="button" class="btn btn-default" data-dismiss="modal" onclick="javascript:fnItopsClearForm();">Cancel</button>
							</footer>
						</div>
							<!-- </form>	 -->
						</div>
					<!-- -/.modal-body -->
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->

		</div>
		
	</form>		<!-- Modal popup for queue -->

</body>
</html>