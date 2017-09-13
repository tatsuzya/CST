<?php
	include 'functions.php';
	require_once('config.php');
	session_start();

	// Connect to server and select database.
	($GLOBALS["___mysqli_ston"] = mysqli_connect(DB_HOST,  DB_USER,  DB_PASSWORD))or die("cannot connect, error: ".((is_object($GLOBALS["___mysqli_ston"])) ? mysqli_error($GLOBALS["___mysqli_ston"]) : (($___mysqli_res = mysqli_connect_error()) ? $___mysqli_res : false)));
	((bool)mysqli_query($GLOBALS["___mysqli_ston"], "USE " . constant('DB_DATABASE')))or die("cannot select DB, error: ".((is_object($GLOBALS["___mysqli_ston"])) ? mysqli_error($GLOBALS["___mysqli_ston"]) : (($___mysqli_res = mysqli_connect_error()) ? $___mysqli_res : false)));
	$tbl_name="topic"; // Table name

?>

<!DOCTYPE HTML>
<html lang="en">

<head>
   <title>PowderLine</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="Style/base.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
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
    <header id="home-banner">
        <div id="home-center">
            <h1 id="banner-text">PowderLine</h1>
            <h1 id="banner-phrase">Shredding since 2017</h1>
            <a id="home-button" href="#home-body">To Page</a>
        </div>
    </header>
    <!-- content middle -->
    <div id="home-body">
      <h1 id="mission-head">OUR MISSION</h1>
      <img src="Images/logoBW.png" alt="mission icon" id="missionicon">
      <div id="mission" class="home-about">

          Our goal at PowderLine is to communicate with BC's Lower Mainland community and share our knowledge to the ins and outs of the
          local snowboarding culture! Here, we share our knowledge on specific slopes and mountains, form guides about our current favourite gear,
          and unite together an already developed extreme sport. All are welcome here, no matter the skill level, tourists and locals alike!
      </div>

      <div id="indexContent" class="contentMid">
        <div class="row">
          <div class="col">
            <div id="section-gear" class="sections">
              <a href="gear.php"><div class="clickable"></div></a>
            </div>
            <div id="gear-paragraph">
              <h1 class="section-header">GEAR</h1>
              <p class="home-about">
                Click the picture to find out about our current snowboarding setup and learn about why we chose them. This is a
                great place to find some inspiration if you are looking to upgrade your equipment!
              </div>
          </div>
        </div>

          <div class="row">
            <div class="col">
            <div id="section-slopes" class="sections">
              <a href="slopes.php"><div class="clickable"></div></a>
            </div>
            <div id="slopes-paragraph">
                <h1 class="section-header">SLOPES</h1>
              <p class="home-about">
                Click the picture to find the best slopes on our local mountains: here you will find directions and information on the lifts/resorts.
                Show your skills in various environments!
              </div>
          </div>
        </div>

        <div class="row">
          <div class="col">
          <div id="section-about" class="sections">
            <a href="about_us.php"><div class="clickable"></div></a>
          </div>
            <div id="about-paragraph">
            <h1 class="section-header">ABOUT</h1>
            <p class="home-about">
              Click the picture to find a little bit about us. We'll tell you what we like about snowboarding, and if you want
              to get to know us, this is where to go!
            </p>
        </div>
      </div>
      </div>
      </div>
      </div>

      <!-- Carousel -->
      <div class="container">
        <div class="row">
          <div class="col-sm-12">
            <h1 id="gallery">OUR GALLERY</h1>
            <div id="home-slide" class="carousel slide" data-ride="carousel" data-interval="5300">

              <div class="carousel-inner">
                <div class="item active">
                  <div class="row">
                  <div class="col-md-6">
                    <img src="Images/slide1.jpg" alt="slide1 viewpoint" class="slide-img"/>
                  </div>
                  <div class="col-md-6">
                    <img src="Images/slide2.jpg" alt="slide2 sun" class="img-r"/>
                  </div>
                </div>
                </div>
                <div class="item">
                  <div class="row">
                  <div class="col-md-6">
                    <img src="Images/slide3.jpg" alt="slide3 skyline" class="slide-img"/>
                  </div>
                  <div class="col-md-6">
                    <img src="Images/slide6.jpg" alt="slide4 slope" class="img-r"/>
                  </div>
                </div>
                </div>
              </div>

              <a class="left carousel-control" href="#home-slide" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
              </a>
              <a class="right carousel-control" href="#home-slide" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
              </a>
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
                    <a href="gear.html"> <img class="icon" src="Images/icon/gmail.png" alt="Logo"></a>
                    <a href="gear.html"> <img class="icon" src="Images/icon/Outlook.png" alt="Logo"></a>
                </div>
                <div class="col-sm-4">
                    <p>Follow Us On </p>
                    <a href="gear.html"><img class="icon" src="Images/icon/Facebook.png" alt="Logo"></a>
                    <a href="gear.html"><img class="icon" src="Images/icon/Twitter.png" alt="Logo"></a>
                    <a href="gear.html"><img class="icon" src="Images/icon/Instagram.png" alt="Logo"></a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>