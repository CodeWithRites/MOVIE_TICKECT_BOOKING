<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Reset Password | CinemaBook</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            margin: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background: linear-gradient(135deg, #ff512f, #dd2476);
            font-family: 'Poppins', sans-serif;
        }

        .reset-container {
            width: 380px;
            padding: 40px;
            border-radius: 20px;
            background: rgba(255, 255, 255, 0.1);
            box-shadow: 0 8px 32px rgba(31, 38, 135, 0.37);
            backdrop-filter: blur(12px);
            -webkit-backdrop-filter: blur(12px);
            border: 1px solid rgba(255, 255, 255, 0.2);
            color: #fff;
        }

        .reset-container h3 {
            text-align: center;
            margin-bottom: 30px;
            color: #ffffff;
            font-weight: 600;
            letter-spacing: 1px;
        }

        label {
            font-weight: 500;
            margin-bottom: 5px;
            display: block;
        }

        input[type="email"],
        input[type="password"] {
            width: 100%;
            border: none;
            border-radius: 10px;
            padding: 12px;
            margin-bottom: 18px;
            background: rgba(255, 255, 255, 0.2);
            color: #fff;
            outline: none;
        }

        input::placeholder {
            color: #ddd;
        }

        .btn-reset {
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 10px;
            background: linear-gradient(90deg, #ff512f, #f09819);
            color: white;
            font-weight: 600;
            transition: 0.3s ease;
        }

        .btn-reset:hover {
            background: linear-gradient(90deg, #f09819, #ff512f);
            transform: translateY(-2px);
        }

        .footer-text {
            text-align: center;
            margin-top: 15px;
            font-size: 14px;
            color: #ccc;
        }

        .footer-text a {
            color: #fff;
            text-decoration: underline;
        }
    </style>
</head>

<body>
    <div class="reset-container">
        <h3>🔒 Reset Password</h3>
        <form action="UpdatePasswordServlet" method="post">
            <label>Email ID</label>
            <input type="email" name="email" placeholder="Enter your registered email" required>

            <label>New Password</label>
            <input type="password" name="new_password" placeholder="Enter new password" required>

            <label>Confirm Password</label>
            <input type="password" name="confirm_password" placeholder="Re-enter new password" required>

            <button type="submit" class="btn-reset">Update Password</button>
        </form>

        <p class="footer-text">
            Remembered your password? <a href="login.jsp">Login here</a>
        </p>
    </div>
</body>
</html>
