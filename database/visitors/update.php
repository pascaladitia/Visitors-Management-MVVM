<?php

include_once('koneksi.php');

if (!empty($_POST['id']) && !empty($_POST['name']) && !empty($_POST['address']) && !empty($_POST['nohp'])
        && !empty($_POST['profession']) && !empty($_POST['visitors'])) {

    $id = $_POST['id'];
    $name = $_POST['name'];
    $address = $_POST['address'];
    $nohp = $_POST['nohp'];
    $profession = $_POST['profession'];
    $visitors = $_POST['visitors'];

    $query = "UPDATE visitors set name = '$name', address = '$address', nohp = '$nohp',
        profession = '$profession', visitors = '$visitors' WHERE id = '$id'";

    $update = mysqli_query($connect, $query);

    if($update) {
        set_response(true, "Success update data");
    } else {
        set_response(false, "False update data");
    }
} else {
    set_response(false, "id, name, address, nohp, profession & visitors harus diisi");
}

function set_response($isSuccess, $message) {
    $result = array(
        'isSuccess' => $isSuccess,
        'message' => $message
    );
    
    echo json_encode($result);
}