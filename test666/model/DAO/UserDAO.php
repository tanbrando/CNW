<?php

    include_once ("../model/BEAN/User.php");
    class UserDAO {
        public function __construct() {}

        public function checkLogin($username, $password) {
            $link = mysqli_connect("localhost","root","") or die("Couldn't connect to database");
            mysqli_select_db($link,"test666") or die("Couldn't select database");
            $sql = "SELECT * FROM user WHERE username = '$username' AND password = '$password'";
            $result = mysqli_query($link, $sql);
            $row = mysqli_fetch_array($result);
            mysqli_close($link);
            if ($row) {
                return new User($row["username"], $row["password"], $row["firstname"], $row["lastname"], $row["roles"]);
            } else {
                return null;
            }
        }

        public function getUserList() {
            $link = mysqli_connect("localhost","root","") or die("Couldn't connect to database");
            mysqli_select_db($link,"test666") or die("Couldn't select database");
            $sql = "SELECT * FROM user";
            $result = mysqli_query($link, $sql);
            $users = [];
            while ($row = mysqli_fetch_array($result)) {
                $users[] = new User($row["username"], $row["password"], $row["firstname"], $row["lastname"], $row["roles"]);
            }
            mysqli_close($link);
            return $users;
        }

        public function searchUsersByName($name) {
            $link = mysqli_connect("localhost","root","") or die("Couldn't connect to database");
            mysqli_select_db($link,"test666") or die("Couldn't select database");
            $sql = "SELECT * FROM user WHERE firstname LIKE '%$name%' OR lastname LIKE '%$name%'";
            $result = mysqli_query($link, $sql);
            $users = [];
            while ($row = mysqli_fetch_array($result)) {
                $users[] = new User($row["username"], $row["password"], $row["firstname"], $row["lastname"], $row["roles"]);
            }
            mysqli_close($link);
            return $users;
        }

        public function getUserByUsername($username) {
            $link = mysqli_connect("localhost","root","") or die("Couldn't connect to database");
            mysqli_select_db($link,"test666") or die("Couldn't select database");
            $sql = "SELECT * FROM user WHERE username = '$username'";
            $result = mysqli_query($link, $sql);
            $row = mysqli_fetch_array($result);
            mysqli_close($link);
            if ($row) {
                return new User($row["username"], $row["password"], $row["firstname"], $row["lastname"], $row["roles"]);
            } else {
                return null;
            }
        }

        public function addUser($username, $password, $firstname, $lastname, $roles) {
            $link = mysqli_connect("localhost","root","") or die("Couldn't connect to database");
            mysqli_select_db($link,"test666") or die("Couldn't select database");
            $sql = "INSERT INTO user (username, password, firstname, lastname, roles) VALUES ('$username', '$password', '$firstname', '$lastname', '$roles')";
            mysqli_query($link, $sql);
            mysqli_close($link);
        }

        public function updateUser($username,$lastname, $roles) {
            $link = mysqli_connect("localhost","root","") or die("Couldn't connect to database");
            mysqli_select_db($link,"test666") or die("Couldn't select database");
            $sql = "UPDATE user SET lastname = '$lastname', roles = '$roles' WHERE username = '$username'";
            mysqli_query($link, $sql);
            mysqli_close($link);
        }

        public function deleteUser($username) {
            $link = mysqli_connect("localhost","root","") or die("Couldn't connect to database");
            mysqli_select_db($link,"test666") or die("Couldn't select database");
            $sql = "DELETE FROM user WHERE username = '$username'";
            mysqli_query($link, $sql);
            mysqli_close($link);
        }
    }
?>