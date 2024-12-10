<?php
    include_once("../model/BO/UserBO.php");
    class AuthController {
        public function login($username, $password) {
            $userBO = new UserBO();
            if ($userBO->login($username, $password)) {
                session_start();
                $_SESSION['user'] = $userBO->login($username, $password);
                header('Location:UserController.php?action=search');
            } else {
                echo "Invalid username or password";
                echo "<a href='AuthController.php?action=login'>Try again</a>";
                echo "<a href='AuthController.php?action=register'>Register</a>";
            }
        }

        public function showLoginForm() {
            include_once('../view/auth/login.html');
        }

        public function showRegisterForm() {
            include_once('../view/auth/register.html');
        }

        public function register($username, $password,$firstname,$lastname,$roles) {
            $userBO = new UserBO();
            $userBO->addUser($username, $password,$firstname,$lastname,$roles);
            header('Location: AuthController.php?action=login');
        }

        public function invoke() {
            $action = isset($_GET['action'])? $_GET['action'] : 'login';
            switch ($action) {
                case 'login':
                    if (isset($_POST['username'])) {
                        $this->login($_POST['username'], $_POST['password']);
                    } else {
                        $this->showLoginForm();
                    }
                    break;
                case'register':
                    if (isset($_POST['username'])) {
                        $this->register($_POST['username'], $_POST['password'], $_POST['firstname'], $_POST['lastname'], $_POST['roles']);
                    } else {
                        $this->showRegisterForm();
                    }
                    break;
            }
        }
    }
    $authController = new AuthController();
    $authController->invoke();
?>