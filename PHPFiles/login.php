<?php 

require "conn.php";
#Defining $_POST variables
$user_name = $_POST["user_name"];
$user_pass = $_POST["password"];
$user_role = $_POST["user_role"];

#Defining constants
define("StudentRole", "student");
define("StaffRole", "teacher");

# Getting that user name of that specific user_role exists
$sql = "SELECT `username` FROM `login` WHERE `username`='$user_name' and `password`='$user_pass' and `user_role` = '$user_role'";
$ifLoginTrue = mysqli_query($conn,$sql);
if(mysqli_num_rows($ifLoginTrue)>0){
	if(strcmp($user_role, StudentRole)==0){
		$mysql_qry = "select * from `student` where `username`='$user_name' and `password`='$user_pass'";
		$result = mysqli_query($conn,$mysql_qry);
		#Converting the response to JSON
		$rows = array();
		$loginResponseIs->loginResponse = $rows;
		if(mysqli_num_rows($result) > 0) {	
				$rows = array();
				while($r = mysqli_fetch_assoc($result)) {
				    $rows[] = $r;
				}
				$loginResponseIs->loginStatus = "success";
				$loginResponseIs->loginResponse = $rows;
				echo json_encode($loginResponseIs);
		}
		else {
			$rows = array();
			$loginResponseIs->loginResponse = $rows;
			$loginResponseIs->loginStatus = "error";
			echo json_encode($loginResponseIs);	
		}
	}
	elseif (strcmp($user_role, StaffRole)==0) {
		$mysql_qry = "select * from `teacher` where `username`='$user_name' and `password`='$user_pass'";
		$result = mysqli_query($conn,$mysql_qry);
		#Converting the response to JSON
		$rows = array();
		$loginResponseIs->loginResponse = $rows;
		if(mysqli_num_rows($result) > 0) {	
				$rows = array();
				while($r = mysqli_fetch_assoc($result)) {
				    $rows[] = $r;
				}
				$loginResponseIs->loginStatus = "success";
				$loginResponseIs->loginResponse = $rows;
				echo json_encode($loginResponseIs);
		}
		else {
			$rows = array();
			$loginResponseIs->loginResponse = $rows;
			$loginResponseIs->loginStatus = "error";
			echo json_encode($loginResponseIs);	
		}
	}
	
}
else{
			$rows = array();
			$loginResponseIs->loginResponse = $rows;
			$loginResponseIs->loginStatus = "error";
			echo json_encode($loginResponseIs);	
}
?>