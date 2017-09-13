 /* Gear jquery */
 $(document).ready(function () {
     $(".accordionHeader").click(function () {
         if ($(this).next().is(":hidden")) {
             $(".accordionContent").hide(700, "swing")
             $(this).next().show(700, "swing", function () {
                 $('html, body').animate({
                     scrollTop: $(this).offset().top - 160
                 }, 450);
             });
             westEndMap();
             northVanMap();
         }
         else {
             $(".accordionContent").hide(500, "swing")
         }
     });
     $('a[href^="#home-body"]').on('click', function (event) {
         var target = $($(this).attr('href'));
         if (target.length) {
             event.preventDefault();
             $('html, body').animate({
                 scrollTop: target.offset().top
             }, 1000);
         }
     });
 });
function scrollTo() {
  document.getElementById("home-body").scrollIntoView();
}

 /* Slopes jquery */
 $(document).ready(function () {
     $(".SlopesCard").hover(function () {
         $(this).find(".SlopesCardImg").fadeTo(300, 0.2);
     }, function () {
         $(this).find(".SlopesCardImg").fadeTo(100, 1);
     });
 });
 $(document).ready(function () {
     $(".BigWhite").click(function () {
         $(".BigWhiteContent").fadeTo(300, 1);
         $(".BigWhiteContent").css({
             "z-index": "1"
         });
         bigWhiteMap();
     });
 });
 $(document).ready(function () {
     $(".Cypress").click(function () {
         $(".CypressContent").fadeTo(300, 1);
         $(".CypressContent").css({
             "z-index": "1"
         });
         cypressMap();
     });
 });
 $(document).ready(function () {
     $(".Grouse").click(function () {
         $(".grouseContent").fadeTo(300, 1);
         $(".grouseContent").css({
             "z-index": "1"
         });
         grouseMap();
     });
 });
 $(document).ready(function () {
     $(".Seymour").click(function () {
         $(".seymourContent").fadeTo(300, 1);
         $(".seymourContent").css({
             "z-index": "1"
         });
         seymourMap();
     });
 });
 $(document).ready(function () {
     $(".SunPeaks").click(function () {
         $(".sunPeaksContent").fadeTo(300, 1);
         $(".sunPeaksContent").css({
             "z-index": "1"
         });
         sunPeaksMap();
     });
 });
 $(document).ready(function () {
     $(".Whistler").click(function () {
         $(".whistlerContent").fadeTo(300, 1);
         $(".whistlerContent").css({
             "z-index": "1"
         });
         whistlerMap();
     });
 });
 /* Google Map */
 function bigWhiteMap() {
     var centermap = {
         lat: 49.7355
         , lng: -118.9414
     };
     var bigWhite = {
         lat: 49.7216
         , lng: -118.9266
     };
     var map = new google.maps.Map(document.getElementById('bigWhiteMap'), {
         zoom: 12
         , center: centermap
         , panControl: true
         , zoomControl: true
         , mapTypeControl: true
         , scaleControl: true
         , streetViewControl: true
         , overviewMapControl: true
         , rotateControl: true
     });
     var marker = new google.maps.Marker({
         position: bigWhite
         , map: map
     });
 }

 function cypressMap() {
     var centermap = {
         lat: 49.3959
         , lng: -123.2046
     };
     var cypress = {
         lat: 49.3959
         , lng: -123.2046
     };
     var map = new google.maps.Map(document.getElementById('cypressMap'), {
         zoom: 14
         , center: centermap
         , panControl: true
         , zoomControl: true
         , mapTypeControl: true
         , scaleControl: true
         , streetViewControl: true
         , overviewMapControl: true
         , rotateControl: true
     });
     var marker = new google.maps.Marker({
         position: cypress
         , map: map
     });
 }

 function grouseMap() {
     var centermap = {
         lat: 49.3722
         , lng: -123.0996
     };
     var grouse = {
         lat: 49.3722
         , lng: -123.0996
     };
     var map = new google.maps.Map(document.getElementById('grouseMap'), {
         zoom: 13
         , center: centermap
         , panControl: true
         , zoomControl: true
         , mapTypeControl: true
         , scaleControl: true
         , streetViewControl: true
         , overviewMapControl: true
         , rotateControl: true
     });
     var marker = new google.maps.Marker({
         position: grouse
         , map: map
     });
 }

 function seymourMap() {
     var centermap = {
         lat: 49.3654
         , lng: -122.9483
     };
     var seymour = {
         lat: 49.3654
         , lng: -122.9483
     };
     var map = new google.maps.Map(document.getElementById('seymourMap'), {
         zoom: 15
         , center: centermap
         , panControl: true
         , zoomControl: true
         , mapTypeControl: true
         , scaleControl: true
         , streetViewControl: true
         , overviewMapControl: true
         , rotateControl: true
     });
     var marker = new google.maps.Marker({
         position: seymour
         , map: map
     });
 }

 function sunPeaksMap() {
     var centermap = {
         lat: 50.8844
         , lng: -119.8859
     };
     var sunPeaks = {
         lat: 50.8844
         , lng: -119.8859
     };
     var map = new google.maps.Map(document.getElementById('sunPeaksMap'), {
         zoom: 12
         , center: centermap
         , panControl: true
         , zoomControl: true
         , mapTypeControl: true
         , scaleControl: true
         , streetViewControl: true
         , overviewMapControl: true
         , rotateControl: true
     });
     var marker = new google.maps.Marker({
         position: sunPeaks
         , map: map
     });
 }

 function whistlerMap() {
     var centermap = {
         lat: 50.1162
         , lng: -122.9574
     };
     var whistler = {
         lat: 50.1162
         , lng: -122.9574
     };
     var map = new google.maps.Map(document.getElementById('whistlerMap'), {
         zoom: 12
         , center: centermap
         , panControl: true
         , zoomControl: true
         , mapTypeControl: true
         , scaleControl: true
         , streetViewControl: true
         , overviewMapControl: true
         , rotateControl: true
     });
     var marker = new google.maps.Marker({
         position: whistler
         , map: map
     });
 }

 function westEndMap() {
     var centermap = {
         lat: 49.2680
         , lng: -123.1447
     };
     var westEnd = {
         lat: 49.2680
         , lng: -123.1447
     };
     var map = new google.maps.Map(document.getElementById('westEndMap'), {
         zoom: 18
         , center: centermap
         , panControl: true
         , zoomControl: true
         , mapTypeControl: true
         , scaleControl: true
         , streetViewControl: true
         , overviewMapControl: true
         , rotateControl: true
     });
     var marker = new google.maps.Marker({
         position: westEnd
         , map: map
     });
 }

 function northVanMap() {
     var centermap = {
         lat: 49.3280
         , lng: -123.0725
     };
     var northVan = {
         lat: 49.3280
         , lng: -123.0725
     };
     var map = new google.maps.Map(document.getElementById('northVanMap'), {
         zoom: 19
         , center: centermap
         , panControl: true
         , zoomControl: true
         , mapTypeControl: true
         , scaleControl: true
         , streetViewControl: true
         , overviewMapControl: true
         , rotateControl: true
     });
     var marker = new google.maps.Marker({
         position: northVan
         , map: map
     });
 }
 /* Back to Top button */
 window.onscroll = function () {
     scrollFunction()
 };
 /* Close button */
 $(document).ready(function () {
     $(".closeBtn").click(function () {
         $(this).parent().css({
             "z-index": "0"
         });
         $(this).parent().hide();
     });
 });
 /* new post button */
 $(document).ready(function () {
     $(".newPost").click(function () {
         $(this).parent().find(".forumContent").css({
             "display": "block"
         });
         $(this).parent().find(".forumContent").css({
             "z-index": "10"
         });
     });
 });

 function scrollFunction() {
     if (document.body.scrollTop > 500 || document.documentElement.scrollTop > 500) {
         document.getElementById("backToTop").style.display = "block";
     }
     else {
         document.getElementById("backToTop").style.display = "none";
     }
 }
 // When the user clicks on the button, scroll to the top of the document
 function topFunction() {
     document.body.scrollTop = 0;
     document.documentElement.scrollTop = 0;
 }
 $(document).ready(function () {
     $(function () {
         $("#date").datepicker();
     })
 });
 /* Banner fade out jquery */
 $(window).scroll(function () {
     var scrollTop = $(window).scrollTop();
     var height = $(window).height();
     $('.bannerSlopes, .bannerGear, .bannerAbout, .bannerForum, .bannerMember').css({
         'opacity': ((height - scrollTop) / height)
     });
 });
 /* Form validation for Membership */
 function testfname() {
     var nameRegex = new RegExp(/[a-zA-Z]$/);
     if ($("#fname").val().match(nameRegex)) {
         return true;
     }
     else {
         return false;
     }
 }

 function testlname() {
     var nameRegex = new RegExp(/[a-zA-Z]$/);
     if ($("#lname").val().match(nameRegex)) {
         return true;
     }
     else {
         return false;
     }
 }

 function testUsername() {
     var nameRegex = new RegExp(/[a-zA-Z0-9]$/);
     if ($("#login").val().match(nameRegex)) {
         return true;
     }
     else {
         return false;
     }
 }

 function testPassword() {
     var regexpPass = new RegExp(/^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/);
     if ($("#password").val().match(regexpPass)) {
         return true;
     }
     else {
         return false;
     }
 }

 function testCPassword() {
     var regexpPass = new RegExp(/^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/);
     if ($("#cpassword").val().match(regexpPass)) {
         return true;
     }
     else {
         return false;
     }
 }

 function testEmail() {
     var regexpEmail = new RegExp(/\S+@\S+\.\S+/);
     if ($("#email").val().match(regexpEmail)) {
         return true;
     }
     else {
         return false;
     }
 }

 function signupValidate() {
     var fname, lname, username, password, cpassword, email
     if (testfname()) {
         $("#errFname").html("");
         fname = true;
     }
     else {
         $("#errFname").html("Please enter a valid first name");
         fname = false;
     }
     if (testlname()) {
         $("#errLname").html("");
         lname = true;
     }
     else {
         $("#errLname").html("Please enter a valid last name");
         lname = false;
     }
     if (testUsername()) {
         $("#errUsername").html("");
         username = true;
     }
     else {
         $("#errUsername").html("Please enter a valid username");
         username = false;
     }
     if (testPassword()) {
         $("#errPass").html("");
         $("#passreqlist").css({
             "visibility": "hidden"
         });
         password = true;
     }
     else {
         $("#errPass").html("Please enter a valid password");
         $("#passreqlist").css({
             "visibility": "visible"
         });
         password = false;
     }
     if (testCPassword()) {
         $("#errCPass").html("");
         cpassword = true;
     }
     else {
         $("#errCPass").html("Please enter a valid password");
         cpassword = false;
     }
     if (testEmail()) {
         $("#errEmail").html("");
         email = true;
     }
     else {
         $("#errEmail").html("Please enter a valid email");
         email = false;
     }
     if (fname && lname && username && password && cpassword && email) {
         return true;
     }
     else {
         return false;
     }
 }

 function testLogUsername() {
     var nameRegex = new RegExp(/[a-zA-Z0-9]$/);
     if ($("#logUsername").val().match(nameRegex)) {
         return true;
     }
     else {
         return false;
     }
 }

 function testLogPass() {
     var regexpPass = new RegExp(/^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/);
     if ($("#logPass").val().match(regexpPass)) {
         return true;
     }
     else {
         return false;
     }
 }

 function loginValidate() {
     var username, password
     if (testLogUsername() && $("#logUsername").val().length != 0) {
         $("#errUsernameLog").html("");
         username = true;
     }
     else {
         $("#errUsernameLog").html("Please enter a valid username");
         username = false;
     }
     if (testLogPass() && $("#logPass").val().length != 0) {
         $("#errPassLog").html("");
         password = true;
     }
     else {
         $("#errPassLog").html("Please enter a valid password");
         password = false;
     }
     if (username && password) {
         return true;
     }
     else {
         return false;
     }
 }
 /* Forum js*/
 function testTopic() {
     if ($("#subject").val().length != 0) {
         return true;
     }
     else {
         return false;
     }
 }

 function testComment() {
     if ($.trim($("#commentBox").val()) != '') {
         return true;
     }
     else {
         return false;
     }
 }

 function forumValidate() {
     var subject, comment
     if (testTopic()) {
         $("#errSubject").html("");
         subject = true;
     }
     else {
         $("#errSubject").html("Subject cannot be blank");
         subject = false;
     }
     if (testComment()) {
         $("#errComment").html("");
         comment = true;
     }
     else {
         $("#errComment").html("Comment box cannot be blank");
         comment = false;
     }
     if (subject && comment) {
         return true;
     }
     else {
         return false;
     }
 }