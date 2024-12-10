<?php
    class User {
        private $username;
        private $password;
        private $firstname;
        private $lastname;
        private $roles;

        public function __construct($username, $password, $firstname, $lastname, $roles) {
            $this->username = $username;
            $this->password = $password;
            $this->firstname = $firstname;
            $this->lastname = $lastname;
            $this->roles = $roles;
        }

        public function getFirstname() {
            return $this->firstname;
        }

        public function getLastname() {
            return $this->lastname;
        }

        public function getRoles() {
            return $this->roles;
        }
        public function getUsername() {
            return $this->username;
        }

    }
?>