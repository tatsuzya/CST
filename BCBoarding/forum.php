<?php
include 'functions.php';
	require_once('config.php');
session_start();

	// Connect to server and select database.
	($GLOBALS["___mysqli_ston"] = mysqli_connect(DB_HOST,  DB_USER,  DB_PASSWORD))or die("cannot connect, error: ".((is_object($GLOBALS["___mysqli_ston"])) ? mysqli_error($GLOBALS["___mysqli_ston"]) : (($___mysqli_res = mysqli_connect_error()) ? $___mysqli_res : false)));
	((bool)mysqli_query($GLOBALS["___mysqli_ston"], "USE " . constant('DB_DATABASE')))or die("cannot select DB, error: ".((is_object($GLOBALS["___mysqli_ston"])) ? mysqli_error($GLOBALS["___mysqli_ston"]) : (($___mysqli_res = mysqli_connect_error()) ? $___mysqli_res : false)));
	$tbl_name="topic"; // Table name


	$sql="SELECT * FROM $tbl_name JOIN members ON members.member_id = topic.member_id";
	// ORDER BY id DESC is order result by descending
	$result=mysqli_query($GLOBALS["___mysqli_ston"], $sql);
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
       <script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
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
    <div class="bannerForum"> </div>
    <!--content-->
    <div class="contentMid">
        <button onclick="topFunction()" id="backToTop" title="Go to top">Back to Top</button>
       <div class="forumboxtitle">Community Forum Posts</div>
        <button class="newPost">Create a new post</button>
        <div class="forumContent">
            <button class="closeBtn"></button>
            <form onsubmit="return forumValidate()" action="add_topic.php"  method="post">                             
                    <label for="topic">Subject: </label>
                    <input name="topic" type="text" class="form-control" id="subject">
                <div class="errorMessage" id="errSubject"></div>
                    <label for="detail">Comment: </label>
                    <textarea name="detail" type="text" class="form-control" rows="5" id="commentBox"> </textarea>
                     <div class="errorMessage" id="errComment"></div>
                <input type="submit" value="Submit"> <input type="reset" name="Submit2" value="Reset" /> </form>
        </div>
        <div class="forumComment">
               <table class="forumTable" width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#CCCCCC">
                <tr>
                    <th width="4%" align="center" bgcolor="#E6E6E6">#</th>
                    <th width="53%" align="center" bgcolor="#E6E6E6">Comment</th>
                    <th width="6%" align="center" bgcolor="#E6E6E6">Name</th>
                    <th width="6%" align="center" bgcolor="#E6E6E6">Date/Time</th>
                </tr>
                   
                <?php
while($rows=mysqli_fetch_array($result)){ // Start looping table row
?>
<tr>
<td bgcolor="#FFFFFF"><?php echo $rows['id']; ?></td>
<td bgcolor="#FFFFFF"><a href="view_topic.php?id=<?php echo $rows['id']; ?>"><?php echo $rows['topic']; ?></a><BR></td>
<td align="center" bgcolor="#FFFFFF"><?php echo $rows['firstname'] . " " . $rows['lastname']; ?></td>

<td align="center" bgcolor="#FFFFFF"><?php echo $rows['datetime']; ?></td>

</tr>

<?php
// Exit looping and close connection
}
((is_null($___mysqli_res = mysqli_close($GLOBALS["___mysqli_ston"]))) ? false : $___mysqli_res);
?>
                
                
            </table>
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
