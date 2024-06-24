<!DOCTYPE html>
<html>

<head>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Include Font Awesome CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        /* CSS for hover effect */
        .social-icon {
            transition: transform 0.3s ease-in-out;
        }

        .social-icon:hover {
            transform: scale(1.1);
        }
    </style>
</head>

<body>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">
                <img src="ems.jpg" alt="Logo" style="width:50px;" class="rounded-pill"><b>E-Commerce</b>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <form class="form-inline mx-auto">
                    <input class="form-control mr-sm-2" type="text" placeholder="Search" style="width: 300px;">
                    <button class="btn btn-warning" type="submit">Search</button>
                </form>
            </div>
            <div class="navbar-collapse justify-content-end">
                <a class="navbar-brand">
                    <!-- Font Awesome Icons with hover effect -->
                    <i class="fas fa-envelope social-icon" style="font-size: 30px; color: #D44638;"></i>&nbsp;
                    <i class="fab fa-twitter social-icon" style="font-size: 30px; color: #1DA1F2;"></i>
                    <i class="fab fa-facebook social-icon" style="font-size: 30px; color: #1877f2;"></i>
                </a>
            </div>
        </div>
    </nav>

    <!-- Include Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
