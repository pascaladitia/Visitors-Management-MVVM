<?php

$hostname = "localhost";
$username = "root";
$password = "";
$database = "visitors_management";

$connect = mysqli_connect($hostname, $username, $password, $database);

if (mysqli_connect_errno()) {
    echo "Failed connect to Mysql: " . mysqli_connect_errno(); die();
} else {
  //  echo "Succes connect to Mysql";
}

?>