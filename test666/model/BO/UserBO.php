<?php
    include_once("../model/DAO/UserDAO.php");
    class UserBO {
        private $userDAO;
        public function __construct() {
            $this->userDAO = new UserDAO();
        }
        public function login($username, $password) {
            return $this->userDAO->checkLogin($username, $password);
        }

        public function getUserList() {
            return $this->userDAO->getUserList();
        }

        public function searchUsersByName($name) {
            return $this->userDAO->searchUsersByName($name);
        }

        public function getUserByUsername($username) {
            return $this->userDAO->getUserByUsername($username);
        }

        public function addUser($username, $password,$firstname,$lastname,$roles) {
            return $this->userDAO->addUser($username, $password, $firstname, $lastname, $roles );
        }

        public function updateUser($username, $lastname, $roles) {
            return $this->userDAO->updateUser( $username, $lastname, $roles);
        }
        public function deleteUser($username) {
            return $this->userDAO->deleteUser($username);
        }




    }
?>