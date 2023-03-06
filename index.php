<?php
require_once("./conn.php");
$request = $_SERVER['REQUEST_METHOD'];

switch ($request) {
    case 'GET':
        listData();
        break;

    case 'POST':
        insertData();
        break;

    case 'PUT':
        updateData();
        break;

    case 'DELETE':
        deleteData();
        break;

    default:
        echo "Something Worng";
        break;
}

function listData()
{
    $response = array();

    $db = new DBConnection();

    $con = $db->mycon();
    $query = mysqli_query($con, "select * from demo_tbl");
    while ($row = mysqli_fetch_array($query)) {
        $data = array();
        $data["id"] = $row["id"];
        $data["name"] = $row["name"];
        $data["job"] = $row["job"];
        $data["imglink"] = $row["imglink"];
        echo json_encode($data);
    }

    mysqli_close($con);
    // echo json_encode($data);
}

function insertData()
{
    $response = array();
    $db = new DBConnection();

    $name = $_REQUEST["name"];
    $job = $_REQUEST["job"];
    $imglink = $_REQUEST["imglink"];

    $con = $db->mycon();
    $query = mysqli_query($con, "insert into demo_tbl(name,job,imglink) VALUES('$name','$job','$imglink')");

    if ($query == true) {
        $response["msg"] = "Data Successfully Inserted";
    } else {
        $response["msg"] = "Error...";
    }
    mysqli_close($con);
    echo json_encode($response);
}

function updateData()
{
    $response = array();
    $db = new DBConnection();

    if (isset($_POST["id"]) && isset($_POST["name"]) && isset($_POST["job"]) && isset($_POST["imglink"])) {

        $id = $_POST["id"];
        $name = $_POST["name"];
        $job = $_POST["job"];
        $imglink = $_POST["imglink"];

        $con = $db->mycon();
        $query = mysqli_query($con, "update demo_tbl set name='$name',job='$job',imglink='$imglink' where id=$id");

        if (mysqli_affected_rows($query) > 0) {
            $response["msg"] = "Data Successfully Updated";
        } else {
            $response["msg"] = "Error...";
        }
    }
    mysqli_close($con);
    echo json_encode($response);
}

function deleteData()
{
}
