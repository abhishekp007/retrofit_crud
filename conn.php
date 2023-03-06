<?php
class DBConnection
{

    public function mycon()
    {
        $con = mysqli_connect("localhost", "root", "", "crud", "3306");
        return $con;
    }
}
