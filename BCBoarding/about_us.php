<?php
	include 'functions.php';
	require_once('config.php');
	session_start();

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
    <script src="script.js" type="text/javascript"></script>
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
    <div class="bannerAbout"> </div>
    <!-- content middle -->
    <div class="contentMid">
        <div class="row">
            <div class="col-sm-12 aboutUsContent1"> <img class="img-fluid" id="bcitlogo" src="Images/bcit-logo.png" alt="BCIT logo">
                <h3>Who We Are</h3>
                <p> We are a team of 5 students from the British Columbia Institute of Technology currently enrolled in the CST program.
                  We are in our first term of the program and have been updating this website with techniques learned
                  throughout our first web development course.  We continued to add to this website while holding group
                   meetings in person and online.  We used A/B testing to help our design decisions and adapted
                  our design following peer and instructor feedback.</p>
            </div>
            <br>
            <br>
             <div class="col-lg-12 aboutUsContent2"> <img class="img-fluid" id="us-Img" src="Images/us.jpg" alt="Picture of group">
              <div id="about-p2">
                <h3>What We Do</h3>
                <p>Because we are all big fans of winter sports (especially snowboarding) and we live in a spectacular city for such activities...
                  we created this site with the purpose of it being a central page for both newcomers and returning veteran snowboarders.
                   British Columbia is surrounded by mountains and as such, our team wanted to create an organized website highlighting our
                    six favourite mountains: with intentions to expand this number later. <br> <br>
                    Picking out new Snowboarding gear can be a tedious and a tricky task, so we also wanted to help guide new and returning
                    snowboarders towards suitable gear. Since Snowboarding has overtime become more commercial and ‘image’ based, we want to
                    use this platform as an opportunity to recommend trusted gear from reliable brands.
                    To encourage community growth, we added a forum where all boarders (old and young) can communicate.
                    We hope to see discussions ranging from gear reviews/mountain reviews, to tricks and tips on how to get
                     the best experience from your trip to the mountains.  This site is to act as a central hub for snowboarders and
                      a great starting point for those finding themselves in the city and wanting to hit the powder! </p>
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
