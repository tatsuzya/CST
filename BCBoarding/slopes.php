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
    <script src="script.js" type="text/javascript">
    </script>
   <script async defer
src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDFo39zzsmv0WNk7a5QCIgCNOSHUaFZfck&callback=initMap">
</script>
    <link href="https://fonts.googleapis.com/css?family=Amatic+SC%7CShadows+Into+Light" rel="stylesheet"> </head>

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
    <div class="bannerSlopes"></div>
    <!-- content middle -->
    <div class="contentMid">
        <div class="row">
            
                <div class="BigWhiteContent slopesContent">
                    <button class="closeBtn"></button>
                    <div class="row">
                        <div class="col-sm-4" id="bigWhiteMap"></div>
                        <div class="col-sm-8">Located 56 km from Kelowna, Big White is the third largest winter resort on our list.  Complete with 118 runs that you will rarely see closed, Big White is also a world class winter sports facility and is home to national and world cup events.  Home of the world-famous Telus park, full of tremendous jumps, rails, and other obstacles is one of its key features.  Good for all ability levels the Telus park is open both for day and night runs.</div>
                    </div>
                </div>
                
                <div class="CypressContent slopesContent">
                    <button class="closeBtn"></button>
                    <div class="row">
                        <div class="col-sm-4" id="cypressMap"></div>
                        <div class="col-sm-8">First opened to the public in the early 1970s Cypress was the first resort in BC to allow and encourage snowboarding.  Unlike some of other mountains Cypress is actually built on two skiable mountains and includes the “bowl” in-between them.  Only a thirty minute drive from downtown Vancouver, Cypress is perfect for a quick adventure away from the city where you can be home for dinner.</div>
                    </div>
                </div>
                
            <div class="col-md-6  SlopesCard BigWhite"> <img class="Location img-fluid SlopesCardImg" src="Images/Slopes/BigWhite.jpg" alt="LocationMap">
                <p class="SlopesText">Big White</p>
                
            </div>
            <div class="col-md-6  SlopesCard Cypress"> <img class="Location img-fluid SlopesCardImg" src="Images/Slopes/Cypress1.jpg" alt="LocationMap">
                <p class="SlopesText">Cypress</p>
                
            </div>
                
        </div>
        <div class="row">
             <div class="grouseContent slopesContent">
                    <button class="closeBtn"></button>
                    <div class="row">
                        <div class="col-sm-4" id="grouseMap"></div>
                        <div class="col-sm-8">A hot spot for Vancouver locals, Grouse mountain is one of the cities most tried and true facilities.  With 26 runs half of which are lit for night skiing grouse is an easy and reliable location to visit.  If you get sick of the slopes there is a 100-seat mountain top theatre and a breathtaking view to experience onboard Grouse’s aerial tram</div>
                    </div>
                </div>
                
                <div class="seymourContent slopesContent">
                    <button class="closeBtn"></button>
                    <div class="row">
                        <div class="col-sm-4" id="seymourMap"></div>
                        <div class="col-sm-8">Seymour first opened for skiing in 1938 and therefore has been a stable resort for Vancouverites for generations.  Seymour has 39 marked trails for you to explore however the regulars prefer the many unmarked routes the mountain contains.  A total of five terrain parks exist for all your freestyling needs, Seymour is great for the entire family.</div>
                    </div>
                </div>
            <div class="col-md-6 SlopesCard Grouse"> <img class="Location img-fluid SlopesCardImg" src="Images/Slopes/Grouse.png" alt="LocationMap">
                <p class="SlopesText">Grouse</p>
               
            </div>
            <div class="col-md-6 SlopesCard Seymour"> <img class="Location img-fluid SlopesCardImg" src="Images/Slopes/Seymour.jpg" alt="LocationMap">
                <p class="SlopesText">Seymour</p>
               
            </div>
        </div>
        <div class="row">
            <div class="sunPeaksContent slopesContent">
                    <button class="closeBtn"></button>
                    <div class="row">
                        <div class="col-sm-4" id="sunPeaksMap"></div>
                        <div class="col-sm-8">Located 56 km northeast of Kamloops Sun Peaks Is known for its breathtaking postcard like sceneries. With the skiable area comprising of three mountains, Sun Peaks is a good place to spend the weekend. With both amazing scenery and thrilling slopes.  A total of 135 runs and over 40km of cross country trails litter the resort and prevent you from needing anything else to do.</div>
                    </div>
                </div>
                
                <div class="whistlerContent slopesContent">
                    <button class="closeBtn"></button>
                    <div class="row">
                        <div class="col-sm-4" id="whistlerMap"></div>
                        <div class="col-sm-8">Over 2 million visitors a year cannot be wrong, Whistler features the “peak 2 peak” gondola which moves between the mountain peaks of Whistler and Blackcomb mountain.  Featuring a whopping 200 runs and 37 ski lifts for all ski levels, whistler is a winter wonderland for those interested in the sport.   Also, home to both the Olympic and Whistler village, visiting whistler allows for a much more social and eventful ski trip than the other mountains.</div>
                    </div>
                </div>
            <div class="col-md-6 SlopesCard SunPeaks"> <img class="Location img-fluid SlopesCardImg" src="Images/Slopes/SunPeaks1.jpg" alt="LocationMap">
                <p class="SlopesText">Sun Peaks</p>
                
            </div>
            <div class="col-md-6 SlopesCard Whistler"> <img class="Location img-fluid SlopesCardImg" src="Images/Slopes/Whistler1.jpg" alt="LocationMap">
                <p class="SlopesText">Whistler</p>
              
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
