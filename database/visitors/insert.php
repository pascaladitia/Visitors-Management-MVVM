<?php

include_once('koneksi.php');

if (!empty($_POST['name']) && !empty($_POST['address']) && !empty($_POST['nohp']) 
    && !empty($_POST['profession']) && !empty($_POST['visitors'])) {

    $name = $_POST['name'];
    $address = $_POST['address'];
    $nohp = $_POST['nohp'];
    $profession = $_POST['profession'];
    $visitors = $_POST['visitors'];

    $query = "INSERT INTO visitors(name, address, nohp, profession, visitors) 
        VALUES ('$name','$address','$nohp','$profession','$visitors')";

    $insert = mysqli_query($connect, $query);

    if($insert) {
        set_response(true, "Success insert data");
    } else {
        set_response(false, "Failed insert data");
    } 
} else {
        set_response(false, "name, address, nohp, profession & visitors harus diisi");
    }

function set_response($isSuccess, $message) {
    $result = array(
        'isSuccess' => $isSuccess,
        'message' => $message
    );

    echo json_encode($result);
}
