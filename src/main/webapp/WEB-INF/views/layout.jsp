<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Big-data</title>

	
<!-- Google Fonts -->
	
<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

	
<link rel="stylesheet" href="./static/css/animate.css">
	
<!-- Custom Stylesheet -->
	
<link rel="stylesheet" href="./static/css/style.css">
<link href="./static/css/bootstrap.min.css" rel="stylesheet">
<link href="one-page-wonder.css" rel="stylesheet">
	
<script src="./static/js/jquery.min.js"></script>
<script src="./static/js/bootstrap.min.js"></script>




    
    
<style>
       
        
        a,
        a:focus,
        a:hover {
            color: #f9bd35;
        }
        /* Custom default button */
        
        .btn-default,
        .btn-default:hover,
        .btn-default:focus {
            color: #fff;
            text-shadow: none;
            /* Prevent inheritence from `body` */
            background-color: #fff;
            border: 1px solid #fff;
        }
        /*
 * Base structure
 */
        
        html,
       
        /* Extra markup and styles for table-esque vertical and horizontal centering */
        
        .site-wrapper {
            display: table;
            width: 100%;
            height: 100%;
            /* For at least Firefox */
            min-height: 100%;
            -webkit-box-shadow: inset 0 0 100px rgba(0, 0, 0, 0);
            box-shadow: inset 0 0 100px rgba(0, 0, 0, 0);
        }
        
       .site-wrapper-inner {
            display: table-cell;
            vertical-align: top;
        }
        
        .cover-container {
            margin-right: auto;
            margin-left: auto;
        }
        /* Padding for spacing */
        
        .inner {
            padding: 30px;
        }
        /*
 * Header
 */
        
        .masthead-brand {
            margin-top: 10px;
            margin-bottom: 10px;
        }
        
        .masthead-nav > li {
            display: inline-block;
        }
        
        .masthead-nav > li + li {
            margin-left: 10px;
        }
        
        .masthead-nav > li > a {
            padding-right: 0;
            padding-left: 0;
            font-size: 16px;
            font-weight: bold;
            color: #fff	;
            /* IE8 proofing */
            color: rgba(255,255, 255, .95);
            border-bottom: 2px solid transparent;
        }
        
        .masthead-nav > li > a:hover,
        .masthead-nav > li > a:focus {
            background-color: transparent;
            border-bottom-color: #a9a9a9;
            border-bottom-color: rgba(255, 255, 255, .25);
        }
        
        .masthead-nav > .active > a,
        .masthead-nav > .active > a:hover,
        .masthead-nav > .active > a:focus {
            color: #00FFFF;
            border-bottom-color: #00FFFF;
        }
        
        @media (min-width: 768px) {
            .masthead-brand {
                float: left;
            }
            .masthead-nav {
                float: right;
            }
        }
        /*
 * Cover
 */
        
        .cover {
            padding: 0 20px;
        }
        
        .cover .btn-lg {
            padding: 10px 20px;
            font-weight: bold;
        }
        /*
 * Footer
 */
        
        .mastfoot {
            color: #999;
            /* IE8 proofing */
            color: rgba(255, 255, 255, .5);
        }
        /*
 * Affix and center
 */
        
        @media (min-width: 768px) {
            /* Pull out the header and footer */
            .masthead {
                position: fixed;
                top: 0;
            }
            .mastfoot {
                position: fixed;
                bottom: 0;
            }
            /* Start the vertical centering */
            .site-wrapper-inner {
                vertical-align: middle;
            }
            /* Handle the widths */
            .masthead,
            .mastfoot,
            .cover-container {
                width: 100%;
                /* Must be percentage or pixels for horizontal alignment */
            }
        }
        
        @media (min-width: 992px) {
            .masthead,
            .mastfoot,
            .cover-container {
                width: 700px;
                position: static;
            }
        }
    </style>


</head>
<!-- IMG BASED LOGO  -->
             <a class="navbar-brand" href="file:///C:/Users/lenovo/Desktop/tweet%20segmentation/UI/demo.html">
<img src="./static/image/logo.png" alt="logo" height="60px" width="70px"></a>   
       <a class="navbar-brand" href="menu.html" ><font color="black"><strong><h4><i><b>Tweet Segmentation </b></i><h4><h4><i><b> &   Named entity recognition</i></b></h4> </a></strong></font>
 <br><br><br>
<!-- Navigation -->
   <marquee behavior="alternate"><font size="7"><b><i>TwiNer..</i></b></font></marquee>
 
<nav class = "navbar navbar-inverse" role = "navigation">
    <div class="container">
   
  <ul class = "nav nav-pills">
  
    <li><a href = "/bigdata-solution">Home</a></li>
    <li><a href ="master">Master </a></li>  
    <li class = "dropdown">
     <a class = "dropdown-toggle" data-toggle = "dropdown" href = "#">
         More topics
         <span class = "caret"></span>
      </a>
        <ul class = "dropdown-menu">
         <li><a href = "#">Food</a></li>
 	 <li><a href = "#">Travel</a></li>
	  <li><a href = "#">Social Media</a></li>
	<li><a href = "#">Technology</a></li>

         
         <li class = "divider"></li>
         <li><a href = "https://twitter.com/">Twitter</a></li>
      </ul>
        
         <li><a data-toggle="tab" href ="#behindpeople">Team</a></li>

         

</nav>

  <div class="tab-content">
  
  
<!--CAMPS TAB-->
  
	
 <!-- TEAM TAB -->
    <div id="behindpeople" class="tab-pane fade">
	<h3>People Behind: Technical Team</h3>
	  <div class = "row">
   
   <div class = "col-sm-push-1 col-md-3">
      <div class = "thumbnail">
         <img src = "./static/image/sup.jpg" class="img-rounded" alt = "Generic placeholder thumbnail"height="1000px" width="500px">
      </div>
      
      <div class = "caption">
         <h4>Er.Supriya Satre(BEIT)</h4>       
      </div>
   </div>
   
   <div class = "col-sm-push-1 col-md-3">
      <div class = "thumbnail">
         <img src = "./static/image/poo.jpg" class="img-rounded" alt = "Generic placeholder thumbnail" height="1000px" width="500px">
      </div>
      
      <div class = "caption">
         <h4>Er.Pooja Bhave(BEIT)</h4>         
      </div>
   </div>
   
  
   
   <div class = "col-sm-push-1 col-md-3">
      <div class = "thumbnail">
         <img src = "./static/image/manda.jpg"class="img-rounded alt = "Generic placeholder thumbnail" height="1000px" width="500px">
      </div>
      
      <div class = "caption">
         <h4>Er.Manda bodkhe(BEIT)</h4>
        </div>
   </div>
   
</div>
</div>	<!--team tab end-->
	                       
<div class="container" role="main">

         <tiles:insertAttribute name="body" />
    

                                   
</div>
</div>


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    
  </body>
</html>