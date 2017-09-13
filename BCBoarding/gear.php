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
    <div class="bannerGear"></div>
    <!--sub navigation bar -->
    <!-- content middle -->
    <div class="gearContent">
        <button onclick="topFunction()" id="backToTop" title="Go to top">Back to Top</button>
        <div class="necessitiesContent">
            <div class="accordionHeader" id="outerwearHeader"><span>Necessities</span></div>
            <div class="accordionContent">
                <div class="row gearRow">
                    <div class="col-md-4"> <img class="Outerwear img-fluid" src="Images/outerwear.JPG" alt="Outerwear"> </div>
                    <div class="col-md-8 necessitiesContent">
                        <h3>Choosing your Outerwear</h3>
                        <p> The outerwear you choose is really important as it's your main source of protection against the mountain. There are a lot of factors you need to consider to ensure you have the best outwear that suits all your needs. These include, material, utility, fit, and price. The materials can range from polyester, nylon, microfibers, and gore-tex. If you have room in your budget, gore-tex is the best choice as its completely waterproof. Otherwise, all three other materials will also do you fine. In terms of utility, you would want to consider whether you want insulation or you want to layer it with other clothes. Another aspect that people forget to consider is utility pockets. You often end up carrying a bunch of stuff such as phone, wallet, keys, ipods, etc. Unless you intend on having a bag with you, its best to make sure your outerwear has extra pockets for them. Lastly, most prefer a baggy fit for its complete range of motion, but there are other fits out there to suit your preferences.   </p>
                    </div>
                </div>
                <div class="row gearRow">
                    <div class="col-md-4"> <img class="Snowboard img-fluid" src="Images/Gear/Snowboard.jpg" alt="Snowboard"> </div>
                    <div class="col-md-8 necessitiesContent">
                        <h3>Types of Snowboards</h3>
                        <p>The best all-mountain snowboard of 2016-2017 is the brainstorm by Slash. This board is a good example of an all around snowboard. If you're not sure what type of snowboarder you are, all-mountain boards are the best option as it should suit most terrains including parks. Overall, you would want a board that is a directional twin which has a symmetrical shape. If you want a more playful board specifically for parks, you would select a board with lower flex rating. Aside from those aspects, the only thing you have to consider is the board's compatibility with your bindings. Most will have standardized insert patterns, but if the two are different you will have to reconsider one of the two to accomodate the other.</p>
                    </div>
                </div>
                <div class="row gearRow">
                    <div class="col-md-4"> <img class="Bindings img-fluid" src="Images/bindings.jpg" alt="Bindings"> </div>
                    <div class="col-md-8 necessitiesContent">
                        <h3>Bindings</h3>
                        <p>Similar to snowboards, when choosing a set of bindings, its best to figure out what your riding style is. The flex ratings on the bindings will differ based on your style. If you plan on spending most of your time in terrain parks or doing freestyle riding, softer flex is the way to go. For an all-mountain rider, or someone who just wants 1 set for all types, a medium flex should do justice. Lastly, if you're all in for deep-powder and speed on tough terrains, a stiffer flex will provide you with better response, energy transfer to the snowboard for going as fast as you can. Aside from your riding style, you should also consider the insert patterns on the snowboard.</p>
                    </div>
                </div>
                <div class="row gearRow">
                    <div class="col-md-4"> <img class="Boots img-fluid" src="Images/boots.jpg" alt="Boots"> </div>
                    <div class="col-md-8">
                        <h3>Boots</h3>
                        <p> For boots, the most important aspect you should consider is the fit. Since you'll be strapped in your boots on and off the mountain, making them as comfortable as you can is the obvious choice. The boots should fit you snugly, but not to a point of pain. Most boots will take a few days for your feet to settle in, so be aware that it will be tighter than normal at first. Some higher price point boots will have heat molding liners to better adjust to your feet and increase comfort levels as well. As with all snowboarding gear, softer flex is preferred by park riders and stiff flex for freeriders. In addition, there are numerous lacing systems that you can choose from. Have a look at all the types of lacing systems before you finish your purchase as it can make or break your experience with the boots.</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="accessoriesContent">
            <div class="accordionHeader"><span>Accessories</span></div>
            <div class="accordionContent">
                <div class="row gearRow">
                    <div class="col-md-4"> <img class="Outerwear img-fluid" src="Images/Gear/Goggles.jpg" alt="Outerwear"> </div>
                    <div class="col-md-4"> <img class="Snowboard img-fluid" src="Images/Gear/bags.JPG" alt="Snowboard"> </div>
                    <div class="col-md-4"> <img class="Snowboard img-fluid" src="Images/Gear/helmet.jpg" alt="Snowboard"> </div>
                </div>
                <div class="row gearRow">
                     <div class="col-md-4"> <img class="Bindings img-fluid" src="Images/Gear/SPads.jpg" alt="Bindings"> </div>
                   <div class="col-md-4"> <img class="Bindings img-fluid" src="Images/Gear/Keys.jpg" alt="Bindings"> </div>
                    <div class="col-md-4"> <img class="Boots img-fluid" src="Images/Gear/driver.jpg" alt="Boots"> </div>
                </div>
            </div>
        </div>
        <div class="shopsContent">
            <div class="accordionHeader"><span>Where to buy</span></div>
            <div class="accordionContent">
                <div class="row gearRow">
                    <div class="col-sm-4" id="westEndMap"></div>
                    <div class="col-sm-8 ">
                        <h3>West End</h3>
                        <p>On West 4th Avenue near Burrard and Pine Street, there is a collection of winter sport shops such as Pacific Boarder, The Boardroom, The White Room and Comor. All of these shops carry excellent quality products and usually have a wide selection of brands. Before buying anything online, its in your best interest to check these places out as they carry US only brand products. There is also a clearance store for the Boardroom which has a variety of products from previous seasons that you can purchase at a lower cost. If you're just starting out or don't have a big budget, this would be the place to go.</p>
                    </div>
                </div>
                <div class="row gearRow">
                    <div class="col-sm-4" id="northVanMap"></div>
                    <div class="col-sm-8">
                        <h3>North Vancouver</h3>
                        <p>Similar to West End area, there are two places in North Van that has a selection of wintersport shops. On Lonsdale Ave, there is The Boardroom and North Shore Ski & Board. Also, on Marine Drive, The Destination Slope Surf Outfitters and Crystal Glide SKi & Board Services Ltd. All four of these shops are excellent places to shop for your gear. It's nice and convenient to buy online, but some of your gear like boots and outerwear is best chosen when you get to try them on.</p>
                    </div>
                </div>
                <div class="row gearRow">
                    <div class="col-sm-4"> <img class="Brands gearImages img-fluid" src="Images/Gear/Logo1.jpg" alt="Brands"> </div>
                    <div class="col-sm-8">
                        <h3>Others</h3>
                        <p>If none of those places are accessible for you, you can always shop online for anything that you need. The only downside is that for some gear like boots, you take the risk of not fitting properly or not being fully satisfied with the purchase. If so, it's a hassle to return or exchange if bought online. Other than that, online shopping is probably where you can have the widest range of selection.</p>
                    </div>
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
