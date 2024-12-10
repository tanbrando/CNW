<?php
    include_once("../model/BO/UserBO.php");

    class UserController {
        public function showSearchForm() {
            include_once("../view/user/search.html");
        }

        public function searchUsers($name) {
            $userBO = new UserBO();
            $userList = $userBO->searchUsersByname($name);
            include_once("../view/user/search.html");
        }

        public function showUpdateForm($username,$name) {
            $userBO = new UserBO();
            $user = $userBO->getUserByUsername($username);
            include_once("../view/user/update.html");
        }
        
        public function updateUser($username, $lastname, $role,$name) {
            $userBO = new UserBO();
            $userBO->updateUser($username, $lastname, $role);
            header("Location: UserController.php?action=search&name=".$name);
        }

        public function deleteUser($username,$name) {
            $userBO = new UserBO();
            $userBO->deleteUser($username);
            header("Location: UserController.php?action=search&name=".$name);
        }

        public function invoke() {
            $action = isset($_GET['action'])? $_GET['action'] :'search';
            switch ($action) {
                case'search':
                    if (isset($_GET['name'])) {
                        $this->searchUsers($_GET['name']);
                    } else {
                        $this->showSearchForm();
                    }
                    break;
                case 'update':
                    if (isset($_POST['lastname']) && isset($_POST['roles'])) {
                        $this->updateUser($_POST['username'], $_POST['lastname'], $_POST['roles'],$_POST['name']);
                    } else {
                        $this->showUpdateForm($_GET['username'],$_GET['name']);
                    }
                    break;
                case 'delete':
                    $this->deleteUser($_GET['username'],$_GET['name']);
                    break;
                default:
                    $this->showSearchForm();
                    break;
                }
        }
    }
    $userController = new UserController();
    $userController->invoke();
?>