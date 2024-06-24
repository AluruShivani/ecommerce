<!DOCTYPE html>
<%@page import="java.sql.*"%>
<html lang="en">
<head>
  
  <jsp:include page="header.jsp" />
  
  <style>
    /* Custom styles for card hover effect */
    .card:hover {
        transform: scale(1.05); /* Increase scale on hover */
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); /* Add box shadow on hover */
        transition: transform 0.3s, box-shadow 0.3s; /* Add a smooth transition effect */
    }
    .card-img-top {
      width: 100%;
      height: 250px; /* Set a consistent height for all images */
      object-fit: cover; /* Ensures the image covers the entire area */
      border: 2px solid #ddd; /* Add border to images */
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Add box shadow to images */
      border-radius: 5px; /* Optional: add rounded corners */
    }
  </style>
  
</head>
<body>
<jsp:include page="title.jsp" />
<jsp:include page="menu.jsp" />

<div id="demo" class="carousel slide" data-bs-ride="carousel">

    <!-- Indicators/dots -->
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
        <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
        <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
        <button type="button" data-bs-target="#demo" data-bs-slide-to="3"></button>
    </div>

    <!-- The slideshow/carousel -->
    <div class="carousel-inner mt-1">
        <div class="carousel-item active">
            <img src="toys.jpg" alt="ecommerce1" class="d-block w-100">
        </div>
        <div class="carousel-item">
            <img src="lappy3.jpg" alt="ecommerce2" class="d-block w-100">
        </div>
        <div class="carousel-item">
            <img src="A1.jpg" alt="ecommerce3" class="d-block w-100">
        </div>
        <div class="carousel-item">
            <img src="footwear1.jpg" alt="ecommerce4" class="d-block w-100">
        </div>
    </div>

    <!-- Left and right controls/icons -->
    <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
        <span class="carousel-control-next-icon"></span>
    </button>
</div>
    
<div class="container-fluid mt-3">
    <div class="row">
        <div class="col-md-4">
            <div class="card" style="width: 100%;">
                <img class="card-img-top" src="ec5.jpg" alt="Card image1">
            </div>
        </div>
        <div class="col-md-4">
            <div class="card" style="width: 100%;">
                <img class="card-img-top" src="ec4.jpg" alt="Card image2">
            </div>
        </div>
        <div class="col-md-4">
            <div class="card" style="width: 100%;">
                <img class="card-img-top" src="ec3.jpg" alt="Card image3">
            </div>
        </div>
    </div>
</div>

<div class="container-fluid mt-3">
    <div class="row">
        <div class="col-md-4">
            <div class="card" style="width: 100%;">
                <img class="card-img-top" src="ec1.jpg" alt="Card image4">
            </div>
        </div>
        <div class="col-md-4">
            <div class="card" style="width: 100%;">
                <img class="card-img-top" src="ec6.jpg" alt="Card image5">
            </div>
        </div>
        <div class="col-md-4">
            <div class="card" style="width: 100%;">
                <img class="card-img-top" src="ec7.jpg" alt="Card image6">
            </div>
        </div>
    </div>
</div>

<div class="container-fluid mt-3 mb-4">
    <div class="row">
        <div class="col-md-4">
            <div class="card" style="width: 100%;">
                <img class="card-img-top" src="ec8.jpg" alt="Card image7">
            </div>
        </div>
        <div class="col-md-4">
            <div class="card" style="width: 100%;">
                <img class="card-img-top" src="ec13.jpg" alt="Card image8">
            </div>
        </div>
        <div class="col-md-4">
            <div class="card" style="width: 100%;">
                <img class="card-img-top" src="ec10.jpg" alt="Card image9">
            </div>
        </div>
    </div>
</div>

<div class="container-fluid mt-3 mb-4">
    <div class="row">
        <div class="col-md-4">
            <div class="card" style="width: 100%;">
                <img class="card-img-top" src="ec11.jpg" alt="Card image10">
            </div>
        </div>
        <div class="col-md-4">
            <div class="card" style="width: 100%;">
                <img class="card-img-top" src="ec12.jpg" alt="Card image11">
            </div>
        </div>
        <div class="col-md-4">
            <div class="card" style="width: 100%;">
                <img class="card-img-top" src="ec3.jpg" alt="Card image12">
            </div>
        </div>
    </div>
</div>

<!-- Footer -->
<div class="container-fluid my-0" style="background-color: #45526e">
    <footer class="text-center text-lg-start text-white" style="background-color: #45526e">
        <!-- Grid container -->
        <div class="container p-4 pb-0">
            <!-- Section: Links -->
            <section class="">
                <!--Grid row-->
                <div class="row">
                    <!-- Grid column -->
                    <div class="col-md-3 col-lg-3 col-xl-3 mx-auto mt-3">
                        <h6 class="text-uppercase mb-4 font-weight-bold">E-Commerce</h6>
                        <p>Millions of Collections One place</p>
                    </div>
                    <!-- Grid column -->

                    <hr class="w-100 clearfix d-md-none" />

                    <!-- Grid column -->
                    <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mt-3">
                        <h6 class="text-uppercase mb-4 font-weight-bold">Products</h6>
                        <p><a class="text-white">Women Wear</a></p>
                        <p><a class="text-white">Home Decor</a></p>
                        <p><a class="text-white">Mens Wear</a></p>
                        <p><a class="text-white">Kids Zone</a></p>
                    </div>
                    <!-- Grid column -->

                    <hr class="w-100 clearfix d-md-none" />

                    <!-- Grid column -->
                    <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mt-3">
                        <h6 class="text-uppercase mb-4 font-weight-bold">Links</h6>
                        <p><a class="text-white">Ecommerce</a></p>
                        <p><a class="text-white">Delivery</a></p>
                        <p><a class="text-white">Shipping Rates</a></p>
                        <p><a class="text-white">Help</a></p>
                    </div>

                    <!-- Grid column -->
                    <hr class="w-100 clearfix d-md-none" />

                    <!-- Grid column -->
                    <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mt-3">
                        <h6 class="text-uppercase mb-4 font-weight-bold">Contact</h6>
                        <p><i class="fas fa-home mr-3"></i> New York, NY 10012, US</p>
                        <p><i class="fas fa-envelope mr-3"></i> info@gmail.com</p>
                        <p><i class="fas fa-phone mr-3"></i> + 01 234 567 88</p>
                        <p><i class="fas fa-print mr-3"></i> + 01 234 567 89</p>
                    </div>
                    <!-- Grid column -->
                </div>
                <!--Grid row-->
            </section>
            <!-- Section: Links -->

            <hr class="my-3">

            <!-- Section: Copyright -->
            <section class="p-3 pt-0">
                <div class="row d-flex align-items-center">
                    <!-- Grid column -->
                    <div class="col-md-7 col-lg-8 text-center text-md-start">
                        <!-- Copyright -->
                        <div class="p-3">
                            © 2020 Copyright:
                            <a class="text-white" href="#">@Ecommers123.com</a>
                        </div>
                        <!-- Copyright -->
                    </div>
                    <!-- Grid column -->

                    <!-- Grid column -->
                    <div class="col-md-5 col-lg-4 ml-lg-0 text-center text-md-end">
                        <!-- Social Media Icons -->
                        <div class="social-icons float-end">
                            <!-- Facebook -->
                            <a class="btn btn-outline-light btn-floating m-1" class="text-white" role="button"><i class="fab fa-facebook-f"></i></a>
                            <!-- Twitter -->
                            <a class="btn btn-outline-light btn-floating m-1" class="text-white" role="button"><i class="fab fa-twitter"></i></a>
                            <!-- Google -->
                            <a class="btn btn-outline-light btn-floating m-1" class="text-white" role="button"><i class="fab fa-google"></i></a>
                            <!-- Instagram -->
                            <a class="btn btn-outline-light btn-floating m-1" class="text-white" role="button"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                    <!-- Grid column -->

                    <!-- Grid column -->
                    <div class="col-12 mt-3">
                        <div class="developer-row d-flex flex-column align-items-center">
                            <h5 class="text-white">Developed by: A.SHIVANI</h5>
                           <!--  <img class="mt-2" alt="Developer Image" src="mine.jpg.jpg" style="width:100px; height:auto;" /> -->
                        </div>
                    </div>
                    <!-- Grid column -->
                </div>
            </section>
            <!-- Section: Copyright -->
        </div>
        <!-- Grid container -->
    </footer>
</div>
<!-- Footer -->

<style>
  .developer-row {
    background-color: #374a6e;
    padding: 10px;
    border-radius: 5px;
  }
</style>

</body>
</html>
