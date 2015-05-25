<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8"/>
<title>Dashboard</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css"/>
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="css/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="css/uniform.default.css" rel="stylesheet" type="text/css"/>
<link href="css/bootstrap-switch.css" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN THEME STYLES -->
<!-- DOC: To use 'rounded corners' style just load 'components-rounded.css' stylesheet instead of 'components.css' in the below style tag -->
<link href="css/components-rounded.css" id="style_components" rel="stylesheet" type="text/css"/>
<link href="css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="css/layout.css" rel="stylesheet" type="text/css"/>
<link href="css/light.css" rel="stylesheet" type="text/css" id="style_color"/>
<link href="css/custom.css" rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->

<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="../../assets/global/plugins/respond.min.js"></script>
<script src="../../assets/global/plugins/excanvas.min.js"></script> 
<![endif]-->
	<script src="js/jquery.min.js" type="text/javascript"></script>
	<script src="js/jquery-migrate.min.js" type="text/javascript"></script>
	<script src="js/jquery-ui.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
	<script src="js/jquery.slimscroll.min.js" type="text/javascript"></script>
	<script src="js/jquery.blockui.min.js" type="text/javascript"></script>
	<script src="js/jquery.cokie.min.js" type="text/javascript"></script>
	<script src="js/jquery.uniform.min.js" type="text/javascript"></script>
	<script src="js/bootstrap-switch.js" type="text/javascript"></script>
	<!-- END CORE JQUERY PLUGINS -->
	<script src="js/bootbox.min.js" type="text/javascript"></script>
	<!-- BEGIN CORE ANGULARJS PLUGINS -->
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.12/angular.js" type="text/javascript"></script>	
	<script src="js/angular-sanitize.min.js" type="text/javascript"></script>
	<script src="js/angular-touch.min.js" type="text/javascript"></script>	
	<script src="js/angular-ui-router.min.js" type="text/javascript"></script>
	<script src="js/ocLazyLoad.min.js" type="text/javascript"></script>
	<script src="js/ui-bootstrap-tpls.min.js" type="text/javascript"></script>
	<!-- END CORE ANGULARJS PLUGINS -->
	
	<!-- BEGIN APP LEVEL ANGULARJS SCRIPTS -->
	<script src="js/app.js" type="text/javascript"></script>
	<script src="js/directives.js" type="text/javascript"></script>
	<!-- END APP LEVEL ANGULARJS SCRIPTS -->
	
	<!-- BEGIN APP LEVEL JQUERY SCRIPTS -->
	<script src="js/metronic.js" type="text/javascript"></script>
	<script src="js/layout.js" type="text/javascript"></script>
	<script src="js/demo.js" type="text/javascript"></script>
	<script src="js/ui-alert-dialog-api.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>

function populateContactData(id, name, phone, email, city, country){
	$("#cntID").val(id);
	$("#cntName").val(name);
	$("#cntPhone").val(phone);
	$("#cntEMail").val(email);
	$("#cntCity").val(city);
	$("#cntCountry").val(country);
}


jQuery(document).ready(function() {
	
	UIAlertDialogApi.init();
	
	$("#clearCnt").click(function(){
		$("#cntID").val("");
		$("#cntName").val("");
		$("#cntPhone").val("");
		$("#cntEMail").val("");
		$("#cntCity").val("");
		$("#cntCountry").val("");
	});
   
	$("#saveCnt").click(function(){
		var id = $("#cntID").val();
		var name = $("#cntName").val();
		var phone = $("#cntPhone").val();
		var email = $("#cntEMail").val();
		var city = $("#cntCity").val();
		var country = $('#cntCountry').val();
		var request = $.ajax({  
            type: "POST",  
            url: "/saveCnt.json",  
            data: "id="+id+"&name="+name+"&phone="+phone+"&email="+email+"&city="+city+"&country="+country
        });
		
		bootbox.alert("Contact Saved !!");
	});
	
	$("#deleteCnt").click(function(){
		var id = $("#cntID").val();
		var request = $.ajax({  
            type: "POST",  
            url: "/deleteCnt.json",  
            data: "id="+id
        });
		
		bootbox.alert("Contact Deleted !!");
	});	
	
	$.getJSON("/getAllContacts.json", function(data) {
        $.each(data, function(i, user) {
            var tblRow = "<tr onclick=\"populateContactData("+user.id+",'"+user.name+"','"+user.phone+"','"+user.email+"','"+user.city+"','"+user.country+"')\"><td>" + user.id + "</td>"
                    		+ "<td>" + user.name + "</td><td>" + user.phone + "</td><td>" + user.email + "</td><td>" + user.city + "</td><td>" + user.country + "</td></tr>"
            $(tblRow).appendTo("#myContacts tbody");
        });
    });
	
});
</script>
<!-- END JAVASCRIPTS -->

</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<!-- DOC: Apply "page-header-fixed-mobile" and "page-footer-fixed-mobile" class to body element to force fixed header or footer in mobile devices -->
<!-- DOC: Apply "page-sidebar-closed" class to the body and "page-sidebar-menu-closed" class to the sidebar menu element to hide the sidebar by default -->
<!-- DOC: Apply "page-sidebar-hide" class to the body to make the sidebar completely hidden on toggle -->
<!-- DOC: Apply "page-sidebar-closed-hide-logo" class to the body element to make the logo hidden on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-hide" class to body element to completely hide the sidebar on sidebar toggle -->
<!-- DOC: Apply "page-sidebar-fixed" class to have fixed sidebar -->
<!-- DOC: Apply "page-footer-fixed" class to the body element to have fixed footer -->
<!-- DOC: Apply "page-sidebar-reversed" class to put the sidebar on the right side -->
<!-- DOC: Apply "page-full-width" class to the body element to have full width page without the sidebar menu -->
<body class="page-header-fixed page-sidebar-closed-hide-logo page-sidebar-closed-hide-logo">
<!-- BEGIN HEADER -->
<div class="page-header navbar navbar-fixed-top">
	<!-- BEGIN HEADER INNER -->
	<div class="page-header-inner">
		<!-- BEGIN RESPONSIVE MENU TOGGLER -->
		<a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
		</a>
		<!-- END RESPONSIVE MENU TOGGLER -->
		<!-- BEGIN PAGE TOP -->
		<div class="page-top">
			<!-- BEGIN TOP NAVIGATION MENU -->
			<div class="top-menu">
				<ul class="nav navbar-nav pull-right">
					<li class="separator hide">
					</li>
					<!-- BEGIN USER LOGIN DROPDOWN -->
					<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
					<li class="dropdown dropdown-user dropdown-dark">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<span class="username username-hide-on-mobile">
						<%= request.getSession().getAttribute("loggedUser") %> </span>
						</a>
						<ul class="dropdown-menu dropdown-menu-default">
							<li>
								<a href="login.html?logout=logout">
								<i class="icon-key"></i> Log Out </a>
							</li>
						</ul>
					</li>
					<!-- END USER LOGIN DROPDOWN -->
				</ul>
			</div>
			<!-- END TOP NAVIGATION MENU -->
		</div>
		<!-- END PAGE TOP -->
	</div>
	<!-- END HEADER INNER -->
</div>
<!-- END HEADER -->
<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
	<!-- BEGIN CONTENT -->
		<div class="page-content">
			<div class="modal fade" id="portlet-config" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
							<h4 class="modal-title">Modal title</h4>
						</div>
						<div class="modal-body">
							 Widget settings form goes here
						</div>
						<div class="modal-footer">
							<button type="button" class="btn blue">Save changes</button>
							<button type="button" class="btn default" data-dismiss="modal">Close</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- BEGIN PAGE BREADCRUMB -->
			<ul class="page-breadcrumb breadcrumb hide">
				<li>
					<a href="#">Home</a><i class="fa fa-circle"></i>
				</li>
				<li class="active">
					 Dashboard
				</li>
			</ul>
			<!-- END PAGE BREADCRUMB -->
			<div class="row">
				<div class="col-md-6 col-sm-12">
					<!-- BEGIN PORTLET-->
					<div class="portlet light ">
						<div class="portlet-title">
							<div class="caption caption-md">
								<i class="icon-bar-chart theme-font-color hide"></i>
								<span class="caption-subject theme-font-color bold uppercase">My contacts</span>
							</div>
						</div>
						<div class="portlet-body">
							<table id="myContacts" class="table table-striped table-bordered table-hover dataTable no-footer" cellspacing="0" width="100%">
						        <thead>
								    <tr>
								    	<th>ID</th>
								    	<th>Name</th>
								    	<th>Phone</th>
								    	<th>E-Mail</th>
								    	<th>City</th>
								    	<th>Country</th>
								    </tr>
								 </thead>
						 					 
						        <tbody>
						        	
								</tbody>
						        
						    </table>
						</div>
						
						<div class="form-group">
							<label class="control-label">ID</label>
							<input id="cntID" type="text" readonly="readonly" placeholder="ID" class="form-control"/>
						</div>
						<div class="form-group">
							<label class="control-label">Name</label>
							<input id="cntName" type="text" placeholder="Name" class="form-control"/>
						</div>
						<div class="form-group">
							<label class="control-label">Phone</label>
							<input id="cntPhone" type="text" placeholder="Phone" class="form-control"/>
						</div>
						<div class="form-group">
							<label class="control-label">E-Mail</label>
							<input id="cntEMail" type="text" placeholder="E-Mail" class="form-control"/>
						</div>
						<div class="form-group">
							<label class="control-label">City</label>
							<input id="cntCity" type="text" class="form-control" placeholder="City" />
						</div>
						<div class="form-group">
							<label class="control-label">Country</label>
							<input id="cntCountry" type="text" class="form-control" placeholder="Country" />
						</div>
						<div class="form-group">
							<input id="saveCnt" value="Save" name="saveCnt" type="button" class="btn default"/>
							<input id="deleteCnt" value="Delete" name="deleteCnt" type="button" class="btn default"/>
							<input id="clearCnt" value="Clear" name="ClearCnt" type="button" class="btn default"/>
						</div>
						
					</div>
					<!-- END PORTLET-->
				</div>
			</div>
			
		</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->

</body>
<!-- END BODY -->
</html>