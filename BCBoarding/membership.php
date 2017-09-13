<?php
session_start();
?>
<?php
	include 'functions.php';
	require_once('config.php');
	

	// Connect to server and select database.
	($GLOBALS["___mysqli_ston"] = mysqli_connect(DB_HOST,  DB_USER,  DB_PASSWORD))or die("cannot connect, error: ".((is_object($GLOBALS["___mysqli_ston"])) ? mysqli_error($GLOBALS["___mysqli_ston"]) : (($___mysqli_res = mysqli_connect_error()) ? $___mysqli_res : false)));
	((bool)mysqli_query($GLOBALS["___mysqli_ston"], "USE " . constant('DB_DATABASE')))or die("cannot select DB, error: ".((is_object($GLOBALS["___mysqli_ston"])) ? mysqli_error($GLOBALS["___mysqli_ston"]) : (($___mysqli_res = mysqli_connect_error()) ? $___mysqli_res : false)));
	$tbl_name="topic"; // Table name

?>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <title>PowderLine</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="Style/base.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="/lib/w3.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
        </script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="script.js" type="text/javascript">
        </script>
    </head>

    <body>
    <!-- navigation bar -->
    <div class="wrap"> <span class="decor"></span>
        <nav class="navbar navbar-inverse narvar-static-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li><a href="index.php">Home</a></li>
                        <li><a href='slopes.php'>Slopes</a></li>
                        <li><a href="gear.php"> Gear </a></li>
                        <li><a href="about_us.php">About us</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <?php
			if (isLoggedIn()){
                echo '<li style="color:white;" >Welcome '.$_SESSION['SESS_FIRST_NAME']. "<br/>";
				echo '<a href="logout.php" style="margin-top:-10px;">Logout</a><br/></li>';                
			} ?>
                        <li><a href="forum.php"><span class="glyphicon glyphicon-user"></span> forum</a></li>
                        <li><a href="membership.php"><span class="glyphicon glyphicon-log-in"></span> register</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
        <!-- div header-->
        <div class="bannerMember">
            <div class="contentMid">
                <div id="passreqs">
                    <ul id="passreqlist">
                        <li>Must contain atleast 1 capital letter </li>
                        <li>Must contain atleast 1 lowercase letter</li>
                        <li>Must contain atleast 1 number </li>
                        <li> Must contain atleast 1 special character</li>
                        <li> Must contain atleast 8 characers</li>
                    </ul>
                </div>
                <div class="form">
                    <div class="registerForm">
                        <form class="registrationform" name="form" onsubmit="return signupValidate()" action="register.php" method="post">
                            <p class="signintitle">Sign-up</p>
                            <input id="fname" name="fname" type="text" placeholder="First Name" />
                            <div class="errorMessage" id="errFname"></div>
                            <input id="lname" name="lname" type="text" placeholder="Last Name" />
                            <div class="errorMessage" id="errLname"></div>
                            <input id="email" name="email" type="text" placeholder="Email address" />
                            <div class="errorMessage" id="errEmail"></div>
                            <input id="login" name="login" type="text" placeholder="Username" />
                            <div class="errorMessage" id="errUsername"></div>
                            <input id="password" name="password" type="password" placeholder="Password" />
                            <div class="errorMessage" id="errPass"></div>
                            <input id="cpassword" name="cpassword" type="password" placeholder="Re-type Password" />
                            <div class="errorMessage" id="errCPass"></div>
                            <input class="submit" name="Submit" type="submit" value="Register"> </form>
                    </div>
                    <div class="signinForm">
                        <?php
	if( isset($_SESSION['ERRMSG_ARR']) && is_array($_SESSION['ERRMSG_ARR']) && count($_SESSION['ERRMSG_ARR']) >0 ) {
		echo '<ul class="err">';
		foreach($_SESSION['ERRMSG_ARR'] as $msg) {
			echo '<li>',$msg,'</li>'; 
		}
		echo '</ul>';
		unset($_SESSION['ERRMSG_ARR']);
	}

			if (isLoggedIn()){
                echo 'Welcome '.$_SESSION['SESS_FIRST_NAME']. "<br/>";
				echo '<a href="logout.php">Logout</a><br/>';
                
                
			} else {
				echo '<form class="loginpage" name="loginpage" onsubmit="return loginValidate()" action="login.php" method="post">';
                echo '<p class="signintitle"> Log-In</p>';
                echo'<input name="login" type="text" id="logUsername" placeholder="Username" />';
                echo'<div  class="errorMessage" id="errUsernameLog"></div>';
                echo'<input name="password" type="password" id="logPass" placeholder="Password" /> ';
               echo'<div class="errorMessage" id="errPassLog"></div>';
                echo'<input class="submit" type="submit" value="Login"> </form>';
			}
		?>
                    </div>
                </div>
            </div>
        </div>
       <!-- footer -->
    <div class="footer">
        <div class="footerContent">
            <div class="row">
                <div class="col-sm-4">
                    <p>This is a comp 1536 project
                        <br> Copyright &copy; 2017 group 3
                        <br> All rights reserved</p>
                </div>
                <div class="col-sm-4">
                    <p>Contact Us</p>
                    <a href="#"> <img class="icon" src="Images/icon/gmail.png" alt="Logo"></a>
                    <a href="#"> <img class="icon" src="Images/icon/Outlook.png" alt="Logo"></a>
                </div>
                <div class="col-sm-4">
                    <p>Follow Us On </p>
                    <a href="#"><img class="icon" src="Images/icon/Facebook.png" alt="Logo"></a>
                    <a href="#"><img class="icon" src="Images/icon/Twitter.png" alt="Logo"></a>
                    <a href="#"><img class="icon" src="Images/icon/Instagram.png" alt="Logo"></a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
