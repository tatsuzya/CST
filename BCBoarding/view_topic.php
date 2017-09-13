<?php

	include 'functions.php';
	require_once('config.php');
	session_start();

	// Connect to server and select database.
	($GLOBALS["___mysqli_ston"] = mysqli_connect(DB_HOST,  DB_USER,  DB_PASSWORD))or die("cannot connect");
	((bool)mysqli_query($GLOBALS["___mysqli_ston"], "USE " . constant('DB_DATABASE')))or die("cannot select DB");
	$tbl_name="topic"; // Table name

	// get value of id that sent from address bar
	$id=$_GET['id'];

	$sql="SELECT * FROM $tbl_name JOIN members ON members.member_id = topic.member_id WHERE id='$id'";
	$result=mysqli_query($GLOBALS["___mysqli_ston"], $sql);

	$rows=mysqli_fetch_array($result);
?>

<!DOCTYPE html>
<html lang="en">

    
   <head>
    <title>BCBoarding</title>
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
       <script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
</head>
<body>
    <!-- div header-->
    <div class="bannerForum"> </div>
    <!-- navigation bar -->
    <div class="wrap"> <span class="decor"></span>
        <nav class="navbar navbar-inverse narvar-static-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button> <img class="resize" src="Images/BCBoardingLogo.png" alt="Logo"> </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li><a href="index.html">Home</a></li>
                        <li class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" href="slopes.html">Slopes <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="slopes.html">Whistler</a></li>
                                <li><a href="#">Grouse</a></li>
                                <li><a href="#">Seymour</a></li>
                                <li><a href="#">Cypress</a></li>
                                <li><a href="#">Big White</a></li>
                                <li><a href="#">Sun Peaks</a></li>
                            </ul>
                        </li>
                        <li class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" href="gear.html">Gear <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="gear.html">Necessities</a></li>
                                <li><a href="#">Accessories</a></li>
                                <li><a href="#">Shops</a></li>
                            </ul>
                        </li>
                        <li><a href="about_us.html">About us</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="forum.php"><span class="glyphicon glyphicon-user"></span> Forum</a></li>
                        <li><a href="membership.php"><span class="glyphicon glyphicon-log-in"></span> Register</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <!--content-->
    <div class="contentMid">
        <table width="400" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
        <tr>
            <td>
                <table width="100%" border="0" cellpadding="3" cellspacing="1" bordercolor="1" bgcolor="#FFFFFF">
                    <tr>
                        <td bgcolor="#F8F7F1"><strong><?php echo $rows['topic']; ?></strong></td>
                    </tr>
                    <tr>
                        <td bgcolor="#F8F7F1">
                            <?php echo $rows['detail']; ?>
                        </td>
                    </tr>
                    <tr> 
                        <td bgcolor="#F8F7F1"><strong>By :</strong>
                            <?php echo $rows['firstname'] . " " . $rows['lastname']; ?>
                        </td>
                    </tr>
                    <tr>
                        <td bgcolor="#F8F7F1"><strong>Date/time : </strong>
                            <?php echo $rows['datetime']; ?>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <BR>
    <?php
$tbl_name2="response"; // Switch to table "response"


$sql2="SELECT * FROM $tbl_name2 WHERE topic_id='$id'";
$result2=mysqli_query($GLOBALS["___mysqli_ston"], $sql2);

while($rows=mysqli_fetch_array($result2)){
?>
        <table width="400" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
            <tr>
                <td>
                    <table width="100%" border="0" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF">
                        <tr>
                            <td bgcolor="#F8F7F1"><strong>ID</strong></td>
                            <td bgcolor="#F8F7F1">:</td>
                            <td bgcolor="#F8F7F1">
                                <?php echo $rows['id']; ?>
                            </td>
                        </tr>
                        <tr>
                            <td width="18%" bgcolor="#F8F7F1"><strong>Name</strong></td>
                            <td width="5%" bgcolor="#F8F7F1">:</td>
                            <td width="77%" bgcolor="#F8F7F1">
                                <?php echo $rows['firstname'] . " " . $rows['lastname']; ?>
                            </td>
                        </tr>
                        <tr>
                            <td bgcolor="#F8F7F1"><strong>Response</strong></td>
                            <td bgcolor="#F8F7F1">:</td>
                            <td bgcolor="#F8F7F1">
                                <?php echo $rows['response']; ?>
                            </td>
                        </tr>
                        <tr>
                            <td bgcolor="#F8F7F1"><strong>Date/Time</strong></td>
                            <td bgcolor="#F8F7F1">:</td>
                            <td bgcolor="#F8F7F1">
                                <?php echo $rows['datetime']; ?>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <br>
        <?php
}
((is_null($___mysqli_res = mysqli_close($GLOBALS["___mysqli_ston"]))) ? false : $___mysqli_res);
// Question 1b added code
     if (!isLoggedIn()) {
        echo 'Please login to continue';
        exit();
     }
    ?>
            <BR>
            <table width="400" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
                <tr>
                    <form name="form1" method="post" action="add_response.php">
                        <td>
                            <table width="100%" border="0" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF">
                                <tr>
                                    <td valign="top"><strong>Response</strong></td>
                                    <td valign="top">:</td>
                                    <td>
                                        <textarea name="response" cols="45" rows="3" id="answer"></textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td>&nbsp;</td>
                                    <td>
                                        <input name="id" type="hidden" value="<?php echo $id; ?>">
                                    </td>
                                    <td>
                                        <input type="submit" name="Submit" value="Submit">
                                        <input type="reset" name="Submit2" value="Reset">
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </form>
                </tr>
            </table>
    </div>
    <!-- footer -->
    <div class="footer">
        <div class="footerContent">
            <div class="row">
                <div class="col-sm-4">
                    <!--img-->
                    <p> Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a </p>
                </div>
                <div class="col-sm-4">
                    <p> Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a </p>
                </div>
                <div class="col-sm-4">
                    <p> Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a </p>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
